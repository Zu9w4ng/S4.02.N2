package cat.itacademy.barcelonactiva.penyamor.david.s04.t02.n02.s04t02n02penyamordavid.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.penyamor.david.s04.t02.n02.s04t02n02penyamordavid.model.domain.Fruit;
import cat.itacademy.barcelonactiva.penyamor.david.s04.t02.n02.s04t02n02penyamordavid.model.services.ServiceImplementation;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping(value = "/api/v1/fruit")
public class FruitController {

    @Autowired
    private ServiceImplementation serviceImplementation;

    @PostMapping(value = "/add")
    public ResponseEntity<String> createFruit(@RequestBody Fruit fruit) {
        try {
            serviceImplementation.addFruit(fruit);
            return new ResponseEntity<>("fruit successfully added", HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteFruitById(@PathVariable("id") Long id) {
        try {
            serviceImplementation.deleteFruit(id);
            return new ResponseEntity<>("fruit deleted successfully", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/getAll")
    public List<Fruit> getAllFruits() {
        return serviceImplementation.getAll();
    }

    @GetMapping("/getOne/{id}")
    public Fruit findFruitById(@PathVariable("id") Long id) {
        return serviceImplementation.getOne(id);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateFruitById(@PathVariable("id") long id, @RequestBody Fruit newFruit){
        Fruit fruit = serviceImplementation.getOne(id);

        if (newFruit != null) {
            fruit.setName(newFruit.getName());
            fruit.setKilograms(newFruit.getKilograms());
            serviceImplementation.updateFruit(fruit);
            return new ResponseEntity<>("fruit updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("no changes done", HttpStatus.OK);
        
    }
}