package proje_eskiz;

public abstract class KaraSinifi extends SavasAraclari{
	 
	 public KaraSinifi(int seviyePuani) {
	     super(seviyePuani);
	 }

	 
	 public abstract String getAltsinif();
	 public abstract void setAltsinif(String altsinif);

	 public abstract int getHavaVurusAvantaji();
	 public abstract void setHavaVurusAvantaji(int havaVurusAvantaji);
	 
	 public abstract int getDenizVurusAvantaji();
	 public abstract void setDenizVurusAvantaji(int denizVurusAvantaji);

	 @Override
	 public void KartPuaniGoster() {
	     super.KartPuaniGoster();
	     System.out.print("Alt Sınıf: " + getAltsinif()+" ");
	     System.out.print("Deniz Vuruş Avantajı: " + getDenizVurusAvantaji()+" ");
	     System.out.println("Hava Vuruş Avantajı: " + getHavaVurusAvantaji()+" ");
	 }
}
