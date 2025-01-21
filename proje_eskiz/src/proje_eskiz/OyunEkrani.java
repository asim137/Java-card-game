package proje_eskiz;

import javax.swing.*;
import java.awt.*;

public class OyunEkrani extends JFrame {

    public OyunEkrani() {
        
        super("Kart Savaşları Oyunu");


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1500, 800);


        this.setLayout(new BorderLayout());


        JLabel baslik = new JLabel("Kart Savaşları!", SwingConstants.CENTER);
        baslik.setFont(new Font("Arial", Font.BOLD, 24));
        baslik.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.add(baslik, BorderLayout.NORTH);


        JPanel merkezPanel = new JPanel(new GridLayout(1, 1));
        this.add(merkezPanel, BorderLayout.CENTER);


        JLabel altBilgi = new JLabel("Hazırlık için kartlarınızı seçiniz!", SwingConstants.CENTER);
        altBilgi.setFont(new Font("Arial", Font.ITALIC, 14));
        this.add(altBilgi, BorderLayout.SOUTH);
    }
}


