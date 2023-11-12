/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaCalificada02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author ivann
 */
public class ClassPrincipal {
     public static void main(String[] args) {
         
         
         
        ArrayList<Paciente> pacientes = new ArrayList<>();
        
         pacientes.add(new Paciente(12345678, "Juan", "Muñoz", "Calle 123", 70.5, 37.0, new Medico(1234, "Marco Loreto", "Dermatología")));
         pacientes.add(new Paciente(98765432, "María", "Alvarez", "Avenida 456", 65.0, 36.5, new Medico(4567, "Luis Perez", "Cardiología")));
         pacientes.add(new Paciente(34578934, "Rosa", "Rojas", "Jiron Venezuela", 65.0, 38.7, new Medico(5678, "José Rivera", "Alergología")));
         pacientes.add(new Paciente(56430742, "Layla", "Carrington", "Avenida Brasil", 43.0, 36.2, new Medico(8967, "Angela Duran", "Pediatría")));
                 
         ArrayList<Medico> medicos = new ArrayList<>();
         
         medicos.add(new Medico(1234, "Marco Loreto", "Dermatología"));
         medicos.add(new Medico(4567, "Luis Perez", "Cardiología"));
         medicos.add(new Medico(5678, "José Rivera", "Alergología"));
         medicos.add(new Medico(8967, "Angela Duran", "Pediatría"));
         
        
         
         
         
          Scanner scanner =  new Scanner(System.in);
        
        
        System.out.println("****** BIENVENIDOS AL SISTEMA DE GESTION DE PACIENTES ********");
        System.out.println("1-Registrar datos de los pacientes");
        System.out.println("2-Eliminar datos de un paciente");
        System.out.println("3-Modificar datos de un paciente");
        System.out.println("4-Mostrar el peso que más se repite");
        System.out.println("5-Mostrar la cantidad de pacientes que tienen el peso que más se repite");
        System.out.println("6-Mostrar el peso mayor y menor");
        System.out.println("7-Dividir el rango de pesos por 4");
        System.out.println("8-Mostrar la lista de pacientes ordenados por apellidos");
        System.out.println("9-Según el paciente, indicar qué doctor lo atendió");
        System.out.println("10-Buscar a los doctores por especialidad.");
        System.out.println("11-Salir");
        System.out.println();
        System.out.println("Ingrese su numero de operación : ");
        int numOperacion = scanner.nextInt();
        
        
        switch (numOperacion) {
            
            case 1:
               
                System.out.println("Lista de Pacientes:");
                for (int i = 0; i < pacientes.size(); i++) {
                   System.out.print((i + 1) + ". ");
                   pacientes.get(i).imprimirPaciente();
                }
                
                try {

                     System.out.println("Ingrese el DNI del paciente:");
                     int dni = scanner.nextInt();

                     System.out.println("Ingrese el nombre del paciente:");
                     String nombre = scanner.next();
    
                     System.out.println("Ingrese el apellido del paciente:");
                     String apellido = scanner.next();

                     System.out.println("Ingrese la dirección del paciente:");
                     String dirección = scanner.next();

                     System.out.println("Ingrese el peso del paciente:");
                     double peso = scanner.nextDouble();
                     scanner.nextLine();

                     System.out.println("Ingrese la temperatura del paciente:");
                     double temperatura = scanner.nextDouble();

                     // Solicitar datos del médico para completar el registro
                 
                     System.out.println("Ingrese el número de colegiatura del médico:");
                     int numcolegiaturaMedico = scanner.nextInt();

                     System.out.println("Ingrese el nombre del médico:");
                     String nombreMedico = scanner.next();

                     System.out.println("Ingrese la especialidad del médico:");
                     String especialidadMedico = scanner.next();
 
    
                     Medico nuevoMedico = new Medico(numcolegiaturaMedico, nombreMedico, especialidadMedico);
                     medicos.add(nuevoMedico);
      
                     Paciente nuevoPaciente = new Paciente(dni, nombre, apellido,dirección, peso, temperatura, nuevoMedico);
                     pacientes.add(nuevoPaciente);
                     System.out.println("Datos del paciente registrados correctamente.");
                 
                } catch (Exception e) {
                    System.out.println("Los datos ingresados no son validos. Vuelva a intentarlo");
                    scanner.nextLine(); 
                }     
                  break;
    
    
            case 2:
                
                System.out.println("Lista de Pacientes:");
                for (int i = 0; i < pacientes.size(); i++) {
                System.out.print((i + 1) + ". ");
                 pacientes.get(i).imprimirPaciente();
                 }
                         
        
                    System.out.println("\nIngrese el número del paciente que desea eliminar:");
                    int numeroEliminar = scanner.nextInt();

                    if (numeroEliminar > 0 && numeroEliminar <= pacientes.size()) {
            
                    Paciente pacienteEliminar = pacientes.get(numeroEliminar - 1);
                    pacientes.remove(pacienteEliminar);
                    System.out.println("Datos del paciente eliminados correctamente.");
                    } else {
                    System.out.println("Número inválido. Verifique el número del paciente a eliminar.");
                     }       
                     break;
                
            case 3:
                
                
                System.out.println("Lista de Pacientes:");
                for (int i = 0; i < pacientes.size(); i++) {
                System.out.print((i + 1) + ". ");
                pacientes.get(i).imprimirPaciente();
                }

                System.out.println("\nIngrese el número del paciente que desea modificar:");
                int numeroModificar = scanner.nextInt();

                if (numeroModificar > 0 && numeroModificar <= pacientes.size()) {
        
                       Paciente pacienteModificar = pacientes.get(numeroModificar - 1);
                       System.out.println("Datos actuales del paciente:");
                       pacienteModificar.imprimirPaciente();
                       
                       
                       Medico medicoAsociado = pacienteModificar.getMedico();
                       System.out.println("\nDatos actuales del médico asociado:");
                       medicoAsociado.imprimirMedico();

        
                       System.out.println("\nIngrese el nuevo DNI del paciente:");
                       int nuevoDNI = scanner.nextInt();
                       scanner.nextLine(); 
                       pacienteModificar.setDNI(nuevoDNI);

                       System.out.println("Ingrese el nuevo nombre del paciente:");
                       String nuevoNombre = scanner.nextLine();
                       pacienteModificar.setNombre(nuevoNombre);
                
                       System.out.println("Ingrese el nuevo apellido del paciente:");
                       String nuevoApellido = scanner.nextLine();
                       pacienteModificar.setApellido(nuevoApellido);

                       System.out.println("Ingrese la nueva dirección del paciente:");
                       String nuevaDireccion = scanner.next();
                       pacienteModificar.setDirección(nuevaDireccion);

                       System.out.println("Ingrese el nuevo peso del paciente:");
                       double nuevoPeso = scanner.nextDouble();
                       pacienteModificar.setPeso(nuevoPeso);

                       System.out.println("Ingrese la nueva temperatura del paciente:");
                       double nuevaTemperatura = scanner.nextDouble();
                       pacienteModificar.setTemperatura(nuevaTemperatura);

                       System.out.println("Datos del paciente modificados correctamente.");
                           } else {
                           System.out.println("Número inválido. Verifique el número del paciente a modificar.");
                           }
                 break;

                
            case 4:
                         
                double pesoRepitente = Paciente.calcularPesoRepitente(pacientes);
                System.out.println("El peso que más se repite es: " + pesoRepitente);
                break;
            
            case 5:
                
                Map<Double, Integer> resultado = Paciente.calcularPesoRepitenteConFrecuencia(pacientes);
                double pesoMasRepite = (double) resultado.keySet().toArray()[0];
                int cantidadPacientes = resultado.get(pesoMasRepite);

                System.out.println("Cantidad de pacientes que tienen el peso que más se repite: " + cantidadPacientes);
                break;
                
            case 6:
                Paciente.mostrarPesoMayorYMenor(pacientes);
                break;
                
            case 7:
                Paciente.mostrarCantidadPersonasPorRango(pacientes);
                break;
                
            case 8:
                Collections.sort(pacientes,
                        (Paciente p1, Paciente p2)-> p1.getApellido().compareTo(p2.getApellido()));
              
                System.out.println("Lista de pacientes ordenados por apellidos:");
                for (int i = 0; i < pacientes.size(); i++) {
                     System.out.print((i + 1) + ". ");
                     pacientes.get(i).imprimirPaciente();
                 }
                break;
                
            case 9:
                
                System.out.println("Lista de Pacientes:");
                for (int i = 0; i < pacientes.size(); i++) {
                     System.out.print((i + 1) + ". ");
                     pacientes.get(i).imprimirPaciente();
                }

                 System.out.println("\nIngrese el número del paciente para ver la información del médico que lo atendió:");
                 int numeroPaciente = scanner.nextInt();

                if (numeroPaciente > 0 && numeroPaciente <= pacientes.size()) {
                     Paciente pacienteSeleccionado = pacientes.get(numeroPaciente - 1);
                     System.out.println(pacienteSeleccionado.obtenerInformacionMedico());
                } else {
                   System.out.println("El número es inválido. Verifique el número del paciente.");
                }
                break;
                
            case 10:
                
                System.out.println("Ingrese la especialidad para buscar doctores:");
                String especialidadBuscada = scanner.next();

                System.out.println("Doctores con especialidad '" + especialidadBuscada + "':");
                boolean encontrado = false;

                for (Medico medico : medicos) {
                     if (medico.getEspecialidad().equalsIgnoreCase(especialidadBuscada)) {
                     System.out.println(medico.obtenerInformacionMedico());
                     encontrado = true;
                    }
                }

                if (!encontrado) {
                    System.out.println("No se encontraron doctores con la especialidad '" + especialidadBuscada + "'.");
                }
                break;
                
            case 11:
                 break;
        }
     }
}
