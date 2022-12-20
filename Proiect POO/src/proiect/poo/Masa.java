package proiect.poo;

public class Masa {
    
    private int nrMasa;
    private int locuri;
    private String tipMasa;
    private static int nrMese = 0;

    public Masa(int locuri, String tipMasa) {
        this.locuri = locuri;
        this.tipMasa= tipMasa;
        this.nrMasa = nrMese + 1;
        nrMese++;
    }

    public Masa() {
        this.locuri = 0;
        this.tipMasa="";
        this.nrMasa = nrMese + 1;
        nrMese++;
    }

    public void afisare(){
        System.out.println("Masa "+nrMasa+": "+this.locuri+" locuri, "+this.tipMasa);
    }

    public void setLocuri(int locuri) {
        this.locuri = locuri;
    }
    
    public int getLocuri() {
        return locuri;
    }

    public void setNrMasa(int nrMasa) {
        this.nrMasa = nrMasa;
    }

    public int getNrMasa() {
        return nrMasa;
    }
    
    public static int getNrMese(){
        return nrMese;
    }

    public String getTipMasa() {
        return tipMasa;
    }
    public void setTipMasa(String tipMasa) {
        this.tipMasa = tipMasa;
    }
}
