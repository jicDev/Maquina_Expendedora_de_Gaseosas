package dao;

import entidades.Gaseosa;
import excepciones.MiException;

import java.util.List;
import java.util.Vector;

public interface GaseosaDAO {
    
    void insertarGaseosa(Gaseosa gaseosa) throws MiException;
    void borrarGaseosa(Gaseosa gaseosa);
    void modificarGaseosa(Gaseosa gaseosa);
    Vector<Vector> listarTodasLasGaseosas();
}
