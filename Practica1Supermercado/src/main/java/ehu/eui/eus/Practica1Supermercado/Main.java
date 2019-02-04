package ehu.eui.eus.Practica1Supermercado;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

import clases.*;

public class Main {
	
	private static Supermercado supermercado;

    public static void main( String[] args ) {
    	InicializarDatosIniciales();
    	//ImprimirDatosProductos(supermercado.getProductosCaducados(1));
    	//ObtenerElPrecioDelProductoMasBaratoPorSeccion();
    	//CalcularSumaDeTodosLosPreciosDeProductosNoCaducados();
    	//MostrarProductosOrdenCreciente();
    	MostrarProductosOrdenCrecienteV2();
    }
    
    
    private static void InicializarDatosIniciales() {
    	supermercado = Supermercado.getSupermercado();
    	supermercado.add(new Producto("Producto1", "Sec1", 5.5f, LocalDate.of(2019,12,12)));
    	supermercado.add(new Producto("Producto1", "Sec1", 7.9f, LocalDate.of(2019,12,12)));
		supermercado.add(new Producto("Producto2", "Sec1", 3.1f, LocalDate.of(2018,12,12)));
		supermercado.add(new Producto("Producto3", "Sec2", 11f, LocalDate.of(2018,12,21)));    	
    }
    
    
    public static void ImprimirDatosProductos(List<Producto> lista) {
    	for(Producto producto: lista) {
    		System.out.println(producto.toString());  		
    	}    	
    }
    
 	public static void ObtenerElPrecioDelProductoMasBaratoPorSeccion() {
 		Map<String, Optional<Producto>> hastable = supermercado.getPrecioMasBaratoPorSeccion();
 		Set<String> keys = hastable.keySet();
 		for(String key : keys) {
 			System.out.println(key + " Producto: " + hastable.get(key));			 			
 		}
 	}
 	
 	
 	public static void CalcularSumaDeTodosLosPreciosDeProductosNoCaducados() {		
 		System.out.println(supermercado.getSumaPreciosNoCaducos()); 				
 	}

 	
 	public static void MostrarProductosOrdenCreciente() {
 		supermercado.ordenarPorOrdenCreciente().stream().forEach(new Consumer<Producto>() {
			@Override
			public void accept(Producto t) {
				System.out.println(t);				
			} 			
		}); 				
 	}
 	
 	public static void MostrarProductosOrdenCrecienteV2() {
 		supermercado.ordenarPorOrdenCreciente().stream().forEach(p -> System.out.println(p));		
 	}
 	// TODO: Mostrar los productos ordenados por precio. De menor a mayor.
    
    
    
    
    
    
    
    
    
}
