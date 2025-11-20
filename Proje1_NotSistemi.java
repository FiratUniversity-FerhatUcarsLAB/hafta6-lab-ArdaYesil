/*
[Adı Soyad : Arda Yeşil]
[ Numarası : 250542013 ]
[ ödev 1   : tamamlandı ]
[ Öğrenciden 2 not 1 ödev verilerini alarak kalma durumunu , harf notu gibi şeyleri hesapladık ]
  */

import java.util.Scanner;

public class ödevyap {

    public static double notHesapla(int vize, int finalNotu ,int ödev){

        return vize *0.3 + finalNotu*0.4 + ödev*0.3;
    }
    public static boolean ogrenciGecmeDurumu(double ortalama){
        if(ortalama>=50)
          return true;  
        return false;
    }
    public static char harfNotu(double ortalama)
    {
        if(ortalama>=90)
        return 'A';
        else if(ortalama>=80)
        return 'B';
        else if(ortalama>=70)
        return 'C';
        else if(ortalama>=60)
        return 'D';
        else
        return 'F';
    }
    public static boolean onurListesi(double ortalama, int vize ,int finalNotu ,int ödev)
    {
        if(ortalama>=85 && vize>=70 && ödev>=70 && finalNotu>=70)
        return true;
        else
        return false;
    }
    public static boolean bütünlemeHakki(double ortalama){
        if(ortalama>=40 && ortalama<50)
        return true;
        else
        return false;
    }
    public static void main(String[] args) {    
        Scanner input=new Scanner(System.in);
        int vize,finalNotu,ödev;
        double ortalama;

        System.out.print("Vize  : ");
        vize=input.nextInt();

        System.out.print("Final : ");
        finalNotu=input.nextInt();

        System.out.print("ödev  : ");
        ödev=input.nextInt();

        System.out.println("=== OGRENCI NOT RAPORU ===");
        System.out.printf("\nVize  Notu    : %.2s ", vize);
        System.out.printf("\nFinal Notu    : %.2s ", finalNotu);
        System.out.printf("\nÖdev  Notu    : %.2s ", ödev);
        System.out.println("\n------------------------------");
        ortalama=notHesapla(vize, finalNotu, ödev);
        System.out.printf("Ortalama      : %.1f", ortalama);
        System.out.println("\nHarf Notu     : "+harfNotu(ortalama));
        if(ogrenciGecmeDurumu(ortalama)==true)
        System.out.println("Durum         : Geçti");
        else
        System.out.println("Durum         : Kaldı");
        System.out.println("Onur Listesi  : "+(onurListesi(ortalama, vize, finalNotu, ödev) ==true ? "Evet" : "Hayır"));
        System.out.println("Bütünleme     : "+(bütünlemeHakki(ortalama)==true ? "Var" : "Yok"));
        input.close();
}
}
