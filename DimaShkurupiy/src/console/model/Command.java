package console.model;

/**
 * Created by Шкурупий on 08.01.2016.
 */
public abstract class Command {
    protected String name;
    private String[] parameters;
    private String[] allowedParameters;
    protected CurrentState currentState;
    protected String help;

    protected Command() {}

    public Command(CurrentState currentState) {
        this.currentState = currentState;
    }

    public String getName() {
        return name;
    }

    public String getHelp() {
        return help;
    }

    public void testReflCall() {
        System.out.println("name " + name);
    }
}
