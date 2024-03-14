import java.io.*;



public class ManejadorFicheros{
    private List<Menu> menus = new ArrayList<>();



    public List<menu> getMenus(){
        return menus;
    }

    public void guardarFichero(String fichero, List<menu> new_menus){
        try(FileWriter f = new FileWriter(fichero)){
            PrintWriter pw = new PrintWriter(f);
            pw.println("MENU;");
            for(Menu m: new_menus){
                pw.print(menuGetPlatos(m)+";")
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        



    }

    public void leerFichero(String fichero){

    }





}



/*     public void menuFichero(){
        for(Plato p: )


    }
    public void platoFichero(){

    }

    */