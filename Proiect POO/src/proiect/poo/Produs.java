package proiect.poo;

public class Produs {
    private String nume;
    private String tip;
    private float pret;
    
    public Produs(){
        this.nume = "";
        this.tip = "";
        this.pret = 0;
    }
    
    public Produs(String nume, String tip, float pret){
        this.nume = nume;
        this.tip = tip;
        this.pret = pret;
    }
    
    public void afisare(){
        System.out.println(nume + ", " + pret + " RON");
    }
    
    public String getNume(){
        return nume;
    }
    
    public void setNume(String nume){
        this.nume = nume;
    }
    
    public String getTip(){
        return tip;
    }
    
    public void setTip(String tip){
        this.tip = tip;
    }
    
    public float getPret(){
        return pret;
    }
    
    public void setPret(float pret){
        this.pret = pret;
    }
}
