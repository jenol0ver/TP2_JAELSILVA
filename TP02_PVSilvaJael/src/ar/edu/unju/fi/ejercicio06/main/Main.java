package ar.edu.unju.fi.ejercicio06.main;

import ar.edu.unju.fi.ejercicio06.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio06.model.FelinoSalvaje;
import ar.edu.unju.fi.ejercicio06.interfaces.funcionales.Converter;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FelinoDomestico gato = new FelinoDomestico("Garfield", (byte)45, 12.0f);
		
		Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(), 
				x.getEdad(), x.getPeso());
		
		FelinoSalvaje felino1 = converter.convertir(gato);
		
		converter.mostrarObjeto(felino1);
		
		FelinoSalvaje felino = new FelinoSalvaje("Tanner", (byte)20, 186f);
		
		if(Converter.isNotNull(felino)) {
			
			Converter<FelinoSalvaje, FelinoDomestico> converter2 = x -> new FelinoDomestico(x.getNombre(), 
					x.getEdad(), x.getPeso());
			
			FelinoDomestico gato2 = converter2.convertir(felino);
			
			converter2.mostrarObjeto(gato2);
			
		}
		
		else {
			System.out.println("El objeto a convertir es nulo");
		}
	}

	}

