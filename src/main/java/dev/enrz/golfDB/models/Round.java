package dev.enrz.golfDB.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Round {
    @Id
    @GeneratedValue
    private int rid;

    @Size(min = 3, max = 50, message = "Between 3 and 50 characters for now(change to required formatting)")
    @NotBlank(message = "Date is required")
    private String date;

    public int getId() {
        return rid;
    }

    //many rounds in one course, not many to many because rounds are all specific to a certain course
    @ManyToOne
    @NotNull(message = "Course is required")
    private Course course;

    public Round(){

    }
    public Round(int rid, String date, Course course) {
        this.rid = rid;
        this.date = date;
        this.course = course;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getRid() {
        return rid;
    }
}
