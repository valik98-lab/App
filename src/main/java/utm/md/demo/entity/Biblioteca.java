package utm.md.demo.entity;

public class Biblioteca {
        private Long id;
        private String nume;
        private String adresa;
        private Long nr_angajati;
        private Long  nrCarti;


        public Biblioteca (Long id,String nume, String adresa, Long nr_angajati, Long nrCarti){
            this.id = id;
            this.nume = nume;
            this.adresa = adresa;
            this.nr_angajati = nr_angajati;
            this.nrCarti = nrCarti;

        }

        public Long getId () {
            return id;
        }

        public void setId (Long id) {
            this.id = id;
        }

        public String  getNume () {
        return nume;
        }

        public void setNume (String nume) {
        this.nume = nume;
        }

        public String  getAdresa () {
        return adresa;
        }

        public void setAdresa (String adresa) {
        this.adresa = adresa;
        }

        public Long getNr_angajati () {
        return nr_angajati;
        }

        public void setNr_angajati (Long nr_angajati) {
        this.nr_angajati= nr_angajati;
        }

        public Long getNrCarti () {
        return nrCarti;
        }
        public void setNrCarti (Long nrCarti) {
        this.nrCarti = nrCarti;
        }
}
