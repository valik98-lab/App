package utm.md.demo.repository;

import utm.md.demo.entity.Carte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Repository
public class CarteRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //GET -extragerea informatiei
    public List<Carte> findAll(){
        List<Carte> carteList = jdbcTemplate.query(
                "SELECT * FROM carte",
                (response,rowNumber) ->
                        new Carte(response.getLong("id"),
                                response.getString("titlu"),
                                response.getString ("autor"),
                                response.getString("clasificare"),
                                response.getFloat("pret"),
                                response.getString("filiala")));
        return carteList;
    }
    public List<Carte> findAllByAutor(String autor){
        List<Carte> carteList = jdbcTemplate.query(
                "SELECT * FROM carte WHERE autor:",
                new Object[]{autor},
                (response,rowNumber) ->
                        new Carte(response.getLong("id"),
                                response.getString("titlu"),
                                response.getString ("autor"),
                                response.getString("clasificare"),
                                response.getFloat("pret"),
                                response.getString("filiala")));

        return carteList;
    }

    public Carte findById(Long id){
       Carte carte = jdbcTemplate.queryForObject(
                "SELECT * FROM carte WHERE id= ?",
                new Object[]{id},
                (response,rowNumber) ->
                        new Carte(response.getLong("id"),
                                response.getString("titlu"),
                                response.getString ("autor"),
                                response.getString("clasificare"),
                                response.getFloat("pret"),
                                response.getString("filiala")));

       return carte;
    }

    public Carte findByIdAndFiliala(Long id,String filiala){
        Carte carte = jdbcTemplate.queryForObject(
                "SELECT * FROM carte WHERE id= ? AND filiala:",
                new Object[]{id,filiala},
                (response,rowNumber) ->
                        new Carte(response.getLong("id"),
                                response.getString("titlu"),
                                response.getString ("autor"),
                                response.getString("clasificare"),
                                response.getFloat("pret"),
                                response.getString("filiala")));

        return carte;
    }
   //POST-creare informatiei
    public void salvare (String titlu, String autor, String clasificare, Float pret, String filiala ){
        jdbcTemplate.update("INSERT INTO (titlu,autor,clasificare,pret,filiala) VALUES (?,?,?,?,?)",
                titlu,autor,clasificare, pret, filiala);

    }

    public void salvare (Carte carte){
        jdbcTemplate.update("INSERT INTO carte(titlu,autor,clasificare,pret,filiala) VALUES (?,?,?,?,?)",
                carte.getTitlu(),carte.getAutor(),carte.getClasificare(), carte.getPret(), carte.getFiliala());

    }

    //PUT -modificarea informatiei

    public void update(Long id,Carte carte){
        jdbcTemplate.update("UPDATE carte SET titlu=?, autor=?,clasificare=?, pret=?,filiala=?",
                carte.getTitlu(),carte.getAutor(),carte.getClasificare(), carte.getPret(), carte.getFiliala(),id);
    }



    //DELETE-stergerea informatiei
    public void delete(Long id){
        jdbcTemplate.update("DELETE FROM carte WHERE id = ?",id);
    }
}

