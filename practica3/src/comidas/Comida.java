package comidas;

import java.util.HashSet;
import java.util.Set;

import enums.Alergeno;
import nutricionales.InfoNutricional;

/**
 * 
 * @author Pol Pumar, Jorge Ibarreta
 */

public abstract class Comida {

	protected InfoNutricional info;
	protected HashSet<Alergeno> alergenos = new HashSet<>();

	/**
	 * Modificador campo info
	 * 
	 * @param info 
	 */
	protected Comida(InfoNutricional info) {
		this.info = info;
	}

	/**
	 * Inicializar campo info
	 * 
	 */
	protected Comida() {
		this.info = new InfoNutricional(0, 0, 0, 0, 0, 0, 0, 0);
	}

	/**
	 * Getter campo info
	 * 
	 * @return InfoNutricional correspondiente
	 */

	public InfoNutricional getInfo() {
		return info;
	}

	/**
	 * Getter campo alergenos
	 * 
	 * @return HashSet de los alergenos
	 */
	protected HashSet<Alergeno> getAlergenos() {
		return alergenos;
	}

	/**
	 * Añade un alergeno al objeto
	 * 
	 * @param a 
	 */
	public void addAlergeno(Alergeno a) {
		alergenos.add(a);
	}

	/**
	 * Devuelve una cadena de texto con los alergenos del objeto
	 * 
	 * @return String con los alergenos
	 */
	public String checkAlergenos() {
		String ret = "";
		for (Alergeno a : Alergeno.values()) {
			if (alergenos.contains(a)) {
				ret += ";Y";
			} else {
				ret += ";N";
			}
		}
		return ret;
	}

	public abstract String getNombre();

	public abstract void recopilarIngredientesPlatos(Set<Ingrediente> ingredientesSet, Set<Plato> platosSet);

}
