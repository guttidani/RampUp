import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestData {

    public static List<Car> carsList = new ArrayList<>(Arrays.asList(
            Car.builder()
                    .name("Audi")
                    .type(TYPE.sedan)
                    .maxSpeed(250)
                    .engine(1.8)
                    .horsePower(150)
                    .build(),
            Car.builder()
                    .name("BMW")
                    .type(TYPE.cabrio)
                    .maxSpeed(280)
                    .engine(3)
                    .horsePower(230)
                    .build(),
            Car.builder()
                    .name("Dacia")
                    .type(TYPE.sedan)
                    .maxSpeed(200)
                    .engine(1.2)
                    .horsePower(90)
                    .build(),
            Car.builder()
                    .name("Lada")
                    .type(TYPE.sedan)
                    .maxSpeed(160)
                    .engine(1.6)
                    .horsePower(90)
                    .build(),
            Car.builder()
                    .name("Ferrari")
                    .type(TYPE.coupe)
                    .maxSpeed(300)
                    .engine(4)
                    .horsePower(350)
                    .build(),
            Car.builder()
                    .name("Opel")
                    .type(TYPE.coupe)
                    .maxSpeed(250)
                    .engine(2)
                    .horsePower(180)
                    .build(),
            Car.builder()
                    .name("Renault")
                    .type(TYPE.sedan)
                    .maxSpeed(200)
                    .engine(1.4)
                    .horsePower(140)
                    .build()
    ));

    public static List<Car> getCarsList() {
        return carsList;
    }

    public static void carsToJson(){
        String jsonCars = Car.listToJson(getCarsList());
        JsonParser.writeJsonToFile(jsonCars,"./cars.json");
    }

    public static List<Car> jsonToList(){

        return Car.JsonToList(JsonParser.ReadJsonFromFile("./cars.json"));
    }
}
