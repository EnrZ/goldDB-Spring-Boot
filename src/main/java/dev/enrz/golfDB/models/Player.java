package dev.enrz.golfDB.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
public class Player {
    @Id
    @GeneratedValue
    private int pid;

    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters.")
    @NotBlank(message = "Name is required")
    private String name;

    public int getId() {
        return pid;
    }

    public Player(){

    }
    public Player(int pid, String name) {
        this.pid = pid;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

