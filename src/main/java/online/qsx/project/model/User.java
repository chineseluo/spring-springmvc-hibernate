package online.qsx.project.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "u_id")
    private Long id;
    @Column
    private String email;
    @Column
    private Boolean sex;

    @Temporal(TemporalType.DATE)
    @Column(name = "birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdate")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdate = new Date();
    @Column
    private String username;
    @Column
    private String password;

    //特殊属性
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "h_id", unique = true)
    private Hobby hobby;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "w_id", unique = true)
    private Work work;

    public Hobby getHobby() {
        return hobby;
    }

    public void setHobby(Hobby hobby) {
        this.hobby = hobby;
        System.out.println("hobby:" + hobby);
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
        System.out.println("Work:" + work);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        System.out.println("email:" + email);
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
        System.out.println("sex:" + sex);
    }

    @Temporal(TemporalType.DATE)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
        System.out.println("birthday:" + birthday);
    }


    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
        System.out.println("createdate:" + createdate);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        System.out.println("username:" + username);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        System.out.println("Password:" + password);
    }

    public User(String email, Boolean sex, Date birthday, Date createdate, String username, String password) {
        this.email = email;
        this.sex = sex;
        this.birthday = birthday;
        this.createdate = createdate;
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public User(String password) {
        this.password = password;
    }

    public User(String email, Boolean sex, Date birthday, Date createdate, String username, String password, Hobby hobby, Work work) {
        this.email = email;
        this.sex = sex;
        this.birthday = birthday;
        this.createdate = createdate;
        this.username = username;
        this.password = password;
        this.hobby = hobby;
        this.work = work;
    }


    public User(Long id) {
        this.id = id;
    }

    public User(Long id, String email, Boolean sex, Date birthday, Date createdate, String username, String password) {
        this.id = id;
        this.email = email;
        this.sex = sex;
        this.birthday = birthday;
        this.createdate = createdate;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", createdate=" + createdate +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String toStringAndHobbyAndWork() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", createdate=" + createdate +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", hobby=" + hobby +
                ", work=" + work +
                '}';
    }
}