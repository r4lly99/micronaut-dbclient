package micronaut.dbclient.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.*;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import micronaut.dbclient.model.Bicycle;
import micronaut.dbclient.service.BicycleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller("/api/v1/bicycle")
public class BicycleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BicycleController.class);
    private final BicycleService bicycleService;

    public BicycleController(BicycleService bicycleService) {
        this.bicycleService = bicycleService;
    }

    @Get()
    @Produces(MediaType.APPLICATION_JSON)
    public Flowable<Bicycle> getAllBicycle() {
        return Flowable.fromIterable(bicycleService.findAll())
                .doOnNext(bicycle -> LOGGER.info("Item in bicycle : {}", bicycle));
    }

    @Get("/{brand}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bicycle> getBikeByBrand(@PathVariable("brand") String brand) {
        return bicycleService.findByBrand(brand);
    }

    @Get("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Observable<Bicycle> getBikeByName(@PathVariable("name") String name) {
        Optional<Bicycle> optionalBicycle = Optional.ofNullable(bicycleService.findByName(name));
        if (optionalBicycle.isEmpty()){
            return Observable.empty();
        }
        return Observable.just(optionalBicycle.get());
    }

    @Post()
    @Produces(MediaType.APPLICATION_JSON)
    public Single<MutableHttpResponse<Bicycle>> saveOrUpdateBike(@Valid @Body Bicycle bicycle) {
        bicycleService.saveBike(bicycle);
        return Single.just(HttpResponse.created(bicycle));
    }

    @Delete("/{bikeName}")
    @Produces(MediaType.TEXT_PLAIN)
    public HttpResponse<String> deleteBike(@PathVariable("bikeName") String name) {
        bicycleService.deleteBike(bicycleService.findByName(name).getId());
        return HttpResponse.ok("Bicycle deleted successfully");
    }

}
