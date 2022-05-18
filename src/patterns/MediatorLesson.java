package patterns;

import java.util.ArrayList;
import java.util.List;

public class MediatorLesson {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        mediator.add(new ConcreteColleague(mediator, "one"));
        mediator.add(new ConcreteColleague(mediator, "two"));
        ConcreteColleague concreteColleague = new ConcreteColleague(mediator, "three");
        mediator.add(concreteColleague);
        concreteColleague.changeStatus();
    }
}

interface Mediator {
    void requestAll(Colleague colleague);
}

class ConcreteMediator implements Mediator {
    List<Colleague> colleagues = new ArrayList<>();

    void add(Colleague colleague) {
        colleagues.add(colleague);
    }

    @Override
    public void requestAll(Colleague colleague) {
        colleague.setTrue();
        for (Colleague coll : colleagues) {
            if (coll != colleague) {
                coll.setFalse();
            }
        }
    }
}

interface Colleague {
    void setFalse();
    void setTrue();
    void changeStatus();
}

class ConcreteColleague implements Colleague {
    boolean status;
    Mediator mediator;
    String name;

    public ConcreteColleague(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    @Override
    public void setFalse() {
        status = false;
        System.out.println(name + " status is False");
    }

    @Override
    public void setTrue() {
        status = true;
        System.out.println(name + " status is True");
    }

    @Override
    public void changeStatus() {
        mediator.requestAll(this);
    }
}
