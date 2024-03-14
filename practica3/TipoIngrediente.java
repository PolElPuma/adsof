package adsof_prac3;

public enum TipoIngrediente {
	CARNE("Carne"),PESCADO("Pescado"),FRUTA_VERDURA("Frutas y verduras"),
	LEGUMBRE("Legumbre"),CEREAL("Cereal"),HUEVO("Huevo"),LACTEO("LACTEO");
	
	
	private String text;
	TipoIngrediente(String string) {
		this.text = string;
	}
	@Override
	public String toString() {
		return text;
	}
	
}
