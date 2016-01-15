package console.view;

import console.model.CurrentState;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Dima on 13.01.2016.
 */
public class WindowView extends JFrame implements IView, Runnable{
    private CurrentState currentState;
    protected String greetings = "Hello, this is the best ever command line console application. The MS-Dos and Bash console are only the childs, realy, men!\n";

    public WindowView(CurrentState currentState) {
        this.currentState = currentState;
        initView();
    }

    @Override
    public void initView() {
        setTitle("Command 10");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        JPanel consoleOut = new JPanel();
        consoleOut.setLayout(new BorderLayout(1,1));
        JScrollPane commandsOutput = new JScrollPane(new JTextArea(greetings));
        commandsOutput.createVerticalScrollBar();
        consoleOut.add(commandsOutput, BorderLayout.CENTER);

        JPanel consoleIn = new JPanel();
        consoleIn.setLayout(new BorderLayout(1,1));

        JTextField userInput = new JTextField();
        consoleIn.add(userInput);

        userInput.setText("D:\\Temp\\");
        userInput.setCaretPosition(userInput.getText().length());

        getContentPane().add(consoleOut);
        getContentPane().add(consoleIn,BorderLayout.SOUTH);

        setVisible(true);

        userInput.requestFocusInWindow();
    }

    @Override
    public String view(String ... str) {
        return null;
    }

    @Override
    public void showOutput(String... str) {

    }

    @Override
    public String readUserInput() {
        return null;
    }

    @Override
    public void run() {

    }

}
