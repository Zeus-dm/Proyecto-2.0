
package enumeraciones;

public enum Texto {
    //Panel Menu Sesion
    BOTON_INICIO_SESION("Iniciar Sesión"),
    BOTON_NUEVO_USUARIO("Crear Usuario"),
    NUEVO_USUARIO("Crear Nuevo Usuario"),
    USUARIO("Usuario"),
    PASSWORD("Contraseña"),
    VER_PASSWORD("Ver. Contraseña"),

    //Panel Menu Principal
    TITULO("El Chefcito"),
    BIENVENIDO("Bienvenido"),
    REGIONES("Regiones"),
    
    AGREGAR_REGION("Agregar Nueva Región"),
    NOMBRE("Nombre"),
    ELIMINAR_REGION("Eliminar Región"),
    REGION("Región"),
    MODIFICAR_REGION("Modificar Región"),
            
    SUCURSALES("Sucursales"),
    AGREGAR_SUCURSAL("Agregar Nueva Sucursal"),
            
    ELIM_SUCURSAL("Elim. Sucursal"),
    ELIMINAR_SUCURSAL("Eliminar Sucursal"),
    SUCURSAL("Sucursal"),
            
    JEFE_SUCURSAL("Jefe Sucursal"),
    MOD_SUCURSAL("Mod. Sucursal"),
    MODIFICAR_SUCURSAL("Modificar Sucursal"),
                
    AGR_JEFE("Agr. Jefe S."),
    AGREGAR_JEFE("Agregar Nuevo Jefe de Sucursal"),
                
    MOD_JEFE("Mod. jefe S."),
    MODIFICAR_JEFE("Modificar Jefe de Sucursal"),
            
    ELIM_JEFE("Elim. jefe S."),
            
    CLIENTES("Clientes"),
    AGR_CLIENTE("Agr. Cliente"),
    AGREGAR_CLIENTE("Agregar Nuevo Cliente"),
    EDAD("Edad"),
    DIRECCION("Dirección"),
    TELEFONO("Teléfono"),
    ID_TELEFONO("+56 9"),
    EMAIL("E-mail"),
    ELIM_CLIENTE("Elim. Cliente"),
    MOD_CLIENTE("Mod. Cliente"),
    MODIFICAR_CLIENTE("Modificar Cliente"),
            
    PRODUCTOS("Productos"),
    BUSCAR("Buscar"),
    PRECIO("Precio"),
    MIN("Min"),
    MAX("Max"),
    BARCODE("BarCode"),
    STOCK_TOTAL("Stock Total"),
    DESCRIPCION("Descripción"),
            
    MODIFICAR_PRODUCTO("Modificar Producto"),
        
    AGR_PRODUCTO("Agr. Producto"),
    AGREGAR_PRODUCTO("Agregar Producto"),
    NUEVO("Nuevo"),
    AGREGAR_NUEVO_PRODUCTO("Agregar Nuevo Producto"),
    STOCK("Stock"),
    EXISTENTE("Existente"),
    AGREGAR_EXISTENTE("Agregar Producto Existente"),
    PRODUCTO("Producto"),
                
    ELIM_PRODUCTO("Elim. Producto"),
    MOD_STOCK("Mod. Stock"),
    MODIFICAR_STOCK("Modificar Stock"),
    
    
    AGREGAR("Agregar"),
    MODIFICAR("Modificar"),
    ELIMINAR("Eliminar"),
    
    REPORTES("Reportes"),
    SALIR("Salir"),
    ACEPTAR("Aceptar"),
    CANCELAR("Cancelar"),
    VOLVER("Volver");
    
    private final String texto;

    private Texto(String texto) {
        this.texto = texto;
    }
    
    public String getTexto(){
        return this.texto;
    }
}
