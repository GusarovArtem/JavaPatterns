package patterns;

public class TemplateLesson {
    public static void main(String[] args) {
        Game template = new Poker();
        template.run();
    }
}

abstract class Game {
    abstract void startGame();

    abstract void play();

    abstract void endGame();

    void run() {
        startGame();
        play();
        endGame();
    }
}

class Poker extends Game {
    @Override
    void startGame() {
        System.out.println("get card");
    }

    @Override
    void play() {
        System.out.println("play");
    }

    @Override
    void endGame() {
        System.out.println("loose money");
    }

}