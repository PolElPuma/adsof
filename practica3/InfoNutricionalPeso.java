package adsof_prac3;

public class InfoNutricionalPeso extends InfoNutricional{

	public InfoNutricionalPeso(double calorias, double hidratos, double grasas_tot, double grasas_sat, double proteinas,
			double azucar, double fibra, double sodio) {
		super(calorias, hidratos, grasas_tot, grasas_sat, proteinas, azucar, fibra, sodio);
	}
	
	@Override
	public String toString() {
		return "INFORMACION NUTRICIONAL POR 100 g -> " + super.toString();
	}
	
	@Override
	public double getFactor(int cantidad) {
		return (double) cantidad/100;
	}
	@Override
	public String getTipo() {
		return "PESO";
	}
	
	
}
