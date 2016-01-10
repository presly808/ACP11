package console.model;

/**
 * Created by DNK on 10.01.2016.
 * класс для описания команд пользователя: команда + агрументы
 */
public class UserOrder {

    public String uOrder;
    public String[] uArgs;

    public void setuOrder(String uOrder) {
        this.uOrder = uOrder;
    }

    public void setuArgs(String[] uArgs) {
        this.uArgs = uArgs;
    }

    public String getuOrder() {
        return this.uOrder.toString();
    }

    public String toString() {
        String res = "";
        for (int i = 0; i < this.uArgs.length; i++) {
            res = res +" "+ uArgs[i];
        }
        return res;
    }

    public String[] getuArgs() {
        return this.uArgs;
    }
}
