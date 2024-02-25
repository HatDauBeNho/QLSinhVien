package T3H.QuanLySinhVien.Controller;

import T3H.QuanLySinhVien.Converter.Course_registrationConverter;
import T3H.QuanLySinhVien.Service.Course_registrationService;
import T3H.QuanLySinhVien.Service.Module_subjectService;
import T3H.QuanLySinhVien.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class Course_registrationController {

    @Autowired
    Course_registrationService course_registrationService;
    @Autowired
    Module_subjectService module_subjectService;
//    @GetMapping("/course_registration")
//    public String getAllregistration(Model model)
//    {
//        List<Course_registrationConverter> result=course_registrationService.getAllCourse_registration();
//        model.addAttribute("course_registrationList",result);
//        return "ManagerCourse_registration/index";
//    }
    @GetMapping("/student/course_registration")
    public String getAllCourse_registration(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loggedInUser = authentication.getName();
        model.addAttribute("userName",loggedInUser);
        model.addAttribute("course_registrationList",course_registrationService.getAllCourse_registrationForView());
        return "Registered_course/index";
    }
    @GetMapping("/student/register_course")
    public String getAllModule_subject(Model model) {
        model.addAttribute("module_subjectList",module_subjectService.getAllModule_subjectForView());
        return "Register_course/index";
    }


//    @PostMapping("/course_registration")
//    public ResponseEntity<List<Course_registration>> addCourse_registration(@RequestBody Course_registration course_registration) {
//        List<Course_registration> result = course_registrationService.addCourse_registration(course_registration);
//        return ResponseEntity.status(HttpStatus.CREATED).body(result);
//    }
//
//    @DeleteMapping("/course_registration/{id}")
//    public ResponseEntity<List<Course_registration>> deleteCourse_registration(@PathVariable int id) {
//        List<Course_registration> result = course_registrationService.deleteCourse_registration(id);
//        return ResponseEntity.ok(result);
//    }
}