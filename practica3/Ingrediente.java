package adsof_prac3;

import java.util.*;
import java.util.stream.Collectors;

public class Ingrediente extends Comida{
	private String tipo;
	private String nombre;
	
	
	/**
     * Crea un ingrediente
     * 
     * @param String nombre a establecer
     * @param InfoNutricional info a establecer
     */
	private Ingrediente(String nombre,InfoNutricional info) {
		super(info);
		this.nombre = nombre;
		this.alergenos = new HashSet<>();
	}
	
	
	/**
     * Crea un ingrediente
     * 
     * @param String nombre a establecer
     * @param String tipo de ingrediente
     * @param InfoNutricional info a establecer
     */
	public Ingrediente(String nombre,String tipo ,InfoNutricional info) {
		this(nombre,info);
		this.tipo = tipo;
	}
	
	
	/**
     * Crea un ingrediente
     * 
     * @param String nombre a establecer
     * @param TipoIngrediente tipo de ingerdiente
     * @param InfoNutricional info a establecer
     */
	public Ingrediente(String nombre,TipoIngrediente tipo, InfoNutricional info) {
		this(nombre,info);
		this.tipo = tipo.toString();
	}
	
	
	/**
     * Añade alergenos a un ingerdiente
     * 
     * @param Alergenos... alergenos a añadir
     * 
     * @return Ingrediente objeto modificado 
     */
	public Ingrediente tieneAlergenos(Alergeno ...alergenos ) {
		for(Alergeno a: alergenos) {
			super.alergenos.add(a);
		}
		return this;
	}
	
	
	/**
     * Convierte a String la info de un ingrediente
     * 
     * @return String con la info 
     */
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
	
	
	/**
     * Conviarte a String un ingerdiente para traterlo con ficheros
     * 
     * @return String con la info para el fichero
     */
	public String toFile() {
		String ret = "INGREDIENTE_" + super.info.getTipo() + ";" + this.nombre+";";
				try {
					ret += TipoIngrediente.fromString(tipo).getName();
				}catch(IllegalArgumentException e){
					ret+=this.tipo;
				}
		return ret+= ";" + info.toFile() + super.checkAlergenos();
	}
	
	
	/**
     * getter de campo nombre
     * 
     * @return String nombre del ingrediente
     */
	@Override
	public String getNombre() {
		return this.nombre;
	}
	
	
	/**
     * Añade ingerdiente a un Set
     * 
     * @param Set ingerdientes 
     * @param Set platos
     */
	public void recopilarIngredientesPlatos(Set<Ingrediente> ingredientesSet, Set<Plato> platosSet) {
        ingredientesSet.add(this);
    }

	
	

}
