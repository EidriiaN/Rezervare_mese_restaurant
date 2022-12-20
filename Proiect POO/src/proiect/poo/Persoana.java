package proiect.poo;

import java.util.Scanner;

public class Persoana {
    private String nume, prenume, nrTelefon;
    Scanner input=new Scanner(System.in);

    public Persoana(String nume, String prenume, String nrTelefon) {
        this.nume = nume;
        this.prenume = prenume;
        this.nrTelefon = nrTelefon;
    }
    
    public Persoana(){
        this.nume="";
        this.prenume="";
        this.nrTelefon="";
    }
    
    public void introducere(){
        System.out.println("Introduceti:\nNume:");
        this.nume=input.next();
        System.out.println("Prenume:");
        this.prenume=input.next();
        System.out.println("Numarul de telefon:");
        this.nrTelefon=input.next();
        
    }


    public void afisare(){

        System.out.println("Nume si prenume: "+this.nume+" "+this.prenume+
        "\nNumar de telefon: "+this.nrTelefon);
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }
    
    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setNrTelefon(String nrTelefon) {
        this.nrTelefon = nrTelefon;
    }

    public String getNrTelefon() {
        return nrTelefon;
    }


}