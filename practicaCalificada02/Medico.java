/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaCalificada02;

import java.util.ArrayList;

/**
 *
 * @author ivann
 */
public class Medico {
    private int nrocolegiatura;
    private String nombre;
    private String especialidad;
    
    private static ArrayList<Medico> medicos = new ArrayList<>();


    //Constructor

    public Medico(int nrocolegiatura, String nombre, String especialidad) {
        this.nrocolegiatura = nrocolegiatura;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }
   

    
    //Metodos

    public int getNrocolegiatura() {
        return nrocolegiatura;
    }

    public void setNrocolegiatura(int nrocolegiatura) {
        this.nrocolegiatura = nrocolegiatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public static ArrayList<Medico> getMedicos() {
        return medicos;
    }

    public static void setMedicos(ArrayList<Medico> medicos) {
        Medico.medicos = medicos;
    }
    
    
    
    
    
    //  
    
    
    public void adicionar(Medico medico) {
        medicos.add(medico);
    }

    public void imprimirMedico() {
    System.out.println("Número de Colegiatura: " + nrocolegiatura +
                       ", Nombre del Médico: " + nombre +
                       ", Especialidad: " + especialidad);
    }
    
    
    public String obtenerInformacionMedico() {
    return "Número de Colegiatura: " + nrocolegiatura + ", Nombre: " + nombre + ", Especialidad: " + especialidad;
    }
}
