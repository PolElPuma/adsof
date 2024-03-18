package adsof_prac3;

import java.util.*;

public class PlanificadorMenu {

	private List<Plato> platos = new ArrayList<>();
	private Map<ElementoNutricional, Double> maximos = new HashMap<>();
	private HashSet<Alergeno> alergenos = new HashSet<>();

	/**
	 * @param platos
	 */
	public PlanificadorMenu(List<Plato> platos) {
		this.platos = platos;
	}

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

	public PlanificadorMenu conMaximo(ElementoNutricional elem,double max) {
		maximos.put(elem, max);
		return this;
	}
	
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
