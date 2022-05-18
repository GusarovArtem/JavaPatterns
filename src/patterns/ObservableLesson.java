package patterns;

import java.util.ArrayList;
import java.util.List;

public class ObservableLesson {
    public static void main(String[] args) {
        Observer observer1 = new Observer("one");
        Observer observer2 = new Observer("two");
        observer1.setState("new state");
        observer2.setState("hello");
    }
}

interface Observable {
    void update();
}

class Observer implements Observable{
    List<Observer> observers = new ArrayList<>();
    String name;
    String state;

    public Observer(String name) {
        this.name = name;
        observers.add(this);
    }

    public void setState(String state) {
        this.state = state;
        notifyAllObservers();
    }

    void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
    @Override
    public void update() {
        System.out.println(name + " change status: " + state + ".");
    }
}
