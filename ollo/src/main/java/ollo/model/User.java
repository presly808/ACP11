package ollo.model;

import ollo.view.IView;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Dima on 01.02.2016.
 */
@Entity
@Table(name="User")
public abstract class User {
    @Transient
    protected IView view;

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
    private int id;

    @Column(name="state")
    private int state;

    @Column(name="email")
    private String eMail;

    @Column(name="name")
    private String name;

    @Column(name="phone")
    private String phone;

    @Column(name="login")
    private String login;

    @Column(name="password")
    private String password;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public IView getView() {
        return view;
    }

    public void setView(IView view) {
        this.view = view;
    }

    public abstract void startView();
}
