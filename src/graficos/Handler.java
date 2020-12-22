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

    public Handler(Window window) {
        this.window = window;

        sodaService = new SodaService();
        sodaService.SetDAO();
        machineService = new MachineService(sodaService);
    }

    public void Insertar(Soda soda) throws ExceptionManager {
        sodaService.InsertSoda(soda);
    }

    public void Modify(Soda soda) {
        sodaService.ModifySoda(soda);
    }

    public void Delete(Soda soda) {
        sodaService.DeleteSoda(soda);
    }

    public Vector<Vector> List() {
        return sodaService.ListSoda();
    }

    public String GetState() {
        return this.machineService.GetState();
    }

    public void AddCoin() {
        machineService.AddCoin();
    }

    public void ReturnCoin() {
        machineService.ReturnCoin();
    }

    public void SelectSoda(String soda) {
        machineService.SelectSoda(soda);
    }

    public String BuySoda() {
        return machineService.BuySoda();
    }

    public void RetrieveSoda() {
        machineService.RetrieveSoda();
    }

    public void InsertSoda() {
        window.ChangeMode(new InsertSoda(this));
    }

    public void DeleteSoda() {
        window.ChangeMode(new DeleteSoda(this));
    }

    public void ModifySoda() {
        window.ChangeMode(new ModifySoda(this));
    }

    public void ListSoda() {
        window.ChangeMode(new ListSoda(this));
    }

    public void ShowMachine() {
        window.ChangeMode(new ShowMachine(this));
    }
}
