package servicios;

import dao.GaseosaDAO;
import dao.GaseosaDataManager;
import entidades.Gaseosa;
import excepciones.MiException;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class GaseosaServicio {

    private GaseosaDAO gaseosaDAO;

    public void insertarGaseosa(Gaseosa gaseosa) throws MiException {
        this.gaseosaDAO.insertarGaseosa(gaseosa);
    }

    public void borrarGaseosa(Gaseosa gaseosa){
        this.gaseosaDAO.borrarGaseosa(gaseosa);
    }

    public void modificarGaseosa(Gaseosa gaseosa){
        this.gaseosaDAO.modificarGaseosa(gaseosa);
    }

    public Vector<Vector> listarTodasLasGaseosas() {
        gaseosaDAO = new GaseosaDataManager();
        return gaseosaDAO.listarTodasLasGaseosas();
    }

    public void setDAO(Gaseosa gaseosa){
        this.gaseosaDAO = new GaseosaDataManager(gaseosa);
    }
}
