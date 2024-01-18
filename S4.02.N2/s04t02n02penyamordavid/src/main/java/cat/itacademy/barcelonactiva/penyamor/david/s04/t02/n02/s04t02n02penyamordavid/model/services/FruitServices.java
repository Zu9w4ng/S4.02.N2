package cat.itacademy.barcelonactiva.penyamor.david.s04.t02.n02.s04t02n02penyamordavid.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.penyamor.david.s04.t02.n02.s04t02n02penyamordavid.model.domain.Fruit;

public interface FruitServices {

    public Fruit addFruit(Fruit fruit);

    public void updateFruit(Fruit fruit);

    public void deleteFruit(long id);

    public Fruit getOne(long id);

    public List<Fruit> getAll();

}
