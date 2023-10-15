package ejb;

import javax.ejb.Remote;
import model.Citoyen;

@Remote
public interface CitoyenService {
    public Citoyen getCitoyen(String cin);
}
