
package domain;

public class SucursalProducto implements IGenerico{
    private int idSP ;
    private int idSucursal ;
    private int idProducto ;
    private int stock ;
    
    public SucursalProducto () {   
    }
    
    public SucursalProducto (int idSP) {
        this.idSP = idSP ;
    }
    
    public SucursalProducto (int idProducto, int idSucursal, int stock){
        this.idSucursal = idSucursal ;
        this.idProducto = idProducto ;
        this.stock = stock ;
    }

    public SucursalProducto(int idSP, int idProducto, int idSucursal, int stock) {
        this.idSP = idSP;
        this.idSucursal = idSucursal;
        this.idProducto = idProducto;
        this.stock = stock;
    }

    public int getIdSP() {
        return idSP;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public int getStock() {
        return stock;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SucursalProducto{idSP=").append(idSP);
        sb.append(", idSucursal=").append(idSucursal);
        sb.append(", idProducto=").append(idProducto);
        sb.append(", stock=").append(stock);
        sb.append('}');
        return sb.toString();
    }
}
