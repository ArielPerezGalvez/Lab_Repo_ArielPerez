/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_repo_arieperez;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ariel
 */
public class Personas {

    private String nombre;
    private String apellido;
    private String correo;
    private Date fecha;
    private String pais;
    private int numero;
    private String contrasena;
    private ArrayList<String> mensajes = new ArrayList();
    private ArrayList<String> no_leidos = new ArrayList();
    private ArrayList<String> leidos = new ArrayList();
    private ArrayList<String> no_deseados = new ArrayList();
    private ArrayList<String> spam = new ArrayList();
    private ArrayList<String> borradores = new ArrayList();
    private ArrayList<String> enviados = new ArrayList();
    private ArrayList<String> eliminados = new ArrayList();
    private ArrayList<String> importantes = new ArrayList();
    ArrayList<Personas> per= new ArrayList();
    private File archivo = null;

    public Personas() {
    }

    public Personas(String nombre, String apellido, String correo, Date fecha, String pais, int numero, String contrasena) {
        this.per = new ArrayList();
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.fecha = fecha;
        this.pais = pais;
        this.numero = numero;
        this.contrasena = contrasena;
    }

    public Personas(String nombre) {
        this.per = new ArrayList();
        this.nombre = nombre;
        archivo = new File("./@unitec.edu/" + nombre + ".txt");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public ArrayList<String> getMensajes() {
        return mensajes;
    }

    public void setMensajes(ArrayList<String> mensajes) {
        this.mensajes = mensajes;
    }

    public ArrayList<String> getNo_leidos() {
        return no_leidos;
    }

    public void setNo_leidos(ArrayList<String> no_leidos) {
        this.no_leidos = no_leidos;
    }

    public ArrayList<String> getLeidos() {
        return leidos;
    }

    public void setLeidos(ArrayList<String> leidos) {
        this.leidos = leidos;
    }

    public ArrayList<String> getNo_deseados() {
        return no_deseados;
    }

    public void setNo_deseados(ArrayList<String> no_deseados) {
        this.no_deseados = no_deseados;
    }

    public ArrayList<String> getSpam() {
        return spam;
    }

    public void setSpam(ArrayList<String> spam) {
        this.spam = spam;
    }

    public ArrayList<String> getBorradores() {
        return borradores;
    }

    public void setBorradores(ArrayList<String> borradores) {
        this.borradores = borradores;
    }

    public ArrayList<String> getEnviados() {
        return enviados;
    }

    public void setEnviados(ArrayList<String> enviados) {
        this.enviados = enviados;
    }

    public ArrayList<String> getEliminados() {
        return eliminados;
    }

    public void setEliminados(ArrayList<String> eliminados) {
        this.eliminados = eliminados;
    }

    public ArrayList<String> getImportantes() {
        return importantes;
    }

    public void setImportantes(ArrayList<String> importantes) {
        this.importantes = importantes;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
        cargarArchivo();
        setNombre(this.archivo.getName());
    }

    @Override
    public String toString() {
        return "Personas{" + "nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", fecha=" + fecha + ", pais=" + pais + ", numero=" + numero + ", contrasena=" + contrasena + '}';
    }
     public void setPersona(Personas s ){
        this.per.add(s);
    };


    public void escribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            for (Personas t : per) {
                bw.write(t.getNombre()+";");
                bw.write(t.getApellido() + ";");
                bw.write(t.getCorreo() + ";");
                bw.write(t.getContrasena()+";");
                bw.write(t.getNumero()+";");
                bw.write(t.getPais()+";");
                bw.write(t.getFecha()+";");
            }
            bw.flush();
        } catch (Exception e) {
        }
        bw.close();
        fw.close();
    }

    public void cargarArchivo() {

        if (archivo.exists()) {//asi verificamos si el archivo existe
            Scanner sc = null;
            try {
                System.out.println("Nuevo");
                sc = new Scanner(archivo);
                sc.useDelimiter(";");
                while (sc.hasNext()) {
                    System.out.println("usuario");
                    per.add(new Personas());
                }
            } catch (Exception e) {
            }
            sc.close();
        }

    }

}//fin de la clase
