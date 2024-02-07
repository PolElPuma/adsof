/**
* Esta aplicación muestra la frecuencia con la que aparecen las distitnas longitudes de las palabras
*
* @author Pol Pumar pol.pumar@estudiante.uam.es y Jorge Ibarreta jorge.ibarreta@estudiante.uam.es
*
*/

/**
 * Esta clase calcula la frecuencia de las longitudes de las palabras
 */
public class FrecuenciaPalabras {
    public static void main(String[] args) {
        if (args.length == 0)
            System.err.println("Se espera al menos una palabra como parametro.");
        else {
            LongitudPalabras palabras = new LongitudPalabras(args);
            imprimeFrecuencias(palabras);
        }
    }

    /**
     * Imprime la frecuencia de las distitnas longitudes
     * 
     * @param palabras Palabras de las que se quiere calcular las frecuencias.
     */
    private static void imprimeFrecuencias(LongitudPalabras palabras) {
        System.out.println(palabras);
        for (int longitud : palabras.getLongitudesUnicas())
            System.out.println("Hay " + palabras.getFrecuencia(longitud) + " palabras de " + longitud + " letras.");
    }

}
