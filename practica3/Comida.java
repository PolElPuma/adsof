package adsof_prac3;

import java.util.*;

public abstract class Comida {

	
	protected InfoNutricional info;
	protected HashSet<Alergeno> alergenos = new HashSet<>();
	
	protected Comida(InfoNutricional info) {
		this.info = info;
		}
	protected Comida() {
		this.info = new InfoNutricional(0,0, 0, 0, 0, 0, 0, 0);
	}
	
	protected InfoNutricional getInfo() {
		return info;
	}
	protected HashSet<Alergeno> getAlergenos() {
		return alergenos;
	}
	
	public void addAlergeno(Alergeno a) {
		alergenos.add(a);
	}
	

}
