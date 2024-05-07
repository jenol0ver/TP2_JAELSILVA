package ar.edu.unju.fi.ejercicio07.main;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


import ar.edu.unju.fi.ejercicio05.model.Producto;
import ar.edu.unju.fi.ejercicio05.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio05.model.Producto.OrigenFabricacion;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scanner = new Scanner(System.in);
		 List<Producto> productos = new ArrayList<Producto>();
		 List<Producto> productosIncrementados = new ArrayList<Producto>();
		
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
                    	mostrarProducto(productos);
                        break;
                    case 2:
                        mostrarProductoSinStock(productos);
                        System.out.println(mostrarProductoSinStock(productos));
                        break;
                    case 3:
                        incrementarPrecio(productos, productosIncrementados);
                        break;
                    case 4:
                    	productosElectrohogar(productos);
                    	System.out.println(productosElectrohogar(productos));
                        break;
                    case 5:
                        ordenarDescendente(productos);
                        break;
                    case 6:
                        productosMayuscula(productos);
                        System.out.println(productosMayuscula(productos));
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
	
	private static List<Producto> productosMayuscula(List<Producto> productos) {
		// TODO Auto-generated method stub
		Function<Producto, Producto> mayusc = p -> {
			p.setDescripcion(p.getDescripcion().toUpperCase());
			return p;
		};

		return productos.stream()
				.map(mayusc)
				.collect(Collectors.toList());
		
		//Predicate<Producto> mayus = p -> (String nombre = p.getDescripcion().toUpperCase());
		
	}

	private static void ordenarDescendente(List<Producto> productos) {
		// TODO Auto-generated method stub
		Comparator<Producto> descendente = Comparator.comparing(Producto :: getPrecioU).reversed();		
		productos.sort(descendente);
		
		System.out.println(productos);
	}

	private static List<Producto> productosElectrohogar(List<Producto> productos) {
		
		// TODO Auto-generated method stub
		Predicate<Producto> electrohogarDisponible = p -> (p.getCategoria().equals(Categoria.ELECTROHOGAR)&& p.isEstado());
		return productos.stream()
                .filter(electrohogarDisponible)
                .collect(Collectors.toList());
	}

	private static void incrementarPrecio(List<Producto> productos, List<Producto> productosIncrementados) {
		// TODO Auto-generated method stub
		Function<Producto, Producto> incrementar = p -> {
			p.setPrecioU(p.getPrecioU()*1.20d);
			return p;
			};
		productosIncrementados = productos.stream()
				.map(incrementar)
				.collect(Collectors.toList());
		
		System.out.println(productosIncrementados.toString());
	}

	private static List<Producto> mostrarProductoSinStock(List<Producto> productos) {
		// TODO Auto-generated method stub
		Predicate<Producto> sinStock = p -> (p.isEstado()==false);
		return productos.stream()
                .filter(sinStock)
                .collect(Collectors.toList());
		
	}

	private static void mostrarProducto(List<Producto> productos) {
		// TODO Auto-generated method stub
		Consumer<Producto> mostrar = p -> {if (p.isEstado()) 
	        System.out.println(p);
			};
		
		productos.forEach(mostrar);
		
	    }

	

	private static void cargarProductos(List<Producto> productos) {
		Producto p1 = new Producto("01", "Microondas", 400, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, true);
		Producto p2 = new Producto("02", "Martillo", 500, OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS, true);
		Producto p3 = new Producto("03", "Netbook", 700, OrigenFabricacion.CHINA, Categoria.INFORMATICA, false);
		Producto p4 = new Producto("04", "Samsung Galaxy a20", 560, OrigenFabricacion.URUGUAY, Categoria.TELEFONIA, true);
		Producto p5 = new Producto("05", "Heladera", 400, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, true);
		Producto p6 = new Producto("06", "Destornillador", 1500, OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS, true);
		Producto p7 = new Producto("07", "Tablet", 2700, OrigenFabricacion.CHINA, Categoria.INFORMATICA, false);
		Producto p8 = new Producto("08", "Iphone", 3560, OrigenFabricacion.URUGUAY, Categoria.TELEFONIA, false);
		Producto p9 = new Producto("09", "Horno", 1400, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, true);
		Producto p10 = new Producto("10", "Tornillo", 7500, OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS, true);
		Producto p11 = new Producto("11", "Laptop", 790, OrigenFabricacion.CHINA, Categoria.INFORMATICA, false);
		Producto p12 = new Producto("12", "Audifonos", 520, OrigenFabricacion.URUGUAY, Categoria.TELEFONIA, false);
		Producto p13 = new Producto("13", "Tv", 1400, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, true);
		Producto p14 = new Producto("14", "Taladro", 7500, OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS, true);
		Producto p15 = new Producto("15", "Auriculares", 790, OrigenFabricacion.CHINA, Categoria.INFORMATICA, false);
		
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
