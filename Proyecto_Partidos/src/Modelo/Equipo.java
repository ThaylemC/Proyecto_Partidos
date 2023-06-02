package Modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Equipo{
    private int ID;
    private String Nombre_Equipo;
    private String Nombre_Entrenador;
    private final String Equipos = "C:\\Users\\pc\\OneDrive\\Documentos\\NetBeansProjects\\Proyecto_Partidos\\src\\Archivos\\Equipos.txt";


    public Equipo(){
    
    }
    public Equipo(String Nombre_Equipo,String Nombre_Entrenador){
        this.ID = GenerarID();
        this.Nombre_Entrenador = Nombre_Entrenador;
        this.Nombre_Equipo = Nombre_Equipo;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNombre_Equipo(String Nombre_Equipo) {
        this.Nombre_Equipo = Nombre_Equipo;
    }

    public void setNombre_Entrenador(String Nombre_Entrenador) {
        this.Nombre_Entrenador = Nombre_Entrenador;
    }
    
    public int getID() {
        return ID;
    }

    public String getNombre_Equipo() {
        return Nombre_Equipo;
    }

    public String getNombre_Entrenador() {
        return Nombre_Entrenador;
    }
    
    @Override
    public String toString(){
        return ID + "|"  + Nombre_Equipo + "|" + Nombre_Entrenador;
    }
    
    public int GenerarID() {
        int id = 0;
        
        try {
            File archivo = new File(Equipos);
            Scanner consola = new Scanner(archivo);
            while (consola.hasNextLine()) {
                consola.nextLine();
                id++;
            }
            consola.close();
        } catch (Exception ex) {
                 JOptionPane.showMessageDialog(null,ex.getMessage());

        }
        return id;
    }
}
