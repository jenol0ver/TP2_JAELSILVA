package ar.edu.unju.fi.ejercicio07.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

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
		 List<Producto> productoDisponible = new ArrayList<Producto>();
		
		cargarProductos(productos);
		
        int opcion = 0;

        do {
            System.out.println("\n\tMENÚ DE PRODUCTOS");
            System.out.println("------------------------");
            System.out.println("1. Mostrar Productos disponibles");
            System.out.println("2. Mostrar productos sin stock");
            System.out.println("3. Incrementar los precios de los productos en un 20%");
            System.out.println("4. Mostrar productos disponibles que corresponden a la categoría Electrohogar");
            System.out.println("5. Ordenar los productos por precio de forma descendente.");
            System.out.println("6. Mostrar los productos con los nombres en mayúsculas. ");
            System.out.println("7. Salir ");
            System.out.print("Ingrese una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                    	mostrarProducto(productos, productoDisponible);
                        break;
                    case 2:
                        //mostrarProductoSinStock(productoDisponible, scanner, carrito);
                        break;
                    case 3:
                        //incrementarPrecio();
                        break;
                    case 4:
                    	//productosElectrohogar(productoDisponible, scanner, carrito);
                        break;
                    case 5:
                        //ordenarDescendente(productoDisponible, scanner, carrito);
                        break;
                    case 6:
                        //productosMayuscula();
                    	break;
                        
                    case 7:
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
        } while (opcion != 7);

        scanner.close();
	}
	
	private static void mostrarProducto(List<Producto> productos, List<Producto> productoDisponible ) {
		// TODO Auto-generated method stub
		Consumer<Producto> mostrar = p -> {if (p.isEstado()) 
	        System.out.println(p);
			};
		
		productos.forEach(mostrar);
		
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

	
	}
