import java.util.*;


public class Plato{

    private String nombre;
    private Set<Plato> platos = new HashSet<>();
    private Map<Ingrediente, Integer> ings = new HashMap<>();





    public Plato Plato(String newNombre){
        this.nombre = newNombre;
    }



    public int addIngrediente(Ingrediente ing, int cantidad){
        if(this.ings.containsKey(ing)){
            return 1;
        }
        this.ings.put(ing, cantidad);
        return 0;
    }

    public double getInfoNutri(Ingrediente Ingrediente[]){
        
    }

    public void addPlato(Plato p){
        if(this.platos.contains(p) == false){
            this.platos.add(p);
        }
    }
}
