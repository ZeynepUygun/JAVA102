package Exception;

public class InvalidAuthenticationException extends Exception{
    /*Exception isminde paket oluşturduk.
    InvalidAuthenticationException sınıfını oluşturduk ve Exception sınıfından kalıtım yaptık.
    Constructors (Constructive Methods)*/
    public InvalidAuthenticationException(String message) {
        super(message);
    }
}
