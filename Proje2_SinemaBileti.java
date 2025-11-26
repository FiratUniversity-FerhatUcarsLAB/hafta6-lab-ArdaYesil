/*
[Adı Soyad : Arda Yeşil]
[ Numarası : 250542013 ]
[ ödev 2   : tamamlandı ]
[Teslim Tarihi : 26.11.2025]
[ Sinema bileti alan birinden bilgilerini alarak indirimler yapılarak biletin fiyatını hesaplıyoz ]
  */
import java.util.Scanner;

public class SinemaBiletiiFiyatlandirma{


public static boolean günKontrol(int günSayısı){ //Seçilen gün hafta içimi hafta sonumu kontrolü
    switch (günSayısı) {
        case 1:
            return true;
        case 2:
            return true;
        case 3:
            return true;
        case 4:
            return true;
        case 5:
            return true;
        case 6:
            return false;
        case 7:
            return false;
        default:
            return false;
    }
}

public static boolean saatKontrol(int saat){//saat 12 den öncemi sonramı kontrolü
    if(saat<12)
    return true;
    else
    return false;
}

public static double temelFiyatHesapla(boolean  gün, boolean  saat){//Gün ve saate göre fiyatlandırma
    if(gün == true && saat==true)
    return 45;
    if(gün == true && saat==false)
    return 65;
    if(gün == false && saat==true)
    return 55;
    else
    return 85;
}

public static double indirimHesapla(int yas,int meslek,int gün){//Yaşa , Mesleğe , Güne göre indirim belirleme
    if(yas<12)
    return 25;
    else if(yas>65)
    return 30;
    else if(meslek==1 && gün<=4)
    return 20;
    else if(meslek==1 && gün>=5)
    return 15;
    else if(meslek==2 && gün==3)
    return 35;
    return 0;
}

public static double filmExtra(int filmTürü){//Seçilen film türüne göre extraları ekleme
    switch (filmTürü) {
        case 1:
            return 0;//2D
        case 2:
            return 25;//3D
        case 3:
            return 35;//IMAX
        case 4:
            return 50;//4DX
        default:
            return 0;
    }
}

public static double ToplamFiyat(double indirim,double filmExtra,double temelFiyat){//Son fiyatı belirleme
    if(indirim!=0)
    {
        
        return (filmExtra+temelFiyat-(temelFiyat*indirim/100));
    }
    else{
        return temelFiyat+filmExtra;
    }
}

public static void biletBilgi(double indirim,double temelFiyat,int filmTürü,boolean saat,boolean gün,int meslek,double toplamFiyat,double extraÜcret,int yas){//Bilgileri ekrana yazdırma
    double netIndirim=0,indirimliFiyat;
    if(indirim!=0)
    netIndirim=temelFiyat-(temelFiyat*indirim/100);
    indirimliFiyat=temelFiyat-netIndirim;
    System.out.println("=======================");
    System.out.println("    BILET BIGLILERI");
    System.out.println("=======================");
    System.out.printf("Temel Fiyat      : %.0f TL ", temelFiyat);
    if(gün==true)
    System.out.print("(hafta içi");
    else
    System.out.print("(hafta sonu");
    if(saat==true)
    System.out.println(" matine)");
    else
    System.out.println(")");
    if(meslek==1)
    System.out.println("Oğrenci indirimi : %"+indirim+" -> "+indirimliFiyat+" TL");
    else if(meslek==2)
    System.out.println("Öğretmen indirimi: %"+indirim+" -> "+indirimliFiyat+" TL");
    else if(yas<12)
    System.out.println("Çocuk indirimi: %"+indirim+" -> "+indirimliFiyat+" TL");
    else if(yas>65)
    System.out.println("Yaşlı indirimi: %"+indirim+" -> "+indirimliFiyat+" TL");
    if(meslek==1||meslek==2 || yas<12 || yas>65)
    System.out.println("İndirimli Fiyat  : "+netIndirim+" TL");
    if(filmTürü==2)
    System.out.println("3D ekstra        : "+extraÜcret+" TL");
    else if(filmTürü==3)
    System.out.println("IMAX ekstra      : "+extraÜcret+" TL");
    else if(filmTürü==4)
    System.out.println("4DX ekstra       : "+extraÜcret+" TL");
    System.out.println("Toplam Fiyat     : "+toplamFiyat+" TL");
}

public static void main(String[] args) {
    double temelFiyat,indirim,extraÜcret,toplamFiyat;
    int gün,saat,yas,meslek,filmTürü;
    boolean kontrolGün,kontrolSaat;
        Scanner input = new Scanner(System.in);
        System.out.println("===============");
        System.out.println("1-Pazartesi");
        System.out.println("2-Salı");
        System.out.println("3-Çarşamba");
        System.out.println("4-Perşembe");
        System.out.println("5-Cuma");
        System.out.println("6-Cumartesi");
        System.out.println("7-Pazari");
        System.out.print("Gün (1-7) : ");
        gün=input.nextInt();

        System.out.println("===============");
        System.out.print("Saat (8-23) : ");
        saat=input.nextInt();

        System.out.println("===============");
        System.out.print("Yaş : ");
        yas=input.nextInt();

        System.out.println("===============");
        System.out.println("1-Öğrenci");
        System.out.println("2-Öğretmen");
        System.out.println("3-Diğer");
        System.out.print("Meslek (1-3) : ");
        meslek=input.nextInt();

        System.out.println("===============");
        System.out.println("1-2D");
        System.out.println("2-3D");
        System.out.println("3-IMAX");
        System.out.println("4-4DX");
        System.out.print("Film Türü (1-4) : ");
        filmTürü=input.nextInt();
        
        kontrolGün=günKontrol(gün);
        kontrolSaat=saatKontrol(saat);
        temelFiyat=temelFiyatHesapla(kontrolGün, kontrolSaat);
        indirim=indirimHesapla(yas, meslek, gün);
        extraÜcret=filmExtra(filmTürü);
        toplamFiyat=ToplamFiyat(indirim, extraÜcret, temelFiyat);


        biletBilgi(indirim, temelFiyat, filmTürü, kontrolSaat, kontrolGün,meslek,toplamFiyat,extraÜcret,yas);
        input.close();
    
    
}
}

