package dev.enrz.golfDB.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

    public Course(){

    }
    public Course(int pid, String name) {
        this.cid = cid;
        this.name = name;
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
}
