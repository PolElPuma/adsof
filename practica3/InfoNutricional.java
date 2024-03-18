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

	public void addInfo(InfoNutricional info) {
		this.addInfo(info, 1);
	}

	public double getFactor(int cantidad) {
		return (double) cantidad;
	}

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
	 * @return the calorias
	 */
	public double getCalorias() {
		return calorias;
	}

	/**
	 * @return the hidratos
	 */
	public double getHidratos() {
		return hidratos;
	}

	/**
	 * @return the grasas_tot
	 */
	public double getGrasa_total() {
		return grasas_tot;
	}

	/**
	 * @return the grasas_sat
	 */
	public double getGrasa_saturada() {
		return grasas_sat;
	}

	/**
	 * @return the proteinas
	 */
	public double getProteinas() {
		return proteinas;
	}

	/**
	 * @return the azucar
	 */
	public double getAzucares() {
		return azucar;
	}

	/**
	 * @return the fibra
	 */
	public double getFibra() {
		return fibra;
	}

	/**
	 * @return the sodio
	 */
	public double getSodio() {
		return sodio;
	}
	
	

}
