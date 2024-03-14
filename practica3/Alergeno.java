package adsof_prac3;

public enum Alergeno {
	
	GLUTEN("gluten"),LACTOSA("lactosa"),HUEVO("huevo"),FRUTOS_SECOS("frutos secos");
	
	private String text;
	Alergeno(String string) {
		this.text = string;
	}
	@Override
	public String toString() {
		return this.text;
	}

}
