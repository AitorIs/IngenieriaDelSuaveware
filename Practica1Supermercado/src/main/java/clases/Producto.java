package clases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Comparator;

public class Producto implements Comparator<Producto>{
	private String nombre;
	private String seccion;
	private float precio;
	private LocalDate fechaExposicion;
	private LocalDate fechaCaducidad;


	public Producto(String pNombre, String pSeccion, float pPrecio,LocalDate pFechaCaducidad){
		nombre = pNombre;
		seccion = pSeccion;
		precio = pPrecio;
		fechaExposicion = LocalDate.now(); 
		fechaCaducidad = pFechaCaducidad;
	}

	public String getNombre() {
		return nombre;
	}


	public String getSeccion() {
		return seccion;
	}


	public float getPrecio() {
		return precio;
	}


	public LocalDate getFechaExposicion() {
		return fechaExposicion;
	}


	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}

	@Override
	public String toString() {
		DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendText(ChronoField.DAY_OF_MONTH)
        .appendLiteral(" de ")
        .appendText(ChronoField.MONTH_OF_YEAR)
        .appendLiteral(" de ")
        .appendText(ChronoField.YEAR)
        .parseCaseInsensitive().toFormatter();
		return String
				.format("Producto: %1$s\nSección: %2$s\nPrecio: %3$.2f\nFecha caducidad: %4$s\n",
						getNombre(), getSeccion(), getPrecio(),
						getFechaCaducidad().format(formatter));
	}
	
	public boolean estaCaducado() 
	{
		return getFechaCaducidad().isBefore(LocalDate.now());
	}

	@Override
	public Comparator<Producto> thenComparing(Comparator<? super Producto> other) {
		return Comparator.super.thenComparing(other);
	}

	@Override
	public int compare(Producto o1, Producto o2) {
		int retorno = 0;
		if(o1.getPrecio()> o2.getPrecio()) {
			retorno = 1;
		}
		else {
			if(o1.getPrecio() < o2.getPrecio()) {
				retorno = -1;
			}
		}
		return retorno;
	}

}
