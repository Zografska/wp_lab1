package mk.finki.ukim.mk.wp.lab.repository.inmemory;

import mk.finki.ukim.mk.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.wp.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ManufactorerRepository {
    public List<Manufacturer> findAll(){
        return DataHolder.manufacturerList;
    }
    public Optional<Manufacturer> findById(Long id)
    {
        return DataHolder.manufacturerList.stream().filter(manufacturer -> manufacturer.getId().equals(id)).findFirst();
    }
}