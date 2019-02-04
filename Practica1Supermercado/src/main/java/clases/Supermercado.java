package clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Supermercado {
	private List<Producto> listaProductos;
	private static Supermercado mSupermercado = new Supermercado();
	private Supermercado() {
		this.listaProductos = new ArrayList<>();
	}

	public static Supermercado getSupermercado() {
		return mSupermercado;
	}

	public boolean add(Producto e) {
		return listaProductos.add(e);
	}
	
	public List<Producto> getProductosCaducados(int opcion) {
		//filtrar(p -> p.getFechaCaducidad().isBefore(LocalDate.now()));
		List<Producto> listaADevolver = null;
		switch (opcion) {
			case 0:
				listaADevolver = this.filtrarVersion1(new Predicate<Producto>() {
					@Override
					public boolean test(Producto t) {						
						return t.getFechaCaducidad().isBefore(LocalDate.now());
					}
				});
				break;
			case 1:
				listaADevolver = this.filtrarVersion2(p -> p.getFechaCaducidad().isBefore(LocalDate.now()));
				break;

		}
		return listaADevolver;
	}
		
	public List<Producto> filtrarVersion1(Predicate<Producto> p){
		List<Producto> listaADevolver = new ArrayList<>();
		for(Producto producto: this.listaProductos) {
			if(p.test(producto)){
				listaADevolver.add(producto);
			}			
		}		
		return listaADevolver;
	}
	
	
	public List<Producto> filtrarVersion2(Predicate<Producto> p){
		List<Producto> listaADevolver = this.listaProductos.stream().filter(p).collect(Collectors.toList());
		
		return listaADevolver;
		
	}
	
	public Map<String, Double> getPrecioMedioPorSeccion() {
		return listaProductos.stream().collect(Collectors.groupingBy(Producto::getSeccion, Collectors.averagingDouble(Producto::getPrecio)));
	}
	
	public Map<String, Optional<Producto>> getPrecioMasBaratoPorSeccion(){
		return this.listaProductos.stream().collect(Collectors.groupingBy(Producto::getSeccion, Collectors.minBy(Comparator.comparingDouble(Producto::getPrecio))));				
	}
	
	public double getSumaPreciosNoCaducos() {		
		return this.listaProductos.stream().filter(p->p.getFechaCaducidad().isAfter(LocalDate.now())).mapToDouble(Producto::getPrecio).sum();					
	}
	
	public List<Producto> ordenarPorOrdenCreciente(){
		return this.listaProductos.stream().sorted(Comparator.comparingDouble(Producto::getPrecio)).collect(Collectors.toList());
		
	}
	
	
	
	

}
