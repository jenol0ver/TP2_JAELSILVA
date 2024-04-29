package ar.edu.unju.fi.ejercicio03.main;

import ar.edu.unju.fi.ejercicio03.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Provincia[] provincias  = Provincia.values();
		
		for (Provincia p : provincias) {
			System.out.println("\nProvincia: " + p
					+ "\nTiene " + p.getCantidadPoblacion() + " habitantes, "
					+ "su superficie es de " + p.getSuperficie() + " km² y "
					+ "su densidad poblacional es " + p.densidadPoblacional());
		}
	}

}
