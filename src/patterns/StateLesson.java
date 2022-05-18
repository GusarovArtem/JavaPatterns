package patterns;

public class StateLesson {
    public static void main(String[] args) {
        Context context = new Context(new LowerCadeState(), "Max");
        context.doAction();
        context.setState(new UpperCadeState());
        context.doAction();
    }
}

interface State {
    void doAction(Context context);
}

class LowerCadeState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println(context.name.toLowerCase());
    }
}

class UpperCadeState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println(context.name.toUpperCase());
    }
}

class Context {
    State state;
    String name;

    public Context(State state, String name) {
        this.state = state;
        this.name = name;
    }

    public void setState(State state) {
        this.state = state;
    }

    void doAction() {
        state.doAction(this);
    }
}
