package console.model;

/**
 * Created by Шкурупий on 08.01.2016.
 */
public abstract class Command {
    protected String name;
    private String[] parameters;
    private String[] allowedParameters;

    public Command() {
    }

    public String help() {
        String helpString = "";
        return helpString;
    }

    public String getName() {
        return name;
    }

    public void testReflCall() {
        System.out.println("name " + name);
    }
}
