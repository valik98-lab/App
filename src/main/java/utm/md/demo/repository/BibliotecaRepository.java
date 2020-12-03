package utm.md.demo.repository;

import utm.md.demo.entity.Biblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;



import java.util.List;
@Repository
public class BibliotecaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //GET -extragerea informatiei
    public List<Biblioteca> findAll(){
        List<Biblioteca> bibliotecaList = jdbcTemplate.query(
                "SELECT * FROM biblioteca",
                (response,rowNumber) ->
                        new Biblioteca(response.getLong("id"),
                                response.getString("nume"),
                                response.getString ("adresa"),
                                response.getLong("nr_angajati"),
                                response.getLong("nrCarti")));
        return bibliotecaList;
    }

//GET -extragerea informatiei dupa id si numele bibliotecii

    public Biblioteca findByIdAndName(Long id, String nume){
      Biblioteca biblioteca  = jdbcTemplate.queryForObject(
                "SELECT * FROM biblioteca  WHERE id= ? AND nume:",
                new Object[]{id,nume},
                (response,rowNumber) ->
                        new Biblioteca(response.getLong("id"),
                                response.getString("nume"),
                                response.getString ("adresa"),
                                response.getLong("nr_angajati"),
                                response.getLong("nrCarti")));

        return biblioteca;
    }

    //POST-creare unei biblioteci cu nformatie noua

    public void salvare (Long id, String nume, String adresa, Long nr_angajati, Long nrCarti ){
        jdbcTemplate.update("INSERT INTO (id,nume,adresa,nr_angajati,nrCarti) VALUES (?,?,?,?,?)",
                id,nume,adresa,nr_angajati,nrCarti);

    }


    //PUT -modificarea informatiei despre o biblioteca

    public void update(Long id, Biblioteca biblioteca){
        jdbcTemplate.update("UPDATE carte SET nume=?,adresa=?,nr_angajati=?,nrCarti=? WHERE id = ?",
                 biblioteca.getNume(),biblioteca.getAdresa(),biblioteca.getNr_angajati(),biblioteca.getNrCarti(),id);
    }


    //DELETE-stergerea informatiei despre numarul de anjati
    public void delete(Long nr_angajati){
        jdbcTemplate.update("DELETE FROM carte WHERE nr_angajati= ?",nr_angajati);
    }
}

