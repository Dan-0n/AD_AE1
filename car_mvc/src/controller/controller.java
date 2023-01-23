package controller;

import java.io.*;
import java.util.ArrayList;
import model.model;

public class controller implements Serializable {
	
  
	private static final long serialVersionUID = -1062335014231397033L;
	private static ArrayList<model> coches = new ArrayList<model>();
	
	public controller() {
	
	 try {
         FileInputStream fileIn = new FileInputStream("coches.dat");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         coches = (ArrayList<model>) in.readObject();
         in.close();
         fileIn.close();
     } catch (FileNotFoundException e) {
     } catch (IOException e) {
         e.printStackTrace();
     } catch (ClassNotFoundException e) {
         e.printStackTrace();
     }
	}
	 

    public void añadirNuevoCoche(int id, String marca, String matricula, String modelo, String color) {
        for (model coche : coches) {
            if (coche.getId() == id || coche.getMatricula().equals(matricula)) {
                System.out.println("Error: El id o matrícula introducido ya existen en el listado.");
                return;
            }
        }
        model nuevoCoche = new model(id, marca, matricula, modelo, color);
        coches.add(nuevoCoche);
        System.out.println("Coche añadido exitosamente.");
    }

    public void borrarCochePorId(int id) {
        for (model coche : coches) {
            if (coche.getId() == id) {
                coches.remove(coche);
                break;
            }
        }
    }

    public model consultarCochePorId(int id) {
        for (model coche : coches) {
            if (coche.getId() == id) {
                return coche;
            }
        }
        return null;
    }

    public void listarCoches() {
        for (model coche : coches) {
            System.out.println(coche.toString());
        }
    }

    public void terminarPrograma() {
        try {
            ObjectOutputStream escritor = new  ObjectOutputStream(new FileOutputStream("coches.dat"));
            escritor.writeObject(coches);
            escritor.close();
            } catch (IOException e) {
            e.printStackTrace();
            }
            System.exit(0);
    }
    
    public void exportarCochesACSV() {
        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter("coches.csv"));
            for (model coche : coches) {
                escritor.write(coche.getId() + ";");
                escritor.write(coche.getMarca() + ";");
                escritor.write(coche.getModelo() + ";");
                escritor.write(coche.getMatricula() + ";");
                escritor.write(coche.getColor() + ";");
                escritor.newLine();
            }
            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}