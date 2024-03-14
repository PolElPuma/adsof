package adsof_prac3;
import java.util.*;


public class Plato extends Comida{

    Map<Comida, Integer> comidas = new HashMap<>();
	private String nombre;

    public Plato (String nombre){
    	super();
    	this.nombre = nombre;
    }

    public boolean addIngrediente(Ingrediente ing, int cantidad){
        if(this.comidas.containsKey(ing)){
            return true;
        }
        
        this.comidas.put(ing, cantidad);
        super.info.addInfo(ing.getInfo(), cantidad);
        for(Alergeno a:ing.getAlergenos()) {
        	super.alergenos.add(a);
        }
        return false;
    }

    public boolean addPlato(Plato p){
        if(this.comidas.containsKey(p)){
        	return false;
        }

        this.comidas.put(p,1);
        super.info.addInfo(p.getInfo());
        for(Alergeno a:p.getAlergenos()) {
        	super.alergenos.add(a);
        }
        return true;
    }
    
    
    public String getNombre() {
		return nombre;
	}

	@Override
    public String toString() {
		String ret = "[Plato] " + this.nombre + ": INFORMACION NUTRICIONAL DEL PLATO -> " + super.info ;
		if(!alergenos.isEmpty()) {
			Iterator<Alergeno> iterator = alergenos.iterator();
			ret += " CONTIENE: ";
			while(iterator.hasNext()) {
				Alergeno a = iterator.next();
				ret+= a.toString();
				if(iterator.hasNext()) {
					ret += ", ";
				}
			}
			
		}
		return ret;
	}
}