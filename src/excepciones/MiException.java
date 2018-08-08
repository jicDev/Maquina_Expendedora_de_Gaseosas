package excepciones;

public class MiException extends Exception {

    public MiException() {

    }

    public MiException(String s) {
        super(s);
        System.out.println(s);
    }

    public MiException(Throwable c) {
        super(c);
    }

    public MiException(String s, Throwable c) {
        super(s, c);
    }
}
