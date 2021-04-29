
package domain;

import enumeraciones.TextoErrores;
import excepciones.*;

public class Producto implements IGenerico{
    private int idProducto ;
    private String nombre ;
    private String marca ;
    private String barCode ;
    private long stockTotal ;
    private int precio ;
    private String descripcion ;
    
    public Producto(){
    }
    
    public Producto(int idProducto){
        this.idProducto = idProducto ;
    }
    
    public Producto(String nombre, String marca, String barCode, long stockTotal, int precio, String descripcion){
        this.nombre = nombre ;
        this.marca = marca ;
        this.barCode = barCode ;
        this.stockTotal = stockTotal ;
        this.precio = precio ;
        this.descripcion = descripcion ;
    }
    
    public Producto(int idProducto, String nombre, String marca, String barCode, long stockTotal, int precio, String descripcion){
        this.idProducto = idProducto ;
        this.nombre = nombre ;
        this.marca = marca ;
        this.barCode = barCode ;
        this.stockTotal = stockTotal ;
        this.precio = precio ;
        this.descripcion = descripcion ;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public String getBarCode() {
        return barCode;
    }

    public long getStockTotal() {
        return stockTotal;
    }

    public int getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    
    public void setNombre(String nombre) {
        if(nombre == null || nombre.isEmpty()){
            throw new TextoEnBlancoException( TextoErrores.NOMBRE_VACIO.getTexto() );
        }else if(nombre.length() > 30){
            throw new TextoTamanoMaximoException( TextoErrores.MAXIMO_CARACTERES_NOMBRE_30.getTexto() );
        }
        this.nombre = nombre;
    }

    public void setMarca(String marca) {
        if(marca == null || marca.isEmpty()){
            throw new TextoEnBlancoException( TextoErrores.MARCA_VACIO.getTexto() );
        }else if(marca.length() > 20){
            throw new TextoTamanoMaximoException( TextoErrores.MAXIMO_CARACTERES_MARCA_20.getTexto() );
        }
        this.marca = marca;
    }

    public void setBarCode(String barCode) {
        if(barCode == null || barCode.isEmpty()){
            throw new TextoEnBlancoException( TextoErrores.BARCODE_VACIO.getTexto() );
        }else{
            if(barCode.length() != 9){
                throw new NumeroRangoException( TextoErrores.BARCODE_RANGO.getTexto() );
            }
        }
        this.barCode = barCode;
    }

    public void setStockTotal(long stockTotal) {
        if(stockTotal < 0){
            throw new NumeroRangoException( TextoErrores.STOCK_CERO.getTexto() );
        }
        this.stockTotal = stockTotal;
    }
    
    public void setStockTotal(String stockTotal){
        if(stockTotal == null || stockTotal.isEmpty()){
            throw new TextoEnBlancoException( TextoErrores.STOCK_VACIO.getTexto() );
        }else if(stockTotal.length() > 5){
            throw new TextoTamanoMaximoException( TextoErrores.STOCK_RANGO.getTexto() );
        }else{
            try {
                long stockTotalAux = Long.parseLong(stockTotal);
                if(stockTotalAux < 0){
                    throw new NumeroRangoException( TextoErrores.STOCK_CERO.getTexto() );
                }
                this.stockTotal = stockTotalAux;
            } catch (NumberFormatException e){
                throw new NumeroFormatException( TextoErrores.STOCK_INVALIDO.getTexto() );
            }
        }
    }

    public void setPrecio(int precio) {
        if(precio <= 0){
            throw new NumeroRangoException( TextoErrores.PRECIO_CERO.getTexto() );
        }
        this.precio = precio;
    }
    
    public void setPrecio(String precio){
        if(precio == null || precio.isEmpty()){
            throw new TextoEnBlancoException( TextoErrores.PRECIO_VACIO.getTexto() );
        }else if(precio.length() > 9){
            throw new TextoTamanoMaximoException( TextoErrores.PRECIO_RANGO.getTexto() );
        }else{
            try {
                int precioAux = Integer.parseInt(precio);
                if(precioAux <= 0){
                    throw new NumeroRangoException( TextoErrores.PRECIO_CERO.getTexto() );
                }
                this.precio = precioAux;
            } catch (NumberFormatException e){
                throw new NumeroFormatException( TextoErrores.PRECIO_INVALIDO.getTexto() );
            }
        }
    }
    
    public void setDescripcion(String descripcion) {
        if(descripcion.length() > 300){
            throw new TextoTamanoMaximoException( TextoErrores.DESCRIPCION_RANGO.getTexto() );
        }
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto{idProducto=").append(idProducto);
        sb.append(", nombre=").append(nombre);
        sb.append(", barCode=").append(barCode);
        sb.append(", stockTotal=").append(stockTotal);
        sb.append(", precio=").append(precio);
        sb.append(", descripcion=").append(descripcion);
        sb.append('}');
        return sb.toString();
    }
}
