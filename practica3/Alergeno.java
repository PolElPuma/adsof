package adsof_prac3;

public enum Alergeno {
	
	GLUTEN("gluten"),LACTOSA("lactosa"),FRUTOS_SECOS("frutos secos"), HUEVO("huevo");
	
	private String text;
	Alergeno(String string) {
		this.text = string;
	}
	@Override
	public String toString() {
		return this.text;
	}

}
