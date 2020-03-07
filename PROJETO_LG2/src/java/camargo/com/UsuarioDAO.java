/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camargo.com;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcos
 */
public class UsuarioDAO implements CrudDAO<Usuario> {
    

    @Override
    public void salvar(Usuario entidade) throws ErroSistema {
          try {
            Connection conexao;
            conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            if(entidade.getCodigoU()==null) {
                ps = conexao.prepareStatement("INSERT INTO `ctnotasbd`.`usuario`(`nomeU`,`email`,`senha`)VALUES(?,?,?);");
            } else {
                ps = conexao.prepareStatement("update usuario set nomeU=?, email=?, senha=? where codigoU=?");
                ps.setInt(4, entidade.getCodigoU());
            }
            
            ps.setString(1, entidade.getNomeU());
            ps.setString(2, entidade.getEmail());
            ps.setString(3, entidade.getSenha());

            

            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
                throw new ErroSistema("Erro ao tentar salvar o objeto.", ex);

        }
    }

    @Override
    public void deletar(Usuario entidade) throws ErroSistema {
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("delete from usuario where codigoU=?");
            ps.setInt(1, entidade.getCodigoU());
            ps.execute();
        } catch (SQLException ex) {
            throw new ErroSistema("Verifique se não há cadernos dependentes deste usuário.");
        }
    }


    @Override
    public List<Usuario> buscar() throws ErroSistema {
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from usuario");
            ResultSet resultSet = ps.executeQuery();
            List<Usuario> usuarios = new ArrayList<>();
            
            while(resultSet.next()) {  
                Usuario usuario = new Usuario();
              
                usuario.setCodigoU(resultSet.getInt("codigoU"));
                usuario.setNomeU(resultSet.getString("nomeU"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setSenha(resultSet.getString("senha"));

               
                
                usuarios.add(usuario);
            }
            FabricaConexao.fecharConexao();
            return usuarios;
                
           
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao buscar objetos.", ex);
        }
    }

    

    
    
    public boolean verificarCadastro(String email, String senha) {
         boolean emailIsCorrect = false;
         boolean senhaIsCorrect = false;
        try {
            List<Usuario> usuariosCadastrados = new ArrayList();
            usuariosCadastrados = buscar();
            
            
            for(int x =0; x <= usuariosCadastrados.size();x++) {
                if(usuariosCadastrados.get(x).getEmail()== email) {
                    emailIsCorrect = true;
                    
                }
                
                if(usuariosCadastrados.get(x).getSenha()== senha) {
                    senhaIsCorrect = true;
                }
                
                if(senhaIsCorrect && emailIsCorrect) {
                    return true;
                } {
                
            }
            }
            
           
        } catch (ErroSistema ex) {
            try {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new ErroSistema("Erro ao verificar login.", ex);
            } catch (ErroSistema ex1) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex1);

            }

        }
        return false;
    }
    

    
}
    
    

