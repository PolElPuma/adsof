package adsof_prac3;

import java.io.*;
import java.util.*;


public class ManejadorFicheros{
	 	private static Map<String, Ingrediente> ingredientes = new HashMap<>();
	    private static Map<String, Plato> platosMap = new HashMap<>();
	    private static List<Menu> menus = new ArrayList<>();

	    
	    /**
	     * Lee una lista de menus de un fichero
	     * 
	     * @param String nombreArchivo nombre del archivo a leer
	     * 
	     * @return List de los menus leidos
	     */
	    public static List<Menu> leerFichero(String nombreArchivo) {
	        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
	            String linea;
	            while ((linea = br.readLine()) != null) {
	                if (linea.startsWith("PLATO")) {
	                    procesarPlato(linea);
	                } else if (linea.startsWith("MENU")) {
	                    procesarMenu(linea);
	                } else if (linea.startsWith("INGREDIENTE")) {
	                    procesarIngrediente(linea);
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return menus;
	    }
	    
	    
	    /**
	     * Guarda menus en un fichero
	     * 
	     * @param String nombreArchivo nombre del archivo a guardar
	     * @param List menus lista de menus a guardar
	     */
	    public static void guardarFichero(String nombreArchivo, List<Menu> menus) {
	        try (PrintWriter pw = new PrintWriter(new FileWriter(nombreArchivo))) {
	            Set<Ingrediente> ingredientesSet = new HashSet<>();
	            Set<Plato> platosSet = new HashSet<>();

	            for (Menu menu : menus) {
	               menu.recopilarIngredientesPlatos(ingredientesSet, platosSet);
	            }

	            for (Ingrediente ingrediente : ingredientesSet) {
	                pw.println(ingrediente.toFile());
	            }

	            for (Plato plato : platosSet) {
	                pw.println(plato.toFile());
	            }

	            for (Menu menu : menus) {
	                pw.println(menu.toFile());
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	   
	    /**
	     * Procesa una cadena como un ingrediente
	     * 
	     * @param String linea a leer
	     * 
	     */
	    private static void procesarIngrediente(String linea) {
	        String[] partes = linea.split(";");
	        String nombre = partes[1];
	        if (!ingredientes.containsKey(nombre)) {
	        	InfoNutricional info;
	        	if(partes[0].equals("INGREDIENTE_PESO")){
	        	     info = new InfoNutricionalPeso(Double.parseDouble(partes[3]),
	                    Double.parseDouble(partes[4]), Double.parseDouble(partes[5]), Double.parseDouble(partes[6]),
	                    Double.parseDouble(partes[7]), Double.parseDouble(partes[8]), Double.parseDouble(partes[9]),
	                    Double.parseDouble(partes[10]));
	        	}else {
	        		 info = new InfoNutricionalUnidad(Double.parseDouble(partes[3]),
		                    Double.parseDouble(partes[4]), Double.parseDouble(partes[5]), Double.parseDouble(partes[6]),
		                    Double.parseDouble(partes[7]), Double.parseDouble(partes[8]), Double.parseDouble(partes[9]),
		                    Double.parseDouble(partes[10]));
	        	}
	        	Ingrediente ingrediente = new Ingrediente(partes[1], partes[2],info);
	        	for (int i = 0; i < 4; i++) {
		            if(partes[i+11].equals(("Y"))){
		            	ingrediente.tieneAlergenos(Alergeno.values()[i]);
		            }
		        }
	            ingredientes.put(nombre, ingrediente);
	        }
	    }
	    
	    
	    /**
	     * Procesa una cadena como un plato
	     * 
	     * @param String linea a leer
	     * 
	     */
	    private static void procesarPlato(String linea) {
	        String[] partes = linea.split(";");
	        String nombre = partes[1];
	        if (!platosMap.containsKey(nombre)) {
	            Plato plato = new Plato(nombre);
	            for (int i = 2; i < partes.length; i++) {
	                String[] comp = partes[i].split(" ");
	                if (comp[0].equals("PLATO")) {
	                    plato.addPlato(platosMap.get(comp[1]));
	                } else {
	                    String nombreIngrediente = comp[1].split(":")[0];
	                    int cantidad = Integer.parseInt(comp[1].split(":")[1]);
	                    plato.addIngrediente(ingredientes.get(nombreIngrediente),cantidad);
	                }
	            }
	            platosMap.put(nombre, plato);
	        }
	    }
	    
	    
	    /**
	     * Procesa una cadena como un menu
	     * 
	     * @param String linea a leer
	     * 
	     */
	    private static void procesarMenu(String linea) {
	        String[] partes = linea.split(";");
	        Menu menu = new Menu();
	        ArrayList<Plato> platos = new ArrayList<>(); 
	        for (int i = 1; i < partes.length; i++) {
	            menu.addPlato(platosMap.get(partes[i]));
	        }
	        menus.add(menu);
	    }
	    
	    
	    /**
	     * Getter campo menus
	     * 
	     * @return List de los menus
	     * 
	     */
	    public static List<Menu> getMenus(){
	    	return menus;
	    }
	}

    