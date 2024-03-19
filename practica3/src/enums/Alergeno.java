package enums;

/**
 * 
 * @author Pol Pumar, Jorge Ibarreta
 */

public enum Alergeno {

	GLUTEN("gluten"), LACTOSA("lactosa"), FRUTOS_SECOS("frutos secos"), HUEVO("huevo");

	private String text;

	/**
	 * 
	 * @param string
	 */
	Alergeno(String string) {
		this.text = string;
	}

	@Override
	public String toString() {
		return this.text;
	}

}
