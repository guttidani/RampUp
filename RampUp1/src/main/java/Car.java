import com.google.gson.Gson;
import lombok.Builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

enum TYPE {
    sedan,
    coupe,
    cabrio
}
@Builder
public class Car {

    public static List<Car> cars = new ArrayList<>();
    public String name;
    public TYPE type;
    public int maxSpeed;
    public double engine;
    public int horsePower;

    public Car(String name, TYPE type, int maxSpeed, double engine, int horsePower) {
        this.name = name;
        this.type = type;
        this.maxSpeed = maxSpeed;
        this.engine = engine;
        this.horsePower = horsePower;
    }

    public static String listToJson(List<Car> cars) {
        Gson gson = new Gson();
        String json = gson.toJson(cars);
        return json;
    }

    public static List<Car> JsonToList(String json) {
        Gson gson = new Gson();
        Car[] carsArray = gson.fromJson(json,Car[].class);
        List<Car> carList = Arrays.asList(carsArray);
//        List<Car> cars = (List<Car>) Arrays.asList(gson.fromJson(json, Car.class));
//        gson.fromJson(json,Car.class);
        return carList;

    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", maxSpeed=" + maxSpeed +
                ", engine=" + engine +
                ", horsePower=" + horsePower +
                '}'+ "\n";
    }
}
