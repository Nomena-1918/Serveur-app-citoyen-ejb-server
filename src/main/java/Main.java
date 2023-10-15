import ejb.CitoyenService;
import ejb.CitoyenServiceImpl;

public class Main {
    public static void main(String[] args) {
        CitoyenService c = new CitoyenServiceImpl();
        System.out.println(c.getCitoyen("123456789011").getNom());
    }
}
