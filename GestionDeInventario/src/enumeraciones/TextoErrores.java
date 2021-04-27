
package enumeraciones;

public enum TextoErrores {
    
    NOMBRE_VACIO("* Error: Campo nombre vacío"),
    
    MARCA_VACIO("* Error: Campo Marca vacío"),
    
    EDAD_VACIO("* Error: Campo edad vacío"),
    EDAD_NO_NUMERO("* Error: Edad debe ser un número"),
    EDAD_NO_RANGO("* Error: Edad fuera de rango"),
    
    MAXIMO_CARACTERES_MARCA_20("* Error: Marca máximo 20 caracteres"),
    MAXIMO_CARACTERES_DIRECCION_20("* Error: Dirección máximo 20 caracteres"),
    MAXIMO_CARACTERES_USUARIO_20("* Error: Usuario máximo 20 caracteres"),
    MAXIMO_CARACTERES_PASSWORD_20("* Error: Contraseña máximo 20 caracteres"),
    MAXIMO_CARACTERES_NOMBRE_20("* Error: Nombre máximo 20 caracteres"),
    
    MAXIMO_CARACTERES_NOMBRE_30("* Error: Nombre máximo 30 caracteres"),
    
    MAXIMO_CARACTERES_NOMBRE_40("* Error: Nombre máximo 40 caracteres"),
    MAXIMO_CARACTERES_EMAIL_40("* Error: E-mail máximo 40 caracteres"),
    
    REGION_DUPLICADO("* Error: Región ya existe"),
    SUCURSAL_DUPLICADO("* Error: Nombre de la sucursal ya existe"),
    
    EMAIL_VACIO("* Error: Campo E-mail Vacío"),
    EMAIL_INVALIDO("* Error: E-mail inválido"),
    
    TELEFONO_VACIO("* Error: Campo Teléfono vacío"),
    TELEFONO_INVALIDO("* Error: Teléfono debe ser un número"),
    TELEFONO_RANGO("* Error: Teléfono debe tener 8 dígitos"),
    
    DIRECCION_VACIO("* Error: Campo Dirección vacío"),
    
    DESCRIPCION_RANGO("* Error: Desc. máximo de 300 caracteres"),
    
    BARCODE_VACIO("* Error: Campo Código de barras vacío"),
    BARCODE_RANGO("* Error: Código de barras debe tener 9 dígitos"),
    BARCODE_DUPLICADO("* Error: Código de barras ya existe"),
    
    PRECIO_VACIO("* Error: Campo Precio vacío"),
    PRECIO_INVALIDO("* Error: Precio debe ser un número"),
    PRECIO_CERO("* Error: Precio debe ser mayor a 0"),
    PRECIO_RANGO("* Error: Precio Máximo de 9 dígitos"),
    
    MIN_VACIO("* Error: Min vacío"),
    MAX_VACIO("* Error: Max vacío"),
    MIN_MAYOR_MAX("* Error: Min > Max"),
    MIN_INVALIDO("* Error: Min Inválido"),
    MAX_INVALIDO("* Error: Max Inválido"),
    MIN_MAX_ERROR("* Error: 9 Dígitos"),
    
    STOCK_VACIO("* Error: Campo Stock Vacío"),
    STOCK_CERO("* Error: Stock debe ser mayor a 0"),
    STOCK_INVALIDO("* Error: Stock debe ser un número"),
    STOCK_RANGO("* Error: Stock Máximo de 5 dígitos"),
    
    USUARIO_PASSWORD_INCORRECTOS("* Error: Usuario y/o contraseña incorrectos"),
    USUARIO_EXISTENTE("* Error: Usuario ya existe"),
    PASSWORD_DIFERENTES("* Error: Contraseñas no coinciden"),
    USUARIO_VACIO("* Error: Campo Usuario Vacío"),
    PASSWORD_VACIO("* Error: Campo Contraseña Vacío");
    
    private final String texto;
    
    private TextoErrores(String texto){
        this.texto = texto;
    }
    
    public String getTexto(){
        return texto;
    }
}
