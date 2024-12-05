import java.time.LocalDate;
import java.util.ArrayList;
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
        if(nazwa!=null)
            this.nazwa = nazwa;
        else
            throw new IllegalArgumentException("nazwa cannot be null");
    }

    public double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        if (cena!=null)
            this.cena = cena;
        else
            throw new IllegalArgumentException("cena cannot be null");
    }

    public int getIloscNaMagazynie() {
        return iloscNaMagazynie;
    }

    public void setIloscNaMagazynie(Integer iloscNaMagazynie) {
        if(iloscNaMagazynie!=null)
            this.iloscNaMagazynie = iloscNaMagazynie;
        else
            throw new IllegalArgumentException("ilosc cannot be null");

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
    private HashMap<Produkt, Integer> listaProduktow;
//    private ArrayList<Produkt> listaProduktow;
    /*KoszykZakupowy(){
        listaProduktow=new ArrayList<Produkt>();

    }*/
    KoszykZakupowy(){
        this.listaProduktow = new HashMap<>();
    }
    /*public ArrayList<Produkt> getListaProduktow() {
        return listaProduktow;
    }

    public void setListaProduktow(ArrayList<Produkt> listaProduktow) {
        this.listaProduktow = listaProduktow;
    }*/

    public HashMap<Produkt, Integer> getListaProduktow() {
        return listaProduktow;
    }

    public void setListaProduktow(HashMap<Produkt, Integer> listaProduktow) {
        if(listaProduktow !=null)
            this.listaProduktow = listaProduktow;
        else throw new IllegalArgumentException("listaProduktow cannot be null");
    }

    public void dodajProdukt(Produkt item, int ilosc){
        if(item.getIloscNaMagazynie() >ilosc){
            listaProduktow.put(item,ilosc);
            item.setIloscNaMagazynie(item.getIloscNaMagazynie()-ilosc);
        }
    }
    public void wyswietlZawartoscKoszyka(){
        for (Produkt item: listaProduktow.keySet()){
            System.out.println("przedmiot: "+item.getNazwa()+", ilosc: "+ listaProduktow.get(item));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Produkt item: listaProduktow.keySet()){
            sb.append("przedmiot: ").append(item.getNazwa()).append(", ilosc: ").append(listaProduktow.get(item)).append("\n");
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
    /* private int iloscWKoszyku(Produkt przedmiot){
        int count=0;
        for(Produkt item:listaProduktow){
            if(item.equals(przedmiot))
                count++;
        }
        return count;
    }*/
    public double obliczCalkowitaWartosc(){
        double suma=0;
        for(Produkt item: listaProduktow.keySet()){
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
        if(koszykZakupowy!=null)
            this.koszykZakupowy = koszykZakupowy;
        else throw new IllegalArgumentException("koszykZakupowy cannot be null");
    }

    public void setStatusZamowienia(String statusZamowienia) {
        if (statusZamowienia!=null)
            this.statusZamowienia = statusZamowienia;
        else throw new IllegalArgumentException("statusZamowienia cannot be null");
    }

    public Platnosc getPlatnosc() {
        return platnosc;
    }

    public void setPlatnosc(Platnosc platnosc) {
        if (platnosc!=null)
            this.platnosc = platnosc;
        else throw new IllegalArgumentException("platnosc cannot be null");
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
            this.koszykZakupowy.getListaProduktow().remove(produkt);

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
        if(imie!=null)
            this.imie = imie;
        else throw new IllegalArgumentException("imie cannot be null");
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        if (nazwisko!=null)
            this.nazwisko = nazwisko;
        else throw new IllegalArgumentException("nazwisko cannot be null");
    }

    public ArrayList<Zamowienie> getListaZamowien() {
        return listaZamowien;
    }

    public void setListaZamowien(ArrayList<Zamowienie> listaZamowien) {
        if (listaZamowien!=null)
            this.listaZamowien = listaZamowien;
        else throw new IllegalArgumentException("listaZamowien cannot be null");
    }

    public Adres getAdresKlienta() {
        return adresKlienta;
    }

    public void setAdresKlienta(Adres adresKlienta) {
        if (adresKlienta!=null)
            this.adresKlienta = adresKlienta;
        else throw new IllegalArgumentException("adresKlienta cannot be null");
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
        return "imie: "+imie+", nazwisko: "+nazwisko+", listaZamowien: "+listaZamowien +",adresKlienta: "+adresKlienta;

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
        if (produkty!=null)
            this.produkty = produkty;
        else throw new IllegalArgumentException("produkty cannot be null");
    }

    public String getNazwaSklepu() {
        return nazwaSklepu;
    }

    public void setNazwaSklepu(String nazwaSklepu) {
        if (nazwaSklepu!=null)
            this.nazwaSklepu = nazwaSklepu;
        else throw new IllegalArgumentException("nazwaSklepu cannot be null");
    }

    public LocalDate getDataPowstania() {
        return dataPowstania;
    }

    public void setDataPowstania(LocalDate dataPowstania) {
        if (dataPowstania!=null) {
            if (dataPowstania.isBefore(LocalDate.now())) {
                this.dataPowstania = dataPowstania;
            } else throw new IllegalArgumentException("The given date cannot be in the future");
        }
        else throw new IllegalArgumentException("dataPowstania cannot be null");
    }

    public Magazyn getMagazynSklepu() {
        return magazynSklepu;
    }

    public void setMagazynSklepu(Magazyn magazynSklepu) {
        if (magazynSklepu!=null)
            this.magazynSklepu = magazynSklepu;
        else throw new IllegalArgumentException("magazynSklepu cannot be null");
    }

    public Sklep(ArrayList<Produkt> produkty, String nazwaSklepu, LocalDate dataPowstania){
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

    public void setKwota(Double kwota) {
        if (kwota!=null)
            this.kwota = kwota;
        else throw new IllegalArgumentException("kwota cannot be null");
    }

    public String getStatusPlatnosci() {
        return statusPlatnosci;
    }

    public void setStatusPlatnosci(String statusPlatnosci) {
        if (statusPlatnosci!=null)
            this.statusPlatnosci = statusPlatnosci;
        else throw new IllegalArgumentException("statusPlatnosci cannot be null");
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
        if (produktyNaMagazynie!=null)
            this.produktyNaMagazynie = produktyNaMagazynie;
        else throw new IllegalArgumentException("produktyNaMagazynie cannot be null");
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

    public Adres(String ulica, int numerDomu, int numerMieszkania, String miasto, String kodPocztowy) {
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
        if(ulica!=null)
            this.ulica = ulica;
        else throw new IllegalArgumentException("ulica cannot be null");
    }

    public int getNumerDomu() {
        return numerDomu;
    }

    public void setNumerDomu(Integer numerDomu) {
        if (numerDomu!=null)
            this.numerDomu = numerDomu;
        else throw new IllegalArgumentException("numerDomu cannot be null");
    }

    public int getNumerMieszkania() {
        return numerMieszkania;
    }

    public void setNumerMieszkania(Integer numerMieszkania) {
        if(numerMieszkania!=null)
            this.numerMieszkania = numerMieszkania;
        else throw new IllegalArgumentException("numerMieszkania cannot be null");
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        if(miasto!=null)
            this.miasto = miasto;
        else throw new IllegalArgumentException("miasto cannot be null");
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        if (kodPocztowy!=null)
            this.kodPocztowy = kodPocztowy;
        else throw new IllegalArgumentException("kodPocztowy cannot be null");
    }

    public void pokaz(){
        System.out.println(this.kodPocztowy + this.miasto);
        System.out.println(this.ulica+", "+this.numerDomu+", "+this.numerMieszkania);
    }
    /*
    public boolean przed(){
        if
    }*/
    @Override
    public String toString(){
        return kodPocztowy + " " + miasto + "\n" + ulica + " " + numerDomu + " " + numerMieszkania;
    }

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
        System.out.println(magazynSklepu);



    }

}