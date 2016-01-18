package console.view;

/**
 * Created by Dima on 13.01.2016.
 */
public interface IView extends Runnable{

    void initView(String ... str);

//    public String view(String ... str);
    public void view(String ... str);

    public void showOutput(String ... str);

    public String readUserInput();

    public void write(String ... str);

}
