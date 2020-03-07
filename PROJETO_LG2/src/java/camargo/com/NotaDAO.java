/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camargo.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcos
 */
public class NotaDAO implements CrudDAO<Nota> {
    @Override
    public void salvar(Nota nota) throws ErroSistema {
        try {
            Connection conexao;
            conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            if(nota.getCodigoN()==null) {
                ps = conexao.prepareStatement("INSERT INTO `ctnotasbd`.`nota`(`nomeN`,`conteudo`,`dataCriacao`,`codigoC`)VALUES(?,?,?,?);");
            } else {
                ps = conexao.prepareStatement("update nota set nomeN=?, conteudo=?, dataCriacao=?, codigoC=? where codigoN=?");
                ps.setInt(5, nota.getCodigoN());
            }
            
            ps.setString(1, nota.getNomeN());
            ps.setString(2, nota.getConteudo());
            ps.setDate(3, (java.sql.Date) new Date(nota.getData().getDate()));
            ps.setInt(4, nota.getCodigoC());
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
                throw new ErroSistema("Erro ao tentar salvar nota.", ex);

        }

    }
    
    @Override
    public List<Nota> buscar() throws ErroSistema  {
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from nota");
            ResultSet resultSet = ps.executeQuery();
            List<Nota> notas = new ArrayList<>();
            
            while(resultSet.next()) {  
                Nota nota = new Nota();
              
                nota.setCodigoN(resultSet.getInt("codigoN"));
                nota.setNomeN(resultSet.getString("nomeN"));
                nota.setConteudo(resultSet.getString("conteudo"));
                nota.setData(resultSet.getDate("dataCriacao"));
                nota.setCodigoC(resultSet.getInt("codigoC"));
                
                notas.add(nota);
            }
            FabricaConexao.fecharConexao();
            return notas;
                
           
        } catch (SQLException ex) {
            throw new ErroSistema("Você ainda não criou suas notas! Aperte em novo para criá-las!", ex);
        }
    }
    
    @Override
    public void deletar(Nota nota) throws ErroSistema {
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("delete from nota where codigoN=?");
            ps.setInt(1, nota.getCodigoN());
            ps.execute();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao deletar nota do sistema.");
        }
    }
    
}
