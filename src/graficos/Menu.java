package graficos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JMenuBar {

    private Handler handler;

    Menu(Handler handler) {

        this.handler = handler;

        JMenu gaseosa = new JMenu("Gaseosas");
        JMenuItem insertar = new JMenuItem("Insertar");
        JMenuItem modificar = new JMenuItem("Modificar");
        JMenuItem borrar = new JMenuItem("Borrar");
        JMenuItem listarTodo = new JMenuItem("Mostrar Todo");
        gaseosa.add(insertar);
        gaseosa.add(modificar);
        gaseosa.add(borrar);
        gaseosa.add(listarTodo);
        add(gaseosa);

        insertar.addActionListener(new NuevoLisener());
        modificar.addActionListener(new ModificarLisener());
        borrar.addActionListener(new BorrarLisener());
        listarTodo.addActionListener(new MostrarTodosLisener());

    }

    private class NuevoLisener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            handler.insertarGaseosa();
        }
    }

    private class BorrarLisener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            handler.borrarGaseosa();
        }
    }

    private class ModificarLisener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            handler.modificarGaseosa();
        }
    }

    private class MostrarTodosLisener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            handler.listarTodasLasGaseosas();
        }
    }
}
