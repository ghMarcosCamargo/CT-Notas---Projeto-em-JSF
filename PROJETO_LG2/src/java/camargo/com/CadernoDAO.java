/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camargo.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcos
 */
public class CadernoDAO implements CrudDAO<Caderno> {

    @Override
    public void salvar(Caderno entidade) throws ErroSistema {
          try {
            Connection conexao;
            conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            if(entidade.getCodigoC()==null) {
                ps = conexao.prepareStatement("INSERT INTO `ctnotasbd`.`caderno`(`nomeC`,`codigoU`)VALUES(?,?);");
            } else {
                ps = conexao.prepareStatement("update caderno set nomeC=?, codigoU=? where codigoC=?");
                ps.setInt(3, entidade.getCodigoC());
            }
            
            ps.setString(1, entidade.getNomeC());
            ps.setInt(2, entidade.getCodigoU());

            

            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
                throw new ErroSistema("Erro ao tentar salvar o objeto.", ex);

        }
    }

    @Override
    public void deletar(Caderno entidade) throws ErroSistema {
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("delete from caderno where codigoC=?");
            ps.setInt(1, entidade.getCodigoC());
            ps.execute();
        } catch (SQLException ex) {
            throw new ErroSistema("Verifique se não há notas dependentes deste caderno.");
        }
    }


    @Override
    public List<Caderno> buscar() throws ErroSistema {
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from caderno");
            ResultSet resultSet = ps.executeQuery();
            List<Caderno> cadernos = new ArrayList<>();
            
            while(resultSet.next()) {  
                Caderno caderno = new Caderno();
              
                caderno.setCodigoC(resultSet.getInt("codigoC"));
                caderno.setNomeC(resultSet.getString("nomeC"));
                caderno.setCodigoU(resultSet.getInt("codigoU"));

               
                
                cadernos.add(caderno);
            }
            FabricaConexao.fecharConexao();
            return cadernos;
                
           
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao buscar objetos.", ex);
        }
    }
    
}
