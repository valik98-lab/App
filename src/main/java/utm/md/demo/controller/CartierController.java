package utm.md.demo.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;
import utm.md.demo.entity.Cartier;
import utm.md.demo.repository.CartierRepository;

import java.util.List;
@RestController
@RequestMapping("/cartier")

public class CartierController {


    @Autowired
    private CartierRepository cartierRepository;

//GET -extragerea informatiei despre cartiere

    @GetMapping
    public List<Cartier> findAll(){
        List<Cartier> bibliotecaList = cartierRepository.findAll();
        return bibliotecaList;
    }

    @GetMapping("/{denumire}")
    public Cartier findById(@PathVariable String denumire) {
        Cartier cartier = cartierRepository.findByDenumire(denumire);
        return cartier;
    }

    //POST-creare unui cartier nou

    @PostMapping
    public void salvare(@RequestBody Cartier cartier){
        cartierRepository.salvare(cartier);
    }
    //PUT -modificarea informatiei despre populatia cartierului

    @PutMapping("/{populatie}")
    public void update(@PathVariable Long populatie, @RequestBody Cartier cartier) {
        cartierRepository.update(populatie,cartier);
    }

    //DELETE-stergerea informatiei despre un cartier cu un anumit numari de institutii publice
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long institutii_publice){
        cartierRepository.delete(institutii_publice);
    }
}
