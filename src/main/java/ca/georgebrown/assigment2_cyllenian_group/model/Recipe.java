package ca.georgebrown.assigment2_cyllenian_group.model;

import javax.persistence.*;

@Entity
@Table(name = "RECIPE")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rid;
    private String rname;
    private String rdescription;
    private String rcountry;

    private boolean favourite;

    private String steps;

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRdescription() {
        return rdescription;
    }

    public void setRdescription(String rdescription) {
        this.rdescription = rdescription;
    }

    public String getRcountry() {
        return rcountry;
    }

    public void setRcountry(String rcountry) {
        this.rcountry = rcountry;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }
}
