/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaCalificada02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ivann
 */
public class Paciente {
    private int DNI;
    private String nombre;
    private String apellido;
    private String dirección;
    private double peso;
    private double temperatura;
    private Medico medico;

    
    
    private static ArrayList<Paciente> pacientes = new ArrayList<>();

    
    //Constructor
    
    public Paciente(int DNI, String nombre, String apellido, String dirección, double peso, double temperatura, Medico medico) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dirección = dirección;
        this.peso = peso;
        this.temperatura = temperatura;
        this.medico = medico;
    }
    
        
    //Metodos

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
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

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public static ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public static void setPacientes(ArrayList<Paciente> pacientes) {
        Paciente.pacientes = pacientes;
    }
    
    
   
    //Otros metodos
    
    public void adicionar(Paciente paciente) {
        pacientes.add(paciente);
    }

    
    public void imprimirPaciente() {
                System.out.println("DNI: " + DNI +
                           ", Nombre: " + nombre +
                           ", Apellido: " + apellido +
                           ", Dirección: " + dirección +
                           ", Peso: " + peso +
                           ", Temperatura: " + temperatura +
                           ", Médico: " + medico);
    }    
    
    public static void eliminarPaciente(int indice) {
        if (indice >= 0 && indice < pacientes.size()) {
            pacientes.remove(indice);
            System.out.println("Datos del paciente eliminados correctamente.");
        } else {
            System.out.println("Índice inválido. Verifique el índice del paciente a eliminar.");
        }
    }

       
     public int tamano() { 
	  return pacientes.size();
    }

    
    public void listarPacientes(){
        
        if (tamano() > 0) {
        for(Paciente paciente : pacientes) {
            System.out.println(paciente.toString());
            }
        }else {
            System.out.println("No hay pacientes registrados registrados");
        }
    
    }
    
    
    public static double calcularPesoRepitente(ArrayList<Paciente> pacientes) {
        
        Map<Double, Integer> frecuenciaPorPeso = new HashMap<>(); //Map es una interfaz y HashMap  es una implementación de map
        //El peso está representado con double y la frecuencia con la que se repite por Int

    
        for (Paciente paciente : pacientes) {
             double peso = paciente.getPeso();
             frecuenciaPorPeso.put(peso, frecuenciaPorPeso.getOrDefault(peso, 0) + 1);
        }

         double pesoRepitente = 0;
         int frecuenciaMaxima = 0;

        for (Map.Entry<Double, Integer> entry : frecuenciaPorPeso.entrySet()) {
             if (entry.getValue() > frecuenciaMaxima) {
             pesoRepitente = entry.getKey();
             frecuenciaMaxima = entry.getValue();
             }
         }

          return pesoRepitente;
}
    
    
    public static Map<Double, Integer> calcularPesoRepitenteConFrecuencia(ArrayList<Paciente> pacientes) {
         Map<Double, Integer> frecuenciaPorPeso = new HashMap<>();

         for (Paciente paciente : pacientes) {
              double peso = paciente.getPeso();
              frecuenciaPorPeso.put(peso, frecuenciaPorPeso.getOrDefault(peso, 0) + 1);
             }

          double pesoRepitente = 0;
          int frecuenciaMaxima = 0;

         for (Map.Entry<Double, Integer> entry : frecuenciaPorPeso.entrySet()) {
              if (entry.getValue() > frecuenciaMaxima) {
                  pesoRepitente = entry.getKey();
                  frecuenciaMaxima = entry.getValue();
             }
        }

            Map<Double, Integer> resultado = new HashMap<>();
            resultado.put(pesoRepitente, frecuenciaMaxima);

            return resultado;
    }    
    
    public static void mostrarPesoMayorYMenor(ArrayList<Paciente> pacientes) {
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
            return;
        }
        double pesoMayor = pacientes.get(0).getPeso();
        double pesoMenor = pacientes.get(0).getPeso();

        for (Paciente paciente : pacientes) {
            double pesoActual = paciente.getPeso();
            if (pesoActual > pesoMayor) {
                pesoMayor = pesoActual;
            }
            if (pesoActual < pesoMenor) {
                pesoMenor = pesoActual;
            }
        }

        System.out.println("Peso mayor: " + pesoMayor);
        System.out.println("Peso menor: " + pesoMenor);
    }
    
    public static void mostrarCantidadPersonasPorRango(ArrayList<Paciente> pacientes) {
        if (pacientes.isEmpty()) {
             System.out.println("No hay pacientes registrados.");
             return;
        }

        double pesoMaximo = pacientes.get(0).getPeso();
        double pesoMinimo = pacientes.get(0).getPeso();

        for (Paciente paciente : pacientes) {
            double pesoActual = paciente.getPeso();
            if (pesoActual > pesoMaximo) {
                 pesoMaximo = pesoActual;
        } 
            if (pesoActual < pesoMinimo) {
                 pesoMinimo = pesoActual;
        }
    }

        double rango = (pesoMaximo - pesoMinimo) / 4;

        int rango1 = 0;
        int rango2 = 0;
        int rango3 = 0;
        int rango4 = 0;

        for (Paciente paciente : pacientes) {
            double pesoActual = paciente.getPeso();

            if (pesoActual >= pesoMinimo && pesoActual < pesoMinimo + rango) {
                rango1++;
                } else if (pesoActual >= pesoMinimo + rango && pesoActual < pesoMinimo + 2 * rango) {
                    rango2++;
                } else if (pesoActual >= pesoMinimo + 2 * rango && pesoActual < pesoMinimo + 3 * rango) {
                    rango3++;
                } else {
                    rango4++;
                }
        }
  
        System.out.println("Cantidad de personas en el rango " + pesoMinimo + " a " + (pesoMinimo + rango) + ": " + rango1);
        System.out.println("Cantidad de personas en el rango " + (pesoMinimo + rango) + " a " + (pesoMinimo + 2 * rango) + ": " + rango2);
        System.out.println("Cantidad de personas en el rango " + (pesoMinimo + 2 * rango) + " a " + (pesoMinimo + 3 * rango) + ": " + rango3);
        System.out.println("Cantidad de personas en el rango " + (pesoMinimo + 3 * rango) + " a " + pesoMaximo + ": " + rango4);
    }
    
    public String obtenerInformacionMedico() {
            if (medico != null) {
               return "Médico: " + medico.getNombre() + ", Especialidad: " + medico.getEspecialidad() + ",Número de colegiatura: " + medico.getNrocolegiatura();
            } else {
                 return "El paciente no tiene asignado un médico.";
            }
    }
    
    
    
}

