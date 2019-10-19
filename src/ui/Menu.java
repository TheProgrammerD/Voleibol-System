/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad Icesi (Cali - Colombia)
 * Solución laboratorio Unidad 2
 * @author Cristian Rivadeneira - josepthcamilo@gmail.com
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package ui;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Date;

import java.io.*;
import java.text.SimpleDateFormat;

import model.Amphitryon;
import model.InvalidRouteException;;

public class Menu {

	private Amphitryon list;
	private Scanner reader;

	public Menu() {
		reader = new Scanner(System.in);
		list = new Amphitryon("Peru", "");
		systemOperation();
	}

	public void systemOperation() {
		boolean close = false;

		while (!close) {
			int userValue = menuSystem();
			switch (userValue) {
			case 1:
				saveFromRoute();
				break;
			case 2:
				searchByIDABB();
				break;
			case 3:
				searchByIDList();
				break;
			case 4:
				paintABB();
				break;
			case 5:
				paintList();
				break;
			case 0:
				close = true;
				break;
			default:
				break;
			}

		}

	}

	public int menuSystem() {
		System.out.println("\nElije una opcion :)");
		System.out.println(String.format("%1$-8s","1.  Cargar informacion desde el archivo "));
		System.out.println(String.format("%1$-8s","2.  Buscar espectadores por ID "));
		System.out.println(String.format("%1$-8s","3.  Buscar participantes por ID "));
		System.out.println(String.format("%1$-8s","4.  Mostrar Arbol ABB "));
		System.out.println(String.format("%1$-8s","5.  Mostrar lista "));
		System.out.println(String.format("%1$-8s","0.  Salir "));
		
		int value = 0;
		//Here I catch the exceptions
		try {
			value = reader.nextInt();
			reader.nextLine();
			if(value <= -1 || value > 5) {
				throw new OutOfRangeExcepcion("\"Por favor digite una opcion valida :)...O tu windows se cerrara\"");
			}
		}catch(InputMismatchException e) {
			System.out.println("Por favor digite una opcion valida :)...O tu windows se cerrara");
			reader.nextLine();
			menuSystem();
		} catch (OutOfRangeExcepcion e) {
			System.out.println(e.getMessage());
		}
		return value;
	}
	
	public void saveFromRoute() {
		System.out.println("Ingrese la ruta relativa del lugar donde se encuentra el archivo CSV: ");
		String file = reader.nextLine();
		try {
			list.loadSpectator(file);
			list.loadParticipants(file); 
			System.out.println("Se ha cargado la informacion correctamente");
		} catch (InvalidRouteException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void searchByIDABB() {
		System.out.println("Ingrese la ID del candidato que desea buscar: ");
		String id = reader.nextLine();
		long t1 = System.nanoTime();
		System.out.println(list.searchInABB(id, list.getRoot()));
		long t2 = System.nanoTime();
		System.out.println("El tiempo que se tardo en realizar la busqueda es de: " + (t2-t1));
	}
	
	public void searchByIDList() {
		System.out.println("Ingrese la ID del candidato que desea buscar: ");
		String id = reader.nextLine();
		long t1 = System.nanoTime();
		System.out.println(list.searchInLinkedList(id, list.getFirst()));
		long t2 = System.nanoTime();
		System.out.println("El tiempo que se tardo en realizar la busqueda es de: " + (t2-t1));
	}
	
	public void paintABB() {
		list.printBinaryTree(list.getRoot(), 0);
	}
	
	public void paintList() {
		System.out.println("Ingrese el pais del que desea buscar los participantes");
		String country = reader.nextLine();
		System.out.println(list.paintRecursive(country, list.getFirst()));
	}
	
	public static void main(String[] args) {

		Menu m = new Menu();
	}
}

