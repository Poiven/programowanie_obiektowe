import java.util.ArrayList;

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
    ArrayList<Produkt> listaProduktow;
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
        int count=0;
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
    KoszykZakupowy koszykZakupowy;
    private String statusZamowienia;

    public String getStatusZamowienia() {
        return statusZamowienia;
    }

    Zamowienie(KoszykZakupowy koszykZakupowy,String statusZamowienia){
        this.koszykZakupowy=koszykZakupowy;
        this.statusZamowienia=statusZamowienia;
    }
    public void ustawStatusZamowienia(String status){
        this.statusZamowienia=status;
    }
    public void wyswietlZamowienie(){
        System.out.println("Zamowienie zawiera: ");
        koszykZakupowy.wyswietlZawartoscKoszyka();
        System.out.println("Status: "+statusZamowienia);
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
            System.out.println("Zamowienie "+ (i+1) +" :");
            listaZamowien.get(i).wyswietlZamowienie();
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
//            osoba.listaZamowien.add();
        }
    }


}


public class Zestaw6 {
    public static void main(String[] args) {
        var monitor = new Produkt("monitor",12.50,3);
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
        koszyk.wyswietlZawartoscKoszyka();
        System.out.println(koszyk.obliczCalkowitaWartosc());

        System.out.println();

        var order = new Zamowienie(koszyk,"W drodze");
        order.wyswietlZamowienie();

        var listaZamowieniowa = new ArrayList<Zamowienie>();
        listaZamowieniowa.add(order);
        listaZamowieniowa.add(order);


        var osoba = new Klient("Jan","Kowalski", listaZamowieniowa);
        osoba.wyswietlHistorieZamowien();
        System.out.println(osoba.obliczLacznyKosztZamowien());
    }
}
