package dev.enrz.golfDB.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import net.bytebuddy.asm.Advice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;


@Entity
public class Round {
    @Id
    @GeneratedValue
    private int rid;

    @NotBlank(message="Date is required and must have mm/dd/yyyy format")
    @Pattern(regexp = "[0-9]{2}/[0-9]{2}/[0-9]{4}", message="mm/dd/yyyy format required")
    private String date;

    @NotBlank(message = "Score is required")
    @Pattern(regexp = "^\\d+$", message = "score must be a number")
    private String score;

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

    public String  getDate() {
        return date;
    }

    public void setDate(String  date) {
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

    public String  getScore() {
        return score;
    }

    public void setScore(String  score) {
        this.score = score;
    }
}
