package ar.edu.unju.fi.ejercicio06.model;

public class FelinoSalvaje {
	private String nombre;
	private byte edad;
	private float peso;
	
	public FelinoSalvaje() {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public byte getEdad() {
		return edad;
	}

	public void setEdad(byte edad) {
		this.edad = edad;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public FelinoSalvaje(String nombre, byte edad, float peso) {
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "\tFelinoSalvaje \nNombre=" + nombre + 
				"\nEdad: " + edad + "\nPeso=" + peso ;
	}
}
