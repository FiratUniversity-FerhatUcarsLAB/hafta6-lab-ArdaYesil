/*
Adı Soyadı : Arda Yeşil
Numarası : 250542013
görev 3 : %63 tamamlandı


*/
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

    public static boolean ogrenciKontrol(int gün,char ögrenci){
        if(gün<=5 && ögrenci=='E' || ögrenci=='e')
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

    public static void main(String[] args) {
        
    }
}
