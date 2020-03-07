/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camargo.com;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Marcos
 */
@ManagedBean
@SessionScoped
public class CadernoBean extends CrudBean<Caderno, CadernoDAO>{
    
    private CadernoDAO cadernoDAO;

    @Override
    public CadernoDAO getDao() {
        if(cadernoDAO == null) {
            cadernoDAO = new CadernoDAO();
        }
        return cadernoDAO;
    }

    @Override
    public Caderno criarNovaEntidade() {
        return new Caderno();
    }
    
    
}
