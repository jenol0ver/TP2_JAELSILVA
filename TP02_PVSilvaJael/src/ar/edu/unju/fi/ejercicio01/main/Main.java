package ar.edu.unju.fi.ejercicio01.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio01.model.Producto;
import ar.edu.unju.fi.ejercicio01.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio01.model.Producto.OrigenFabricacion;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		List<Producto> productos = new ArrayList<Producto>();	
		
        int opcion = 0;

        do {
            System.out.println("\n\tMENÚ DE PRODUCTO");
            System.out.println("------------------------");
            System.out.println("1. Crear producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Modificar producto");            
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        altaProducto(scanner, productos);
                        break;
                    case 2:
                        mostrarProductos(productos);
                        break;
                    case 3:
                        modificarProducto(scanner, productos);
                        break;                    
                    case 4:
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
	

private static void altaProducto(Scanner scanner, List<Producto> productos) {
	try {
        System.out.print("Ingrese el codigo del producto: ");
        String codigo =scanner.nextLine();

        System.out.print("Ingresar la descripcion del producto: ");
        String descripcion = scanner.nextLine();

        System.out.print("Ingrese el precio unitario del producto: ");
        double precioU = scanner.nextDouble();
        scanner.nextLine();
        
        int op=0;
        menuOrigenFab();
        ar.edu.unju.fi.ejercicio01.model.Producto.OrigenFabricacion origen = null;
        
        try {
            op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                     origen = OrigenFabricacion.ARGENTINA;
                    break;
                case 2:
                	origen = OrigenFabricacion.CHINA;
                    break;
                case 3:
                	origen = OrigenFabricacion.BRASIL;
                    break;
                case 4:
                	origen = OrigenFabricacion.URUGUAY;
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
        
        op=0;
        menuCategoria();
        ar.edu.unju.fi.ejercicio01.model.Producto.Categoria categoria = null;
        
        try {
            op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                     categoria = Categoria.ELECTROHOGAR;
                    break;
                case 2:
                	categoria = Categoria.HERRAMIENTAS;
                    break;
                case 3:
                	categoria = Categoria.INFORMATICA;
                    break;
                case 4:
                	categoria = Categoria.TELEFONIA;
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

        Producto producto = new Producto(codigo, descripcion, precioU, origen, categoria);
        productos.add(producto);     
        
        System.out.println("Producto agregado correctamente.");
    } catch (Exception e) {
        System.out.println("Error al dar de alta el producto. Motivo: " + e.getMessage());
    }
	
	}

private static void mostrarProductos(List<Producto>productos) {
	for (Producto producto : productos) {
		System.out.println(producto.toString());
			}
		}


private static void modificarProducto(Scanner scanner, List<Producto> productos) {
		// TODO Auto-generated method stub
	int op = 0;
		System.out.print("Ingrese el codigo del producto a modificar: ");
		String codigo = scanner.nextLine();
		Producto producto= buscarProducto(codigo, productos);
		if (producto.getCodigo() != null) {
			System.out.println("\n\tMODIFICAR PRODUCTO");
			System.out.println("------------------------");
			System.out.println("1. Descripcion");
			System.out.println("2. Precio Unitario");
			System.out.println("3. Origen de fabricacion");            
			System.out.println("4. Categoria");      
			System.out.print("Ingrese una opcion: ");

			try {
				op = scanner.nextInt();
        		scanner.nextLine();

        		switch (op) {
                	case 1:
                		System.out.print("Nueva descripcion del producto: ");
                		producto.setDescripcion(scanner.nextLine());
                    break;
                	case 2:
                		System.out.print("Nuevo precio unitario del producto: ");
                		producto.setPrecioU(scanner.nextDouble());
                		scanner.nextLine();
                    break;
                	case 3:
                		System.out.print("Nuevo origen de fabricacion del producto: ");
                		menuOrigenFab();
                		try {
                			op = scanner.nextInt();
                			scanner.nextLine();

                			switch (op) {
                            	case 1:
                            		producto.setOrigenFab(OrigenFabricacion.ARGENTINA);
                                break;
                            	case 2:
                            		producto.setOrigenFab(OrigenFabricacion.CHINA);
                                break;
                            	case 3:
                            		producto.setOrigenFab(OrigenFabricacion.BRASIL);
                                break;
                            	case 4:
                            		producto.setOrigenFab(OrigenFabricacion.URUGUAY);
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
                		break;                    
                	case 4:
                		menuCategoria();
                		try {
                			op = scanner.nextInt();
                			scanner.nextLine();

                			switch (op) {
                				case 1:
                					producto.setCategoria(Categoria.ELECTROHOGAR);
                                break;
                				case 2:
                					producto.setCategoria(Categoria.HERRAMIENTAS);
                                break;
                				case 3:
                					producto.setCategoria(Categoria.INFORMATICA);
                                break;
                				case 4:
                					producto.setCategoria(Categoria.TELEFONIA);
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
            System.out.println("No se encontro el producto con el codigo ingresado.");
        }
		
	}

private static Producto buscarProducto(String codigo, List<Producto> productos){
	Producto productoEncontrado = new Producto();
	try {        	
        for (Producto producto : productos) {
        	if (producto.getCodigo().equalsIgnoreCase(codigo)){
        		productoEncontrado = producto;
        	}                
        }
    } catch (Exception e) {
        System.out.println("Error" + e.getMessage());
    }
    return productoEncontrado;	
}

private static void menuOrigenFab() {
	System.out.println("----ORIGEN DE FABRICACION---- ");
    System.out.println("1. ARGENTINA");
    System.out.println("2. CHINA");
    System.out.println("3. BRASIL");            
    System.out.println("4. URUGUAY");
    System.out.print("Ingrese una opción: ");
	
}
private static void menuCategoria() {
	System.out.println("----CATEGORIA---- ");
    System.out.println("1. ELECTROHOGAR");
    System.out.println("2. HERRAMIENTAS");
    System.out.println("3. INFORMATICA");            
    System.out.println("4. TELEFONIA");
    System.out.print("Ingrese una opción: ");
	
}

}
