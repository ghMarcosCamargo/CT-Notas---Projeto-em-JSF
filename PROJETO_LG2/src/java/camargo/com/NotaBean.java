
package camargo.com;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Marcos
 */

@ManagedBean
@SessionScoped
public class NotaBean extends CrudBean<Nota, NotaDAO> {
    
    private NotaDAO notaDAO;

    @Override
    public NotaDAO getDao() {
        if(notaDAO == null) {
            notaDAO = new NotaDAO();
        }
        return notaDAO;
    }

    @Override
    public Nota criarNovaEntidade() {
        return new Nota();
    }

    
}
