package ar.edu.unju.fi.ejercicio02.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio02.model.Efemeride;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		List<Efemeride> efemerides = new ArrayList<Efemeride>();	
		
        int opcion = 0;

        do {
            System.out.println("\n\tMENÚ DE EFEMERIDES");
            System.out.println("------------------------");
            System.out.println("1. Crear efemeride");
            System.out.println("2. Mostrar efemerides");
            System.out.println("3. Eliminar efemeride");   
            System.out.println("4. Modificar efemeride");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        //altaeEfemeride(scanner, efemerides);
                        break;
                    case 2:
                        //mostrarEfemerides(efemerides);
                        break;
                    case 3:
                        //eliminarEfemerides(scanner, efemerides);
                        break;                    
                    case 4:
                        //modificarEfemeride(scanner, efemeride);
                        break;
                    case 5:
                        System.out.println("Saliendo del menú...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero.");
                scanner.nextLine(); 
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado. Motivo: " + e.getMessage());
            }
        } while (opcion != 4);

        scanner.close();
	}

	}
