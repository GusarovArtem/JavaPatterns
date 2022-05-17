package patterns;

public class AbstractFactoryLesson {
    public static void main(String[] args) {
        Factory milkFactory = new AbstractFactory().createFactory("Milk");
        Factory bakeryFactory = new AbstractFactory().createFactory("Bakery");
        Product milk = milkFactory.create("Milk");
        Product cheese = milkFactory.create("Cheese");
        milk.taste();
        cheese.taste();

        Product bread = bakeryFactory.create("Bread");
        Product cake = bakeryFactory.create("Cake");
        bread.taste();
        cake.taste();
    }
}

interface Product {
    void taste();
}

class Milk implements Product {
    @Override
    public void taste() {
        System.out.println("ммм, молочко)");
    }
}

class Cheese implements Product {
    @Override
    public void taste() {
        System.out.println("ммм, сырочек)");
    }
}


class MilkFactory implements Factory {
    public Product create (String typeOfProduct) {
        switch (typeOfProduct) {
            case ("Milk") : return new Milk();
            case ("Cheese") : return new Cheese();
            default: return null;
        }
    }
}

class Cake implements Product {
    @Override
    public void taste() {
        System.out.println("ммм, тортик)");
    }
}

class Bread implements Product {
    @Override
    public void taste() {
        System.out.println("ммм, хлебушек)");
    }
}


class BakeryFactory implements Factory {
    public Product create (String typeOfProduct) {
        switch (typeOfProduct) {
            case ("Bread") : return new Bread();
            case ("Cake") : return new Cake();
            default: return null;
        }
    }
}

interface Factory {
    Product create(String typeOfProduct);
}

class AbstractFactory {
    Factory createFactory(String typeOfFactory) {
        switch (typeOfFactory) {
            case "Milk" : return new MilkFactory();
            case "Bakery" : return new BakeryFactory();
            default: return null;
        }
    }
}