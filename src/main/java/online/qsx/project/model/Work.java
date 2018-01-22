package online.qsx.project.model;


import javax.persistence.*;
import java.util.Date;

/**
 * Created by 84825 on 2018/1/16.
 */
@Entity
@Table(name = "work")
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String workname;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate = new Date();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWorkname() {
        return workname;
    }

    public void setWorkname(String workname) {
        this.workname = workname;
        System.out.println("work");
    }

    @Temporal(TemporalType.DATE)
    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Work(String workname, Date createdate) {
        this.workname = workname;
        this.createdate = createdate;
    }

    public Work(Date createdate) {
        this.createdate = createdate;
    }

    public Work(String workname) {
        this.workname = workname;
    }

    public Work() {
    }

    public Work(Long id) {
        this.id = id;
    }

    public Work(Long id, String workname) {
        this.id = id;
        this.workname = workname;
    }

    public Work(Long id, String workname, Date createdate) {
        this.id = id;
        this.workname = workname;
        this.createdate = createdate;
    }

    @Override
    public String toString() {
        return "Work{" +
                "id=" + id +
                ", workname='" + workname + '\'' +
                ", createdate=" + createdate +
                '}';
    }
}
