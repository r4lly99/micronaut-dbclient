package micronaut.dbclient.service;

import io.micronaut.transaction.annotation.ReadOnly;
import micronaut.dbclient.model.Bicycle;
import micronaut.dbclient.repository.BicycleRepository;
import org.bson.types.ObjectId;

import javax.inject.Singleton;
import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Singleton
public class BicycleServiceImpl implements BicycleService {

    private final BicycleRepository bicycleRepository;

    public BicycleServiceImpl(BicycleRepository bicycleRepository) {
        this.bicycleRepository = bicycleRepository;
    }

    @Override
    @ReadOnly
    public List<Bicycle> findAll() {
        return bicycleRepository.findAll().blockingGet();
    }

    @Override
    @ReadOnly
    public List<Bicycle> findByBrand(@NotEmpty String brand) {
        return bicycleRepository.findByBrand(brand).blockingGet();
    }

    @Override
    public Bicycle findByName(@NotEmpty String name) {
        return bicycleRepository.findByName(name).blockingGet();
    }

    @Override
    @Transactional
    public void saveBike(@NotNull Bicycle bicycle) {
        bicycleRepository.create(bicycle).blockingGet();
    }

    @Override
    public void updateBike(@NotNull Bicycle bicycle) {
        bicycleRepository.update(bicycle).blockingGet();
    }

    @Override
    public void deleteBike(@NotEmpty ObjectId id) {
        bicycleRepository.delete(id).blockingGet();
    }
}
