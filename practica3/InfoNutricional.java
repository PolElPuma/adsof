package adsof_prac3;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class InfoNutricional {
	private double calorias;
	private double hidratos;
	private double grasas_tot;
	private double grasas_sat;
	private double proteinas;
	private double azucar;
	private double fibra;
	private double sodio;
	
	
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
	public InfoNutricional(double calorias, double hidratos, double grasas_tot, double grasas_sat, double proteinas,
			double azucar, double fibra, double sodio) {
		this.calorias = calorias;
		this.hidratos = hidratos;
		this.grasas_tot = grasas_tot;
		this.grasas_sat = grasas_sat;
		this.proteinas = proteinas;
		this.azucar = azucar;
		this.fibra = fibra;
		this.sodio = sodio;
	}
	
	
	/**
     * Añadir info a otro objeto
     * 
     * @param InfoNutricional info para añadir
     * @param int cantidad cantidad a añadir
     */
	public void addInfo(InfoNutricional info, int cantidad) {
		double factor = info.getFactor(cantidad);
		this.calorias += info.calorias * factor;
		this.hidratos += info.hidratos * factor;
		this.grasas_tot += info.grasas_tot * factor;
		this.grasas_sat += info.grasas_sat * factor;
		this.proteinas += info.proteinas * factor;
		this.azucar += info.azucar * factor;
		this.fibra += info.fibra * factor;
		this.sodio += info.sodio * factor;
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
     * Obtener el factor correspondiente a un objeto
     * 
     * @param int cantidad de factor
     * @return double factor en cuestion
     */
	public double getFactor(int cantidad) {
		return (double) cantidad;
	}
	
	
	/**
     * Funcion para poder tratar la clase con ficheros
     * 
     * @return String con la InfoNutricional
     */
	public String toFile() {
		DecimalFormat n = new DecimalFormat("#.##");
		DecimalFormatSymbols customSymbols = new DecimalFormatSymbols(Locale.US);
		customSymbols.setDecimalSeparator('.');
		n.setDecimalFormatSymbols(customSymbols);
		return n.format(this.calorias) + ";" + n.format(this.hidratos) + ";" + n.format(this.grasas_tot) + ";"
				+ n.format(this.grasas_sat) + ";" + n.format(this.proteinas) + ";" + n.format(this.azucar) + ";"
				+ n.format(this.fibra) + ";" + n.format(this.sodio);
	}

	public String getTipo() {
		return "";
	}

	@Override
	public String toString() {
		DecimalFormat n = new DecimalFormat("#.##");
		return "Valor energetico: " + n.format(this.calorias) + " kcal, Hidratos de carbono: " + n.format(this.hidratos)
				+ " g, Grasas: " + n.format(this.grasas_tot) + " g, Saturadas: " + n.format(this.grasas_sat)
				+ " g, Proteinas: " + n.format(this.proteinas) + " g, Azucares: " + n.format(this.azucar) + "g, Fibra: "
				+ n.format(this.fibra) + " g, Sodio: " + n.format(this.sodio) + " mg.";
	}

	/**
	 * Getter del campo calorias
	 * @return the calorias
	 */
	public double getCalorias() {
		return calorias;
	}

	/**
	 * Getter del campo hidratos
	 * @return the hidratos
	 */
	public double getHidratos() {
		return hidratos;
	}

	/**
	 * Getter del campo grasas_tot
	 * @return the grasas_tot
	 */
	public double getGrasa_total() {
		return grasas_tot;
	}

	/**
	 * Getter del campo grasas_sat
	 * @return the grasas_sat
	 */
	public double getGrasa_saturada() {
		return grasas_sat;
	}

	/**
	 * Getter del campo proteinas
	 * @return the proteinas
	 */
	public double getProteinas() {
		return proteinas;
	}

	/**
	 * Getter del campo azucares
	 * @return the azucar
	 */
	public double getAzucares() {
		return azucar;
	}

	/**
	 * Getter del campo fibra
	 * @return the fibra
	 */
	public double getFibra() {
		return fibra;
	}

	/**
	 * Getter del campo sodio
	 * @return the sodio
	 */
	public double getSodio() {
		return sodio;
	}
	
	

}
