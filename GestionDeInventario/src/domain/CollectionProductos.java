
package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionProductos {
    private final Map<String,Producto> mapaProductos;
    private final List<String> nombresProductos;
    private final List<String> barCodesProductos;
    private final List<String> marcasProductos;
    private final List<Integer> cantProductosMarca;

    public CollectionProductos() {
        mapaProductos = new HashMap<>();
        nombresProductos = new ArrayList<>();
        barCodesProductos = new ArrayList<>();
        marcasProductos = new ArrayList<>();
        cantProductosMarca = new ArrayList<>();
    }
    
    //METODOS
    public boolean verificarExistencia(String barCode){
        Producto producto = mapaProductos.get(barCode);
        return producto != null;
    }
    
    public Producto obtenerProducto(String barCode){
        return mapaProductos.get(barCode);
    }
    
    public void agregarProducto(Producto producto){
        mapaProductos.put(producto.getBarCode(), producto);
        
        todosProductos();
    }
    
    public void eliminarProducto(String barCode){
        for (int i = 0; i < barCodesProductos.size(); i++) {
            if(barCode.equals(barCodesProductos.get(i))){
                barCodesProductos.remove(i);
                nombresProductos.remove(i);
                break;
            }
        }
        
        mapaProductos.remove(barCode);
    }
    
    public void modificarProducto(String preBarCode, Producto nuevoProducto){
        for (int i = 0; i < barCodesProductos.size(); i++) {
            if(preBarCode.equals(barCodesProductos.get(i))){
                barCodesProductos.set(i, nuevoProducto.getBarCode());
                nombresProductos.set(i, nuevoProducto.getNombre());
                break;
            }
        }
        
        mapaProductos.remove(preBarCode);
        mapaProductos.put(nuevoProducto.getBarCode(), nuevoProducto);
    }
    
    public List<String> todosProductos(){
        nombresProductos.removeAll(nombresProductos);
        barCodesProductos.removeAll(barCodesProductos);
        
        for (Producto producto : mapaProductos.values()) {
            nombresProductos.add(producto.getNombre());
            barCodesProductos.add(producto.getBarCode());
        }
        return nombresProductos;
    }
    
    public List<String> todosBarCodes(){
        return barCodesProductos;
    }
    
    public List<String> productosFiltrados(){
        return nombresProductos;
    }
    
    public List<String> filtrarProductos(String textoBuscar){
        nombresProductos.removeAll(nombresProductos);
        barCodesProductos.removeAll(barCodesProductos);
        
        for (Producto producto : mapaProductos.values()) {
            if(producto.getNombre().toLowerCase().contains(textoBuscar.toLowerCase())){
                nombresProductos.add(producto.getNombre());
                barCodesProductos.add(producto.getBarCode());
            }
        }
        return nombresProductos;
    }
    
    public List<String> filtrarProductos(int min, int max){
        nombresProductos.removeAll(nombresProductos);
        barCodesProductos.removeAll(barCodesProductos);
        
        for (Producto producto : mapaProductos.values()) {
            if((producto.getPrecio() >= min) && (producto.getPrecio() <= max)){
                nombresProductos.add(producto.getNombre());
                barCodesProductos.add(producto.getBarCode());
            }
        }
        return nombresProductos;
    }
    
    public List<String> filtrarProductos(int min, int max, String textoBuscar){
        nombresProductos.removeAll(nombresProductos);
        barCodesProductos.removeAll(barCodesProductos);
        
        for (Producto producto : mapaProductos.values()) {
            if((producto.getPrecio() >= min) && (producto.getPrecio() <= max) && (producto.getNombre().toLowerCase().contains(textoBuscar.toLowerCase()))){
                nombresProductos.add(producto.getNombre());
                barCodesProductos.add(producto.getBarCode());
            }
        }
        return nombresProductos;
    }
    
    public List<String> todasMarcas(){
        marcasProductos.removeAll(marcasProductos);
        boolean flag;
        
        for (Producto producto : mapaProductos.values()) {
            flag = true;
            for (String marca : marcasProductos) {
                if(marca.equals(producto.getMarca())){
                    flag = false;
                    break;
                }
            }
            if(flag){
                marcasProductos.add(producto.getMarca());
            }
        }
        
        return marcasProductos;
    }
    
    public List<Integer> cantidadProductosMarca(){
        cantProductosMarca.removeAll(cantProductosMarca);
        int cont;
        
        for (String marca : marcasProductos) {
            cont = 0;
            for (Producto producto : mapaProductos.values()) {
                if(marca.equals(producto.getMarca())){
                    cont++;
                }
            }
            cantProductosMarca.add(cont);
        }
        
        return cantProductosMarca;
    }
}
