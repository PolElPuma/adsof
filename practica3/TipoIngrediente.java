package adsof_prac3;

public enum TipoIngrediente {
    CARNE("Carne", "CARNE"), PESCADO("Pescado", "PESCADO"), FRUTA_VERDURA("Frutas y verduras", "FRUTA_VERDURA"),
    LEGUMBRE("Legumbre", "LEGUMBRE"), CEREAL("Cereal", "CEREAL"), HUEVO("Huevo", "HUEVO"), LACTEO("Lacteo", "LACTEO");

    private String text;
    private String name;
    

    /**
     * Crea un TipoIngrediente
     * 
     * @param String text a establecer
     * @param String name a establecer
     */
    TipoIngrediente(String text, String name) {
        this.text = text;
        this.name = name;
    }
    
    
    /**
     * Convierte un TipoIngrediente a String
     * 
     * @return String con la informacion de TipoIngrediente
     */
    @Override
    public String toString() {
        return text;
    }
    
    
    /**
     * Getter de campo name
     * 
     * @return String del campo name
     */
    public String getName() {
        return name;
    }
    
    
    /**
     * Convierte un String a TipoIngerdiente
     * 
     * @param String text a convertir
     * 
     * @return TipoIngrediente si ha ido bien, IllegalArgumentException si algo fue mal
     */
    public static TipoIngrediente fromString(String text) throws IllegalArgumentException{
        for (TipoIngrediente tipo : TipoIngrediente.values()) {
            if (tipo.text.equalsIgnoreCase(text)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException();
    }
}
