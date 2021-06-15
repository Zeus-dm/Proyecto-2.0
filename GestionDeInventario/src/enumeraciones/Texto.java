
package enumeraciones;

public enum Texto {
    //Panel Menu Inicio Sesion
        //Inicio Sesion
    USUARIO("Usuario"),
    PASSWORD("Contraseña"),
    INICIAR_SESION("Iniciar Sesión"),
    NO_CUENTA("¿No tienes Cuenta?"),
    REGISTRATE("Registrate"),
        //Crear Cuenta
    CREA_CUENTA("Crea tu cuenta"),
    VER_PASSWORD("Verificar Contraseña"),
    CREAR_CUENTA("Crear Cuenta"),

    //Panel Menu Principal
    TITULO("El Chefcito"),
    BIENVENIDO("Bienvenido"),
    CERRAR_SESION("Cerrar Sesión"),
    REGIONES("Regiones"),
    CLIENTES("Clientes"),
    PRODUCTOS("Productos"),
    SALIR("Salir"),
    
    //Otros
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
            
    
    BUSCAR("Buscar"),
    PRECIO("Precio"),
    MIN("Min"),
    MAX("Max"),
    MARCA("Marca"),
    BARCODE("BarCode"),
    STOCK_TOTAL("Stock Total"),
    DESCRIPCION("Descripción"),
            
    MODIFICAR_PRODUCTO("Modificar Producto"),
        
    AGR_PRODUCTO("Agr. Producto"),
    AGREGAR_PRODUCTO("Agregar Nuevo Producto"),
    NUEVO("Nuevo"),
    STOCK("Stock"),
    EXISTENTE("Existente"),
    AGREGAR_EXISTENTE("Agregar Producto"),
    PRODUCTO("Producto"),
                
    ELIM_PRODUCTO("Elim. Producto"),
    MOD_STOCK("Mod. Stock"),
    MODIFICAR_STOCK("Modificar Stock"),
    
    
    AGREGAR("Agregar"),
    MODIFICAR("Modificar"),
    ELIMINAR("Eliminar"),
    
    CONFIRMACION_ELIMINAR("¿Estas seguro de Eliminar?"),
    CONFIRMACION_ELIMINAR_PRODUCTO("*Esto eliminara el producto en todas las sucursales que lo contengan."),
    CONFIRMACION_ELIMINAR_JEFE("¿Estas seguro de Eliminar el Jefe?"),
    CONFIRMACION_ELIMINAR_PRODUCTO_SUCURSAL("¿Estas seguro de Eliminar este producto de la Sucursal?"),
    
    PREVISUALIZACION("Previsualización"),
    
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
