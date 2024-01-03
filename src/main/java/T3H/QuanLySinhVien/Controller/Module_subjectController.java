package T3H.QuanLySinhVien.Controller;

import T3H.QuanLySinhVien.Converter.Module_subjectConverter;
import T3H.QuanLySinhVien.Converter.SubjectConverter;
import T3H.QuanLySinhVien.Converter.TeacherConverter;
import T3H.QuanLySinhVien.Entities.dto.Module_subjectDto;
import T3H.QuanLySinhVien.Service.Module_subjectService;
import T3H.QuanLySinhVien.Service.SubjectService;
import T3H.QuanLySinhVien.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class Module_subjectController {
    @Autowired
    Module_subjectService moduleSubjectService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    SubjectService subjectService;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @GetMapping("/module_subject")
    public String getAllModule_subject(Model model)
    {
        model.addAttribute("module_subjectList",moduleSubjectService.getAllModule_subjectForView());
        model.addAttribute("teacherList",teacherService.getAllTeachForView());
        model.addAttribute("subjectList",subjectService.getAllSubject());
        return "ManagerModule_subject/index";
    }

    @PostMapping("/addModule_subject")
    public String addModule_subject(@ModelAttribute("module_subject") Module_subjectDto module_SubjectDto) {

        moduleSubjectService.addModule_subject(module_SubjectDto);
        return "redirect:/module_subject"; // Chuyển hướng về trang danh sách lớp học sau khi thêm mới
    }

    @PostMapping("/deleteModule_subject")
    public String deleteModule_subject(@RequestParam int id)
    {
        moduleSubjectService.deleteModule_subject(id);
        return "redirect:/module_subject";
    }
    @GetMapping("/updateModule_subjectForm/{id}")
    public String getUpdateModule_subject(@PathVariable Integer id, Model model)
    {
        model.addAttribute("module_subject", moduleSubjectService.getModule_subjectById(id));
        model.addAttribute("module_subjectList",moduleSubjectService.getAllModule_subjectForView());
        model.addAttribute("teacherList",teacherService.getAllTeachForView());
        model.addAttribute("subjectList",subjectService.getAllSubject());
        return "ManagerModule_subject/update";
    }
    @PostMapping("/updateModule_subject")
    public String updateModule_subject(@ModelAttribute("module_subject") Module_subjectDto module_subjectDto)
    {
        moduleSubjectService.updateModule_subject(module_subjectDto);
        return "redirect:/module_subject";
    }
}
