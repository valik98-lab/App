package utm.md.demo.controller;


import utm.md.demo.entity.Carte;
import utm.md.demo.repository.CarteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;
@RestController
@RequestMapping("/carte")

public class CarteController {

    @Autowired
    private CarteRepository carteRepository;

//GET -extragerea informatiei despre toate cartile

@GetMapping
    public List<Carte>findAll(){
       List<Carte> carteList = carteRepository.findAll();
        return carteList;
    }

//GET -extragerea informatiei dupa autorul specificat

    @GetMapping("/autor/{autor}")
    public List<Carte> findAllByAutor(@PathVariable String autor) {
         List<Carte> carteList = carteRepository.findAllByAutor(autor);
        return carteList;
    }

//GET -extragerea informatiei dupa id specificat

    @GetMapping("/{id}")
    public Carte findById(@PathVariable Long id) {
    Carte carte = carteRepository.findById(id);
      return carte;
    }

//GET -extragerea informatiei dupa id si filiala specificata

    @GetMapping("/{id}/{filiala}")
    public Carte findByIdAndFiliala(@PathVariable Long id,@PathVariable String filiala) {
        Carte carte = carteRepository.findByIdAndFiliala(id,filiala);
        return carte;
    }

    //POST-creare informatiei

    @PostMapping
    public void salvare(@RequestParam String titlu,
                        @RequestParam(required = false) String autor,
                        @RequestParam (required = false) String clasificare,
                        @RequestParam (required = false) Float pret,
                        @RequestParam (required = false) String filiala){
        carteRepository.salvare(titlu,autor,clasificare ,pret,filiala);
    }
/*
    @PostMapping
        public void salvare(@RequestBody Carte carte){
        carteRepository.salvare(carte);
    }*/
//path ->/carte/{id}/{titlu}
// query -> /carte?id=2$titlu:
// body -> /carte {"titlu:" "titlui dorit", "autor" "autorul cartii"...}

    //PUT -modificarea informatiei

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Carte carte) {
    carteRepository.update(id,carte);
    }

    //DELETE-stergerea informatiei
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        carteRepository.delete(id);
    }
}
