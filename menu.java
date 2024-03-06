import java.util.*;


public class Menu{
    private Integer nMenus;
    private Integer id;
    private Set<Plato> platos = new HashSet<>();



    public Menu Menu(Plato... plato){
        this.nMenus++;
        this.id = this.nMenus;
        for(Plato p : plato){
            if(this.platos.contains(p) == false){
                this.platos.add(plato);
            }
        }
    }
}
