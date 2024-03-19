package adsof_prac3;

public class InfoNutricionalUnidad extends InfoNutricional{
	
	
	/**
     * Costructor de la clase
     * 
     * @param calorias
     * @param hidratos
     * @param grasas_tot
     * @param grasas_sat
     * @param proteinas
     * @param azucar
     * @param fibra
     * @param sodio
     */
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
     * Getter tipo de InfoNutricionalUnidad
     * 
     * @return String con el tipo
     */
	@Override
	public String getTipo() {
		return "UNIDAD";
	}
	
}
