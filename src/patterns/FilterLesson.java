package patterns;

import java.util.ArrayList;
import java.util.List;

public class FilterLesson {
    public static void main(String[] args) {
        CarF carF1 = new CarF(150, "purple", 2);
        CarF carF2 = new CarF(130, "blue", 4);
        CarF carF3 = new CarF(105, "pink", 4);
        CarF carF4 = new CarF(285, "grey", 2);
        List<CarF> cars = new ArrayList<>();
        cars.add(carF1);
        cars.add(carF2);
        cars.add(carF3);
        cars.add(carF4);

//        cars = new SpeedFilter().filter(cars);
//        cars = new DoorsFilter().filter(cars);

//        AndFilter andFilter = new AndFilter(new SpeedFilter(), new DoorsFilter());
//        cars = andFilter.filter(cars);

        OrFilter orFilter = new OrFilter(new SpeedFilter(), new DoorsFilter());
        cars = orFilter.filter(cars);

        for (CarF car : cars) {
            System.out.println(car.getMaxSpeed());
        }
    }
}

interface CarFilter {
    List<CarF> filter(List<CarF> cars);
}

class SpeedFilter implements CarFilter {
    @Override
    public List<CarF> filter(List<CarF> cars) {
        List<CarF> list = new ArrayList<>();
        for (CarF car: cars) {
             if  (car.getMaxSpeed() < 140) {
                 list.add(car);
             }
        }

        return list;
    }
}

class DoorsFilter implements CarFilter {
    @Override
    public List<CarF> filter(List<CarF> cars) {
        List<CarF> list = new ArrayList<>();
        for (CarF car: cars) {
            if  (car.getDoors() > 2) {
                list.add(car);
            }
        }

        return list;
    }
}

class AndFilter implements CarFilter {
    CarFilter filterOne;
    CarFilter filterTwo;

    public AndFilter(CarFilter filterOne, CarFilter filterTwo) {
        this.filterOne = filterOne;
        this.filterTwo = filterTwo;
    }

    @Override
    public List<CarF> filter(List<CarF> cars) {
        List<CarF> list = filterOne.filter(cars);
        return filterTwo.filter(list);
    }
}

class OrFilter implements CarFilter {
    CarFilter filterOne;
    CarFilter filterTwo;

    public OrFilter(CarFilter filterOne, CarFilter filterTwo) {
        this.filterOne = filterOne;
        this.filterTwo = filterTwo;
    }

    @Override
    public List<CarF> filter(List<CarF> cars) {
        List<CarF> list1 = filterOne.filter(cars);
        List<CarF> list2 = filterTwo.filter(cars);

        for (CarF car : list2) {
            if (!list1.contains(car)) {
                list1.add(car);
            }
        }
        return list1;
    }
}

class CarF {
    public CarF(int maxSpeed, String color, int doors) {
        this.maxSpeed = maxSpeed;
        this.color = color;
        this.doors = doors;
    }

    private int maxSpeed;
    private String color;
    private int doors;

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }
}
