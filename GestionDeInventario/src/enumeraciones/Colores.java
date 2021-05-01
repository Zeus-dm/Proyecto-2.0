
package enumeraciones;

public enum Colores {
    FONDO("#3C3F42","#EEEEEE"),
    TITULO("#FFFFFF","#000000"),
    
    TEXTO("#FFFFFF","#000000"),
    FONDO_TABLA("#5C5E5F","#E0E0E0"),
    TEXTO_ERROR("#F44336","#F44336"),
    
    FONDO_BOTON("#5C5E5F","#E0E0E0"),
    TEXTO_BOTON("#FFFFFF","#000000"),
    
    BORDE("#EFB810","#1CBAA4"),
    
    GRAFICO_BARRAS("#F44336","#9C27B0"),
    
    ICONO_CERRAR("/gui/imagenes/iconosInicioSesion/cerrar_blanco_28.png","/gui/imagenes/iconosInicioSesion/cerrar_negro_28.png"),
    ICONO_CERRAR_DRAGGED("/gui/imagenes/iconosInicioSesion/cerrar_rojo_28.png","/gui/imagenes/iconosInicioSesion/cerrar_rojo_28.png"),
    
    ICONO_NO_VISTA("/gui/imagenes/iconosInicioSesion/no_vista_blanco_28.png","/gui/imagenes/iconosInicioSesion/no_vista_negro_28.png"),
    ICONO_NO_VISTA_DRAGGED("/gui/imagenes/iconosInicioSesion/no_vista_dorado_28.png","/gui/imagenes/iconosInicioSesion/no_vista_agua_28.png"),
    
    ICONO_VISTA("/gui/imagenes/iconosInicioSesion/vista_blanco_28.png","/gui/imagenes/iconosInicioSesion/vista_negro_28.png"),
    ICONO_VISTA_DRAGGED("/gui/imagenes/iconosInicioSesion/vista_dorado_28.png","/gui/imagenes/iconosInicioSesion/vista_agua_28.png"),
    
    ICONO_ERROR("/gui/imagenes/iconosMultiProposito/error_rojo_28.png","/gui/imagenes/iconosMultiProposito/error_rojo_28.png"),
     
    ICONO_MODO("/gui/imagenes/iconosMenuPrincipal/luna_blanca_32.png","/gui/imagenes/iconosMenuPrincipal/sol_negro_32.png"),
    ICONO_MODO_DRAGGED("/gui/imagenes/iconosMenuPrincipal/luna_dorado_32.png","/gui/imagenes/iconosMenuPrincipal/sol_agua_32.png"),
    
    ICONO_SONIDO("/gui/imagenes/iconosMenuPrincipal/sonido_blanco_32.png","/gui/imagenes/iconosMenuPrincipal/sonido_negro_32.png"),
    ICONO_SONIDO_DRAGGED("/gui/imagenes/iconosMenuPrincipal/sonido_dorado_32.png","/gui/imagenes/iconosMenuPrincipal/sonido_agua_32.png"),
    
    ICONO_MUTE("/gui/imagenes/iconosMenuPrincipal/mute_blanco_32.png","/gui/imagenes/iconosmenuPrincipal/mute_negro_32.png"),
    ICONO_MUTE_DRAGGED("/gui/imagenes/iconosMenuPrincipal/mute_dorado_32.png","/gui/imagenes/iconosmenuPrincipal/mute_agua_32.png"),
    
    ICONO_ARCHIVO("/gui/imagenes/iconosMenuPrincipal/archivo_blanco_32.png","/gui/imagenes/iconosMenuPrincipal/archivo_negro_32.png"),
    ICONO_ARCHIVO_DRAGGED("/gui/imagenes/iconosMenuPrincipal/archivo_dorado_32.png","/gui/imagenes/iconosMenuPrincipal/archivo_agua_32.png"),
    
    ICONO_LUPA("/gui/imagenes/iconos/lupa_blanca_32.png","/gui/imagenes/iconos/lupa_negra_32.png"),
    ICONO_GRAFICO_TORTA("/gui/imagenes/iconos/grafico_torta_blanco_32.png","/gui/imagenes/iconos/grafico_torta_negro_32.png"),
    ICONO_GRAFICO_BARRA("/gui/imagenes/iconos/grafico_blanco_32.png","/gui/imagenes/iconos/grafico_negro_32.png"),
    ICONO_ATRAS("/gui/imagenes/iconos/atras_blanco_32.png","/gui/imagenes/iconos/atras_negro_32.png"),
    
    ICONO_AGREGAR_JEFE_SUCURSAL("/gui/imagenes/iconos/agregar_jefe_blanco_32.png","/gui/imagenes/iconos/agregar_jefe_negro_32.png"),
    ICONO_QUITAR_AGREGAR_JEFE_SUCURSAL("/gui/imagenes/iconos/quitar_agregar_jefe_blanco_32.png","/gui/imagenes/iconos/quitar_agregar_jefe_negro_32.png"),
    ICONO_ELIMINAR_JEFE_SUCURSAL("/gui/imagenes/iconos/eliminar_jefe_blanco_32.png","/gui/imagenes/iconos/eliminar_jefe_negro_32.png"),
    ICONO_MODIFICAR_JEFE_SUCURSAL("/gui/imagenes/iconos/modificar_jefe_blanco_32.png","/gui/imagenes/iconos/modificar_jefe_negro_32.png");
    
    private final String colorOscuro;
    private final String colorClaro;

    private Colores(String colorOscuro, String colorClaro) {
        this.colorOscuro = colorOscuro;
        this.colorClaro = colorClaro;
    }
    
    public String getColor(int modo){
        if(modo == 0){
            return this.colorOscuro;
        }else{
            return this.colorClaro;
        }
    }
}
