package adsof_prac3;

import java.util.*;

public class Menu extends Comida {

	private ArrayList<Plato> comidas = new ArrayList<>();
	private int id;
	private static int counter = 0;

	/**
	 * Crea un menu
	 * 
	 * @param Plato... platos a establecer en el menu
	 */
	public Menu(Plato... platos) {
		super();
		counter += 1;
		this.id = counter;

		for (Plato p : platos) {
			this.comidas.add(p);
			super.info.addInfo(p.getInfo());
			for (Alergeno a : p.getAlergenos()) {
				super.alergenos.add(a);
			}
		}

	}

	/**
	 * Convirete un menu a String
	 * 
	 * @return String con la informacion de un menu
	 */
	@Override
	public String toString() {
		String ret = "Menu " + this.id + " [";
		if (!comidas.isEmpty()) {
			Iterator<Plato> iterator = comidas.iterator();
			while (iterator.hasNext()) {
				Plato p = iterator.next();
				ret += p.getNombre();
				if (iterator.hasNext()) {
					ret += ", ";
				}
			}

		}
		ret += "]: INFORMACION NUTRICIONAL DEL MENU -> " + super.info;
		if (!alergenos.isEmpty()) {
			Iterator<Alergeno> iterator = alergenos.iterator();
			ret += " CONTIENE: ";
			while (iterator.hasNext()) {
				Alergeno a = iterator.next();
				ret += a.toString();
				if (iterator.hasNext()) {
					ret += ", ";
				}
			}

		}
		return ret;
	}

	/**
	 * Añade un plato a un menu
	 * 
	 * @param Plato p a añadir
	 */
	public void addPlato(Plato p) {
		this.comidas.add(p);
		super.info.addInfo(p.getInfo());
		for (Alergeno a : p.getAlergenos()) {
			super.alergenos.add(a);
		}

	}

	/**
	 * Conviarte un menu a String para tratarlo con ficheros
	 * 
	 * @return String con la informacion de un menu
	 */
	public String toFile() {
		String ret = "MENU";
		for (Plato p : this.comidas) {
			ret += ";" + p.getNombre();
		}
		return ret;
	}

	/**
	 * Getter del campo nombre
	 * 
	 * @return String con el nombre del menu
	 */
	@Override
	public String getNombre() {
		return String.valueOf(id);
	}

	/**
	 * Recupera platos e ingredientes de un menu
	 * 
	 * @param Set para guardar ingredientes
	 * @param Set para guardar platos
	 */
	public void recopilarIngredientesPlatos(Set<Ingrediente> ingredientesSet, Set<Plato> platosSet) {
		for (Plato plato : comidas) {
			plato.recopilarIngredientesPlatos(ingredientesSet, platosSet);
		}
	}

	/**
	 * Quita platos de la lista
	 * 
	 * @param plato
	 */
	public void removePlato(Plato plato) {
		this.comidas.remove(plato);
	}
	
	/**
	 * Obtiene lista de platos
	 * 
	 * @return comidas
	 */
	public List<Plato> getPlatos() {
		return comidas;
	}
}
