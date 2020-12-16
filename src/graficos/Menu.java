package graficos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JMenuBar {
    private Handler handler;

    Menu(Handler handler) {
        this.handler = handler;
        JMenu soda = new JMenu("Gaseosas");

        JMenuItem insert = new JMenuItem("Insertar");
        JMenuItem modify = new JMenuItem("Modificar");
        JMenuItem delete = new JMenuItem("Borrar");
        JMenuItem list = new JMenuItem("Mostrar Todo");

        soda.add(insert);
        soda.add(modify);
        soda.add(delete);
        soda.add(list);
        add(soda);

        insert.addActionListener(new InsertLisener());
        modify.addActionListener(new ModifyLisener());
        delete.addActionListener(new DeleteLisener());
        list.addActionListener(new ListLisener());

        JMenu machine = new JMenu("Expendedora");
        JMenuItem show = new JMenuItem("Mostrar");
        machine.add(show);
        add(machine);

        show.addActionListener(new ShowLisener());
    }

    private class InsertLisener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            handler.insertSoda();
        }
    }

    private class DeleteLisener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            handler.deleteSoda();
        }
    }

    private class ModifyLisener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            handler.modifySoda();
        }
    }

    private class ListLisener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            handler.listSoda();
        }
    }

    private class ShowLisener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) { handler.showMachine(); }
    }
}
