package T3H.QuanLySinhVien.Controller;

import T3H.QuanLySinhVien.Converter.DepartmentConverter;
import T3H.QuanLySinhVien.Converter.TeacherConverter;
import T3H.QuanLySinhVien.Entities.dto.DepartmentDto;
import T3H.QuanLySinhVien.Service.DepartmentService;
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
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @GetMapping("/department")
    public String getAllDepartment(Model model)
    {
        model.addAttribute("departmentList",departmentService.getAllDepartmentForView());
        model.addAttribute("teacherList",teacherService.getAllTeachForView());
        return "ManagerDepartment/index";
    }
    @GetMapping("/deparment")
    public String searchByDepartmentname(@PathVariable String searchString,Model model)
    {
        model.addAttribute("result",departmentService.searchByDepartmentname(searchString));
        return "ManagerDepartment/index";
    }
    @PostMapping("/addDepartment")
    public String addDepartment(@ModelAttribute("department") DepartmentDto departmentDto)
    {
        departmentService.addDepartment(departmentDto);
        return "redirect:/department";
    }

    @PostMapping("/deleteDepartment")
    public String deleteDepartment(@RequestParam int id)
    {
        departmentService.deleteDepartment(id);
        return "redirect:/department";
    }
    @GetMapping("/updateDepartmentForm/{id}")
    public String getUpdateDepartment(@PathVariable Integer id, Model model)
    {

        model.addAttribute("department",departmentService.getDepartmentById(id));
        model.addAttribute("teacherList",teacherService.getAllTeachForView());
        return "ManagerDepartment/update";
    }
    @PostMapping("/updateDepartment")
    public String updateClassroom(@ModelAttribute("department") DepartmentDto departmentDto)
    {
        departmentService.updateDepartment(departmentDto);
        return "redirect:/department";
    }

//    @PutMapping("/deparment")
//    public ResponseEntity<Integer> updateDepartment(@RequestBody DepartmentDto departmentDto)
//    {
//        String sql="UPDATE departments" +
//                " SET department_name=:deparment_name,teacher_id=:teacher_id,updated_at=:updated_at" +
//                " WHERE department_id=:department_id";
//        MapSqlParameterSource nameParameters=new MapSqlParameterSource()
//                .addValue("department_id",departmentDto.getDepartment_id())
//                .addValue("deparment_name",departmentDto.getDepartment_name())
//                .addValue("teacher_id",)
//    }

}
