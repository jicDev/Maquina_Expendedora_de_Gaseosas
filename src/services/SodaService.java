package services;

import dao.soda.SodaDAO;
import dao.soda.SodaDataManager;
import entidades.Soda;
import excepciones.ExceptionManager;

import java.util.Vector;

public class SodaService {
    private SodaDAO sodaDAO;

    public void InsertSoda(Soda soda) throws ExceptionManager {
        this.sodaDAO.InsertSoda(soda);
    }

    public void DeleteSoda(Soda soda){
        this.sodaDAO.DeleteSoda(soda);
    }

    public void ModifySoda(Soda soda){
        this.sodaDAO.ModifySoda(soda);
    }

    public Vector<Vector> ListSoda() {
        return sodaDAO.ListSoda();
    }

    public void DecreaseStock(String brand) {
        Soda soda = this.sodaDAO.GetSoda(brand);
        soda.SetStock(soda.GetStock() - 1);
        ModifySoda(soda);
    }

    public boolean HasStock(String brand) {
        Soda soda = this.sodaDAO.GetSoda(brand);
        return soda.GetStock() != 0;
    }

    public void SetDAO(){
        this.sodaDAO = new SodaDataManager();
    }
}
