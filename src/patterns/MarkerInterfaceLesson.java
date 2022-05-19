package patterns;

public class MarkerInterfaceLesson {
    public static void main(String[] args) {
        Person artem = new Person();
        if (artem instanceof ThemeParkBand) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}

interface ThemeParkBand {

}

class Person implements ThemeParkBand {

}