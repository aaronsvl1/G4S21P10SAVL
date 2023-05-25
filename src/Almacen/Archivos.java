/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Almacen;

import Infomacion.Convertir;
import Infomacion.Datos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shack
 */
public class Archivos {
    List<Datos> contenido = new ArrayList<>();
    
    public List<Datos> Leer(){
        String linea;
        Datos datos;
        try {
            FileReader archivo = new FileReader("DATOS.txt");
            BufferedReader br = new BufferedReader(archivo);
            
            while((linea = br.readLine())!= null){
                datos = new Datos();
                Convertir convertir = new Convertir();
                datos = convertir.aclase(linea);
                contenido.add(datos);
                System.out.println("valor de linea" +linea );
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contenido;
    }
    public boolean grabar(Datos cadena){
        Convertir convertir= new Convertir();
        boolean estado= true;
        FileWriter archivo;
        try {
            archivo = new FileWriter("DATOS.txt", true);
            BufferedWriter bw = new BufferedWriter(archivo);
            bw.write(convertir.ajson(cadena)+"\n");
            bw.close();
            archivo.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            estado = false;
        } 
        return estado;
    }
}
