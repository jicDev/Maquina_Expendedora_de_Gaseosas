package graficos;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ShowMachine extends JPanel {
    private Handler handler;
    private JLabel state;

    public ShowMachine() {
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        handler = new Handler();

        removeAll();
        add(StartLayout(), BorderLayout.PAGE_START);
        add(CenterLayout(), BorderLayout.CENTER);
        add(RightLayout(), BorderLayout.LINE_END);
        add(EndLayout(), BorderLayout.PAGE_END);
        validate();
        repaint();
        updateUI();
    }

    private JPanel StartLayout() {
        GridBagConstraints c = new GridBagConstraints();

        JPanel start = new JPanel();
        start.setLayout(new GridBagLayout());

        BufferedImage upPicture = null;
        try {
            upPicture = ImageIO.read(getClass().getResource("/resources/images/up.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JLabel vendindMachineBrand = new JLabel(new ImageIcon(upPicture));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0,50,0,50);
        c.gridx = 0;
        c.gridy = 0;
        start.add(vendindMachineBrand, c);

        state = new JLabel(" MAQUINA_LISTA ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0,50,0,50);
        c.gridx = 1;
        c.gridy = 0;
        start.add(state, c);

        return start;
    }

    private JPanel CenterLayout() {
        GridBagConstraints c = new GridBagConstraints();

        JPanel center = new JPanel();
        center.setLayout(new GridBagLayout());

        BufferedImage cocacolaPicture = null;
        try {
            cocacolaPicture = ImageIO.read(getClass().getResource("/resources/images/coca_cola.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedImage cocacolalightPicture = null;
        try {
            cocacolalightPicture = ImageIO.read(getClass().getResource("/resources/images/coca_cola_light.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedImage cocacolazeroPicture = null;
        try {
            cocacolazeroPicture = ImageIO.read(getClass().getResource("/resources/images/coca_cola_zero.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedImage spritePicture = null;
        try {
            spritePicture = ImageIO.read(getClass().getResource("/resources/images/sprite.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JLabel cocacola = new JLabel(new ImageIcon(cocacolaPicture));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0,0,0,0);
        c.gridx = 0;
        c.gridy = 0;
        center.add(cocacola, c);

        JButton cocacolaSelect = new JButton("Seleccionar");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0,0,0,0);
        c.gridx = 1;
        c.gridy = 0;
        cocacolaSelect.addActionListener(new SelectLisener("Coca Cola"));
        center.add(cocacolaSelect, c);

        JLabel cocacolalight = new JLabel(new ImageIcon(cocacolalightPicture));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0,0,0,0);
        c.gridx = 2;
        c.gridy = 0;
        center.add(cocacolalight, c);

        JButton cocacolalightSelect = new JButton("Seleccionar");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0,0,0,0);
        c.gridx = 3;
        c.gridy = 0;
        cocacolalightSelect.addActionListener(new SelectLisener("Coca Cola Light"));
        center.add(cocacolalightSelect, c);

        JLabel cocacolazero = new JLabel(new ImageIcon(cocacolazeroPicture));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0,0,0,0);
        c.gridx = 0;
        c.gridy = 1;
        center.add(cocacolazero, c);

        JButton cocacolazeroSelect = new JButton("Seleccionar");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0,0,0,0);
        c.gridx = 1;
        c.gridy = 1;
        cocacolazeroSelect.addActionListener(new SelectLisener("Coca Cola Zero"));
        center.add(cocacolazeroSelect, c);

        JLabel sprite = new JLabel(new ImageIcon(spritePicture));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0,0,0,0);
        c.gridx = 2;
        c.gridy = 1;
        center.add(sprite, c);

        JButton spriteSelect = new JButton("Seleccionar");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0,0,0,0);
        c.gridx = 3;
        c.gridy = 1;
        spriteSelect.addActionListener(new SelectLisener("Sprite"));
        center.add(spriteSelect, c);

        return center;
    }

    private JPanel RightLayout() {
        GridBagConstraints c = new GridBagConstraints();

        JPanel right = new JPanel();
        right.setLayout(new GridBagLayout());

        JButton addCoin = new JButton("Insertar Ficha");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(50,0,50,0);
        c.gridx = 0;
        c.gridy = 0;
        addCoin.addActionListener(new AddCoinLisener());
        right.add(addCoin, c);

        JButton returnCoin = new JButton("Devolver Ficha");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(50,0,50,0);
        c.gridx = 0;
        c.gridy = 1;
        returnCoin.addActionListener(new ReturnCoinLisener());
        right.add(returnCoin, c);

        JButton buy = new JButton("Comprar");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(50,0,50,0);
        c.gridx = 0;
        c.gridy = 2;
        buy.addActionListener(new BuySodaLisener());
        right.add(buy, c);

        return right;
    }

    private JPanel EndLayout() {
        GridBagConstraints c = new GridBagConstraints();

        JPanel end = new JPanel();
        end.setLayout(new GridBagLayout());

        JLabel sodaLabel = new JLabel(" ICONO ELEGIDO");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0,50,0,50);
        c.gridx = 0;
        c.gridy = 0;
        end.add(sodaLabel, c);

        JButton soda = new JButton("Agarrar gaseosa");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0,50,0,50);
        c.gridx = 1;
        c.gridy = 0;
        soda.addActionListener(new RetrieveLisener());
        end.add(soda, c);

        return end;
    }

    public class AddCoinLisener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            state.setText(handler.AddCoin());
        }
    }

    public class ReturnCoinLisener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            state.setText(handler.ReturnCoin());
        }
    }

    public class SelectLisener implements ActionListener {
        private String soda;

        public SelectLisener(String soda) {
            this.soda = soda;
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            state.setText(handler.SelectSoda(soda));
        }
    }

    public class BuySodaLisener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            state.setText(handler.BuySoda());
        }
    }

    public class RetrieveLisener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            state.setText(handler.RetrieveSoda());
        }
    }
}
