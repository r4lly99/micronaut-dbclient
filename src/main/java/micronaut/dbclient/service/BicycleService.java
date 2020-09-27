package micronaut.dbclient.service;

import micronaut.dbclient.model.Bicycle;
import org.bson.types.ObjectId;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface BicycleService {

    List<Bicycle> findAll();

    List<Bicycle> findByBrand(@NotEmpty String brand);

    Bicycle findByName(@NotEmpty String name);

    void saveBike(@NotNull Bicycle bicycle);

    void updateBike(@NotNull Bicycle bicycle);

    void deleteBike(@NotEmpty ObjectId id);

}
