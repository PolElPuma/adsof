package adsof_prac3;

import java.util.*;

public class PlanificadorMenu {

	private List<Plato> platos = new ArrayList<>();
	private Map<ElementoNutricional, Double> maximos = new HashMap<>();
	private HashSet<Alergeno> alergenos = new HashSet<>();

	/**
	 * Funcion para establecer el campo platos
	 * @param platos
	 */
	public PlanificadorMenu(List<Plato> platos) {
		this.platos = platos;
	}

	
	/**
     * Elimina de un menu los platos con ciertos alergenos
     * 
     * @param Alergeno alergenos a eliminar
     */
	public PlanificadorMenu sinAlergenos(Alergeno ...alergenos) {
		for(Alergeno a : alergenos) {
			Iterator<Plato> iterator = platos.iterator();
	        while (iterator.hasNext()) {
	            Plato p = iterator.next();
	            if (p.contains(a)) {
	                iterator.remove(); // Safe removal
	            }
	        }
		}
		
		return this;
	}
	
	
	/**
     * Establece un cierto maximo a un ElementoNutricional
     * 
     * @param ElementoNutricional elem a limitar
     * @param double max maximo a establecer
     * 
     * @return PlanificadorMenu objeto modificado
     */
	public PlanificadorMenu conMaximo(ElementoNutricional elem,double max) {
		maximos.put(elem, max);
		return this;
	}
	
	
	/**
     * Crea un menu asegurandose de que cumple unos min y max
     * 
     * @param int min calorias minimas
     * @param int max calorias maximas
     * 
     * @return Menu el menu creado o null en caso de error
     */
	public Menu planificar(int min, int max) {
		Menu m = new Menu();
		for(Plato p: platos) {
			if (m.getInfo().getCalorias() + p.getInfo().getCalorias() < max) {
				m.addPlato(p);
			}
			if(m.getInfo().getCalorias() > min) {
				return m;
			}
		}
		return null;
	}

}
