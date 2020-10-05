import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class ProgramPrincipal implements Runnable {
    Magazin magazin;
    Thread t;
    ProgramPrincipal(Magazin magazin) {
        this.magazin = magazin;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("Introduceti comanda: ");
            String s = sc.nextLine();
            String[] s1 = s.split(" ");

            if (s1[0].equals("exit")) {
                magazin.setExit(true);
                System.out.println("Exit");
                break;
            } else if (s1[0].equals("ADAUGA_CLIENT")) {
                try {
                    System.out.println("Introdu numele clientului : ");
                    String nume = sc.nextLine();
                    int anInregistrare = Calendar.getInstance().get(Calendar.YEAR);
                    System.out.println(anInregistrare);
                    boolean reducere = (anInregistrare < 2018) ? true : false;
                    Client c = new Client(nume, anInregistrare, reducere);

                    magazin.adaugaClient(c, nume);
                } catch (ClientDejaInregistratException e) {
                    System.out.println(e.getMessage());
                }

            } else if (s1[0].equals("ADAUGA_PRODUS")) {

                try {
                    String nume= magazin.citireClient();
                    int nrProdus = magazin.citireNrProdus();
                    System.out.println("DONE");
                    magazin.verificaStoc(nrProdus);
                    ArrayList<Produs> listaStocDisponibil = new ArrayList<>(magazin.getListaProduse());
                    magazin.adaugaProdus(nume, magazin.getListaProduse().get(nrProdus));
                    listaStocDisponibil.get(nrProdus).setNrProduse(listaStocDisponibil.get(nrProdus).getNrProduse() - 1);

                    magazin.setListaProduse(listaStocDisponibil);
                }

                catch (ClientInexistentException e) {
                    System.out.println(e.getMessage());
                }
                catch (ProdusInexistentException e)
                {
                    magazin.getStock();
                    System.out.println(e.getMessage());
                }
                catch (StocInexistentException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Alege alt produs!");
                    magazin.getStock();
                }

            }
            //Implemenat pentru a putea adauga produse in stocul magazinului, din care clientul poate alege
            else if (s1[0].equals("ADAUGA_PRODUS_STOC")) {
                System.out.println("Laptop/Telefon/Televizor");
                String obiect = sc.nextLine();

                switch (obiect) {
                    case "Laptop": {
                        Laptop l = new Laptop();
                        l.citire(l);
                        magazin.adaugaStoc(l);
                    }
                    case "Telefon" : {
                        Telefon t = new Telefon();
                        t.citireTelefon(t);
                        magazin.adaugaStoc(t);
                    }
                    case "Televizor":{
                        Televizor t = new Televizor();
                        t.citireTelevizor(t);
                        magazin.adaugaStoc(t);
                    }

                    //de completat celelalte tipuri
                }
            } else if (s1[0].equals("AFISARE_CLIENTI")) {
                magazin.afisareClienti();
            } else if (s1[0].equals("STERGERE_PRODUS")) {
                try {
                    System.out.println("Introdu numele clientului : ");
                    String nume = sc.nextLine();
                    magazin.afisareCos(nume);
                    System.out.println("Introdu numele producatorului si modelul : ");
                    String producator = sc.nextLine();
                    magazin.stergereProdus(nume, producator);
                } catch (ClientInexistentException e) {
                    System.out.println(e.getMessage());
                }

            } else if (s1[0].equals("AFISARE_COS")) {
                try {
                    String nume = magazin.citireClient();
                    magazin.afisareCos(nume);
                } catch (ClientInexistentException e) {
                    System.out.println(e.getMessage());
                }
            } else if (s1[0].equals("AFISARE_COMPLETA")) {
                //PRET
                magazin.afisareCompleta();
            } else if (s1[0].equals("STERGE_TOATE_PRODUSELE")) {
                try {
                    String nume = magazin.citireClient();
                    magazin.StergeToateProdusele(nume);
                } catch (ClientInexistentException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Comanda gresita");
            }
        }

    }
}

