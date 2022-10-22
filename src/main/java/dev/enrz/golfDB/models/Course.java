package dev.enrz.golfDB.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue
    private int cid;

    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters.")
    @NotBlank(message = "Name is required")
    private String name;

    @Size(min = 3, max = 50, message = "Location must be between 3 and 50 characters.")
    @NotBlank(message = "Location is required")
    private String location;

    public int getId() {
        return cid;
    }

    @OneToMany(mappedBy = "course")
    private final List<Round> rounds = new ArrayList<>();
    public Course(){

    }
    public Course(int cid, String name, String location) {
        this.cid = cid;
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public int getCid() {
        return cid;
    }
}
