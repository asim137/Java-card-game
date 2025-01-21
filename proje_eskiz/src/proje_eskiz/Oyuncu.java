package proje_eskiz;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Oyuncu {
	String  OyuncuID;
	String  OyuncuAdi;
	int skor;
	int toplamDayaniklilik=0;
	int u=0,o=0,f=0,sh=0,sd=0,KFS=0;
	ArrayList<Ucak> ucakList = new ArrayList<>();
	ArrayList<Obus> obusList = new ArrayList<>();
	ArrayList<Firkateyn> firkateynList = new ArrayList<>();
	ArrayList<Siha> sihaList = new ArrayList<>();
	ArrayList<Sida> sidaList = new ArrayList<>();
	ArrayList<KFS> KFSList = new ArrayList<>();
	
	ArrayList<String> Kartlar = new ArrayList<>();
	ArrayList<String> kullanilanKartlar = new ArrayList<>();
	ArrayList<String> kullanilmayanKartlar = new ArrayList<>();
	
	// seviye , sınıf, dayaniklilik , vurus  ,alt sinif , 
	/*
	Ucak ucak1 = new Ucak(0,"hava",20,10,"ucak",10,0);
	Siha siha1 = new Siha(0,"hava",15,10,"siha",10,10);
	Obus obus1 = new Obus(0,"kara",20,10,"obus",5,0) ;
	KFS KFS1 = new KFS(0,"kara",10,10,"obus",10,20) ;
	Sida sida1  = new Sida(0,"deniz",15,10,"sida",10,10);
	Firkateyn firkateyn1  = new Firkateyn(0,"deniz",25,10,"firkateyn",5,0);
	*/
	public Oyuncu(String OyuncuID,String OyuncuAdi,int skor)
	{
		this.OyuncuAdi=OyuncuAdi;
		this.OyuncuID=OyuncuID;
		this.skor=skor;
	}
	
	public Oyuncu()
	{
		this.OyuncuAdi="bilgisayar";
		this.OyuncuID="2";
		this.skor=0;
	}
	
	public int SkorGoster(int skor)
	{
		return skor;
	}
	
	public void kartSec(int secim,String kelime)
	{
		
		//ucakList.add(new Ucak(0,"hava",20,10,"ucak",10,0));
		if(kelime.equals("user"))
		{
		if(secim==1)
		{
			u++;
			ucakList.add(new Ucak(0,"hava",20,10,"ucak",10,0));
			Kartlar.add("ucak"+u);
		}
		else if(secim==2)
		{
			o++;
			obusList.add(new Obus(0,"kara",20,10,"obus",5,0));
			Kartlar.add("obus"+o);
		}
		else if(secim==3)
		{
			f++;
			firkateynList.add(new Firkateyn(0,"deniz",25,10,"firkateyn",5,0));
			Kartlar.add("firkateyn"+f);
		}
		}
		
		else if(kelime.equals("bilgisayar"))
		{
			for(int i=1;i<7;i++)
			{
				Random random = new Random();
				int a = random.nextInt(3)+1;
				if(a==1)
				{
					u++;
					ucakList.add(new Ucak(0,"hava",20,10,"ucak",10,0));
					Kartlar.add("ucak"+u);
				}
				else if(a==2)
				{
					o++;
					obusList.add(new Obus(0,"kara",20,10,"obus",5,0));
					Kartlar.add("obus"+o);
				}
				else if(a==3)
				{
					f++;
					firkateynList.add(new Firkateyn(0,"deniz",25,10,"firkateyn",5,0));
					Kartlar.add("firkateyn"+f);
				}
			}
		}
		else if(kelime.equals("rastgele"))
		{
			if(skor<20)
			{
				Random random = new Random();
				int a = random.nextInt(3)+1;
				if(a==1)
				{
					u++;
					ucakList.add(new Ucak(0,"hava",20,10,"ucak",10,0));
					Kartlar.add("ucak"+u);
				}
				else if(a==2)
				{
					o++;
					obusList.add(new Obus(0,"kara",20,10,"obus",5,0));
					Kartlar.add("obus"+o);
				}
				else if(a==3)
				{
					f++;
					firkateynList.add(new Firkateyn(0,"deniz",25,10,"firkateyn",5,0));
					Kartlar.add("firkateyn"+f);
				}
			}
			else if(skor>=20)
			{
				Random random = new Random();
				int a = random.nextInt(6)+1;
				if(a==1)
				{
					u++;
					ucakList.add(new Ucak(0,"hava",20,10,"ucak",10,0));
					Kartlar.add("ucak"+u);
				}
				else if(a==2)
				{
					o++;
					obusList.add(new Obus(0,"kara",20,10,"obus",5,0));
					Kartlar.add("obus"+o);
				}
				else if(a==3)
				{
					f++;
					firkateynList.add(new Firkateyn(0,"deniz",25,10,"firkateyn",5,0));
					Kartlar.add("firkateyn"+f);
				}
				else if(a==4)
				{
					sh++;
					sihaList.add(new Siha(0,"hava",15,10,"siha",10,10));
					Kartlar.add("siha"+sh);
				}
				else if(a==5)
				{
					KFS++;
					KFSList.add(new KFS(0,"kara",10,10,"obus",10,20));
					Kartlar.add("KFS"+KFS);
				}
				else if(a==6)
				{
					sd++;
					sidaList.add(new Sida(0,"deniz",15,10,"sida",10,10));
					Kartlar.add("sida"+sd);
				}
			}
		}
	}

	
	public void kartListesi(String OyuncuAdi)
	{

		
		if(OyuncuAdi.equals("bilgisayar")) {
			System.out.print("Bilgisayar : ");
			
		}
		
		else {
			System.out.print("user : ");
			
			}
		for(int i=0;i<Kartlar.size();i++)
		{
			String Kart = Kartlar.get(i);
			System.out.print(Kart+" ");
			
		}
		System.out.println();

	}
	
}
