package proje_eskiz;

import java.util.*;

import java.awt.BorderLayout;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;


public class Oyun {
	
	public static int SaldiriHesapla(String saldiran, String savunan)
	{
		if(saldiran.equals("ucak"))
		{
			if(savunan.equals("obus")||savunan.equals("KFS")) return 20;
			else return 10;
		}
		else if(saldiran.equals("obus"))
		{
			if(savunan.equals("firkateyn")||savunan.equals("sida")) return 15;
			else return 10;
		}
		else if(saldiran.equals("firkateyn"))
		{
			if(savunan.equals("ucak")||savunan.equals("siha")) return 15;
			else return 10;
		}
		else if(saldiran.equals("siha"))
		{
			if(savunan.equals("obus")||savunan.equals("KFS")) return 20;
			else if(savunan.equals("firkateyn")||savunan.equals("sida")) return 20;
			else return 10;
		}
		else if(saldiran.equals("KFS"))
		{
			if(savunan.equals("firkateyn")||savunan.equals("sida")) return 20;
			else if(savunan.equals("ucak")||savunan.equals("siha")) return 30;
			else return 10;
		}
		else if(saldiran.equals("sida"))
		{
			if(savunan.equals("ucak")||savunan.equals("siha")) return 20;
			else if(savunan.equals("obus")||savunan.equals("KFS")) return 20;
			else return 10;
		}
		
		return 0;
	}
	
	public static void PuanGuncelle(Oyuncu oyuncu1,String kelime,int puan,int i)
	{
		if(puan<=10) oyuncu1.skor+=10;
		else oyuncu1.skor+=puan;
		
		if(kelime.equals("ucak"))
		{
			if(puan<=10) {oyuncu1.ucakList.get(i).seviyePuani+=10; }
			else {oyuncu1.ucakList.get(i).seviyePuani+=puan; }
			
		}
		else if(kelime.equals("obus"))
		{
			if(puan<=10) {oyuncu1.obusList.get(i).seviyePuani+=10; }
			else {oyuncu1.obusList.get(i).seviyePuani+=puan;}
		}
		else if(kelime.equals("firkateyn"))
		{
			if(puan<=10) oyuncu1.firkateynList.get(i).seviyePuani+=10;
			else oyuncu1.firkateynList.get(i).seviyePuani+=puan;
		}
		else if(kelime.equals("siha"))
		{
			if(puan<=10) oyuncu1.sihaList.get(i).seviyePuani+=10;
			else oyuncu1.sihaList.get(i).seviyePuani+=puan;
		}
		else if(kelime.equals("KFS"))
		{
			if(puan<=10) oyuncu1.KFSList.get(i).seviyePuani+=10;
			else oyuncu1.KFSList.get(i).seviyePuani+=puan;
		}
		else if(kelime.equals("sida"))
		{
			if(puan<=10) oyuncu1.sidaList.get(i).seviyePuani+=10;
			else oyuncu1.sidaList.get(i).seviyePuani+=puan;
		}
	}
	
	public static void ListedenCikart(Oyuncu oyuncu,String kelime,int i)
	{
		
		if(kelime.equals("ucak"))
		{
			if(oyuncu.ucakList.get(i).getDayaniklilik()<=0) {
				//oyuncu.ucakList.remove(i);
				oyuncu.Kartlar.remove(indisBul(oyuncu,kelime,i+1));
			}
		}
		else if(kelime.equals("obus"))
		{
			if(oyuncu.obusList.get(i).getDayaniklilik()<=0) {
				//oyuncu.obusList.remove(i);
				oyuncu.Kartlar.remove(indisBul(oyuncu,kelime,i+1));
			}
		}
		else if(kelime.equals("firkateyn"))
		{
			if(oyuncu.firkateynList.get(i).getDayaniklilik()<=0) {
				//oyuncu.firkateynList.remove(i);
				oyuncu.Kartlar.remove(indisBul(oyuncu,kelime,i+1));
			}
		}
		else if(kelime.equals("siha"))
		{
			if(oyuncu.sihaList.get(i).getDayaniklilik()<=0) {
				//oyuncu.sihaList.remove(i);
				oyuncu.Kartlar.remove(indisBul(oyuncu,kelime,i+1));
			}
		}
		else if(kelime.equals("KFS"))
		{
			if(oyuncu.KFSList.get(i).getDayaniklilik()<=0) {
				//oyuncu.KFSList.remove(i);
				oyuncu.Kartlar.remove(indisBul(oyuncu,kelime,i+1));
			}
		}
		else if(kelime.equals("sida"))
		{
			if(oyuncu.sidaList.get(i).getDayaniklilik()<=0) {
				//oyuncu.sidaList.remove(i);
				oyuncu.Kartlar.remove(indisBul(oyuncu,kelime,i+1));
			}
		}
		
	}
	
	public static int indisBul(Oyuncu oyuncu,String kelime,int i)
	{
		int j=0;
		String aranan = kelime+i;
		while(!oyuncu.Kartlar.get(j).equals(aranan))
		{
			j++;
		}
		return j;
	}
	
	
	public static void KartPuaniGoster2(Oyuncu oyuncu1,String kelime,int i)
	{
		if(kelime.equals("ucak"))  { 
			oyuncu1.ucakList.get(i).KartPuaniGoster(); 
			yazdirDosyaya2(" "+"dayaniklilik : "+oyuncu1.ucakList.get(i).getDayaniklilik());
			yazdirDosyaya2(" "+"seviye puani : "+oyuncu1.ucakList.get(i).seviyePuani);
		}
		else if(kelime.equals("obus")) {
			oyuncu1.obusList.get(i).KartPuaniGoster();
			yazdirDosyaya2(" "+"dayaniklilik : "+oyuncu1.obusList.get(i).getDayaniklilik());
			yazdirDosyaya2(" "+"seviye puani : "+oyuncu1.obusList.get(i).seviyePuani);
		}
		else if(kelime.equals("firkateyn")) {
			oyuncu1.firkateynList.get(i).KartPuaniGoster();
			yazdirDosyaya2(" "+"dayaniklilik : "+oyuncu1.firkateynList.get(i).getDayaniklilik());
			yazdirDosyaya2(" "+"seviye puani : "+oyuncu1.firkateynList.get(i).seviyePuani);
		}
		else if(kelime.equals("siha")) {
			oyuncu1.sihaList.get(i).KartPuaniGoster();
			yazdirDosyaya2(" "+"dayaniklilik : "+oyuncu1.sihaList.get(i).getDayaniklilik());
			yazdirDosyaya2(" "+"seviye puani : "+oyuncu1.sihaList.get(i).seviyePuani);
		}
		else if(kelime.equals("KFS")) {
			oyuncu1.KFSList.get(i).KartPuaniGoster();
			yazdirDosyaya2(" "+"dayaniklilik : "+oyuncu1.KFSList.get(i).getDayaniklilik());
			yazdirDosyaya2(" "+"seviye puani : "+oyuncu1.KFSList.get(i).seviyePuani);
		}
		else if(kelime.equals("sida")) {
			oyuncu1.sidaList.get(i).KartPuaniGoster();
			yazdirDosyaya2(" "+"dayaniklilik : "+oyuncu1.sidaList.get(i).getDayaniklilik());
			yazdirDosyaya2(" "+"seviye puani : "+oyuncu1.sidaList.get(i).seviyePuani);
		}
	}
	
	public static int DayaniklilikDondur(String kelime,Oyuncu oyuncu)
	{
		String tur;
		int a;
		tur = kelime.replaceAll("\\d", "");
		a = Integer.parseInt(kelime.replaceAll("\\D", ""));
		if(tur.equals("ucak")) return oyuncu.ucakList.get(a-1).getDayaniklilik();
		else if(tur.equals("KFS")) return oyuncu.KFSList.get(a-1).getDayaniklilik();
		else if(tur.equals("obus")) return oyuncu.obusList.get(a-1).getDayaniklilik();
		else if(tur.equals("firkateyn")) return oyuncu.firkateynList.get(a-1).getDayaniklilik();
		else if(tur.equals("siha")) return oyuncu.sihaList.get(a-1).getDayaniklilik();
		else if(tur.equals("sida")) return oyuncu.sidaList.get(a-1).getDayaniklilik();
		return 0;
	}
	
	 private static BufferedWriter writer;
	 public static void yazdirDosyaya(String icerik) {
	        try {
	            writer.write(icerik);
	            writer.newLine(); // Satır sonu
	        } catch (IOException e) {
	            System.out.println("Dosyaya yazarken bir hata oluştu: " + e.getMessage());
	        }
	    }
	 public static void yazdirDosyaya2(String icerik) {
	        try {
	            writer.write(icerik);
	        } catch (IOException e) {
	            System.out.println("Dosyaya yazarken bir hata oluştu: " + e.getMessage());
	        }
	    }
	
	public static void main(String[] args)
	{
		String dosyaAdi = "oyun_sonuclari.txt";
		
	/*	javax.swing.SwingUtilities.invokeLater(() -> {
	        // Ana oyun ekranını başlat
	        OyunEkrani oyunEkrani = new OyunEkrani();

	        // Oyuncu nesneleri oluştur
	        Oyuncu user = new Oyuncu("1234", "Hasan", 45);
	        Oyuncu bilgisayar = new Oyuncu();

	        // Kart panelini oluştur ve oyun ekranına ekle
	        KartPaneli kartPaneli = new KartPaneli(user, bilgisayar);
	        oyunEkrani.add(kartPaneli, BorderLayout.CENTER);

	        // Oyunu görünür yap
	        oyunEkrani.setVisible(true);
	    });
		*/
		 try {
	            writer = new BufferedWriter(new FileWriter(dosyaAdi, false));
	         
		
		Scanner kart = new Scanner(System.in);
		Scanner Tur = new Scanner(System.in);
		Oyuncu user  = new Oyuncu("1234","hasan",0);
		Oyuncu bilgisayar = new Oyuncu();
		String kelime;
		int sayi,a=0,b=0,c=0,temp=0,isaret=0;
		String[] PCList = new String[3];
		Random rand = new Random();
		ArrayList<String> kullanilanKartlar = new ArrayList<>();
		
		System.out.println("Tur sayisi giriniz : ");
		int tur = Tur.nextInt();
		
		for(int i=1;i<7;i++)
		{
			System.out.println(i+". karti seciniz");
			String secim = kart.nextLine();
			if(secim.equals("ucak"))
			{
				user.kartSec(1,"user");
			}
			else if(secim.equals("obus"))
			{
				user.kartSec(2,"user");
			}
			else if(secim.equals("firkateyn"))
			{
				user.kartSec(3,"user");
			}
		}
		// user.kartListesi("user");
		
		bilgisayar.kartSec(0,"bilgisayar");

		// bilgisayar.kartListesi("bilgisayar");
		
		for(int j=0;j<tur;j++) {

			System.out.println("---------------------------");
			yazdirDosyaya("---------------------------");
			System.out.println("   "+(j+1)+". tur");
			yazdirDosyaya("   "+(j+1)+". tur");
			user.kartListesi("user");
			yazdirDosyaya2("user kart listesi :");
			for(int m=1;m<7;m++) {
			       yazdirDosyaya2(user.Kartlar.get(m-1)+" ");}
			bilgisayar.kartListesi("bilgisayar");
			yazdirDosyaya("");
			yazdirDosyaya2("bilgisayar kart listesi :");
			for(int m=1;m<7;m++) {
			       yazdirDosyaya2(bilgisayar.Kartlar.get(m-1)+" ");}
			
			System.out.println();
			for(int i=0;i<user.kullanilanKartlar.size();i++)
			{
				System.out.print(user.kullanilanKartlar.get(i));
			}
			System.out.println();
			for(int i=0;i<user.kullanilanKartlar.size();i++)
			{
				System.out.print(bilgisayar.kullanilanKartlar.get(i));
			}
			System.out.println();
			
			
			System.out.print("user kullanılmayan kartlar : ");
			user.kullanilmayanKartlar.clear();
			for (int k = 0; k < user.Kartlar.size(); k++) {
			    boolean kullaniliyor = false;
			    for (int i = 0; i < user.kullanilanKartlar.size(); i++) {
			        if (user.Kartlar.get(k).equals(user.kullanilanKartlar.get(i))) {
			            kullaniliyor = true;
			            break;
			        }
			    }
			    if (!kullaniliyor) {
			        user.kullanilmayanKartlar.add(user.Kartlar.get(k));
			    }
			}
			
			for(int k=0;k<user.kullanilmayanKartlar.size();k++)
			{
				System.out.print(user.kullanilmayanKartlar.get(k)+" ");
			}
			
			System.out.println();
			System.out.print("bilgisayar kullanılmayan kartlar : ");
			bilgisayar.kullanilmayanKartlar.clear();
			for (int k = 0; k < bilgisayar.Kartlar.size(); k++) {
			    boolean kullaniliyor = false;
			    for (int i = 0; i < bilgisayar.kullanilanKartlar.size(); i++) {
			        if (bilgisayar.Kartlar.get(k).equals(bilgisayar.kullanilanKartlar.get(i))) {
			            kullaniliyor = true;
			            break;
			        }
			    }
			    if (!kullaniliyor) {
			        bilgisayar.kullanilmayanKartlar.add(bilgisayar.Kartlar.get(k));
			    }
			}
			for(int k=0;k<bilgisayar.kullanilmayanKartlar.size();k++)
			{
				System.out.print(bilgisayar.kullanilmayanKartlar.get(k)+" ");
			}
			
			System.out.println();
        do {
            a = rand.nextInt(bilgisayar.Kartlar.size()) + 1;
            do {
                b = rand.nextInt(bilgisayar.Kartlar.size()) + 1;
            } while (a == b); 

            do {
                c = rand.nextInt(bilgisayar.Kartlar.size()) + 1;
            } while (a == c || b == c); 
            
        } while (a == b && b == c && a == c);
        
        yazdirDosyaya("");
        System.out.print("Bilgisayarın seçtiği kartlar : ");
        yazdirDosyaya2("Bilgisayarın seçtiği kartlar : ");
    	System.out.print(bilgisayar.Kartlar.get(a-1)+" ");
    	yazdirDosyaya2(bilgisayar.Kartlar.get(a-1)+" ");
		System.out.print(bilgisayar.Kartlar.get(b-1)+" ");
		 yazdirDosyaya2(bilgisayar.Kartlar.get(b-1)+" ");
		System.out.println(bilgisayar.Kartlar.get(c-1)+" ");
		 yazdirDosyaya2(bilgisayar.Kartlar.get(c-1)+" ");     

		
		PCList[0] = bilgisayar.Kartlar.get(a-1).replaceAll("\\d", "");
		a = Integer.parseInt(bilgisayar.Kartlar.get(a-1).replaceAll("\\D", ""));
		
		PCList[1] = bilgisayar.Kartlar.get(b-1).replaceAll("\\d", "");
		b = Integer.parseInt(bilgisayar.Kartlar.get(b-1).replaceAll("\\D", ""));
		
		PCList[2] = bilgisayar.Kartlar.get(c-1).replaceAll("\\d", "");
		c = Integer.parseInt(bilgisayar.Kartlar.get(c-1).replaceAll("\\D", ""));
		
		System.out.println("Üç tane kart seçiniz");
		yazdirDosyaya(" kullanıcı kart seçiyor");
		for(int i=0;i<3;i++)
		{
			yazdirDosyaya2(" kullanıcı kartı:");
			String secim = kart.nextLine();
			kelime =  secim.replaceAll("\\d", "");
			// ucak2 ' yi ucak olarak alir
			sayi = Integer.parseInt(secim.replaceAll("\\D", ""));
			// ucak2 'deki 2'yi alir ve int'e çevirir.
			
			if(i==0) temp=a;
			else if(i==1) temp=b;
			else if(i==2) temp=c;
			
			if(PCList[i].equals("ucak"))
			{
			  bilgisayar.ucakList.get(temp-1).DurumGuncelle(SaldiriHesapla(kelime,PCList[i]));
			  bilgisayar.kullanilanKartlar.add("ucak"+temp);

			  if(bilgisayar.ucakList.get(temp-1).getDayaniklilik()<=0) 
			  {
				  PuanGuncelle(user,kelime,bilgisayar.ucakList.get(temp-1).seviyePuani,sayi-1);
			  }
			}
			
			else if(PCList[i].equals("obus"))
			{
			  bilgisayar.obusList.get(temp-1).DurumGuncelle(SaldiriHesapla(kelime,PCList[i]));
			  bilgisayar.kullanilanKartlar.add("obus"+temp);
			  if(bilgisayar.obusList.get(temp-1).getDayaniklilik()<=0) 
			  {
				  PuanGuncelle(user,kelime,bilgisayar.obusList.get(temp-1).seviyePuani,sayi-1);
			  }
			}
			
			else if(PCList[i].equals("firkateyn"))
			{
			  bilgisayar.firkateynList.get(temp-1).DurumGuncelle(SaldiriHesapla(kelime,PCList[i]));
			  bilgisayar.kullanilanKartlar.add("firkateyn"+temp);
			  if(bilgisayar.firkateynList.get(temp-1).getDayaniklilik()<=0) 
			  {
				  PuanGuncelle(user,kelime,bilgisayar.firkateynList.get(temp-1).seviyePuani,sayi-1);
			  }
			  
			}
			else if(PCList[i].equals("KFS"))
			{
			  bilgisayar.KFSList.get(temp-1).DurumGuncelle(SaldiriHesapla(kelime,PCList[i]));
			  bilgisayar.kullanilanKartlar.add("KFS"+temp);
			  if(bilgisayar.KFSList.get(temp-1).getDayaniklilik()<=0) 
			  {
				  PuanGuncelle(user,kelime,bilgisayar.KFSList.get(temp-1).seviyePuani,sayi-1);
			  }
			  
			}
			else if(PCList[i].equals("siha"))
			{
			  bilgisayar.sihaList.get(temp-1).DurumGuncelle(SaldiriHesapla(kelime,PCList[i]));
			  bilgisayar.kullanilanKartlar.add("siha"+temp);
			  if(bilgisayar.sihaList.get(temp-1).getDayaniklilik()<=0) 
			  {
				  PuanGuncelle(user,kelime,bilgisayar.sihaList.get(temp-1).seviyePuani,sayi-1);

			  }
			}
			else if(PCList[i].equals("sida"))
			{
			  bilgisayar.sidaList.get(temp-1).DurumGuncelle(SaldiriHesapla(kelime,PCList[i]));
			  bilgisayar.kullanilanKartlar.add("sida"+temp);
			  if(bilgisayar.sidaList.get(temp-1).getDayaniklilik()<=0) 
			  {
				  PuanGuncelle(user,kelime,bilgisayar.sidaList.get(temp-1).seviyePuani,sayi-1);

			  }
			}
			
			if(kelime.equals("ucak"))
			{
			  user.ucakList.get(sayi-1).DurumGuncelle(SaldiriHesapla(PCList[i],kelime));
			  user.kullanilanKartlar.add("ucak"+sayi);
			  if(user.ucakList.get(sayi-1).getDayaniklilik()<=0) 
			  {
				  PuanGuncelle(bilgisayar,PCList[i],user.ucakList.get(sayi-1).seviyePuani,temp-1);
			  }
			}
			
			else if(kelime.equals("obus"))
			{
			  user.obusList.get(sayi-1).DurumGuncelle(SaldiriHesapla(PCList[i],kelime));
			  user.kullanilanKartlar.add("obus"+sayi);
			  if(user.obusList.get(sayi-1).getDayaniklilik()<=0) 
			  {
				  PuanGuncelle(bilgisayar,PCList[i],user.obusList.get(sayi-1).seviyePuani,temp-1);

			  }
			  
			}
			
			else if(kelime.equals("firkateyn"))
			{
			  user.firkateynList.get(sayi-1).DurumGuncelle(SaldiriHesapla(PCList[i],kelime));
			  user.kullanilanKartlar.add("firkateyn"+sayi);
			  if(user.firkateynList.get(sayi-1).getDayaniklilik()<=0) 
			  {
				  PuanGuncelle(bilgisayar,PCList[i],user.firkateynList.get(sayi-1).seviyePuani,temp-1);

			  }
			  
			}
			else if(kelime.equals("KFS"))
			{
			  user.KFSList.get(sayi-1).DurumGuncelle(SaldiriHesapla(PCList[i],kelime));
			  user.kullanilanKartlar.add("KFS"+sayi);
			  if(user.KFSList.get(sayi-1).getDayaniklilik()<=0) 
			  {
				  PuanGuncelle(bilgisayar,PCList[i],user.KFSList.get(sayi-1).seviyePuani,temp-1);
			    	
			  }
			  
			}
			else if(kelime.equals("siha"))
			{
			  user.sihaList.get(sayi-1).DurumGuncelle(SaldiriHesapla(PCList[i],kelime));
			  user.kullanilanKartlar.add("siha"+sayi);
			  if(user.sihaList.get(sayi-1).getDayaniklilik()<=0) 
			  {
				  PuanGuncelle(bilgisayar,PCList[i],user.sihaList.get(sayi-1).seviyePuani,temp-1);
			  }
			  
			}
			else if(kelime.equals("sida"))
			{
			  user.sidaList.get(sayi-1).DurumGuncelle(SaldiriHesapla(PCList[i],kelime));
			  user.kullanilanKartlar.add("sida"+sayi);
			  if(user.sidaList.get(sayi-1).getDayaniklilik()<=0) 
			  {
				  PuanGuncelle(bilgisayar,PCList[i],user.sidaList.get(sayi-1).seviyePuani,temp-1);
				  
			  }
			  
			}
			  
			  System.out.print(kelime + sayi + ": ");
			  yazdirDosyaya2(kelime + sayi + ": ");
			  KartPuaniGoster2(user,kelime,sayi-1);
			  yazdirDosyaya("");
			  yazdirDosyaya2(" bilgisayar kartı : ");
			  System.out.print(PCList[i] + temp + ": ");
			  yazdirDosyaya2(PCList[i] + temp + ": ");
			  KartPuaniGoster2(bilgisayar,PCList[i],temp-1);
			  
			  ListedenCikart(user,kelime,sayi-1);
			  ListedenCikart(bilgisayar,PCList[i],temp-1);
			  
			  System.out.println();
			  System.out.println("user skor : "+user.skor);
			  System.out.println("bilgisayar skor : "+bilgisayar.skor);
			  System.out.println();
			  yazdirDosyaya("");
			  yazdirDosyaya("user skor : " + user.skor);
	          yazdirDosyaya("bilgisayar skor : " + bilgisayar.skor);
	          yazdirDosyaya("");
			  
		}
		if(isaret!=0) break;
		if(bilgisayar.Kartlar.size()==1) {bilgisayar.kartSec(0,"rastgele"); isaret++;}
		if(user.Kartlar.size()==1) {user.kartSec(0,"rastgele"); isaret++;}
		
		if(bilgisayar.Kartlar.size()==0) 
		{
			System.out.println(user.OyuncuAdi+"kazandı");
			yazdirDosyaya(user.OyuncuAdi+"kazandı");
			break;
		}
		else if(user.Kartlar.size()==0)
		{
			System.out.println(bilgisayar.OyuncuAdi+"kazandı");
			yazdirDosyaya(bilgisayar.OyuncuAdi+"kazandı");
			break;
		}
		  user.kartSec(0,"rastgele");
		  bilgisayar.kartSec(0,"rastgele");
  }
		
		if(bilgisayar.Kartlar.size()!=0&&user.Kartlar.size()!=0)
		{
			if(user.skor==bilgisayar.skor) 
			{
				for(int i=0;i<user.Kartlar.size();i++)
				{
					user.toplamDayaniklilik+=DayaniklilikDondur(user.Kartlar.get(i),user);
				}
				for(int i=0;i<bilgisayar.Kartlar.size();i++)
				{
					bilgisayar.toplamDayaniklilik+=DayaniklilikDondur(bilgisayar.Kartlar.get(i),bilgisayar);
				}
				if(bilgisayar.toplamDayaniklilik>user.toplamDayaniklilik) 
					bilgisayar.skor+=bilgisayar.toplamDayaniklilik-user.toplamDayaniklilik;
				else if(bilgisayar.toplamDayaniklilik<user.toplamDayaniklilik) 
					user.skor+=user.toplamDayaniklilik-bilgisayar.toplamDayaniklilik;
			}
			if(user.skor>bilgisayar.skor) { System.out.println(user.OyuncuAdi+" kazandı");
			yazdirDosyaya(user.OyuncuAdi+" kazandı");}
			else if(bilgisayar.skor>user.skor) { System.out.println(bilgisayar.OyuncuAdi+" kazandı");
			yazdirDosyaya(bilgisayar.OyuncuAdi+" kazandı");}
		}
		user.kartListesi("user");
		yazdirDosyaya("user kart listesi : ");
		for(int m=1;m<7;m++) {
		       yazdirDosyaya2(user.Kartlar.get(m-1)+" ");}
		bilgisayar.kartListesi("bilgisayar");
		yazdirDosyaya("");
		yazdirDosyaya("bilgisayar kart listesi : ");
		for(int m=1;m<7;m++) {
		       yazdirDosyaya2(bilgisayar.Kartlar.get(m-1)+" ");}
		 }
		   catch (IOException e) {
	           System.out.println("Dosya açılırken bir hata oluştu: " + e.getMessage());
	       } finally 
			 {
	           try {
	               if (writer != null) {
	                   writer.close(); 
	               }
	           } catch (IOException e) {
	               System.out.println("Dosya kapatılırken bir hata oluştu: " + e.getMessage());
	           }
	         }
}
	
}



