package co.edu.uniquindio.fx10.modelo;

import co.edu.uniquindio.fx10.modelo.Propiedad;

import java.util.ArrayList;

public class DataBase {

    private ArrayList<Propiedad> listaPropiedades;
    private static DataBase db;

    public DataBase() {
        this.listaPropiedades = new ArrayList<>();
    }

    public ArrayList<Propiedad> getListaPropiedades() {
        return listaPropiedades;
    }

    public void setListaPropiedades(ArrayList<Propiedad> listaPropiedades) {
        this.listaPropiedades = listaPropiedades;
    }

    public static DataBase getInstance(){
        if (db == null){
            db = new DataBase();
        }
        return db;
    }




}
