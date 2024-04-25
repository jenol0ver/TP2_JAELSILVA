package ar.edu.unju.fi.ejercicio01.model;

import ar.edu.unju.fi.ejercicio01.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio01.model.Producto.OrigenFabricacion;

public class Producto {
	private String codigo;
	private String descripcion;
	private double precioU;
	private OrigenFabricacion origenFab;
	private Categoria categoria;
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public enum OrigenFabricacion{
		ARGENTINA, CHINA, BRASIL, URUGUAY
	}
	public enum Categoria{
		TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecioU() {
		return precioU;
	}
	public void setPrecioUnitario(double precioU) {
		this.precioU = precioU;
	}
	public OrigenFabricacion getOrigenFab() {
		return origenFab;
	}
	public void setOrigenFab(OrigenFabricacion origenFab) {
		this.origenFab = origenFab;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Producto(String codigo, String descripcion, double precioU, OrigenFabricacion origenFab,
			Categoria categoria) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioU = precioU;
		this.origenFab = origenFab;
		this.categoria = categoria;
	}
	
	@Override
	public String toString() {
		return "\n----INFORMACION DEL PRODUCTO---" + 
				"\nCodigo: " + codigo + "\nDescripcion: " + descripcion + 
				"\nPrecio Unitario: " + precioU + "\nOrigen de Fabricacion: " + origenFab + 
				"\nCategoria: " + categoria;
	}

}
