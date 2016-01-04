package week4_Max.console.commands;

public class Pwd extends Command {
    @Override
    public void run() {
        System.out.println(getFile().getAbsolutePath());
    }

    @Override
    public String help() {
        return null;
    }
}
