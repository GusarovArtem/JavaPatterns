package patterns;

import java.util.HashMap;
import java.util.Map;

public class FlyWeightLesson {
    public static void main(String[] args) {
        FlyWeightGarage flyWeightGarage = new FlyWeightGarage();

        Mercedes mercedes = flyWeightGarage.getMercedes("green");
        Mercedes mercedes2 = flyWeightGarage.getMercedes("green");

        System.out.println(mercedes.color);
    }
}

class Mercedes {
    String color;
}

class FlyWeightGarage {
    Map<String, Mercedes> map = new HashMap<>();
    Mercedes getMercedes(String color) {
        Mercedes mercedes = map.get(color);

        if (mercedes == null) {
            mercedes = new Mercedes();
            mercedes.color = color;
            map.put(color, mercedes);
        }
        return mercedes;
    }
}