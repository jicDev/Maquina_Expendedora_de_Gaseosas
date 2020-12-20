package dao.soda;

import entidades.Soda;
import excepciones.ExceptionManager;

import java.util.Vector;

public interface SodaDAO {
    void InsertSoda(Soda soda) throws ExceptionManager;
    void DeleteSoda(Soda soda);
    void ModifySoda(Soda soda);
    Soda GetSoda(String brand);
    Vector<Vector> ListSoda();
}
