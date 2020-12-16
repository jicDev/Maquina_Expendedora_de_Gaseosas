package graficos;

import entidades.Soda;
import excepciones.ExceptionManager;
import servicios.SodaService;
import java.util.Vector;

public class Handler {
    private Window window;
    private SodaService sodaService;
    private Soda soda;

    public Handler() {
        sodaService = new SodaService();
    }

    public Handler(Soda soda) {
        this.soda = soda;
        sodaService = new SodaService();
        sodaService.setDAO(soda);
    }

    public Handler(Window window) {
        this.window = window;
    }

    public void insertar() throws ExceptionManager {
        sodaService.insertSoda(soda);
    }

    public void modify() {
        sodaService.modifySoda(soda);
    }

    public void delete() {
        sodaService.deleteSoda(soda);
    }

    public Vector<Vector> list() {
        return sodaService.listSoda();
    }

    public void insertSoda() {
        window.ChangeMode(new InsertSoda());
    }

    public void deleteSoda() {
        window.ChangeMode(new DeleteSoda());
    }

    public void modifySoda() {
        window.ChangeMode(new ModifySoda());
    }

    public void listSoda() {
        window.ChangeMode(new ListSoda());
    }

    public void showMachine() {
        window.ChangeMode(new ShowMachine());
    }
}
