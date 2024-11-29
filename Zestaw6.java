import java.util.ArrayList;
import java.util.Collection;

class Produkt{
    String nazwa;
    double cena;
    int iloscNaMagazynie;

    Produkt(String nazwa,double cena,int iloscNaMagazynie){
        this.nazwa=nazwa;
        this.cena=cena;
        this.iloscNaMagazynie=iloscNaMagazynie;
    }

    public void wyswietlInformacje(){
        System.out.println("Nazwa: "+this.nazwa+"\nCena: "+this.cena+"\nIlosc na magazynie: "+this.iloscNaMagazynie);
    }
    public void dodajDoMagazynu(int ilosc){
        this.iloscNaMagazynie+=ilosc;
    }
    public void usunZMagazynu(int ilosc){
        if (ilosc<=this.iloscNaMagazynie){
            this.iloscNaMagazynie-=ilosc;
        }
    }
}

class KoszykZakupowy{
    public ArrayList<Produkt> listaProduktow;
    KoszykZakupowy(){
        listaProduktow=new ArrayList<Produkt>();

    }
    public void dodajProdukt(Produkt item, int ilosc){
        if(item.iloscNaMagazynie>ilosc){
            for(int i = 0;i<ilosc;i++) {
                listaProduktow.add(item);
                item.iloscNaMagazynie--;
            }
        }
    }
    public void wyswietlZawartoscKoszyka(){
        ArrayList<Produkt> widziane = new ArrayList<>();
        for(Produkt item:listaProduktow){
            if(!widziane.contains(item)){
                widziane.add(item);
            }

        }
        for(Produkt item:widziane){
            System.out.println("Nazwa: "+item.nazwa+"\nilosc: "+iloscWKoszyku(item));
        }
    }
    private int iloscWKoszyku(Produkt przedmiot){
        int count=0;
        for(Produkt item:listaProduktow){
            if(item.equals(przedmiot))
                count++;
        }
        return count;
    }
    public double obliczCalkowitaWartosc(){
        double suma=0;
        for(Produkt item:listaProduktow){
            suma+=item.cena;
        }
        return suma;
    }

}

class Zamowienie{
    public KoszykZakupowy koszykZakupowy;
    private String statusZamowienia;
    public Platnosc platnosc;


    public String getStatusZamowienia() {
        return statusZamowienia;
    }

    Zamowienie(KoszykZakupowy koszykZakupowy,String statusZamowienia){
        this.koszykZakupowy=koszykZakupowy;
        this.statusZamowienia=statusZamowienia;
        this.platnosc = new Platnosc(this.koszykZakupowy.obliczCalkowitaWartosc(), "nieoplacone");
    }
    public void ustawStatusZamowienia(String status){
        this.statusZamowienia=status;
    }
    public void wyswietlZamowienie(){
        System.out.println("Zamowienie zawiera: ");
        koszykZakupowy.wyswietlZawartoscKoszyka();
        System.out.println("Status: "+statusZamowienia);
    }
    public void finalizujZamowienie(){
        if (platnosc.statusPlatnosci.equals("oplacone"))
            this.ustawStatusZamowienia("Gotowe do wysylki");

    }
    public void zwrocProdukt(Produkt produkt, int ilosc){
        for (int i=0;i<ilosc;i++) {
            this.koszykZakupowy.listaProduktow.remove(produkt);

        }
        produkt.iloscNaMagazynie += ilosc;
    }

}

class Klient{
    String imie;
    String nazwisko;
    ArrayList<Zamowienie> listaZamowien;

    Klient(String imie,String nazwisko,ArrayList<Zamowienie> listaZamowien){
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.listaZamowien=listaZamowien;
    }

    public void dodajZamowienie(Zamowienie singleOrder){
        listaZamowien.add(singleOrder);
    }

    public void wyswietlHistorieZamowien(){
        for(int i = 0; i<listaZamowien.size(); i++){
            System.out.println("{\nZamowienie "+ (i+1) +" :");
            listaZamowien.get(i).wyswietlZamowienie();
            System.out.println("}");
        }
    }
    public double obliczLacznyKosztZamowien(){
        double lacznie = 0;
        for (int i = 0; i < listaZamowien.size(); i++) {
            lacznie += listaZamowien.get(i).koszykZakupowy.obliczCalkowitaWartosc();
        }
        return lacznie;
    }

}

class Sklep{
    ArrayList<Produkt> produkty;

    Sklep(ArrayList<Produkt> produkty){
        this.produkty=produkty;
    }

    public void dodajProdukt(Produkt singleProduct){
        produkty.add(singleProduct);
    }
    public void wyswietlOferty(){
        for (Produkt item : produkty) {
            System.out.print(item.nazwa+", ");
        }
    }
    public Produkt wyszukajProduktu(String nazwa){
        for (Produkt item : produkty) {
            if(item.nazwa.equals(nazwa)){
                return item;
            }
        }
        return null;
    }
    public void zakupy(Produkt singleProduct, Klient osoba, int ilosc){
        if (singleProduct.iloscNaMagazynie>=ilosc){
            osoba.listaZamowien.getLast().koszykZakupowy.dodajProdukt(singleProduct, ilosc);
        }

    }


}

class Platnosc{
    double kwota;
    String statusPlatnosci;

    Platnosc(double sum, String tekst){
        this.kwota = sum;
        this.statusPlatnosci = tekst;
    }
    public void zaplac(){
        this.statusPlatnosci = "oplacone";
        this.kwota = 0;
    }
}


public class Zestaw6 {
    public static void main(String[] args) {
        var monitor = new Produkt("monitor",12.50,20);
        var myszka = new Produkt("myszka",2.50,12);
        // zad 1
        /*
        monitor.wyswietlInformacje();
        monitor.dodajDoMagazynu(1);
        monitor.wyswietlInformacje();
        System.out.println();
        monitor.usunZMagazynu(15);
        monitor.wyswietlInformacje();
        System.out.println();
        monitor.usunZMagazynu(2);
        monitor.wyswietlInformacje();
        */

        var koszyk = new KoszykZakupowy();
        koszyk.dodajProdukt(monitor,1);
        koszyk.dodajProdukt(myszka,2);
        koszyk.dodajProdukt(monitor,3);

        var koszyk2 = new KoszykZakupowy();
        koszyk2.dodajProdukt(monitor,5);
//        koszyk.wyswietlZawartoscKoszyka();
        System.out.println(koszyk.obliczCalkowitaWartosc());

        System.out.println();

        var order = new Zamowienie(koszyk,"W drodze");
        order.wyswietlZamowienie();
        System.out.println();
        var order2 = new Zamowienie(koszyk2,"zagubione");


        var listaZamowieniowa = new ArrayList<Zamowienie>();
        listaZamowieniowa.add(order);
        listaZamowieniowa.add(order2);


        var osoba = new Klient("Jan","Kowalski", listaZamowieniowa);
        osoba.wyswietlHistorieZamowien();
        System.out.println(osoba.obliczLacznyKosztZamowien());

//        System.out.println(monitor.iloscNaMagazynie);
        var sklepik = new Sklep(new ArrayList<Produkt>());

    }

}
