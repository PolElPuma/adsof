package utiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import comidas.Ingrediente;
import comidas.Menu;
import comidas.Plato;
import enums.Alergeno;
import nutricionales.InfoNutricional;
import nutricionales.InfoNutricionalPeso;
import nutricionales.InfoNutricionalUnidad;

/**
 * 
 * @author Pol Pumar, Jorge Ibarreta
 */

public class ManejadorFicheros {
	private static Map<String, Ingrediente> ingredientes = new HashMap<>();
	private static Map<String, Plato> platosMap = new HashMap<>();
	private static List<Menu> menus = new ArrayList<>();

	/**
	 * Lee una lista de menus de un fichero
	 * 
	 * @param nombreArchivo nombre del archivo a leer
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
	 * @param nombreArchivo nombre del archivo a guardar
	 * @param menus lista de menus a guardar
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
	 * @param linea a leer
	 * 
	 */
	private static void procesarIngrediente(String linea) {
		String[] partes = linea.split(";");
		String nombre = partes[1];
		if (!ingredientes.containsKey(nombre)) {
			InfoNutricional info;
			if (partes[0].equals("INGREDIENTE_PESO")) {
				info = new InfoNutricionalPeso(Double.parseDouble(partes[3]), Double.parseDouble(partes[4]),
						Double.parseDouble(partes[5]), Double.parseDouble(partes[6]), Double.parseDouble(partes[7]),
						Double.parseDouble(partes[8]), Double.parseDouble(partes[9]), Double.parseDouble(partes[10]));
			} else {
				info = new InfoNutricionalUnidad(Double.parseDouble(partes[3]), Double.parseDouble(partes[4]),
						Double.parseDouble(partes[5]), Double.parseDouble(partes[6]), Double.parseDouble(partes[7]),
						Double.parseDouble(partes[8]), Double.parseDouble(partes[9]), Double.parseDouble(partes[10]));
			}
			Ingrediente ingrediente = new Ingrediente(partes[1], partes[2], info);
			for (int i = 0; i < 4; i++) {
				if (partes[i + 11].equals(("Y"))) {
					ingrediente.tieneAlergenos(Alergeno.values()[i]);
				}
			}
			ingredientes.put(nombre, ingrediente);
		}
	}

	/**
	 * Procesa una cadena como un plato
	 * 
	 * @param linea a leer
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
					plato.addIngrediente(ingredientes.get(nombreIngrediente), cantidad);
				}
			}
			platosMap.put(nombre, plato);
		}
	}

	/**
	 * Procesa una cadena como un menu
	 * 
	 * @param linea a leer
	 * 
	 */
	private static void procesarMenu(String linea) {
		String[] partes = linea.split(";");
		Menu menu = new Menu();
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
	public static List<Menu> getMenus() {
		return menus;
	}

	/**
	 * Getter campo menus
	 * 
	 * @return List de los menus
	 * 
	 */
	public static Collection<Plato> getPlatos() {
		return platosMap.values();
	}

	/**
	 * Getter campo menus
	 * 
	 * @return List de los menus
	 * 
	 */
	public static Collection<Ingrediente> getIngredientes() {
		return ingredientes.values();
	}
}
