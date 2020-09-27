package micronaut.dbclient.repository;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import micronaut.dbclient.model.Bicycle;
import org.bson.types.ObjectId;

import javax.inject.Singleton;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

@Singleton
public class BicycleRepositoryImpl implements BicycleRepository{

    private final MongoClient mongoClient;

    public BicycleRepositoryImpl(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @Override
    public Single<Bicycle> create(@NotNull Bicycle bicycle) {
        return Single.fromPublisher(
                getCollection().insertOne(bicycle)
        ).map(success -> bicycle);
    }

    @Override
    public Single<List<Bicycle>> findAll() {
        return Flowable.fromPublisher(
                getCollection().find()
        ).toList();
    }

    @Override
    public Maybe<Bicycle> findByName(@NotEmpty String name) {
        return Flowable.fromPublisher(
                getCollection().find(eq("name", name))
        ).firstElement();
    }

    @Override
    public Single<List<Bicycle>> findByBrand(@NotEmpty String brand) {
        return Flowable.fromPublisher(
                getCollection()
                        .find(eq("brand", brand))
        ).toList();
    }

    @Override
    public Single<Bicycle> update(@NotNull Bicycle bicycle) {
        return Single.fromPublisher(
                getCollection().findOneAndReplace(eq("id", bicycle.getId()), bicycle)
        ).map(success -> bicycle);

    }

    @Override
    public Maybe<Bicycle> delete(@NotNull ObjectId id) {
        return Flowable.fromPublisher(
                getCollection()
                        .findOneAndDelete(eq("_id", id))
        ).firstElement();
    }

    private MongoCollection<Bicycle> getCollection() {
        return mongoClient
                .getDatabase("micronaut")
                .getCollection("bicycle", Bicycle.class);
    }

}
