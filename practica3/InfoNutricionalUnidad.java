package adsof_prac3;

public class InfoNutricionalUnidad extends InfoNutricional{
	
	public InfoNutricionalUnidad(double calorias, double hidratos, double grasas_tot, double grasas_sat, double proteinas,
			double azucar, double fibra, double sodio) {
		super(calorias, hidratos, grasas_tot, grasas_sat, proteinas, azucar, fibra, sodio);
	}
	/**
     * Convierte a String la InfoNutricionalUnidad
     * 
     * @return String con la InfoNutricionalUnidad
     */
	@Override
	public String toString() {
		return "INFORMACION NUTRICIONAL POR UNIDAD -> " + super.toString();
	}
	
	/**
     * Metodo auxiliar para prints
     * 
     * @return String con el tipo
     */
	@Override
	public String getTipo() {
		return "UNIDAD";
	}
	
}
