package ar.edu.unju.fi.ejercicio05.Main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio05.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio05.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio05.model.Producto;
import ar.edu.unju.fi.ejercicio05.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio05.model.Producto.OrigenFabricacion;

public class Main {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scanner = new Scanner(System.in);
		 List<Producto> productos = new ArrayList<Producto>();
		 List<Producto> carrito = new ArrayList<Producto>();
		 List<Producto> productoDisponible = new ArrayList<Producto>();
		
		cargarProductos(productos);
		
        int opcion = 0;

        do {
            System.out.println("\n\tMENÚ DE PRODUCTOS");
            System.out.println("------------------------");
            System.out.println("1. Mostrar Productos");
            System.out.println("2. Realizar compra");
            System.out.println("3. Salir");
            System.out.print("Ingrese una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                    	mostrarProducto(productos, productoDisponible);
                        break;
                    case 2:
                        realizarCompra(productoDisponible, scanner, carrito);
                        break;
                    case 3:
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
        } while (opcion != 3);

        scanner.close();
	}
	
	private static void mostrarProducto(List<Producto> productos, List<Producto> productoDisponible ) {
		// TODO Auto-generated method stub
		 for (Producto producto : productos) {
	            if (producto.isEstado()) {
	                productoDisponible.add(producto);
	                System.out.println(producto);
	            }
	        }
	}

	private static void realizarCompra(List<Producto> productoDisponible, Scanner scanner, List<Producto> carrito) {
		// TODO Auto-generated method stub
		Double monto = 0d;
		int op=0;
		
	    	do {
	    	System.out.println("\n\tREALIZAR COMPRA");
			System.out.println("------------------------");
			System.out.println("1. Añadir producto al carrito");
			System.out.println("2. Pago Efectivo");
			System.out.println("3. Pago con tarjeta");            
			System.out.println("4. Salir");      
			System.out.print("Ingrese una opcion: ");

			try {
				op = scanner.nextInt();
        		scanner.nextLine();

        		switch (op) {
                	case 1:
                		añadirProducto(scanner, productoDisponible, carrito, monto);                		
                    break;
                	case 2:
                		pagoEfectivo(carrito, monto);
                		carrito.clear();
                		
                    break;
                	case 3:
                		pagoTarjeta(carrito, monto);
                		carrito.clear();
                		break;                    
                	case 4:
                		System.out.println("Saliendo del menú...");
                	default:
                		System.out.println("Opción no válida. Intente nuevamente.");
        		}
        	} catch (InputMismatchException e) {
        		System.out.println("Error: Debe ingresar un número entero.");
        		scanner.nextLine(); 
        	} catch (Exception e) {
        		System.out.println("Ocurrió un error inesperado. Motivo: " + e.getMessage());
        	}
		} while (op != 4);
		   		
		
	}

	private static void pagoTarjeta(List<Producto> carrito, Double monto) {
		// TODO Auto-generated method stub
		PagoTarjeta tarjeta = new PagoTarjeta("47241371", LocalDate.now(),montoTotal(carrito, monto));
		tarjeta.realizarPago(montoTotal(carrito, monto));
		tarjeta.imprimirRecibo();
	}

	private static void pagoEfectivo(List<Producto> carrito, Double monto) {
		// TODO Auto-generated method stub
		PagoEfectivo efectivo = new PagoEfectivo(montoTotal(carrito, monto), LocalDate.now());
		efectivo.realizarPago(montoTotal(carrito, monto));
		efectivo.imprimirRecibo();
	}

	private static void añadirProducto(Scanner scanner, List<Producto> productoDisponible, List<Producto> carrito, Double monto) {
		// TODO Auto-generated method stub
		boolean band = false;
		String op= " ";
		
		do {
		System.out.print("Ingrese el codigo del producto a comprar: ");
	    String codigo =scanner.nextLine();
	        
	    Producto producto=buscarProducto(codigo, productoDisponible);
	        
	    if (producto.getCodigo()!=null) {
	    	carrito.add(producto);
	    	System.out.println("Producto añadido al carrito");
	    	System.out.println("Monto Total: " + montoTotal(carrito, monto));
	    } 
	    	else {
	            System.out.println("No se encontro el producto con el codigo ingresado.");
	        }	
	    
	    	System.out.println("Desea agregar mas producto al carrito? s/n");
	    	op=scanner.nextLine();
	    	
	    	if (op.equals("s")) {
	    		band=true;
	    		
	    	}
	    	else {
	    		band = false;
	    	}
	    	
	    	
		}while (band==true);
		
	}

	

	private static void cargarProductos(List<Producto> productos) {
		Producto p1 = new Producto("01", "01", 400, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, true);
		Producto p2 = new Producto("02", "02", 500, OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS, true);
		Producto p3 = new Producto("03", "03", 700, OrigenFabricacion.CHINA, Categoria.INFORMATICA, false);
		Producto p4 = new Producto("04", "04", 560, OrigenFabricacion.URUGUAY, Categoria.TELEFONIA, true);
		Producto p5 = new Producto("05", "05", 400, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, true);
		Producto p6 = new Producto("06", "06", 1500, OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS, true);
		Producto p7 = new Producto("07", "07", 2700, OrigenFabricacion.CHINA, Categoria.INFORMATICA, false);
		Producto p8 = new Producto("08", "08", 3560, OrigenFabricacion.URUGUAY, Categoria.TELEFONIA, false);
		Producto p9 = new Producto("09", "09", 1400, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, true);
		Producto p10 = new Producto("10", "10", 7500, OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS, true);
		Producto p11 = new Producto("11", "11", 790, OrigenFabricacion.CHINA, Categoria.INFORMATICA, false);
		Producto p12 = new Producto("12", "12", 520, OrigenFabricacion.URUGUAY, Categoria.TELEFONIA, false);
		Producto p13 = new Producto("13", "09", 1400, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, true);
		Producto p14 = new Producto("14", "10", 7500, OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS, true);
		Producto p15 = new Producto("15", "11", 790, OrigenFabricacion.CHINA, Categoria.INFORMATICA, false);
		
		productos.add(p1);
		productos.add(p2);
		productos.add(p3);
		productos.add(p4);
		productos.add(p5);
		productos.add(p6);
		productos.add(p7);
		productos.add(p8);
		productos.add(p9);
		productos.add(p10);
		productos.add(p11);
		productos.add(p12);
		productos.add(p13);
		productos.add(p14);
		productos.add(p15);
	}
	
	private static Producto buscarProducto(String codigo, List<Producto> productoDisponible){
		Producto productoEncontrado = new Producto();
		try {        	
	        for (Producto producto : productoDisponible) {
	        	if (producto.getCodigo().equalsIgnoreCase(codigo)){
	        		productoEncontrado = producto;
	        	}                
	        }
	    } catch (Exception e) {
	        System.out.println("Error" + e.getMessage());
	    }
	    return productoEncontrado;	
	}
	
	private static Double montoTotal (List<Producto> carrito, Double monto) {
		
		for (Producto producto : carrito) {
			monto += producto.getPrecioU();
		}
		return monto;
	}
	//solo para probar pq dice que ocurrio un error :( 
	//EL ERROR ES PQ MI TOKEN YA EXPIRO
	//:((

	}
