package ca.georgebrown.assigment2_cyllenian_group.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EVENT")
@EntityListeners(AuditingEntityListener.class)
public class EventPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eid;


    private String ename;

    private String edescription;

    private boolean complete;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date modifiedDate;

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEdescription() {
        return edescription;
    }

    public void setEdescription(String edescription) {
        this.edescription = edescription;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
