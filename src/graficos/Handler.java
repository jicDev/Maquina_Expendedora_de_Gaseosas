package graficos;

import entidades.Gaseosa;
import excepciones.MiException;
import servicios.GaseosaServicio;
import java.util.Vector;

public class Handler {

    private Ventana ventana;
    private GaseosaServicio gaseosaServicio;
    private Gaseosa gaseosa;

    public Handler() {
        gaseosaServicio = new GaseosaServicio();
    }

    public Handler(Gaseosa gaseosa) {
        this.gaseosa = gaseosa;
        gaseosaServicio = new GaseosaServicio();
        gaseosaServicio.setDAO(gaseosa);
    }

    public Handler(Ventana ventana) {
        this.ventana = ventana;
    }

    public void insertar() throws MiException {
        gaseosaServicio.insertarGaseosa(gaseosa);
    }

    public void modificar() {
        gaseosaServicio.modificarGaseosa(gaseosa);
    }

    public void borrar() {
        gaseosaServicio.borrarGaseosa(gaseosa);
    }

    public Vector<Vector> listar() {
        return gaseosaServicio.listarTodasLasGaseosas();
    }

    public void insertarGaseosa() {
        ventana.changeMode(new InsertarGaseosa());
    }

    public void borrarGaseosa() {
        ventana.changeMode(new BorrarGaseosa());
    }

    public void modificarGaseosa() {
        ventana.changeMode(new ModificarGaseosa());
    }

    public void listarTodasLasGaseosas() {
        ventana.changeMode(new ListarTodasLasGaseosas());
    }
}
