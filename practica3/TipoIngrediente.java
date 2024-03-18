package adsof_prac3;

public enum TipoIngrediente {
    CARNE("Carne", "CARNE"), PESCADO("Pescado", "PESCADO"), FRUTA_VERDURA("Frutas y verduras", "FRUTA_VERDURA"),
    LEGUMBRE("Legumbre", "LEGUMBRE"), CEREAL("Cereal", "CEREAL"), HUEVO("Huevo", "HUEVO"), LACTEO("Lacteo", "LACTEO");

    private String text;
    private String name;

    TipoIngrediente(String text, String name) {
        this.text = text;
        this.name = name;
    }

    @Override
    public String toString() {
        return text;
    }

    public String getName() {
        return name;
    }
    public static TipoIngrediente fromString(String text) throws IllegalArgumentException{
        for (TipoIngrediente tipo : TipoIngrediente.values()) {
            if (tipo.text.equalsIgnoreCase(text)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException();
    }
}
