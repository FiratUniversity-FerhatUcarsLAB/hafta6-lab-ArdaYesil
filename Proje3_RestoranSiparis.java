/*
Adı Soyadı : Arda Yeşil
Numarası : 250542013
görev 3 : %63 tamamlandı


*/

import java.util.Scanner;

public class RestorantSiparişSistemi {
    final static double comboIndirim=0.15,içecekIndirim=0.20,ogrenciIndirim=0.10;
    public static double anaYemekSeçim(int yemekDeğer){//Ana Yemeğin fiyatını belirler
        switch (yemekDeğer) {
            case 1:
                return 85;
            case 2:
                return 120;
            case 3:
                return 110;
            case 4:
                return 65;
            default:
                return 0;
        }
    }

    public static double BaşlangiçSeçim(int başlangiçDeğer){//Başlangıç/Meze Fiyatını belirler
        switch (başlangiçDeğer) {
            case 0:
                return 0;
            case 1:
                return 25;
            case 2:
                return 45;
            case 3:
                return 55;
            default:
                return 0;
        }
    }

    public static double içeçekSeçim(int içeçekDeğer){//İçeceğin fiyatını belirler
        switch (içeçekDeğer) {
            case 0:
                return 0;
            case 1:
                return 15;
            case 2:
                return 12;
            case 3:
                return 35;
            case 4:
                return 25;
            default:
                return 0;
        }
    }

    public static double tatliSeçim(int tatliDeğer){//tatlı fiyatını belirliyor
        switch (tatliDeğer) {
            case 0:
                return 0;
            case 1:
               return 65;
            case 2:
               return 55;
            case 3:
               return 35;
            default:
                return 0;
        }
    }

    public static boolean comboKontrol(double anaVar,double içecekVar,double tatliVar){//combo varmı kontrol ediyor
        if(anaVar>0 && içecekVar>0 && tatliVar>0)
            return true;
        return false;
    }

    public static boolean happyTimeKontrol(int saat){//içeçek için indirim varmı kontrol ediliyor
        if(saat>14 && saat<17)
            return true;
        return false;
    }

    public static boolean ogrenciKontrol(int gün,String ögrenci){
        if(gün<=5 && (ögrenci=="E" || ögrenci=="e"))
            return true;
        return false;
    }

    public static double fiyatIndirimHesapla(double toplamTutar,boolean combo,boolean ogrenci,boolean happyTime,double içecek){
        if(combo==true){
        toplamTutar=toplamTutar-(toplamTutar*comboIndirim); 
        }

        if(happyTime==true){
        toplamTutar=toplamTutar-(toplamTutar*içecekIndirim);
        }
        
        if(ogrenci==true){
        toplamTutar=toplamTutar-(toplamTutar*ogrenciIndirim);
        }
        
        return toplamTutar;
    }

    public static double bahşişHesapla(double sonFiyat){
        return sonFiyat*0.10;
    }

    @SuppressWarnings("StringEquality")
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int anaYemek,başlangiç,içecek,tatli,saat,gün;
        double anaYemekSeçim,başlangiçSeçim,içecekSeçim,tatliSeçim,günSeçim,toplamFiyat,hesapFiyat,bahşiş;
        boolean comboIndirim,saatSeçim,ogrenciSeçim;
        String ogrenci;

        System.out.println("====== Ana Yemek =======");
        System.out.println("1- Izgara Tavuk - 85 TL");
        System.out.println("2- Adana Kebap - 120 TL");
        System.out.println("3- Levrek - 110 TL");
        System.out.println("4- Mantı - 65 TL");
        System.out.print("Ana Yemek (1-4) : ");
        anaYemek = input.nextInt();

        System.out.println("\n====== Başlangiç =======");
        System.out.println("0- Hişbir şey");
        System.out.println("1- Çorba - 25 TL");
        System.out.println("2- Humus - 45 TL");
        System.out.println("3- Sigara Böreği - 55 TL");
        System.out.print("Başlangıç (0-3) : ");
        başlangiç=input.nextInt();


        System.out.println("\n====== İçecekler =======");
        System.out.println("0- Hişbir şey");
        System.out.println("1-  Kola - 15 TL");
        System.out.println("2- Ayran - 12 TL");
        System.out.println("3- Taze Meyve Suyu - 35 TL");
        System.out.println("4-  Limonata - 25 TL");
        System.out.print("İçecek (0-4) : ");
        içecek=input.nextInt();

        System.out.println("\n====== Tatlılar =======");
        System.out.println("0- Hiçbir şey");
        System.out.println("1- Künefe - 65 TL");
        System.out.println("2- Baklava - 55 TL");
        System.out.println("3- Sütlaç - 35 TL");
        System.out.print("Tatlı (0-3) : ");
        tatli=input.nextInt();

        System.out.print("\nSaat (8-23) : " );
        saat=input.nextInt();

        System.out.print("\nÖğrenci misiniz (E/H) : " );
        ogrenci=input.next();

        System.out.println("\n====== Gün =======");
        System.out.println("1-Pazartesi");
        System.out.println("2-Salı");
        System.out.println("3-Çarşamba");
        System.out.println("4-Perşembe");
        System.out.println("5-Cuma");
        System.out.println("6-Cumartesi");
        System.out.println("7-Pazari");
        System.out.print("Gün (1-7) : ");
        gün=input.nextInt();

        anaYemekSeçim=anaYemekSeçim(anaYemek);
        başlangiçSeçim=BaşlangiçSeçim(başlangiç);
        içecekSeçim=içeçekSeçim(içecek);
        tatliSeçim=tatliSeçim(tatli);
        comboIndirim=comboKontrol(anaYemekSeçim, içecekSeçim, tatliSeçim);
        saatSeçim=happyTimeKontrol(saat);
        ogrenciSeçim=ogrenciKontrol(gün, ogrenci);
        toplamFiyat=anaYemekSeçim+başlangiçSeçim+içecekSeçim+tatliSeçim;
        hesapFiyat= fiyatIndirimHesapla(toplamFiyat, comboIndirim, ogrenciSeçim, saatSeçim, içecekSeçim);
        bahşiş=bahşişHesapla(hesapFiyat);

        System.out.println("\n=== Hesap Bilgi ===");
        System.out.printf("Ara Toplam : %.2f TL", toplamFiyat);
        System.out.printf("\nToplam Tutar : %.2f TL" , hesapFiyat);
        System.out.printf("\nBahşiş Önerisi : %.2f TL",bahşiş); 
        
    }
}
