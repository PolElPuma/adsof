package nutricionales;

/**
 * 
 * @author Pol Pumar, Jorge Ibarreta
 */

public class InfoNutricionalPeso extends InfoNutricional {

	public InfoNutricionalPeso(double calorias, double hidratos, double grasas_tot, double grasas_sat, double proteinas,
			double azucar, double fibra, double sodio) {
		super(calorias, hidratos, grasas_tot, grasas_sat, proteinas, azucar, fibra, sodio);
	}

	/**
	 * Convierte a String la InfoNutricionalPeso
	 * 
	 * @return String con la InfoNutricionalPeso
	 */
	@Override
	public String toString() {
		return "INFORMACION NUTRICIONAL POR 100 g -> " + super.toString();
	}

	/**
	 * Getter del factor deun InfoNutricionalPeso
	 * 
	 * @return double porcentaje de cantidad
	 */
	@Override
	public double getFactor(int cantidad) {
		return (double) cantidad / 100;
	}

	/**
	 * Metodo auxiliar para prints
	 * 
	 * @return String con el tipo
	 */
	@Override
	public String getTipo() {
		return "PESO";
	}

}
