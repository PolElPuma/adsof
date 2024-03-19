package adsof_prac3;

import java.util.*;

public class PruebaComida {

    public static void main(String[] args) {
        PruebaComida prueba = new PruebaComida();
        prueba.probarClases();
    }

    public void probarClases() {
        Map<String, Ingrediente> ingredientes = crearIngredientes();

        System.out.println("Ingredientes:");
        for (Ingrediente ingrediente : ingredientes.values()) {
            System.out.println("- " + ingrediente);
        }
        System.out.println();

        List<Plato> platos = crearPlatos(ingredientes);

        System.out.println("Platos:");
        for (Plato plato : platos) {
            System.out.println("- " + plato);
        }
        System.out.println();

        Menu menu = crearMenu(platos);

        System.out.println("Menú:");
        System.out.println(menu);
    }

    public Map<String, Ingrediente> crearIngredientes() {
        Map<String, Ingrediente> ingredientes = new LinkedHashMap<>();
        ingredientes.put("Pasta",
                new Ingrediente("Pasta", TipoIngrediente.CEREAL,
                        new InfoNutricionalPeso(372, 74, 1.8, 0.277, 12, 2.6, 2.9, 6))
                .tieneAlergenos(Alergeno.GLUTEN, Alergeno.HUEVO));
        ingredientes.put("Tomate", new Ingrediente("Tomate", TipoIngrediente.FRUTA_VERDURA,
                new InfoNutricionalUnidad(14, 2.2, 0.2, 0, 0.7, 2.04, 1, 4)));
        ingredientes.put("Aceite", new Ingrediente("Aceite", "Grasa",
                new InfoNutricionalPeso(885, 0, 100, 12.81, 0, 0, 0, 2)));
        return ingredientes;
    }

    public List<Plato> crearPlatos(Map<String, Ingrediente> ingredientes) {
        List<Plato> platos = new ArrayList<>();
        Plato plato1 = new Plato("Pasta con tomate");
        plato1.addIngrediente(ingredientes.get("Pasta"), 200);
        plato1.addIngrediente(ingredientes.get("Tomate"), 100);
        platos.add(plato1);
        return platos;
    }

    public Menu crearMenu(List<Plato> platos) {
        Menu menu = new Menu();
        for (Plato plato : platos) {
            menu.addPlato(plato);
        }
        return menu;
    }
}