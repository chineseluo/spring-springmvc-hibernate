package online.qsx.project.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "hobby")
public class Hobby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate = new Date();
    @Column
    private String hobbyname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
        System.out.println("id:" + id);
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getHobbyname() {
        return hobbyname;
    }

    public void setHobbyname(String hobbyname) {
        this.hobbyname = hobbyname;
        System.out.println("hobbyname:" + hobbyname);
    }

    public Hobby(Date createdate, String hobbyname) {
        this.createdate = createdate;
        this.hobbyname = hobbyname;
    }

    public Hobby(String hobbyname) {
        this.hobbyname = hobbyname;
    }

    public Hobby() {
    }

    public Hobby(Long id) {
        this.id = id;
    }

    public Hobby(Long id, String hobbyname) {
        this.id = id;
        this.hobbyname = hobbyname;
    }

    public Hobby(Long id, Date createdate, String hobbyname) {
        this.id = id;
        this.createdate = createdate;
        this.hobbyname = hobbyname;
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "id=" + id +
                ", createdate=" + createdate +
                ", hobbyname='" + hobbyname + '\'' +
                '}';
    }
}