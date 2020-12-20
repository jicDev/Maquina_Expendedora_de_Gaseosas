package graficos;

import entidades.Soda;
import excepciones.ExceptionManager;
import services.MachineService;
import services.SodaService;
import java.util.Vector;

public class Handler {
    private Window window;
    private SodaService sodaService;
    private MachineService machineService;
    private Soda soda;

    public Handler() {
        sodaService = new SodaService();
        machineService = new MachineService();
        machineService.setDao();
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

    public String AddCoin() {
        return machineService.AddCoin();
    }

    public String ReturnCoin() {
        return machineService.ReturnCoin();
    }

    public String SelectSoda(String soda) {
        return machineService.SelectSoda(soda);
    }

    public String BuySoda() {
        return machineService.BuySoda();
    }

    public String RetrieveSoda() {
        return machineService.RetrieveSoda();
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
