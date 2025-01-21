package proje_eskiz;


public abstract class SavasAraclari {
 
 
 protected int seviyePuani;
 

 public abstract int getDayaniklilik();
 public abstract void setDayaniklilik(int dayaniklilik);
 
 public abstract String getSinif();
 public abstract void setSinif(String sinif);
 
 public abstract int getVurus();
 public abstract void setVurus(int vurus);
 
 public SavasAraclari(int seviyePuani) {
     this.seviyePuani = seviyePuani;
 }

 
 public void KartPuaniGoster() {
     System.out.print("Dayanıklılık: " + getDayaniklilik()+" ");
     System.out.print("Seviye Puanı: " + seviyePuani+" ");
     System.out.print("Sınıf: " + getSinif()+" ");
     System.out.print("Vuruş Gücü: " + getVurus()+" ");
 }

 public abstract void DurumGuncelle(int saldiriDegeri);
}
