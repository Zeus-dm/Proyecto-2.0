
package enumeraciones;

public enum Colores {
    FONDO("#3C3F42","#EEEEEE"),
    TITULO("#FFFFFF","#000000"),
    
    TEXTO("#FFFFFF","#000000"),
    FONDO_TABLA("#5C5E5F","#E0E0E0"),
    TEXTO_ERROR("#F44336","#F44336"),
    
    FONDO_BOTON("#4C5053","#E0E0E0"),
    TEXTO_BOTON("#FFFFFF","#000000"),
    
    BORDE("#EFB810","#1CBAA4"),
        
    ICONO_MODO("/gui/imagenes/iconos/luna_blanca_32.png","/gui/imagenes/iconos/sol_negro_32.png"),
    ICONO_SONIDO("/gui/imagenes/iconos/sonido_blanco_32.png","/gui/imagenes/iconos/sonido_negro_32.png"),
    ICONO_MUTE("/gui/imagenes/iconos/mute_blanco_32.png","/gui/imagenes/iconos/mute_negro_32.png"),
    ICONO_ARCHIVO("/gui/imagenes/iconos/archivo_blanco_32.png","/gui/imagenes/iconos/archivo_negro_32.png"),
    ICONO_LUPA("/gui/imagenes/iconos/lupa_blanca_32.png","/gui/imagenes/iconos/lupa_negra_32.png"),
    ICONO_GRAFICO_TORTA("/gui/imagenes/iconos/grafico_torta_blanco_32.png","/gui/imagenes/iconos/grafico_torta_negro_32.png"),
    ICONO_GRAFICO_BARRA("/gui/imagenes/iconos/grafico_blanco_32.png","/gui/imagenes/iconos/grafico_negro_32.png"),
    ICONO_ATRAS("/gui/imagenes/iconos/atras_blanco_32.png","/gui/imagenes/iconos/atras_negro_32.png");
    
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
