package micronaut.dbclient.repository;

import io.reactivex.Maybe;
import io.reactivex.Single;
import micronaut.dbclient.model.Bicycle;
import org.bson.types.ObjectId;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface BicycleRepository {

    Single<Bicycle> create(@NotNull Bicycle bicycle);

    Single<List<Bicycle>> findAll();

    Maybe<Bicycle> findByName(@NotEmpty String name);

    Single<List<Bicycle>> findByBrand(@NotEmpty String brand);

    Single<Bicycle> update(@NotNull Bicycle bicycle);

    Maybe<Bicycle> delete(@NotNull ObjectId id);

}
