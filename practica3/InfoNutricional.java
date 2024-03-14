package adsof_prac3;

import java.text.DecimalFormat;

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
		this.addInfo(info,1);
	}
	
	public double getFactor(int cantidad) {
		return (double) cantidad;
	}
	
	
	
	@Override
	public String toString() {
		DecimalFormat n = new DecimalFormat("#.00");
		return "Valor energetico: "+n.format(this.calorias)+" kcal, Hidratos de carbono: " + n.format(this.hidratos) + " g, Grasas: "
				+ n.format(this.grasas_tot) + " g, Saturadas: " + n.format(this.grasas_tot) + " g, Proteinas: " + n.format(this.proteinas) 
				+ " g, Azucares: " + n.format(this.azucar) + "g, Fibra: " +  n.format(this.fibra) + " g, Sodio: " + n.format(this.sodio) + " mg.";
	}

	
}
