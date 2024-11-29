import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;

class Produkt{
    private String nazwa;
    private double cena;
    private int iloscNaMagazynie;

    Produkt(String nazwa,double cena,int iloscNaMagazynie){
        this.nazwa=nazwa;
        this.cena=cena;
        this.iloscNaMagazynie=iloscNaMagazynie;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getIloscNaMagazynie() {
        return iloscNaMagazynie;
    }

    public void setIloscNaMagazynie(int iloscNaMagazynie) {
        this.iloscNaMagazynie = iloscNaMagazynie;
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
    @Override
    public String toString() {return "Nazwa: "+this.nazwa+"\nCena: "+this.cena+"\nIlosc na magazynie: "+this.iloscNaMagazynie;}

//    Override
//    public String getClass(){
//        return "Czesc jestem klasa Produkt";
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produkt produkt = (Produkt) o;
        return Double.compare(cena, produkt.cena) == 0 && Objects.equals(nazwa, produkt.nazwa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwa, cena);
    }
}

class KoszykZakupowy{
    private HashMap<Produkt, Integer> listaProdukt;
//    private ArrayList<Produkt> listaProduktow;
    /*KoszykZakupowy(){
        listaProduktow=new ArrayList<Produkt>();

    }*/
    KoszykZakupowy(){
        this.listaProdukt = new HashMap<>();
    }
    /*public ArrayList<Produkt> getListaProduktow() {
        return listaProduktow;
    }

    public void setListaProduktow(ArrayList<Produkt> listaProduktow) {
        this.listaProduktow = listaProduktow;
    }*/

    public HashMap<Produkt, Integer> getListaProdukt() {
        return listaProdukt;
    }

    public void setListaProdukt(HashMap<Produkt, Integer> listaProdukt) {
        this.listaProdukt = listaProdukt;
    }

    public void dodajProdukt(Produkt item, int ilosc){
        if(item.getIloscNaMagazynie() >ilosc){
            listaProdukt.put(item,ilosc);
            item.setIloscNaMagazynie(item.getIloscNaMagazynie()-ilosc);
        }
    }
    public void wyswietlZawartoscKoszyka(){
        for (Produkt item: listaProdukt.keySet()){
            System.out.println("przedmiot: "+item.getNazwa()+", ilosc: "+listaProdukt.get(item));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Produkt item: listaProdukt.keySet()){
            sb.append("przedmiot: ").append(item.getNazwa()).append(", ilosc: ").append(listaProdukt.get(item)).append("\n");
        }
        return sb.toString();
    }

    /*public void wyswietlZawartoscKoszyka(){
        ArrayList<Produkt> widziane = new ArrayList<>();
        for(Produkt item:listaProduktow){
            if(!widziane.contains(item)){
                widziane.add(item);
            }

        }
        for(Produkt item:widziane){
            System.out.println("Nazwa: "+ item.getNazwa() +"\nilosc: "+iloscWKoszyku(item));
        }
    }*/
    /*private int iloscWKoszyku(Produkt przedmiot){
        int count=0;
        for(Produkt item:listaProduktow){
            if(item.equals(przedmiot))
                count++;
        }
        return count;
    }*/
    public double obliczCalkowitaWartosc(){
        double suma=0;
        for(Produkt item:listaProdukt.keySet()){
            suma+= item.getCena();
        }
        return suma;
    }

}

class Zamowienie{
    private KoszykZakupowy koszykZakupowy;
    private String statusZamowienia;
    private Platnosc platnosc;

    KoszykZakupowy getKoszykZakupowy() {
        return koszykZakupowy;
    }

    public void setKoszykZakupowy(KoszykZakupowy koszykZakupowy) {
        this.koszykZakupowy = koszykZakupowy;
    }

    public void setStatusZamowienia(String statusZamowienia) {
        this.statusZamowienia = statusZamowienia;
    }

    public Platnosc getPlatnosc() {
        return platnosc;
    }

    public void setPlatnosc(Platnosc platnosc) {
        this.platnosc = platnosc;
    }

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
        if (platnosc.getStatusPlatnosci().equals("oplacone"))
            this.ustawStatusZamowienia("Gotowe do wysylki");

    }
    public void zwrocProdukt(Produkt produkt, int ilosc){
        for (int i=0;i<ilosc;i++) {
            this.koszykZakupowy.getListaProdukt().remove(produkt);

        }
        produkt.setIloscNaMagazynie(produkt.getIloscNaMagazynie()+ilosc);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("zamowienie zawiera: ").append(koszykZakupowy.toString()).append("\n").append("status zamowienia: ").append(statusZamowienia).append("\n").append("\n");
        return sb.toString();
    }

}

class Klient{
    private String imie;
    private String nazwisko;
    private ArrayList<Zamowienie> listaZamowien;
    private Adres adresKlienta;

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public ArrayList<Zamowienie> getListaZamowien() {
        return listaZamowien;
    }

    public void setListaZamowien(ArrayList<Zamowienie> listaZamowien) {
        this.listaZamowien = listaZamowien;
    }

    public Adres getAdresKlienta() {
        return adresKlienta;
    }

    public void setAdresKlienta(Adres adresKlienta) {
        this.adresKlienta = adresKlienta;
    }

    Klient(String imie, String nazwisko, ArrayList<Zamowienie> listaZamowien, Adres adresKlienta){
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.listaZamowien=listaZamowien;
        this.adresKlienta=adresKlienta;
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
            lacznie += listaZamowien.get(i).getKoszykZakupowy().obliczCalkowitaWartosc();
        }
        return lacznie;
    }
    @Override
    public String toString() {
        return "imie: "+imie+", nazwisko: "+nazwisko;

    }

}

class Sklep{
    private ArrayList<Produkt> produkty;
    private String nazwaSklepu;
    private LocalDate dataPowstania;
    private Magazyn magazynSklepu;


    public ArrayList<Produkt> getProdukty() {
        return produkty;
    }

    public void setProdukty(ArrayList<Produkt> produkty) {
        this.produkty = produkty;
    }

    public String getNazwaSklepu() {
        return nazwaSklepu;
    }

    public void setNazwaSklepu(String nazwaSklepu) {
        this.nazwaSklepu = nazwaSklepu;
    }

    public LocalDate getDataPowstania() {
        return dataPowstania;
    }

    public void setDataPowstania(LocalDate dataPowstania) {
        if (dataPowstania.isBefore(LocalDate.now())) {
            this.dataPowstania = dataPowstania;
        }
        else throw new IllegalArgumentException("The given date cannot be in the future");
    }

    public Magazyn getMagazynSklepu() {
        return magazynSklepu;
    }

    public void setMagazynSklepu(Magazyn magazynSklepu) {
        this.magazynSklepu = magazynSklepu;
    }

    Sklep(ArrayList<Produkt> produkty, String nazwaSklepu, LocalDate dataPowstania){
        if (dataPowstania.isBefore(LocalDate.now())) {
            this.produkty = produkty;
            this.nazwaSklepu = nazwaSklepu;
            this.dataPowstania = dataPowstania;
        }
        else throw new IllegalArgumentException("The given date cannot be in the future");
    }

    public void dodajProdukt(Produkt singleProduct){
        produkty.add(singleProduct);
    }
    public void wyswietlOferty(){
        for (Produkt item : produkty) {
            System.out.print(item.getNazwa() +", ");
        }
    }
    public Produkt wyszukajProduktu(String nazwa){
        for (Produkt item : produkty) {
            if(item.getNazwa().equals(nazwa)){
                return item;
            }
        }
        return null;
    }
    public void zakupy(Produkt singleProduct, Klient osoba, int ilosc){
        if (singleProduct.getIloscNaMagazynie() >=ilosc){
            osoba.getListaZamowien().getLast().getKoszykZakupowy().dodajProdukt(singleProduct, ilosc);
        }

    }


}

class Platnosc{
    private double kwota;
    private String statusPlatnosci;

    public double getKwota() {
        return kwota;
    }

    public void setKwota(double kwota) {
        this.kwota = kwota;
    }

    public String getStatusPlatnosci() {
        return statusPlatnosci;
    }

    public void setStatusPlatnosci(String statusPlatnosci) {
        this.statusPlatnosci = statusPlatnosci;
    }

    Platnosc(double sum, String tekst){
        this.kwota = sum;
        this.statusPlatnosci = tekst;
    }
    public void zaplac(){
        this.statusPlatnosci = "oplacone";
        this.kwota = 0;
    }
}

class Magazyn{
    private HashMap<Produkt, Integer> produktyNaMagazynie = new HashMap<Produkt, Integer>();

    public HashMap<Produkt, Integer> getProduktyNaMagazynie() {
        return produktyNaMagazynie;
    }

    public void setProduktyNaMagazynie(HashMap<Produkt, Integer> produktyNaMagazynie) {
        this.produktyNaMagazynie = produktyNaMagazynie;
    }

    public Magazyn(Produkt p){
        produktyNaMagazynie.put(p, p.getIloscNaMagazynie());
    }

    @Override
    public String toString() {
        StringBuilder tekst = new StringBuilder();
        for (Produkt item : produktyNaMagazynie.keySet()) {
            tekst.append("przedmiot: ").append(item.getNazwa()).append(", ").append(produktyNaMagazynie.get(item)).append("\n");
        }
        return tekst.toString();
    }
    public void dodajProdukt(Produkt singleProduct){
        produktyNaMagazynie.put(singleProduct, singleProduct.getIloscNaMagazynie());
    }
}
class Adres{
    private String ulica;
    private int numerDomu;
    private int numerMieszkania;
    private String miasto;
    private String kodPocztowy;

    public Adres(String ulica, int numerDomu, String miasto, String kodPocztowy){
        this.ulica = ulica;
        this.numerDomu = numerDomu;
        this.miasto = miasto;
        this.kodPocztowy = kodPocztowy;

    }

    Adres(String ulica, int numerDomu, int numerMieszkania, String miasto, String kodPocztowy) {
        this.ulica = ulica;
        this.numerDomu = numerDomu;
        this.numerMieszkania = numerMieszkania;
        this.miasto = miasto;
        this.kodPocztowy = kodPocztowy;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public int getNumerDomu() {
        return numerDomu;
    }

    public void setNumerDomu(int numerDomu) {
        this.numerDomu = numerDomu;
    }

    public int getNumerMieszkania() {
        return numerMieszkania;
    }

    public void setNumerMieszkania(int numerMieszkania) {
        this.numerMieszkania = numerMieszkania;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public void pokaz(){
        System.out.println(this.kodPocztowy + this.miasto);
        System.out.println(this.ulica+", "+this.numerDomu+", "+this.numerMieszkania);
    }
    /*
    public boolean przed(){
        if
    }*/

}


public class Zestaw7 {
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
/*
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
*/

        Magazyn magazynSklepu = new Magazyn(monitor);
        magazynSklepu.dodajProdukt(myszka);
        System.out.println(magazynSklepu.toString());



    }

}