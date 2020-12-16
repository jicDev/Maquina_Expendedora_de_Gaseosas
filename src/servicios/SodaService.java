package servicios;

import dao.SodaDAO;
import dao.SodaDataManager;
import entidades.Soda;
import excepciones.ExceptionManager;

import java.util.Vector;

public class SodaService {

    private SodaDAO sodaDAO;

    public void insertSoda(Soda soda) throws ExceptionManager {
        this.sodaDAO.InsertSoda(soda);
    }

    public void deleteSoda(Soda soda){
        this.sodaDAO.DeleteSoda(soda);
    }

    public void modifySoda(Soda soda){
        this.sodaDAO.ModifySoda(soda);
    }

    public Vector<Vector> listSoda() {
        sodaDAO = new SodaDataManager();
        return sodaDAO.ListSoda();
    }

    public void setDAO(Soda soda){
        this.sodaDAO = new SodaDataManager(soda);
    }
}
