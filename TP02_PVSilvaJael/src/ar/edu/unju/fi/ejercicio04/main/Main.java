package ar.edu.unju.fi.ejercicio04.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio04.constantes.Posicion;
import ar.edu.unju.fi.ejercicio04.model.Jugador;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		List<Jugador> jugadores = new ArrayList<Jugador>();	
		
        int opcion = 0;

        do {
            System.out.println("\n\tMENÚ DE JUGADORES");
            System.out.println("------------------------");
            System.out.println("1. Alta de jugador");
            System.out.println("2. Mostrar datos de un jugador");
            System.out.println("3. Mostrar todos los jugadores ordenados por apellido");
            System.out.println("4. Modificar los datos de un jugador");
            System.out.println("5. Eliminar un jugador");
            System.out.println("6. Mostrar cantidad total de jugadores");
            System.out.println("7. Mostrar la cantidad de jugadores por nacionalidad");
            System.out.println("8. Salir");
            System.out.print("Ingrese una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        altaJugador(scanner,jugadores);
                        break;
                    case 2:
                        mostrarDatosJugador(scanner,jugadores);
                        break;
                    case 3:
                        mostrarJugadoresOrdenadosApellido(jugadores);
                        break;
                    case 4:
                        modificarDatos(scanner,jugadores);
                        break;
                    case 5:
                        eliminarJugador(scanner, jugadores);
                        break;
                    case 6:
                    	System.out.println("Cantidad total de jugadores: " + jugadores.size());
                        break;
                    case 7:
                        cantidadJugadoresNacionalidad(scanner, jugadores);
                        break;
                    case 8:
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
        } while (opcion != 8);

        scanner.close();
	}
	
	private static void altaJugador(Scanner scanner, List<Jugador> jugadores) {
        try {
            System.out.print("Ingrese el nombre del jugador: ");
            String nombre =scanner.nextLine();

            System.out.print("Ingrese el apellido del jugador: ");
            String apellido = scanner.nextLine();

            System.out.print("Ingrese la fecha de nacimiento (YYYY-MM-DD): ");
            LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine());

            System.out.print("Ingrese la nacionalidad del jugador: ");
            String nacionalidad = scanner.nextLine();

            System.out.print("Ingrese la estatura del jugador (en cm): ");
            double estatura = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Ingrese el peso del jugador (en kg): ");
            double peso = scanner.nextDouble();
            scanner.nextLine();

            menuPosicion();
            int pos = scanner.nextInt();

            Jugador jugador = new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, Posicion.values()[pos-1]);
            jugadores.add(jugador);
            
            System.out.println("Jugador agregado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al dar de alta al jugador. Motivo: " + e.getMessage());
        }
    }

	private static void mostrarDatosJugador(Scanner scanner, List<Jugador> jugadores) {
		
		try {
            System.out.print("Ingrese el nombre del jugador: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese el apellido del jugador: ");
            String apellido = scanner.nextLine();

            Jugador jugador = buscarJugador(nombre, apellido, jugadores);
                if (jugador.getApellido() != null) {
                    System.out.println("Nombre: " + jugador.getNombre());
                    System.out.println("Apellido: " + jugador.getApellido());
                    System.out.println("Fecha de nacimiento: " + jugador.getFechaNac());
                    System.out.println("Nacionalidad: " + jugador.getNacionalidad());
                    System.out.println("Estatura: " + jugador.getEstatura());
                    System.out.println("Peso: " + jugador.getPeso());
                    System.out.println("Posición: " + jugador.getPosicion());
                    System.out.println("Edad: " + jugador.calcularEdad());      
                }
            
                else {
                System.out.println("No se encontró al jugador con el nombre y apellido ingresados.");
            }
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    private static void mostrarJugadoresOrdenadosApellido(List<Jugador> jugadores) {
        
    	ArrayList<Jugador> jugadoresOrdenados = new ArrayList<>(jugadores);
        Collections.sort(jugadoresOrdenados, Comparator.comparing(Jugador::getApellido));

        for (Jugador jugador : jugadoresOrdenados) {
            System.out.println(jugador.getApellido() + ", " + jugador.getNombre());
        }
 	}
    
    private static void modificarDatos(Scanner scanner, List<Jugador> jugadores) {
    	System.out.print("Ingrese el nombre del jugador: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el apellido del jugador: ");
        String apellido = scanner.nextLine();

        Jugador jugador = buscarJugador(nombre, apellido, jugadores);
            if (jugador != null) {
            	System.out.print("Nuevo nombre: ");
                jugador.setNombre(scanner.nextLine());

                System.out.print("Nuevo apellido: ");
                jugador.setApellido(scanner.nextLine());

                System.out.print("Nueva fecha de nacimiento (YYYY-MM-DD): ");
                jugador.setFechaNac(LocalDate.parse(scanner.nextLine()));

                System.out.print("Nueva nacionalidad: ");
                jugador.setNacionalidad(scanner.nextLine());

                System.out.print("Nueva estatura: ");
                jugador.setEstatura(scanner.nextDouble());

                System.out.print("Nuevo peso: ");
                jugador.setPeso(scanner.nextDouble());

                menuPosicion();
                jugador.setPosicion(Posicion.values()[scanner.nextInt()-1]);

                System.out.println("Datos del jugador " + jugador.getNombre() + " modificados correctamente.");
            }
        
            else {
            System.out.println("No se encontró al jugador con el nombre y apellido ingresados.");
        }
    }
    
    private static void eliminarJugador(Scanner scanner, List<Jugador> jugadores) {
    	try {
            System.out.print("Ingrese el nombre del jugador: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese el apellido del jugador: ");
            String apellido = scanner.nextLine();

            Iterator<Jugador> iterator = jugadores.iterator();
            boolean encontrado = false;

            while (iterator.hasNext()) {
                Jugador jugador = iterator.next();
                if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
                    iterator.remove();
                    System.out.println("Jugador eliminado correctamente.");
                    encontrado = true;               
                }
                if (!encontrado) {
                    System.out.println("No se encontró al jugador con el nombre y apellido ingresados.");
                }
            }
                   	          
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    	
    }
    
    private static void cantidadJugadoresNacionalidad(Scanner scanner, List<Jugador> jugadores) {
    	 System.out.print("Ingrese la nacionalidad: ");
    	    String nacionalidad = scanner.next();

    	    int cantidad = 0;

    	    for (Jugador jugador : jugadores) {
    	        if (jugador.getNacionalidad().equalsIgnoreCase(nacionalidad)) {
    	            cantidad++;
    	        }
    	    }
    	    System.out.println("Cantidad de jugadores de " + nacionalidad + ": " + cantidad);
    }
    
    private static Jugador buscarJugador(String nombre, String apellido, List<Jugador> jugadores){
    	Jugador jugadorEncontrado = new Jugador();
    	try {        	
            for (Jugador jugador : jugadores) {
            	if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
            		jugadorEncontrado = jugador;
            	}                
            }
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return jugadorEncontrado;
    	
    }
    
    private static void menuPosicion(){
    	System.out.println("----POSICION DE JUGADOR---- ");
        System.out.println("1. DELANTERO");
        System.out.println("2. MEDIO");
        System.out.println("3. DEFENSA");            
        System.out.println("4. ARQUERO");
        System.out.print("Ingrese una opción: ");
    }
	

}
