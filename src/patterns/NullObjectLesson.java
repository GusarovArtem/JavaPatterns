package patterns;

import java.io.FileNotFoundException;

//Борьба с NPE
public class NullObjectLesson {
    public static void main(String[] args) {
        Animal animal = getAnimal();
        animal.eat();
    }

    static Animal getAnimal() {
        try {
//            if (new File("nosuchfile.txt").exists()) {
//                return new Lion();
//            }
        } finally {
            return new NoAnimal();
        }
    }
}

interface Animal {
    void eat();
}

class Lion implements Animal {
    @Override
    public void eat() {
        System.out.println("Lion eat");
    }
}

class NoAnimal implements Animal {
    public void eat() { }
}
