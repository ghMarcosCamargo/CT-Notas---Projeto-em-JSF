/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camargo.com;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Marcos
 */
public class Nota {
    private Integer codigoN;
    private String nomeN;
    private String conteudo;
    private Date data;
    private Integer codigoC;

    public Integer getCodigoN() {
        return codigoN;
    }

    public void setCodigoN(Integer codigoN) {
        this.codigoN = codigoN;
    }

    public String getNomeN() {
        return nomeN;
    }

    public void setNomeN(String nomeN) {
        this.nomeN = nomeN;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getCodigoC() {
        return codigoC;
    }

    public void setCodigoC(Integer codigoC) {
        this.codigoC = codigoC;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.codigoN);
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
        final Nota other = (Nota) obj;
        if (!Objects.equals(this.codigoN, other.codigoN)) {
            return false;
        }
        return true;
    }
    
    
}
