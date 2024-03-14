package adsof_prac3;

import java.util.*;

public class Menu extends Comida{
	
	private ArrayList<Plato> comidas = new ArrayList<>();
	private int id ;
	private static int counter = 0;
	
	
	public Menu(Plato ...platos) {
		super();
		counter +=1;
		this.id = counter;
		
		for(Plato p:platos) {
			this.comidas.add(p);
	        super.info.addInfo(p.getInfo());
	        for(Alergeno a:p.getAlergenos()) {
	        	super.alergenos.add(a);
	        }
		}
		
	}
	
    @Override
    public String toString() {
		String ret = "Menu " + this.id + " [";
		if(!comidas.isEmpty()) {
			Iterator<Plato> iterator = comidas.iterator();
			while(iterator.hasNext()) {
				Plato p = iterator.next();
				ret+= p.getNombre();
				if(iterator.hasNext()) {
					ret += ", ";
				}
			}
			
		}
		ret+= "]: INFORMACION NUTRICIONAL DEL MENU -> " +super.info;
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
