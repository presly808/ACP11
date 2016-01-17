package console.view;

import console.model.CurrentState;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Dima on 13.01.2016.
 */
public class WindowView extends JFrame implements IView, Runnable{
    private CurrentState currentState;
    protected String greetings = "Hello, this is the best ever command line console application. The MS-Dos and Bash console are only the childs, realy, men!\n";

    JTextField userInput = new JTextField();
    JTextArea consoleWorkFlow;

    public WindowView(CurrentState currentState) {
        this.currentState = currentState;
        //initView();
    }

    @Override
    public void initView(String ... str) {
        setTitle("Command 10");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        JPanel consoleOut = new JPanel();
        consoleOut.setLayout(new BorderLayout(1,1));
        consoleWorkFlow = new JTextArea(greetings);
        JScrollPane commandsOutput = new JScrollPane( consoleWorkFlow );
        commandsOutput.createVerticalScrollBar();
        consoleOut.add(commandsOutput, BorderLayout.CENTER);

        write(str);

        JPanel consoleIn = new JPanel();
        consoleIn.setLayout(new BorderLayout(1,1));

        consoleIn.add(userInput);

        userInput.setText(currentState.getCurrentPath() + ">");
        userInput.setCaretPosition(userInput.getText().length());
        userInput.addActionListener(new InputListener());

        getContentPane().add(consoleOut);
        getContentPane().add(consoleIn,BorderLayout.SOUTH);

        setVisible(true);

        userInput.requestFocusInWindow();
    }

    @Override
    public void view(String ... str) {
        initView(str);
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
        initView();
    }

    public void write(String ... str) {
        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            sb.append(s);
            sb.append("\n");
        }
        consoleWorkFlow.append(sb.toString());
    }
/*
    public static void main(String[] args) {
        new WindowView(null);
    }
*/
    private class InputListener extends Component implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String InputText = userInput.getText();
            userInput.setText(currentState.getCurrentPath()+ ">");
            String userInputText = InputText.replace(currentState.getCurrentPath()+ ">","");
            currentState.setUserCommand(userInputText);
        }
    }

}
