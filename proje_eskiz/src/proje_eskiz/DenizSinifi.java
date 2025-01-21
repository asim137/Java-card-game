package proje_eskiz;

public abstract  class DenizSinifi extends SavasAraclari{
	
	 public DenizSinifi(int seviyePuani) {
	     super(seviyePuani);
	 }

	 
	 public abstract String getAltsinif();
	 public abstract void setAltsinif(String altsinif);

	 public abstract int getHavaVurusAvantaji();
	 public abstract void setHavaVurusAvantaji(int havaVurusAvantaji);
	 
	 public abstract int getKaraVurusAvantaji();
	 public abstract void setKaraVurusAvantaji(int karaVurusAvantaji);

	 @Override
	 public void KartPuaniGoster() {
	     super.KartPuaniGoster();
	     System.out.print("Alt Sınıf: " + getAltsinif()+" ");
	     System.out.print("Hava Vuruş Avantajı: " + getHavaVurusAvantaji()+" ");
	     System.out.println("Kara Vuruş Avantajı: " + getKaraVurusAvantaji()+" ");
	 }
}
