package console.controller;

import console.model.Command;
import console.model.CurrentState;
import console.model.UserOrder;
import console.utils.ReflectionUtils;
import console.utils.StrCmdParser;
import console.view.IView;
import console.view.WindowView;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Шкурупий on 08.01.2016.
 */
public class Controller {
    private CurrentState currentState;
    private IView view;
    //private Command currentCommand;
    CopyOnWriteArrayList<String> commandResults = new CopyOnWriteArrayList<String>();

    public Controller() throws Exception {
        this.currentState = new CurrentState();
//        this.view = new ConsoleView(this.currentState);
        this.view = new WindowView(this.currentState);
        view.view(); //de facto == start producer of userCommand
        // can start here any other produsers of userCommand (for example - from net port listener - other users throw terminal can sends own commands
        askCommand();
    }

    public void askCommand(String ... previosReturnedResultsToShow) {
        final String[] userCommand = {""};

        Thread consumer = new Thread("GET_USER_COMMAND") {
            public void run() {
                userCommand[0] = currentState.getUserCommand();
            }
        };
        consumer.start();

        ///

        try {
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //ArrayList<String> commandResults = new ArrayList<>();
        //List<String> commandResults = Collections.synchronizedList(new ArrayList<String>());
        //CopyOnWriteArrayList<String> commandResults = new CopyOnWriteArrayList<String>();

        StrCmdParser parser = new StrCmdParser();
        ArrayList<UserOrder> userOrders = parser.parserStrCmd(userCommand[0]);

        for (int i = 0; i < userOrders.size(); i++) {
            String commandName = userOrders.get(i).getuOrder();
            Command currentCommand = findCommandByName(commandName);
            String[] currentArgs = userOrders.get(i).getuArgs();
 //                commandResults.add((String) ReflectionUtils.callMethod(currentCommand, "doExec", commandName, userOrders.get(i).getuArgs()));
            Thread threadForCommand = new Thread("Command") {
                public void run() {
                    try {
                        commandResults.add((String) ReflectionUtils.callMethod(currentCommand, "doExec", commandName, currentArgs));
                        //System.out.println((String) ReflectionUtils.callMethod(currentCommand, "doExec", commandName, currentArgs));
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                }
            };
            threadForCommand.start();
        }

        ArrayList<String> arrStr = new ArrayList<>();
            Iterator<String> iterator = commandResults.iterator();
            while (iterator.hasNext()) {
                arrStr.add(iterator.next());
            }
            commandResults = new CopyOnWriteArrayList<String>();
// TODO Разобраться как передавать результаты выплонения правильно. Сейчас я пытаюсь брать результаты раньше, чем они там появляются. продюсер-консюмер?
        String[] returnedResultsToShow = arrStr.toArray(new String[arrStr.size()]);
        view.write(returnedResultsToShow);
        askCommand();
    }

    private Command findCommandByName(String needleName) {
        for (Command c : this.currentState.getCommands() ) {
            if ( c.getName().equals( needleName.toLowerCase() ) ) {
                return c;
            }
        }
        return findCommandByName("cmd");
    }

}
