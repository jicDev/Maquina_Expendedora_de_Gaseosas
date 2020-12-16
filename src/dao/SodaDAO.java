package dao;

import entidades.Soda;
import excepciones.ExceptionManager;

import java.util.Vector;

public interface SodaDAO {
    void InsertSoda(Soda soda) throws ExceptionManager;
    void DeleteSoda(Soda soda);
    void ModifySoda(Soda soda);
    Vector<Vector> ListSoda();
}
