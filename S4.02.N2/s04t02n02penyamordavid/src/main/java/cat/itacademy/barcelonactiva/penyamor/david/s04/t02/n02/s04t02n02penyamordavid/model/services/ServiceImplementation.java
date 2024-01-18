package cat.itacademy.barcelonactiva.penyamor.david.s04.t02.n02.s04t02n02penyamordavid.model.services;

import java.util.Optional;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.penyamor.david.s04.t02.n02.s04t02n02penyamordavid.model.domain.Fruit;
import cat.itacademy.barcelonactiva.penyamor.david.s04.t02.n02.s04t02n02penyamordavid.model.repository.FruitRepository;


@Service
public class ServiceImplementation implements FruitServices {

    @Autowired
    private FruitRepository fruitRepository;

    public Fruit addFruit(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    public void updateFruit(Fruit fruit) {
        fruitRepository.save(fruit);
    }

    public void deleteFruit(long id) {
        fruitRepository.deleteById(id);
    }

    public Fruit getOne(long id) {
        Optional<Fruit> fruit = fruitRepository.findById(id);
        return fruit.orElseThrow();
    }

    public List<Fruit> getAll() {
        return fruitRepository.findAll();
    }
}
