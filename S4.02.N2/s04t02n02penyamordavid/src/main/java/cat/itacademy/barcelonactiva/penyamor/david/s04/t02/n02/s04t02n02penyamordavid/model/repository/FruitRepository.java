package cat.itacademy.barcelonactiva.penyamor.david.s04.t02.n02.s04t02n02penyamordavid.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cat.itacademy.barcelonactiva.penyamor.david.s04.t02.n02.s04t02n02penyamordavid.model.domain.Fruit;

public interface FruitRepository extends JpaRepository<Fruit, Long> {
    
}