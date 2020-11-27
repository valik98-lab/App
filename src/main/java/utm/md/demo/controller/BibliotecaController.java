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
import org.springframework.web.bind.annotation.*;
import utm.md.demo.entity.Biblioteca;
import utm.md.demo.entity.Carte;
import utm.md.demo.repository.BibliotecaRepository;

import java.util.List;
@RestController
@RequestMapping("/biblioteca")

public class BibliotecaController {


        @Autowired
        private BibliotecaRepository bibliotecaRepository;

//GET -extragerea informatiei despre biblioteci

        @GetMapping
        public List<Biblioteca> findAll(){
            List<Biblioteca> bibliotecaList = bibliotecaRepository.findAll();
            return bibliotecaList;
        }
//GET -extragerea informatiei dupa id si numele bibliotecii
    @GetMapping("/{id}/{nume}")
    public Biblioteca  findByIdAndName(@PathVariable Long id, @PathVariable String nume) {
       Biblioteca biblioteca  = bibliotecaRepository.findByIdAndName(id,nume);
        return biblioteca;
    }

//POST-creare unei biblioteci cu nformatie noua

    @PostMapping
    public void salvare(@RequestParam Long id,
                        @RequestParam(required = false) String nume,
                        @RequestParam (required = false) String adresa,
                        @RequestParam (required = false) Long nr_angajati ,
                        @RequestParam (required = false)Long nrCarti){
        bibliotecaRepository.salvare(id,nume,adresa,nr_angajati,nrCarti);
    }

    //PUT -modificarea informatiei despre bibliotec
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Biblioteca biblioteca){
        bibliotecaRepository.update(id,biblioteca);
    }

    //DELETE-stergerea informatiei despre numarul de angajati
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long nr_angajati){
        bibliotecaRepository.delete(nr_angajati);
    }


}

