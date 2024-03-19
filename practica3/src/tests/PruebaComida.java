package tests;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import comidas.Ingrediente;
import comidas.Menu;
import comidas.Plato;
import enums.Alergeno;
import enums.ElementoNutricional;
import enums.TipoIngrediente;
import nutricionales.InfoNutricionalPeso;
import nutricionales.InfoNutricionalUnidad;
import utiles.ManejadorFicheros;
import utiles.PlanificadorMenu;

/**
 * 
 * @author Pol Pumar, Jorge Ibarreta
 */

public class PruebaComida {

	public static void main(String[] args) {
		PruebaComida prueba = new PruebaComida();
		prueba.probarClases();
	}

	private void probarClases() {
		Map<String, Ingrediente> ingredientes = crearIngredientes();

		System.out.println("Ingredientes:");
		for (Ingrediente ingrediente : ingredientes.values()) {
			System.out.println("* " + ingrediente);
		}
		System.out.println();
		List<Plato> platos = crearPlatos(ingredientes);
		System.out.println("Platos:");
		for (Plato plato : platos) {
			System.out.println("* " + plato);
		}
		System.out.println();
		Menu menu = crearMenu(platos);
		System.out.println("Menú:");
		System.out.println(menu);
		System.out.println("\nPruebas adicionales:");
		probarErrores(menu, ingredientes);
		probarEntero();
	}

	private Map<String, Ingrediente> crearIngredientes() {
		Map<String, Ingrediente> ingredientes = new LinkedHashMap<>();
		ingredientes.put("Pasta",
				new Ingrediente("Pasta", TipoIngrediente.CEREAL,
						new InfoNutricionalPeso(372, 74, 1.8, 0.277, 12, 2.6, 2.9, 6))
						.tieneAlergenos(Alergeno.GLUTEN, Alergeno.HUEVO));
		ingredientes.put("Tomate", new Ingrediente("Tomate", TipoIngrediente.FRUTA_VERDURA,
				new InfoNutricionalUnidad(14, 2.2, 0.2, 0, 0.7, 2.04, 1, 4)));
		ingredientes.put("Aceite",
				new Ingrediente("Aceite", "Grasa", new InfoNutricionalPeso(885, 0, 100, 12.81, 0, 0, 0, 2)));
		return ingredientes;
	}

	private List<Plato> crearPlatos(Map<String, Ingrediente> ingredientes) {
		List<Plato> platos = new ArrayList<>();
		Plato plato1 = new Plato("Pasta con tomate");
		plato1.addIngrediente(ingredientes.get("Pasta"), 200);
		plato1.addIngrediente(ingredientes.get("Tomate"), 100);
		platos.add(plato1);
		return platos;
	}

	private Menu crearMenu(List<Plato> platos) {
		Menu menu = new Menu();
		for (Plato plato : platos) {
			menu.addPlato(plato);
		}
		return menu;
	}

	private void probarErrores(Menu menu, Map<String, Ingrediente> ingredientes) {
		System.out.println("Intentar añadir un plato que ya está en el menú:");
		Plato platoDuplicado = new Plato("Pasta con tomate");
		platoDuplicado.addIngrediente(ingredientes.get("Pasta"), 200);
		platoDuplicado.addIngrediente(ingredientes.get("Tomate"), 100);
		menu.addPlato(platoDuplicado);
		System.out.println("El menú antes: " + menu);
		menu.addPlato(platoDuplicado);
		System.out.println("El menú después: " + menu);
		System.out.println("\nIntentar crear un menú sin platos:");
		Menu menuVacio = new Menu();
		System.out.println(menuVacio);
	}

	private void probarEntero() {
		System.out.println("\nPRUEBA TOTAL DE FUNCIONAMIENTO:");
		System.out.println("Se leen ingredientes y platos de fichero");
		ManejadorFicheros.leerFichero("." + File.separator + "resources" + File.separator + "nuestrotester.txt");
		Collection<Ingrediente> ingredientes = ManejadorFicheros.getIngredientes();
		Collection<Plato> platos = ManejadorFicheros.getPlatos();
		System.out.println("\nIngredientes:");
		for (Ingrediente ingrediente : ingredientes) {
			System.out.println("* " + ingrediente);
		}
		System.out.println("\nPlatos:");
		for (Plato plato : platos) {
			System.out.println("* " + plato);
		}
		System.out.println(
				"\nPlanificamos automaticamente un menu con estos platos y ciertos requisitos (kcal 1500 - 2500, grasas < 30g, azúcar < 25g):");
		PlanificadorMenu planificador = new PlanificadorMenu(new ArrayList<>(platos))
				.conMaximo(ElementoNutricional.GRASA_TOTAL, 30.0).conMaximo(ElementoNutricional.AZUCARES, 25.0)
				.sinAlergenos(Alergeno.GLUTEN);
		Menu menu = planificador.planificar(1500, 2500);
		System.out.println("* " + menu);
	}

}
