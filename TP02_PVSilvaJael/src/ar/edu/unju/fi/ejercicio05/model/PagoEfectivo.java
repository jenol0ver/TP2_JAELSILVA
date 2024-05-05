package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import ar.edu.unju.fi.ejercicio05.interfaces.Pago;

public class PagoEfectivo implements Pago{
	private double montoPagado;
	private LocalDate fechaPago;
	
	public PagoEfectivo() {
		// TODO Auto-generated constructor stub
	}

	public PagoEfectivo(double montoPagado, LocalDate fechaPago) {
		this.montoPagado = montoPagado;
		this.fechaPago = fechaPago;
	}

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}

	
	public void realizarPago(double monto) {
		montoPagado = monto * 0.9;		
	}

	@Override
	public void imprimirRecibo() {
		// TODO Auto-generated method stub
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		System.out.println("\nFecha de pago: " + fechaPago.format(formatter)
							+ "\nMonto Pagado: " + montoPagado);
		
	}

}
