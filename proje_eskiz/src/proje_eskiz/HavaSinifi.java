package proje_eskiz;


public abstract class HavaSinifi extends SavasAraclari {
 
 
 public HavaSinifi(int seviyePuani) {
     super(seviyePuani);
 }

 
 public abstract String getAltsinif();
 public abstract void setAltsinif(String altsinif);

 public abstract int getKaraVurusAvantaji();
 public abstract void setKaraVurusAvantaji(int karaVurusAvantaji);
 
 public abstract int getDenizVurusAvantaji();
 public abstract void setDenizVurusAvantaji(int denizVurusAvantaji);

 @Override
 public void KartPuaniGoster() {
     super.KartPuaniGoster();
     System.out.print("Alt Sınıf: " + getAltsinif()+" ");
     System.out.print("Kara Vuruş Avantajı: " + getKaraVurusAvantaji()+" ");
     System.out.println("Deniz Vuruş Avantajı: " + getDenizVurusAvantaji()+" ");
 }
}
