package proje_eskiz;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class KartPaneli extends JPanel { 
    private Oyuncu user, bilgisayar;
    private JLabel bilgiLabel;
    private int secimSayisi = 0;
    private final int MAX_SECIM = 6;
    private ArrayList<String> kullaniciSecimleri = new ArrayList<>();
    private ArrayList<String> bilgisayarSecimleri = new ArrayList<>();
    private ArrayList<String> secilenKartlar = new ArrayList<>(); 
    private JPanel buttonPanel, kartListePanel, sonucPanel;
    private Map<String, Integer> kartSayisiMap = new HashMap<>();  
    private ArrayList<String> bilgisayarGizliKartlar = new ArrayList<>(); 

    private final Map<String, Integer> kartDayaniklilik = new HashMap<>() {{
        put("ucak", 20);
        put("obus", 20);
        put("firkateyn", 25);
    }};

    private final Map<String, Integer> kartVurusGucu = new HashMap<>() {{
        put("ucak", 10);
        put("obus", 10);
        put("firkateyn", 10);
    }};

   
    private final Map<String, Map<String, Integer>> ozelAvantajlar = new HashMap<>() {{
        put("ucak", Map.of("obus", 10));
        put("obus", Map.of("firkateyn", 5));
        put("firkateyn", Map.of("ucak", 10));
    }};
    
    private String kartSavas(String kullaniciKart, String bilgisayarKart) {
        String kullaniciTip = kullaniciKart.replaceAll("\\d", ""); 
        String bilgisayarTip = bilgisayarKart.replaceAll("\\d", ""); 

        int kullaniciDayaniklilik = kartDayaniklilik.getOrDefault(kullaniciTip, 0);
        int bilgisayarDayaniklilik = kartDayaniklilik.getOrDefault(bilgisayarTip, 0);

        int kullaniciVurusGucu = kartVurusGucu.getOrDefault(kullaniciTip, 0);
        int bilgisayarVurusGucu = kartVurusGucu.getOrDefault(bilgisayarTip, 0);

      
        kullaniciVurusGucu += ozelAvantajlar.getOrDefault(kullaniciTip, Map.of()).getOrDefault(bilgisayarTip, 0);
        bilgisayarVurusGucu += ozelAvantajlar.getOrDefault(bilgisayarTip, Map.of()).getOrDefault(kullaniciTip, 0);

      
        while (kullaniciDayaniklilik > 0 && bilgisayarDayaniklilik > 0) {
            bilgisayarDayaniklilik -= kullaniciVurusGucu;
            if (bilgisayarDayaniklilik <= 0) break;
            kullaniciDayaniklilik -= bilgisayarVurusGucu;
        }

       
        if (kullaniciDayaniklilik > 0 && bilgisayarDayaniklilik<=0) {
            return "Kullanıcı kazandı!";
        } else if (bilgisayarDayaniklilik > 0 && kullaniciDayaniklilik<=0) {
            return "Bilgisayar kazandı!";
        } else if(kullaniciDayaniklilik>bilgisayarDayaniklilik) {
            return "Kullanıcı kazandı!";
        }
        else if (bilgisayarDayaniklilik>kullaniciDayaniklilik){
        	return "Bilgisayar kazandı!";
        }
        else {
        	return "berabere";
        }
        
    }

 

    public KartPaneli(Oyuncu user, Oyuncu bilgisayar) {
        this.user = user;
        this.bilgisayar = bilgisayar;
        this.setLayout(new BorderLayout());

        
        bilgiLabel = new JLabel("6 kart seçiniz:");
        this.add(bilgiLabel, BorderLayout.NORTH);

      
        buttonPanel = new JPanel(new GridLayout(1, 3));
        String[] kartTurleri = {"ucak", "obus", "firkateyn"};

        for (String kart : kartTurleri) {
            JButton kartButton = new JButton(kart);
            kartButton.addActionListener(e -> kullaniciKartSecimi(kart));
            buttonPanel.add(kartButton);
        }
        this.add(buttonPanel, BorderLayout.CENTER);

      
        kartListePanel = new JPanel(new GridLayout(1, 6));
        kartListePanel.setBorder(BorderFactory.createTitledBorder("Kullanıcı Kartları"));
        kartListePanel.setVisible(false);
        this.add(kartListePanel, BorderLayout.SOUTH);

     
        sonucPanel = new JPanel(new GridLayout(2, 3));
        sonucPanel.setBorder(BorderFactory.createTitledBorder("Seçilen Kartlar"));
        sonucPanel.setVisible(false);
        this.add(sonucPanel, BorderLayout.EAST);
    }

    private void kullaniciKartSecimi(String kart) {
        if (secimSayisi < MAX_SECIM) {
  
            kullaniciSecimleri.add(kart);

            kartSayisiMap.put(kart, kartSayisiMap.getOrDefault(kart, 0) + 1);
            int kartKodu;

            if (kart.equals("ucak")) {
                kartKodu = 1;
            } else if (kart.equals("obus")) {
                kartKodu = 2;
            } else {
                kartKodu = 3;
            }

            user.kartSec(kartKodu, "user");

          
            String kartSayisiText = "";
            if (kartSayisiMap.get(kart) >= 1) {
                kartSayisiText = kartSayisiMap.get(kart).toString();
            }

            bilgiLabel.setText((secimSayisi + 1) + ". seçim: " + kart + kartSayisiText);

            secimSayisi++;

            if (secimSayisi == MAX_SECIM) {
            
                bilgisayarKartSecimi();
                buttonPanel.setVisible(false);

              
                bilgiLabel.setText("6 kart seçildi. Lütfen bu kartlardan 3 tanesini seçiniz.");
                gosterKullaniciKartlari();
            }
        }
    }

    private void bilgisayarKartSecimi() {
        Random rand = new Random();
        String[] kartTurleri = {"ucak", "obus", "firkateyn"};
        bilgisayarSecimleri.clear(); 

        while (bilgisayarSecimleri.size() < MAX_SECIM) {
            String kart = kartTurleri[rand.nextInt(kartTurleri.length)]; 
            bilgisayarSecimleri.add(kart);
        }

        ArrayList<String> numaralandirilmisKartlar = new ArrayList<>();
        Map<String, Integer> kartNumaralari = new HashMap<>();
        for (String kart : bilgisayarSecimleri) {
            kartNumaralari.put(kart, kartNumaralari.getOrDefault(kart, 0) + 1);
            String kartAdi = kart + kartNumaralari.get(kart); 
            numaralandirilmisKartlar.add(kartAdi);
        }

        bilgisayarGizliKartlar.clear();
        while (bilgisayarGizliKartlar.size() < 3) {
            String kart = numaralandirilmisKartlar.get(rand.nextInt(numaralandirilmisKartlar.size()));
            if (!bilgisayarGizliKartlar.contains(kart)) {
                bilgisayarGizliKartlar.add(kart);
            }
        }
    }

    private void gosterKullaniciKartlari() {
        kartListePanel.removeAll();
        kartListePanel.setVisible(true);

        Map<String, Integer> kartNumaralari = new HashMap<>();
        for (String kart : kullaniciSecimleri) {
            kartNumaralari.put(kart, kartNumaralari.getOrDefault(kart, 0) + 1);
            String kartAdi = kart + kartNumaralari.get(kart); 

            JButton kartButton = new JButton(kartAdi);
            kartButton.addActionListener(e -> ucKartSecimi(kartAdi));

            kartButton.setPreferredSize(new Dimension(120, 660)); 

            kartListePanel.add(kartButton);
        }

        this.revalidate();
        this.repaint();

    }

    private void ucKartSecimi(String kart) {
        if (secilenKartlar.size() < 3) {
            secilenKartlar.add(kart);
            bilgiLabel.setText(kart + " seçildi.");

            if (secilenKartlar.size() == 3) {
                bilgiLabel.setText("3 kart seçtiniz! Sonuçlar gösteriliyor.");
                gosterSecilenKartlar();
                kartlariSavastir();
            }
        }
    }

    private void gosterSecilenKartlar() {
        kartListePanel.setVisible(false);
        sonucPanel.removeAll();
        sonucPanel.setVisible(true);
 
        for (String kart : bilgisayarGizliKartlar) {
            JLabel kartLabel = new JLabel("Bilgisayar: " + kart);
            kartLabel.setHorizontalAlignment(SwingConstants.CENTER);
            kartLabel.setBorder(BorderFactory.createLineBorder(Color.RED));

          
            kartLabel.setPreferredSize(new Dimension(480, 300));  
            sonucPanel.add(kartLabel);
        }

        for (String kart : secilenKartlar) {
            JLabel kartLabel = new JLabel("User: " + kart);
            kartLabel.setHorizontalAlignment(SwingConstants.CENTER);
            kartLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE));

            kartLabel.setPreferredSize(new Dimension(480, 300)); 
            sonucPanel.add(kartLabel);
        }
        
        



        this.revalidate();
        this.repaint();
    }
    private void kartlariSavastir() {
        StringBuilder sonuc = new StringBuilder("<html>Savaş Sonuçları:<br>");
        int kullaniciKazanmaSayisi = 0;
        int bilgisayarKazanmaSayisi = 0;

        for (int i = 0; i < 3; i++) {
            String kullaniciKart = secilenKartlar.get(i);
            String bilgisayarKart = bilgisayarGizliKartlar.get(i);

            String savasSonucu = kartSavas(kullaniciKart, bilgisayarKart);
            sonuc.append(kullaniciKart).append(" vs ").append(bilgisayarKart)
                  .append(": ").append(savasSonucu).append("<br>");

            if (savasSonucu.contains("Kullanıcı")) {
                kullaniciKazanmaSayisi++;
            } else if (savasSonucu.contains("Bilgisayar")) {
                bilgisayarKazanmaSayisi++;
            }
        }

        sonuc.append("<br>Genel Sonuç: ");
        if (kullaniciKazanmaSayisi > bilgisayarKazanmaSayisi) {
            sonuc.append("Kullanıcı Kazandı!");
        } else if (bilgisayarKazanmaSayisi > kullaniciKazanmaSayisi) {
            sonuc.append("Bilgisayar Kazandı!");
        } else {
            sonuc.append("Berabere!");
        }
        sonuc.append("</html>");

        bilgiLabel.setText(sonuc.toString());
        JOptionPane.showMessageDialog(this, sonuc.toString(), "Savaş Sonucu:", JOptionPane.INFORMATION_MESSAGE);
    }
}