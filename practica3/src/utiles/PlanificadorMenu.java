package utiles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import comidas.Menu;
import comidas.Plato;
import enums.Alergeno;
import enums.ElementoNutricional;

/**
 * 
 * @author Pol Pumar, Jorge Ibarreta
 */

public class PlanificadorMenu {

	private List<Plato> platos = new ArrayList<>();
	private Map<ElementoNutricional, Double> maximos = new HashMap<>();

	/**
	 * @param platos
	 */
	public PlanificadorMenu(List<Plato> platos) {
		this.platos = platos;
	}

	/**
	 * Asigna una nueva lista de platos que no tienen los alergenos
	 * 
	 * @param alergenos
	 * @return this
	 */
	public PlanificadorMenu sinAlergenos(Alergeno... alergenos) {
		List<Plato> platosSinAlergenos = new ArrayList<>();
		for (Plato p : platos) {
			boolean contieneAlergeno = false;
			for (Alergeno a : alergenos) {
				if (p.contains(a)) {
					contieneAlergeno = true;
					break;
				}
			}
			if (!contieneAlergeno) {
				platosSinAlergenos.add(p);
			}
		}
		this.platos = platosSinAlergenos;
		return this;
	}

	/**
	 * Establece un cierto maximo a un ElementoNutricional
	 * 
	 * @param elem a limitar
	 * @param max maximo a establecer
	 * 
	 * @return PlanificadorMenu objeto modificado
	 */
	public PlanificadorMenu conMaximo(ElementoNutricional elem, double max) {
		maximos.put(elem, max);
		return this;
	}

	/**
	 * Crea un menu asegurandose de que cumple unos min y max
	 * 
	 * @param min calorias minimas
	 * @param max calorias maximas
	 * 
	 * @return Menu el menu creado o null en caso de error
	 */
	public Menu planificar(int min, int max) {
		for (int r = 1; r <= platos.size(); r++) {
			for (int i = 0; i <= platos.size() - r; i++) {
				Menu actual = new Menu();
				for (int j = i; j < i + r; j++) {
					actual.addPlato(platos.get(j));
				}
				if (esMenuValido(actual, min, max)) {
					return actual;
				}
			}
		}
		return null;
	}

	/**
	 * Metodo auxiliar para comprobar si un menu cumple los criterios
	 * 
	 * @param menu
	 * @param min
	 * @param max
	 * @return
	 */
	private boolean esMenuValido(Menu menu, int min, int max) {
		if (menu.getInfo().getCalorias() < min || menu.getInfo().getCalorias() > max) {
			return false;
		}
		for (ElementoNutricional e : maximos.keySet()) {
			if (menu.getInfo().getNutriente(e) > maximos.get(e)) {
				return false;
			}
		}
		return true;
	}

}
