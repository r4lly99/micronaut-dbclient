package micronaut.dbclient.controller;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import micronaut.dbclient.model.Bicycle;
import micronaut.dbclient.model.BicycleType;
import micronaut.dbclient.model.builder.BicycleBuilder;
import micronaut.dbclient.service.BicycleService;
import micronaut.dbclient.service.BicycleServiceImpl;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

import static io.micronaut.http.HttpRequest.GET;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@MicronautTest
class BicycleControllerTest {

    @Inject
    @Client("/")
    RxHttpClient client;

    @Inject
    private BicycleService bicycleServiceMock;

//    @Test
//    void getAllBicycle() {
//        final Bicycle bicycleA = TestBikeWithId("54651022bffebc03098b4567", "Element", "Element Police", BicycleType.FOLDING, "white", 5, 2400.00 );
//        final Bicycle bicycleB = TestBikeWithId("54651022bffebc03098b4568", "Element", "Element Troy", BicycleType.FOLDING, "red", 5, 3400.00 );
//        final List<Bicycle> allBikes = Arrays.asList(bicycleA, bicycleB);
//
//        bicycleServiceMock = mock(BicycleServiceImpl.class);
//        when(bicycleServiceMock.findAll()).thenReturn(allBikes);
//
//        HttpResponse<String> response = client.exchange(GET("/api/v1/bicycle"), String.class).blockingFirst();
//
//        assertEquals(HttpStatus.OK, response.status());
//        assertTrue(response.getContentType().isPresent());
//        assertEquals(MediaType.APPLICATION_JSON, response.getContentType().get().toString());
//
//        assertTrue(response.getBody().isPresent());
//        String result = response.getBody().get();
//        assertEquals(2, (int) JsonPath.read(result, "$.length()"));
//        assertThrows(PathNotFoundException.class, () -> JsonPath.read(result, "$[0].id"));
//        assertEquals("Element Police", JsonPath.read(result, "$[0].name"));
//        assertEquals("Element", JsonPath.read(result, "$[0].brand"));
//        assertEquals("white", JsonPath.read(result, "$[0].colour"));
//        assertThrows(PathNotFoundException.class, () -> JsonPath.read(result, "$[1].id"));
//        assertEquals("Element Troy", JsonPath.read(result, "$[1].name"));
//        assertEquals("Element", JsonPath.read(result, "$[1].brand"));
//        assertEquals("red", JsonPath.read(result, "$[1].colour"));
//
//        verify(bicycleServiceMock, times(1)).findAll();
//        verifyNoMoreInteractions(bicycleServiceMock);

//    }

//    @Test
//    void getBikeByName() {
//    }
//
//    @Test
//    void saveOrUpdateBike() {
//    }
//
//    @Test
//    void deleteBike() {
//    }

    private Bicycle TestBikeWithId(String id, String brand, String name, BicycleType type, String colour, int gear, double price){
        return new BicycleBuilder().setId(id).setBrand(brand).setName(name).setType(type).setColour(colour).setGear(gear).setPrice(price).createBike();
    }
}