
package FunGenerales;

import domain.Region;
import domain.Sistema;
import domain.Sucursal;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;

public class FunReporte {
    public static void generarReporte(Sistema sistema){
        Calendar cal = Calendar.getInstance();
        
        String dia = "" + cal.get(Calendar.DATE);
        String mes = "" + (cal.get(Calendar.MONTH) + 1);
        String ano = "" + cal.get(Calendar.YEAR);
        
        if(dia.length() == 1){
            dia = "0" + dia;
        }
        if(mes.length() == 1){
            mes = "0" + mes;
        }
        
        File archivo = new File("../Reportes/reporte_" + dia + "-" + mes + "-" + ano + ".txt");
        try {
            PrintWriter escritura = new PrintWriter(archivo);
            
            escritura.println("-----Regiones-----");
            List<String> nombresRegiones = sistema.nombresRegiones();
            for (String nombreRegion : nombresRegiones) {
                escritura.println(" "+nombreRegion);
                Region region = sistema.obtenerRegion(nombreRegion);
                
                escritura.println("\t-----Sucursales-----");
                List<String> nombresSucursales = region.nombresSucursales();
                for (String nombreSucursal : nombresSucursales) {
                    escritura.println("\t "+nombreSucursal);
                    Sucursal sucursal = region.obtenerSucursal(nombreSucursal);
                    
                    escritura.println("\t\t-----Productos-----");
                    List<String> nombresProductos = sucursal.todosProductos();
                    for (String nombreProducto : nombresProductos) {
                        escritura.println("\t\t "+nombreProducto);
                    }
                }
                
                escritura.println("");
            }
            
            escritura.println("-----Clientes-----");
            List<String> nombresClientes = sistema.nombresClientes();
            for (String nombreCliente : nombresClientes) {
                escritura.println(" "+nombreCliente);
            }
            
            escritura.println("\n-----Todos los Productos-----");
            List<String> nombresProductos = sistema.todosProductos();
            for (String nombreProducto : nombresProductos) {
                escritura.println(" "+nombreProducto);
            }
            
            escritura.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
