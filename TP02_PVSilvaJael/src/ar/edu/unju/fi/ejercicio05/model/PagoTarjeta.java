package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio05.interfaces.Pago;

public class PagoTarjeta implements Pago{
	private String numTarjeta;
	private LocalDate fechaPago;
	private double montoPagado;
	public PagoTarjeta() {
		// TODO Auto-generated constructor stub
	}
	public String getNumTarjeta() {
		return numTarjeta;
	}
	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}
	public LocalDate getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}
	public double getMontoPagado() {
		return montoPagado;
	}
	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}
	public PagoTarjeta(String numTarjeta, LocalDate fechaPago, double montoPagado) {
		this.numTarjeta = numTarjeta;
		this.fechaPago = fechaPago;
		this.montoPagado = montoPagado;
	}
	
	@Override
	public void realizarPago(double monto) {
		// TODO Auto-generated method stub
		montoPagado = monto * 1.5;
		
	}
	@Override
	public void imprimirRecibo() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		System.out.println("\nNumero de tarjeta: " + numTarjeta + 
				"\nFecha de pago: " + fechaPago.format(formatter)
				+ "\nMonto Pagado: " + montoPagado);
		
		
		
	}
	
}
