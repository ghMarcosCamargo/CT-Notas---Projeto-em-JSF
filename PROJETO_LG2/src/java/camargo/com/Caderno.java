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
public class Caderno {
    private Integer codigoC;
    private String nomeC;
    private Integer codigoU;

    public Integer getCodigoC() {
        return codigoC;
    }

    public void setCodigoC(Integer codigoC) {
        this.codigoC = codigoC;
    }

    public String getNomeC() {
        return nomeC;
    }

    public void setNomeC(String nomeC) {
        this.nomeC = nomeC;
    }

    public Integer getCodigoU() {
        return codigoU;
    }

    public void setCodigoU(Integer codigoU) {
        this.codigoU = codigoU;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.codigoC);
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
        final Caderno other = (Caderno) obj;
        if (!Objects.equals(this.codigoC, other.codigoC)) {
            return false;
        }
        return true;
    }

    
    
    
    
}
