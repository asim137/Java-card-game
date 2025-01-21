package proje_eskiz;

public class Obus extends KaraSinifi{
	private int dayaniklilik;
    private String sinif;
    private int vurus;
    private String altsinif;
    private int havaVurusAvantaji;
    private int denizVurusAvantaji;

    public Obus(int seviyePuani, String sinif, int dayaniklilik, int vurus,String altsinif,int denizVurusAvantaji,int havaVurusAvantaji) {
        super(seviyePuani);
        this.sinif = sinif;
        this.dayaniklilik = dayaniklilik;
        this.vurus = vurus;
        this.altsinif=altsinif;
        this.havaVurusAvantaji=havaVurusAvantaji;
        this.denizVurusAvantaji=denizVurusAvantaji;
    }

    @Override
    public int getDayaniklilik() {
        return dayaniklilik;
    }

    @Override
    public void setDayaniklilik(int dayaniklilik) {
        this.dayaniklilik = dayaniklilik;
    }

    @Override
    public String getSinif() {
        return sinif;
    }

    @Override
    public void setSinif(String sinif) {
        this.sinif = sinif;
    }

    @Override
    public int getVurus() {
        return vurus;
    }

    @Override
    public void setVurus(int vurus) {
        this.vurus = vurus;
    }

    @Override
    public String getAltsinif() {
        return altsinif;
    }

    @Override
    public void setAltsinif(String altsinif) {
        this.altsinif = altsinif;
    }

    @Override
    public int getHavaVurusAvantaji() {
        return havaVurusAvantaji;
    }

    @Override
    public void setHavaVurusAvantaji(int havaVurusAvantaji) {
        this.havaVurusAvantaji = havaVurusAvantaji;
    }
    
    @Override
    public int getDenizVurusAvantaji() {
        return denizVurusAvantaji;
    }

    @Override
    public void setDenizVurusAvantaji(int denizVurusAvantaji) {
        this.denizVurusAvantaji = denizVurusAvantaji;
    }

    
    @Override
    public void KartPuaniGoster() {
        super.KartPuaniGoster();
    }

    @Override
    public void DurumGuncelle(int saldiriDegeri) {
        setDayaniklilik(getDayaniklilik() - saldiriDegeri);
}

}
	   