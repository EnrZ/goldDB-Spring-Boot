package dev.enrz.golfDB.controllers;

import dev.enrz.golfDB.data.CourseRepository;
import dev.enrz.golfDB.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("courses")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;


    @GetMapping("addcourse")
    public String renderAddCourseForm(Model model){

        //the empty event object just made will have information about the fields
        model.addAttribute("course" , new Course());

        return "courses/addcourse";

    }

    @PostMapping("addcourse")
    public String addCourseForm(@ModelAttribute @Valid Course newCourse, Errors errors, Model model)  {


        if(errors.hasErrors()) {
            //the empty event object just made will have information about the fields
                model.addAttribute("title", "Add Course");

            return "courses/addcourse";
        }
        courseRepository.save(newCourse);

        return "redirect:";
    }


    @GetMapping
    public String displayCourses(@RequestParam(required = false) Integer categoryId, Model model) {

        if (categoryId == null) {
            model.addAttribute("courses", courseRepository.findAll());
            model.addAttribute("title", "All Courses");
        }


        return "courses/index";
    }
}
