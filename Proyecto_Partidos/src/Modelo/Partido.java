
package Modelo;
import Controlador.Interfaz;
import java.io.File;
import java.time.LocalDate;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class Partido{

    private long ID;
    private LocalDate Fecha;
    private String Equipo_Local;
    private int Goles_Local;
    private String Equipo_Visitante;
    private int Goles_Visitante;
    private String Partidos = "C:\\Users\\pc\\OneDrive\\Documentos\\NetBeansProjects\\Proyecto_Partidos\\src\\Archivos\\Partidos.txt";

    public Partido(String Equipo_Local, int Goles_Local, String Equipo_Visitante, int Goles_Visitante){
        this.ID = GenerarID();
        this.Equipo_Local = Equipo_Local;
        this.Goles_Local = Goles_Local;
        this.Equipo_Visitante = Equipo_Visitante;
        this.Goles_Visitante = Goles_Visitante;
        this.Fecha = LocalDate.now();
    }
    
    public Partido(){
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setFecha(LocalDate Fecha) {
        this.Fecha = Fecha;
    }

    public void setEquipo_Local(String Equipo_Local) {
        this.Equipo_Local = Equipo_Local;
    }

    public void setGoles_Local(int Goles_Local) {
        this.Goles_Local = Goles_Local;
    }

    public void setEquipo_Visitante(String Equipo_Visitante) {
        this.Equipo_Visitante = Equipo_Visitante;
    }

    public void setGoles_Visitante(int Goles_Visitante) {
        this.Goles_Visitante = Goles_Visitante;
    }
    
    public long getID() {
        return ID;
    }

    public LocalDate getFecha() {
        return Fecha;
    }

    public String getEquipo_Local() {
        return Equipo_Local;
    }

    public int getGoles_Local() {
        return Goles_Local;
    }

    public String getEquipo_Visitante() {
        return Equipo_Visitante;
    }

    public int getGoles_Visitante() {
        return Goles_Visitante;
    }

    
    @Override
    public String toString(){
        return ID + "|" + Equipo_Local + "|" +Goles_Local + "|" + Equipo_Visitante + "|" + Goles_Visitante + "|" + Fecha;
    }
    
    public int GenerarID() {
        int id = 0;
        
        try {
            File archivo = new File(Partidos);
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
