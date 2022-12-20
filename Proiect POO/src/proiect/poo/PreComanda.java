package proiect.poo;

import java.util.ArrayList;
import java.util.Scanner;

public class PreComanda {
    
    private ArrayList<Produs> produse;
    private String observatii;

    public PreComanda() {
        this.produse = new ArrayList<>();
        this.observatii = "";
    }

    public PreComanda(ArrayList<Produs> produse, String observatii) {
        this.produse = produse;
        this.observatii = observatii;
    }
    
    public void initializare(Meniu meniu){
        Scanner in = new Scanner(System.in);
        meniu.afisare();
        System.out.println("Introduceti comanda dumneavoastra. Cand sunteti gata, tastati 0 pentru a trece la urmatorul pas.");
        while (true){
            String p = in.nextLine();
            if (p.equals("0")) break;
            Produs x = meniu.hasProdus(p);
            if (x == null){
                System.out.println("Produsul nu exista.");
                continue;
            }
            produse.add(x);
            System.out.println("Produsul a fost adaugat cu succes!");
        }
        System.out.println("Observatii comanda:");
        this.observatii = in.nextLine();
    }
    
    public void afisare(){
        System.out.println("Pre-comanda: ");
        for (int i = 0; i < produse.size(); i++){
            System.out.print(produse.get(i).getNume());
            if (i < produse.size() - 1) System.out.print(", ");
            else System.out.print(".");
        }
        System.out.println();
    }
    
    public String getObservatii() {
        return observatii;
    }

    public void setObservatii(String observatii) {
        this.observatii = observatii;
    }
    
    public boolean isNull(){
        return produse.size() == 0;
    }
}