import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class Tests {

    private static List<Car> cars;

    @Before
    public void setup() {
        cars = TestData.jsonToList();
        System.out.println("setup method");
    }


    @Test
    public void Test1() {

        int maxHP = 0;
        Gson gson = new Gson();

        for (Car car : cars) {
            if (car.horsePower > maxHP) {
                maxHP = car.horsePower;
                System.out.println(gson.toJson(car));

                System.out.println("---------");
            }
        }

        log.info("maxHorsePower: " + maxHP + "limit: 350");
        Assert.assertEquals(350, maxHP);
    }

    @Test
    public void Test2() throws Exception {

        //simple foreach
        List<Car> sedans1 = new ArrayList<>();
        for (Car car : cars) {
            if (car.type == TYPE.sedan) {
                sedans1.add(car);
                throw new Exception();
            }
        }

        //fluent foreach
        List<Car> sedans4 = new ArrayList<>();
        cars.forEach(car -> {
            if (car.type == TYPE.sedan){
                sedans4.add(car);
            }
        });


        //stream api collect
        List<Car> sedans2 = cars.stream()
                .filter(c -> c.type == TYPE.sedan)
                .collect(Collectors.toList());

        //stream api foreach
        List<Car> sedans3 = new ArrayList<>();
        cars.stream()
                .filter(c -> c.type == TYPE.sedan)
                .forEach(sedans3::add);

        Assert.assertEquals(4, sedans2.size());
    }

    @Test
    public void Test3() {

        List<Car> nagyMotorok = new ArrayList<>();
        List<Car> nagyMotorok1 = new ArrayList<>();

        //fluent
        cars.forEach(car -> {
            if (car.engine > 1.6) {
                nagyMotorok1.add(car);

            }});

        for (Car car : cars) {
            if (car.engine > 1.6) {
                nagyMotorok.add(car);
            }
        }

        for (Car car : nagyMotorok) {
            Assert.assertEquals(true, car.engine >= 1.8);
        }

        for (Car car : nagyMotorok1) {
            Assert.assertEquals(true, car.engine >= 1.8);
        }
    }

    @Test
    public void writing() {
        TestData.carsToJson();
    }

    @Test
    public void readingValidation() {

//        List<Car> carss = Car.JsonToList(JsonParser.ReadJsonFromFile("./cars.json"));

//        for (Car car : carss) {
//            if (car != null) {
//                System.out.println(car.toString());
//            }
//        }

        System.out.println("-----");
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}

