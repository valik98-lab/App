package utm.md.demo.entity;

public class Carte {
    private Long id;
    private String titlu;
    private String autor;
    private String clasificare;
    private Float pret;
    private String filiala;

    public Carte(Long id,String titlu, String autor, String clasificare, Float pret, String filiala){
        this.id = id;
        this.titlu = titlu;
        this.autor = autor;
        this.clasificare = clasificare;
        this.pret = pret;
        this.filiala = filiala;
    }

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu (String titlu) {
        this.titlu = titlu;
    }

    public String getAutor () {
        return autor;
    }

    public void setAutor (String autor) {
        this.autor = autor;
    }

    public String getClasificare () {
        return clasificare;
    }

    public void setClasificare (String clasificare) {
        this.clasificare = clasificare;
    }

    public Float getPret () {
        return pret;
    }

    public void setPret (Float pret) {
        this.pret = pret;
    }

    public String getFiliala () {
        return filiala;
    }

    public void setFiliala (String filiala) {
        this.filiala = filiala;
    }
}

