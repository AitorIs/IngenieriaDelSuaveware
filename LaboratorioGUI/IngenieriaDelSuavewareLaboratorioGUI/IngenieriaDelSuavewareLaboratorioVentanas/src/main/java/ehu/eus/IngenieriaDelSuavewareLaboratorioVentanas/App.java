package ehu.eus.IngenieriaDelSuavewareLaboratorioVentanas;

import vista.DialogoLongeo;
import vista.VentanaConfig;
import vista.VentanaFinal;

/**
 * Hello world!
 *
 */
public class App {
	
	private static String usuario;
	private static String contrasena;
	private static DialogoLongeo dialogoLongeo;
	private static VentanaConfig ventanaConfig;
	private static VentanaFinal ventanaFinal;
	
    public static void main( String[] args ){
    	InicializarUsuarioYContrasena();
        dialogoLongeo = new DialogoLongeo();
        dialogoLongeo.setVisible(true);
        
    }
    
    
    private static void InicializarUsuarioYContrasena() {
    	usuario = "admin";
    	contrasena = "admin";
    }
    
    public static void Login(String presunto_usuario, String presunta_contrasena) {
    	System.out.println(presunta_contrasena);
    	if(VerificarAcceso(presunto_usuario, presunta_contrasena)) {
    		dialogoLongeo.dispose();
    		InicializarVentanaConfig();
    	}  	
    }
    
    private static boolean VerificarAcceso(String presunto_usuario, String presunta_contrasena) {
    	return (usuario.equals(presunto_usuario) && contrasena.equals(presunta_contrasena));
    }
    
    
    private static void InicializarVentanaConfig(){
    	ventanaConfig = new VentanaConfig();
    	ventanaConfig.setVisible(true);   	
    }
    
    
    public static void PasarAVentanaFinal(int eleccionResolucion) {
    	int resolucion = (eleccionResolucion-47)*200;
    	System.out.println(resolucion);
    	ventanaConfig.dispose();
    	ventanaFinal = new VentanaFinal(resolucion);
    	ventanaFinal.setVisible(true);
    	
    	
    }
    

    
    
    
}
