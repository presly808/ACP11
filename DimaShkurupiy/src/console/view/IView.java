package console.view;

import console.model.CurrentState;

/**
 * Created by Dima on 13.01.2016.
 */
public interface IView extends Runnable{

    void initView();

    public String view(String ... str);

    public void showOutput(String ... str);

    public String readUserInput();

}
