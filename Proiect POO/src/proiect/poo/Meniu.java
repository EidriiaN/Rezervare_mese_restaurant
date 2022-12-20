package proiect.poo;

import java.util.ArrayList;

public class Meniu {
    private ArrayList<Produs> felul1;
    private ArrayList<Produs> felul2;
    private ArrayList<Produs> desert;
    private ArrayList<Produs> bauturi;
    
    public Meniu(){
        this.felul1 = new ArrayList<>();
        this.felul2 = new ArrayList<>();
        this.desert = new ArrayList<>();
        this.bauturi = new ArrayList<>();
    }
    
    public Produs hasProdus(String nume){
        nume = nume.toLowerCase();
        for (Produs x : felul1){
            if (x.getNume().toLowerCase().equals(nume)) return x;
        }
        for (Produs x : felul2){
            if (x.getNume().toLowerCase().equals(nume)) return x;
        }
        for (Produs x : desert){
            if (x.getNume().toLowerCase().equals(nume)) return x;
        }
        for (Produs x : bauturi){
            if (x.getNume().toLowerCase().equals(nume)) return x;
        }
        return null;
    }
    
    public void addProdus(Produs x){
        if (x.getTip().equals("Felul 1")) felul1.add(x);
        if (x.getTip().equals("Felul 2")) felul2.add(x);
        if (x.getTip().equals("Desert")) desert.add(x);
        if (x.getTip().equals("Bautura")) bauturi.add(x);
    }
    
    public void afisare(){
        System.out.println("-MENIU-");
        System.out.println("\nFelul 1:\n");
        for (Produs x : felul1){
            x.afisare();
        }
        System.out.println("\nFelul 2:\n");
        for (Produs x : felul2){
            x.afisare();
        }
        System.out.println("\nDesert:\n");
        for (Produs x : desert){
            x.afisare();
        }
        System.out.println("\nBauturi:\n");
        for (Produs x : bauturi){
            x.afisare();
        }
        System.out.println();
    }
}
