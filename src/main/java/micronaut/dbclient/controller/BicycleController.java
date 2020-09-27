package micronaut.dbclient.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import micronaut.dbclient.model.Bicycle;
import micronaut.dbclient.service.BicycleService;

import java.util.List;

@Controller("/api/v1/bicycle")
public class BicycleController {

    private final BicycleService bicycleService;

    public BicycleController(BicycleService bicycleService) {
        this.bicycleService = bicycleService;
    }

    @Get()
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bicycle> getAllBicycle() {
        return bicycleService.findAll();
    }

    @Get("/{brand}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bicycle> getBikeByName(@PathVariable("brand") String brand) {
        return bicycleService.findByBrand(brand);
    }

    @Post()
    @Produces(MediaType.TEXT_PLAIN)
    public HttpResponse<String> saveOrUpdateBike(@Body Bicycle bicycle) {
        bicycleService.saveBike(bicycle);
        return HttpResponse.ok("Bicycle added successfully");
    }

    @Delete("/{bikeName}")
    @Produces(MediaType.TEXT_PLAIN)
    public HttpResponse<String> deleteBike(@PathVariable("bikeName") String name) {
        bicycleService.deleteBike(bicycleService.findByName(name).getId());
        return HttpResponse.ok("Bicycle deleted successfully");
    }

}
