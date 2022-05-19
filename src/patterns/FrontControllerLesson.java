package patterns;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class FrontControllerLesson {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNext()) {
                String nextLine = scanner.nextLine();
                new Thread() {
                    @Override
                    public void run() {
                        new DispatcherServlet().process(nextLine);
                    }
                }.start();

            }
        }
    }
}

class DispatcherServlet {
    void process(String url) {
        switch (url) {
            case "home" : new HomeController().show(); break;
            case "user" : new UserController().show(); break;
            default: new DefaultController().show();
        }
    }
}

interface ShowPage {
    void show();
}

class HomeController implements ShowPage {
    @Override
    public void show() {
        System.out.println("Home Page");
    }
}

class UserController implements ShowPage{
    @Override
    public void show() {
        System.out.println("User Page");
    }
}

class DefaultController implements  ShowPage{
    @Override
    public void show() {
        System.out.println("Error");
    }
}
