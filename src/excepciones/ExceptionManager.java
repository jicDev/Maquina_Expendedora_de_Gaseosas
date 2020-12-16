package excepciones;

public class ExceptionManager extends Exception {
    public ExceptionManager() {}

    public ExceptionManager(String s) {
        super(s);
        System.out.println(s);
    }

    public ExceptionManager(Throwable c) {
        super(c);
    }

    public ExceptionManager(String s, Throwable c) {
        super(s, c);
    }
}
