package T3H.QuanLySinhVien.Controller;

import T3H.QuanLySinhVien.Converter.LevelConverter;
import T3H.QuanLySinhVien.Converter.TeacherConverter;
import T3H.QuanLySinhVien.Entities.dto.*;
import T3H.QuanLySinhVien.Service.LevelService;
import T3H.QuanLySinhVien.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @Autowired
    LevelService levelService;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @GetMapping("/teacher")
    public String getAllTeacher(Model model)
    {
        model.addAttribute("levelList",levelService.getAllLevel());
        model.addAttribute("teacherList",teacherService.getAllTeachForView());
        return "ManagerTeacher/index";
    }

    @PostMapping("/addTeacher")
    public String addTeacher(@ModelAttribute("teacher") TeacherDto teacherDto,
                             @ModelAttribute("account") AccountDto accountDto,
                             @ModelAttribute("infor") InforDto inforDto)
    {
        teacherService.addTeacher(teacherDto,accountDto,inforDto);
        return "redirect:/teacher"; // Chuyển hướng về trang danh sách lớp học sau khi thêm mới
    }
    @PostMapping("/deleteTeacher")
    public String deleteTeacher(@RequestParam int id)
    {
        teacherService.deleteTeacher(id);
        return "redirect:/teacher";
    }
    @GetMapping("/updateTeacherForm/{id}")
    public String getUpdateTeacher(@PathVariable Integer id, Model model)
    {
        model.addAttribute("teacher",teacherService.getTeacherById(id));
        return "ManagerTeacher/update";
    }

    @PostMapping("/updateTeacher")
    public String updateStudent(@ModelAttribute("teacher") TeacherDto teacherDto,
                                @ModelAttribute("infor") InforDto inforDto)
    {
        teacherService.updateTeacher(teacherDto,inforDto);
        return "redirect:/teacher";
    }
}
