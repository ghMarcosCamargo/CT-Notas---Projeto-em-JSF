/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camargo.com;

import java.util.Objects;

/**
 *
 * @author Marcos
 */
public class Usuario {
    private Integer codigoU;
    private String nomeU;
    private String email;
    private String senha;

    public Integer getCodigoU() {
        return codigoU;
    }

    public void setCodigoU(Integer codigoU) {
        this.codigoU = codigoU;
    }

    public String getNomeU() {
        return nomeU;
    }

    public void setNomeU(String nomeU) {
        this.nomeU = nomeU;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.codigoU);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.codigoU, other.codigoU)) {
            return false;
        }
        return true;
    }

    
    
}
