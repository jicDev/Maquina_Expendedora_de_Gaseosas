package graficos;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ShowMachine extends JPanel {
    private Handler handler;

    public ShowMachine() {
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        handler = new Handler();

        JPanel start = new JPanel();
        start.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

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

        JLabel state = new JLabel(" MAQUINA_LISTA ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0,50,0,50);
        c.gridx = 1;
        c.gridy = 0;
        start.add(state, c);

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
        center.add(spriteSelect, c);

        JPanel right = new JPanel();
        right.setLayout(new GridBagLayout());

        JButton pay = new JButton("Insertar Ficha");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(50,0,50,0);
        c.gridx = 0;
        c.gridy = 0;
        right.add(pay, c);

        JButton giveback = new JButton("Devolver Ficha");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(50,0,50,0);
        c.gridx = 0;
        c.gridy = 1;
        right.add(giveback, c);

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
        end.add(soda, c);

        removeAll();
        add(start, BorderLayout.PAGE_START);
        add(center, BorderLayout.CENTER);
        add(right, BorderLayout.LINE_END);
        add(end, BorderLayout.PAGE_END);
        validate();
        repaint();
        updateUI();
    }
}
