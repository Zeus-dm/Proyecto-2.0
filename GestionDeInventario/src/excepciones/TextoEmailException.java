
package excepciones;

public class TextoEmailException extends RuntimeException{
    public TextoEmailException(String mensaje) {
        super(mensaje);
    }
}
