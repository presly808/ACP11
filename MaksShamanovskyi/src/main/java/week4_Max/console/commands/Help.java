package week4_Max.console.commands;

public class Help extends Command {

    public Help(){
    }

    public Help(Command com) {
        System.out.println(com.help());
    }

    @Override
    public void run() {
    }

    @Override
    public String help() {
        return null;
    }
}
