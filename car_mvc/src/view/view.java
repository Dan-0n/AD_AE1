package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.controller;
import model.model;

public class view {
    public static void main(String[] args) {
    	
    controller controller = new controller();
    Scanner scanner = new Scanner(System.in);
    boolean exit = false;
        
    while (!exit) {
        System.out.println("1. A�adir nuevo coche");
        System.out.println("2. Borrar coche por id");
        System.out.println("3. Consultar coche por id");
        System.out.println("4. Listado de coches");
        System.out.println("5. Exportar coches a archivo CSV");
        System.out.println("6. Terminar el programa");
        System.out.print("Seleccione una opci�n: ");
            
        try {
        	int option = Integer.parseInt(scanner.nextLine());
            switch(option) {
                case 1: 
                    System.out.println("Introduzca el id del coche:");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println("Introduzca la marca del coche:");
                    String marca = scanner.nextLine();
                    System.out.println("Introduzca el modelo del coche:");
                    String modelo = scanner.nextLine();
                    System.out.println("Introduzca la matr�cula del coche:");
                    String matricula = scanner.nextLine();
                    System.out.println("Introduzca el color del coche:");
                    String color = scanner.nextLine();
                    controller.a�adirNuevoCoche(id, marca, matricula, modelo, color);
                    break;
                    
                case 2:
                    System.out.println("Introduzca el ID del coche que desea borrar:");
                    int idBorrar = Integer.parseInt(scanner.nextLine());
                    controller.borrarCochePorId(idBorrar);
                    break;
                        
                case 3:
                    System.out.println("Introduzca el ID del coche que desea buscar:");
                    int idConsultar = Integer.parseInt(scanner.nextLine());
                    model coche = controller.consultarCochePorId(idConsultar);
                    if (coche == null) {
                        System.out.println("No se encontr� un coche con ese ID.");
                    } else {
                        System.out.println(coche.toString());
                    }
                    break;
                        
                case 4: 
                    System.out.println("Listado de coches:");
                    controller.listarCoches();
                    break;
                        
                case 5:
                    System.out.println("Creando archivo CSV...");
                    controller.exportarCochesACSV();
                    System.out.println("Archivo CSV creado correctamente.");
                    break;
                        
                case 6:
                	System.out.println("Guardando cambios y saliendo de la aplicaci�n...");
                	controller.terminarPrograma();
                	exit = true;
                	break;
                	
                default:
                    System.out.println("Introduzca un n�mero del men�. Las opciones son entre 1 y 6.");
                    break;
            }
        } catch(InputMismatchException e) {
            System.out.println("Debes introducir un n�mero entre 1 y 6.");
            scanner.next();
        } catch(NumberFormatException e) {
        System.out.println("Debes introducir un n�mero entero v�lido.");
        }
    }
    
    }
}
