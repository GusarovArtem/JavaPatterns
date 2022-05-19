package patterns;

public class VisitorLesson {
    public static void main(String[] args) {
        Pet dog = new Dog();
        dog.doJob(new ConcreteVisitor());

        Pet cat = new Cat();
        cat.doJob(new ConcreteVisitor());
    }
}

interface Pet {
    void doJob(Visitor visitor);
}

class Dog implements Pet {
    @Override
    public void doJob(Visitor visitor) {
        visitor.doDog();
    }
}

class Cat implements Pet {
    @Override
    public void doJob(Visitor visitor) {
        visitor.doCat();
    }
}

interface Visitor {
    void doDog();
    void doCat();
}

class ConcreteVisitor implements Visitor {
    @Override
    public void doDog() {
        System.out.println("haw-haw");
    }

    @Override
    public void doCat() {
        System.out.println("may-may");
    }
}


