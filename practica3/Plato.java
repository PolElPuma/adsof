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
    
    

	public Set<Comida> getComidas() {
		return comidas.keySet();
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
	public String toFile() {
		String ret = "PLATO;"+this.nombre;
		for(Comida c: this.comidas.keySet()) {
			if(Plato.class.isInstance(c)) {
				ret+=";PLATO "+ c.getNombre();
			}else {
				ret+=";INGREDIENTE "+c.getNombre()+":"+this.comidas.get(c);
			}
			
		}
		return ret;
	}
	
	public boolean contains(Alergeno ...alergenos) {
		for(Alergeno a: alergenos) {
			if (super.alergenos.contains(a)){
				return true;
			}
		}
		return false;
	}
	
	public void recopilarIngredientesPlatos(Set<Ingrediente> ingredientesSet, Set<Plato> platosSet) {
        platosSet.add(this);
        for (Comida c : this.getComidas()) {
        	c.recopilarIngredientesPlatos(ingredientesSet, platosSet);
        }
    }
	
	
}