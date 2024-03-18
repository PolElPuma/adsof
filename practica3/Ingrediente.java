package adsof_prac3;

import java.util.*;
import java.util.stream.Collectors;

public class Ingrediente extends Comida{
	private String tipo;
	private String nombre;
	
	private Ingrediente(String nombre,InfoNutricional info) {
		super(info);
		this.nombre = nombre;
		this.alergenos = new HashSet<>();
	}
	
	public Ingrediente(String nombre,String tipo ,InfoNutricional info) {
		this(nombre,info);
		this.tipo = tipo;
	}
	public Ingrediente(String nombre,TipoIngrediente tipo, InfoNutricional info) {
		this(nombre,info);
		this.tipo = tipo.toString();
	}
	public Ingrediente tieneAlergenos(Alergeno ...alergenos ) {
		for(Alergeno a: alergenos) {
			super.alergenos.add(a);
		}
		return this;
	}
	
	public String toString() {
		String ret = "["+this.tipo+"] " + this.nombre + ": " + this.info ;
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
		String ret = "INGREDIENTE_" + super.info.getTipo() + ";" + this.nombre+";";
				try {
					ret += TipoIngrediente.fromString(tipo).getName();
				}catch(IllegalArgumentException e){
					ret+=this.tipo;
				}
		return ret+= ";" + info.toFile() + super.checkAlergenos();
	}

	@Override
	public String getNombre() {
		return this.nombre;
	}
	
	public void recopilarIngredientesPlatos(Set<Ingrediente> ingredientesSet, Set<Plato> platosSet) {
        ingredientesSet.add(this);
    }

	
	

}
