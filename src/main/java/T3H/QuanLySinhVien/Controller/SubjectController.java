package T3H.QuanLySinhVien.Controller;

import T3H.QuanLySinhVien.Converter.DepartmentConverter;
import T3H.QuanLySinhVien.Converter.SubjectConverter;
import T3H.QuanLySinhVien.Entities.dto.SubjectDto;
import T3H.QuanLySinhVien.Service.DepartmentService;
import T3H.QuanLySinhVien.Service.SubjectService;
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
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @GetMapping("/subject")
    public String getAllSubject(Model model)
    {
        model.addAttribute("subjectList",subjectService.getAllSubjectForView());
        model.addAttribute("departmentList",departmentService.getAllDepartmentForView());
        return "ManagerSubject/index";
    }

    @PostMapping("/addSubject")
    public String addSubject(@ModelAttribute("subject") SubjectDto subjectDto)
    {
        subjectService.addSubject(subjectDto);
        return "redirect:/subject"; // Chuyển hướng về trang danh sách lớp học sau khi thêm mới
    }
    @PostMapping("/deleteSubject")
    public String deleteSubject(@RequestParam int id)
    {
        subjectService.deleteSubject(id);
        return "redirect:/subject";
    }

    @GetMapping("/updateSubjectForm/{id}")
    public String getUpdateSubject(@PathVariable Integer id, Model model)
    {
        model.addAttribute("subject", subjectService.getSubjectById(id));
        model.addAttribute("departmentList",departmentService.getAllDepartment());
        return "ManagerSubject/update";
    }
    @PostMapping("/updateSubject")
    public String updateSubject(@ModelAttribute("major") SubjectDto subjectDto)
    {
        subjectService.updateSubject(subjectDto);
        return "redirect:/subject";
    }
}
