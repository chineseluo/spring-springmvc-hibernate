package online.qsx.project.model;

/**
 * Created by 84825 on 2018/1/22.
 */
public class Manager {
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Manager(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Manager() {

    }
}
