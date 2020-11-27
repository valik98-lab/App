package utm.md.demo.entity;

public class Cartier {
    private String denumire;
    private Long populatie;
    private Long institutii_publice;

    public Cartier(String denumire, Long  populatie, Long institutii_publice){
        this.denumire = denumire;
        this.populatie = populatie;
        this.institutii_publice = institutii_publice;
    }

    public String  getDenumire () {
        return denumire;
    }

    public void setDenumire (String denumire) {
        this.denumire = denumire;
    }

    public Long getPopulatie () {
        return populatie;
    }

    public void setPopulatie (Long populatie) {
        this.populatie = populatie;
    }

    public Long getInstitutii_publice () {
        return institutii_publice;
    }
    public void setInstitutii_publice (Long institutii_publice) {
        this.institutii_publice = institutii_publice;
    }

}
