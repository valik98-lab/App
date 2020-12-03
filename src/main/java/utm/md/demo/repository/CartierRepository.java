package utm.md.demo.repository;

import utm.md.demo.entity.Cartier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.List;

@Repository
public class CartierRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

//GET -extragerea informatiei
    public List<Cartier> findAll(){
        List<Cartier> cartierList = jdbcTemplate.query(
                "SELECT * FROM cartier",
                (response,rowNumber) ->
                        new Cartier(response.getString("denumire"),
                                response.getLong("populatie"),
                                response.getLong("institutii_publice")));
        return cartierList;
    }
//GET -extragerea informatiei dupa denumirea cartierului
     public Cartier findByDenumire(String denumire){
        Cartier cartier  = jdbcTemplate.queryForObject(
                "SELECT * FROM cartier WHERE denumire= ?",
                new Object[]{denumire},
                (response,rowNumber) ->
                        new Cartier(response.getString("denumire"),
                                response.getLong("populatie"),
                                response.getLong("institutii_publice")));

        return cartier;
    }

    //POST-creare informatiei
    public void salvare (Cartier cartier ){
        jdbcTemplate.update("INSERT INTO cartier(denumire, populatie, institutii_publice) VALUES (?,?,?)",
                cartier.getDenumire(),cartier.getPopulatie(),cartier.getInstitutii_publice());

    }

    //PUT -modificarea informatiei despre numarul populatiei

    public void update(Long populatie,Cartier cartier ){
        jdbcTemplate.update("UPDATE carte SET denumire=?, populatie=?,institutii_publice=? WHERE populatie = ?",
                cartier.getDenumire(),cartier.getPopulatie(),cartier.getInstitutii_publice(),populatie );
    }

    //DELETE-stergerea informatiei despre un cartier cu un anumit numar de institutii publice

    public void delete(Long institutii_publice){
        jdbcTemplate.update("DELETE FROM carte WHERE institutii_publice  = ?",institutii_publice);
    }
}