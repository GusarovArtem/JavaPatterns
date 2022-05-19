package patterns;

public class MVCLesson {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.execute();
    }
}

class Schoolboy {
    String name = "Artem";
    int age = 16;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class DBLayer implements ModelLayer {
    @Override
    public Schoolboy getSchoolboy() {
        return new Schoolboy();
    }
}

class FileSystemLayer implements ModelLayer {
    @Override
    public Schoolboy getSchoolboy() {
        return new Schoolboy();
    }
}

interface ModelLayer {
    Schoolboy getSchoolboy();
}

interface View {
    void showSchoolBoy(Schoolboy schoolboy);
}

class ConsoleView implements View {
    @Override
    public void showSchoolBoy(Schoolboy schoolboy) {
        System.out.println("Schoolboy name: " + schoolboy.getName() +".\nAge: " + schoolboy.age + ".");
    }
}

class HtmlView implements View {
    @Override
    public void showSchoolBoy(Schoolboy schoolboy) {
        System.out.println("<html><body>Schoolboy name: " + schoolboy.getName() +".\nAge: " + schoolboy.age + ".</html></body>");
    }
}


class Controller {
    ModelLayer modelLayer = new DBLayer();
    View view = new ConsoleView();

    void execute() {
        Schoolboy schoolboy = modelLayer.getSchoolboy();
        view.showSchoolBoy(schoolboy);
    }
}

