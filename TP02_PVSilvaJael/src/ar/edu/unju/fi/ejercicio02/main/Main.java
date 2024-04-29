package ar.edu.unju.fi.ejercicio02.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio02.constantes.Mes;
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
                        altaEfemeride(scanner, efemerides);
                        break;
                    case 2:
                        mostrarEfemerides(efemerides);
                        break;
                    case 3:
                        eliminarEfemerides(scanner, efemerides);
                        break;                    
                    case 4:
                        modificarEfemeride(scanner, efemerides);
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
	
	private static void altaEfemeride(Scanner scanner, List<Efemeride> efemerides) {
		try {
	        System.out.print("Ingrese el codigo de la efemeride: ");
	        String codigo =scanner.nextLine();
	        
	        mes();
	        int mes = scanner.nextInt();
	        
	        int dia=0;
	        do {
	        	System.out.print("Ingrese el dia de la efemeride: ");
	        	dia = scanner.nextInt();
	        	scanner.nextLine();
	        }while (dia <0 || dia>31);
	        
	        System.out.print("Ingrese el detalle de la efemeride: ");
	        String detalle = scanner.nextLine();
	        
	        Efemeride efemeride = new Efemeride(codigo, Mes.values()[mes-1], dia, detalle);       
	        efemerides.add(efemeride);
	   	        
	        System.out.println("Efemeride agregada correctamente.");
	    } catch (Exception e) {
	        System.out.println("Error al agregar efemeride. Motivo: " + e.getMessage());
	    }		
		}
	
	private static void mostrarEfemerides(List<Efemeride> efemerides) {
		try {
			for (Efemeride efemeride : efemerides) {
				System.out.println(efemeride.toString());
			}
		} catch (Exception e) {
	        System.out.println("Error. Motivo: " + e.getMessage());
	    }
	}
	
	private static void eliminarEfemerides(Scanner scanner, List<Efemeride> efemerides) {
		try {
			System.out.print("Ingrese el codigo de la efemeride: ");
	        String codigo =scanner.nextLine();
	        
	        Efemeride efemeride=buscarEfemeride(codigo, efemerides);
	        
	        if (efemeride.getCodigo()!=null) {
	        	efemerides.remove(efemeride);	
	        	System.out.println("Efemeride eliminada correctamente.");
	        	}
	        
	        else {
	               System.out.println("No se encontro la efemeride con el codigo ingresado.");
	          }	          
	        
		} catch (Exception e) {
	        System.out.println("Error al eliminar efemeride. Motivo: " + e.getMessage());
		}
		
	}
	        
	private static void modificarEfemeride(Scanner scanner, List<Efemeride> efemerides) {
		int op=0;
		System.out.print("Ingrese el codigo de la efemeride: ");
	    String codigo =scanner.nextLine();
	        
	    Efemeride efemeride=buscarEfemeride(codigo, efemerides);
	        
	    if (efemeride.getCodigo()!=null) {
	    	System.out.println("\n\tMODIFICAR EFEMERIDE");
	    	System.out.println("------------------------");
	    	System.out.println("1. Modificar mes");
	   		System.out.println("2. Modificar dia");
	   		System.out.println("3. Modificar detalle");            	   		    
	   		System.out.println("Ingrese una opcion: ");

	    		try {
	    			op = scanner.nextInt();
	            	scanner.nextLine();

	            	switch (op) {
	                   	case 1:
	                   		System.out.print("Nuevo mes de la efemeride: ");
	                   		mes();
	                   		int mes = scanner.nextInt();
	                   		efemeride.setMes(Mes.values()[mes-1]);	                  
	                    break;
	                   	case 2:
	                   		int dia=0;
	            	        do {
	            	        	System.out.print("Nuevo dia de la efemeride: ");
	            	        	dia = scanner.nextInt();
	            	        	scanner.nextLine();
	            	        }while (dia <0 || dia>31);
	                   		scanner.nextLine();
	                    break;
	                   	case 3:
	                   		System.out.print("Nuevo detalle: ");
	                   		efemeride.setDetalle(scanner.nextLine());
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
	    	}
	    	else {
	               System.out.println("No se encontro la efemeride con el codigo ingresado.");
	          }	        	       	    			    		
		}
	
	private static Efemeride buscarEfemeride(String codigo, List<Efemeride> efemerides){
		Efemeride efemerideEncontrado = new Efemeride();
		try {        	
	        for (Efemeride efemeride : efemerides) {
	        	if (efemeride.getCodigo().equalsIgnoreCase(codigo)){
	        		efemerideEncontrado = efemeride;
	        	}                
	        }
	    } catch (Exception e) {
	        System.out.println("Error" + e.getMessage());
	    }
	    return efemerideEncontrado;	
	}
	
	private static void mes(){
		System.out.print("\n\t ELIJA UN MES ");
		System.out.print("\n1. Enero");
		System.out.print("\n2. Febrero");
		System.out.print("\n3. Marzo");
		System.out.print("\n4. Abril");
		System.out.print("\n5. Mayo");
		System.out.print("\n6. Junio");
		System.out.print("\n7. Julio");
		System.out.print("\n8. Agosto");
		System.out.print("\n9. Septiembre");
		System.out.print("\n10. Octubre");
		System.out.print("\n11. Noviembre");
		System.out.print("\n12. Diciembre");
		System.out.println("\nIngrese una opcion: ");	
		
	}

	}
