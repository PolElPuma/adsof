package adsof_prac3;
import java.util.*;


public class Plato extends Comida{

    Map<Comida, Integer> comidas = new HashMap<>();
	private String nombre;
	
	
	/**
     * Crea un Plato
     * 
     * @param String nombre a establecer
     */
    public Plato (String nombre){
    	super();
    	this.nombre = nombre;
    }
    
    
    /**
     * Añade un ingrediente a un plato
     * 
     * @param Ingrediente ing a añadir
     * @param int cantidad de ing a añadir
     * 
     * @return true si ya lo tenia, false si lo ha añadido
     */
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
    
    
    /**
     * Añade un plato a otro plato
     * 
     * @param Plato p a añadir
     * 
     * @return false si ya lo tenia, true si lo ha añadido
     */
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
    
    
    /**
     * Getter campo nombre
     * 
     * @return String del campo nombre
     */
    public String getNombre() {
		return nombre;
	}
    
    
    /**
     * Getter de keys del campo comidas
     * 
     * @return Set con las keys del campo comidas
     */
	public Set<Comida> getComidas() {
		return comidas.keySet();
	}
	
	
	/**
     * Convierte a String la informacion de un plato
     * 
     * @return String con la informacion de un plato
     */
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
	
	
	/**
     * Convierte a String la informacion de un plato para tratarlo con ficheros
     * 
     * @return String con la informacion de un plato
     */
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
	
	
	/**
     * Comprueba si un plato tiene ciertos alergenos
     * 
     * @param Alergeno... alergenos a comprobar
     * 
     * @return true si tiene alguno, false si no los tiene
     */
	public boolean contains(Alergeno ...alergenos) {
		for(Alergeno a: alergenos) {
			if (super.alergenos.contains(a)){
				return true;
			}
		}
		return false;
	}
	
	
	/**
     * Añade Ingerdientes y platos a un plato
     * 
     * @param Set ingerdientes a añadir
     * @param Set platos a añadir
     * 
     */
	public void recopilarIngredientesPlatos(Set<Ingrediente> ingredientesSet, Set<Plato> platosSet) {
        platosSet.add(this);
        for (Comida c : this.getComidas()) {
        	c.recopilarIngredientesPlatos(ingredientesSet, platosSet);
        }
    }
	
	
}