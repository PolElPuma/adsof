package adsof_prac3;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.EnumMap;
import java.util.Locale;
import java.util.Map;

public class InfoNutricional {
	private double calorias;
	private Map<ElementoNutricional, Double> nutrientes;
	
	
	/**
     * Constructor de la clase
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
	public InfoNutricional(double calorias, double hidratos, double grasas_tot, double grasas_sat, double proteinas,
			double azucar, double fibra, double sodio) {
		this.calorias = calorias;
		this.nutrientes = new EnumMap<>(ElementoNutricional.class);
		this.nutrientes.put(ElementoNutricional.HIDRATOS, hidratos);
		this.nutrientes.put(ElementoNutricional.GRASA_TOTAL, grasas_tot);
		this.nutrientes.put(ElementoNutricional.GRASA_SATURADA, grasas_sat);
		this.nutrientes.put(ElementoNutricional.PROTEINAS, proteinas);
		this.nutrientes.put(ElementoNutricional.AZUCARES, azucar);
		this.nutrientes.put(ElementoNutricional.FIBRA, fibra);
		this.nutrientes.put(ElementoNutricional.SODIO, sodio);
	}
	/**
     * Añadir valores de otro objeto
     * 
     * @param InfoNutricional info para añadir
     * @param int cantidad cantidad a añadir
     */
	public void addInfo(InfoNutricional info, int cantidad) {
		double factor = info.getFactor(cantidad);
		this.calorias += info.calorias * factor;
		for (ElementoNutricional nutriente : ElementoNutricional.values()) {
			Double valor = this.nutrientes.get(nutriente);
			if (valor != null) {
				this.nutrientes.put(nutriente, valor + info.nutrientes.get(nutriente) * factor);
			}
		}
	}
	/**
     * Añadir info a otro objeto
     * 
     * @param InfoNutricional info para añadir
     */
	public void addInfo(InfoNutricional info) {
		this.addInfo(info, 1);
	}
	/**
     * Obtener el factor por el que multiplicar una cantidad
     * 
     * @param int cantidad de factor
     * @return double factor en cuestion
     */
	public double getFactor(int cantidad) {
		return (double) cantidad;
	}
	
	/**
	 * Obtener cantidad de un nutriente
	 * 
	 * @param nutriente
	 * @return double nutriente
	 */
	public double getNutriente(ElementoNutricional nutriente) {
		return this.nutrientes.get(nutriente);
	}
	/**
	 * 
	 * @return calorias
	 */
	public double getCalorias() {
		return calorias;
	}
	
	/**
	 * Metodo auxiliar para prints
	 * 
	 * @return ""
	 */
	public String getTipo() {
		return "";
	}
	
	/**
     * Funcion para poder escribir la clase con formato a fichero
     * 
     * @return String con la InfoNutricional
     */
	public String toFile() {
	    DecimalFormat n = new DecimalFormat("#.##");
	    DecimalFormatSymbols customSymbols = new DecimalFormatSymbols(Locale.US);
	    customSymbols.setDecimalSeparator('.');
	    n.setDecimalFormatSymbols(customSymbols);

	    StringBuilder sb = new StringBuilder(n.format(this.calorias));
	    for (ElementoNutricional nutriente : ElementoNutricional.values()) {
	        if (nutriente != ElementoNutricional.CALORIAS) {
	            Double value = this.nutrientes.get(nutriente);
	                sb.append(";").append(n.format(value));
	        }
	    }

	    return sb.toString();
	}
	
	@Override
	public String toString() {
	    DecimalFormat n = new DecimalFormat("#.##");
	    return "Valor energetico: " + n.format(this.calorias) + " kcal, Hidratos de carbono: " + n.format(this.nutrientes.get(ElementoNutricional.HIDRATOS))
	            + " g, Grasas: " + n.format(this.nutrientes.get(ElementoNutricional.GRASA_TOTAL)) + " g, Saturadas: " + n.format(this.nutrientes.get(ElementoNutricional.GRASA_SATURADA))
	            + " g, Proteinas: " + n.format(this.nutrientes.get(ElementoNutricional.PROTEINAS))  + " g, Azucares: " + n.format(this.nutrientes.get(ElementoNutricional.AZUCARES))  + "g, Fibra: "
	            + n.format(this.nutrientes.get(ElementoNutricional.AZUCARES)) + " g, Sodio: " +n.format(this.nutrientes.get(ElementoNutricional.SODIO))  + " mg.";
	}

}