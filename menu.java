import java.util.*;


public class Menu{
    private Integer nMenus;
    private Integer id;
    private Set<Plato> platos = new HashSet<>();



    public Menu Menu(Plato... plato){
        this.nMenus++;
        this.id = this.nMenus;
        for(p : plato){
            this.platos.add(plato);
        }
    }
}