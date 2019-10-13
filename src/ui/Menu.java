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

import model.Amphitryon;;

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
		System.out.println("Ingrese la ruta relativa del lugar donde se encuentra el archivo CSV");
		String file = reader.nextLine();
		list.loadSpectator(file);
		list.loadParticipants(file);
	}
}

