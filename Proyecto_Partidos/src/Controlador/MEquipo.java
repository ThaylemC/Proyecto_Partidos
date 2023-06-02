/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Equipo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author franc
 */
public class MEquipo implements Interfaz {
    private final String Equipos = "C:\\Users\\pc\\OneDrive\\Documentos\\NetBeansProjects\\Proyecto_Partidos\\src\\Archivos\\Equipos.txt";
    private final String tempFile = "C:\\Users\\pc\\OneDrive\\Documentos\\NetBeansProjects\\Proyecto_Partidos\\src\\Archivos\\Archivo_Temp.txt";

    private Equipo equipo;
    
    public MEquipo(){
    
    }
    public MEquipo(Equipo equipo){
        this.equipo = equipo;
    }
    @Override
    public boolean Agregar() {
        try{
            FileWriter fileWriter = new FileWriter(Equipos, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(equipo.toString());
            bufferedWriter.newLine();
            bufferedWriter.close();
            return true;

        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean Eliminar() {
        try (BufferedReader br = new BufferedReader(new FileReader(Equipos))) {
            FileWriter fileWriter = new FileWriter(tempFile, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] Datos = linea.split("\\|");
                String id = String.valueOf(equipo.getID());
                if (!Datos[0].equals(id)) {
                    bufferedWriter.write(String.join("|",Datos));
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
            br.close();

            // Reemplazar el archivo original con el archivo temporal
            File archivoOriginal = new File(Equipos);
            File archivoTemporal = new File(tempFile);
            if (archivoOriginal.exists()) {
                archivoOriginal.delete();
            }
            archivoTemporal.renameTo(archivoOriginal);

            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean Actualizar() {
        try (BufferedReader br = new BufferedReader(new FileReader(Equipos))) {
            FileWriter fileWriter = new FileWriter(tempFile, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] Datos = linea.split("\\|");
                String id = String.valueOf(equipo.getID());
                if (Datos[0].equals(id)) {
                    bufferedWriter.write(equipo.toString());
                    bufferedWriter.newLine();
                } else {
                    bufferedWriter.write(linea);
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
            br.close();

            // Reemplazar el archivo original con el archivo temporal
            File archivoOriginal = new File(Equipos);
            File archivoTemporal = new File(tempFile);
            if (archivoOriginal.exists()) {
                archivoOriginal.delete();
            }
            archivoTemporal.renameTo(archivoOriginal);

            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }

    @Override
    public List<String> Listar() {
        List<String> Datos = new ArrayList<String>();
        
        try {
            File archivo = new File(Equipos);
            Scanner consola = new Scanner(archivo);
            while (consola.hasNextLine()) {
                String Valor = consola.nextLine();
                Datos.add(Valor);
            }
            consola.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        
        return Datos;
    }
}
