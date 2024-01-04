package T3H.QuanLySinhVien.Controller;

import T3H.QuanLySinhVien.Service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController
{
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    DashboardService dashboardService;

    @GetMapping("dashboard")
    public String getDashboard(Model model)
    {
        model.addAttribute("countDepartment",dashboardService.countDeparment() );
        model.addAttribute("countMajor",dashboardService.countMajor() );
        model.addAttribute("countTeacher",dashboardService.countTeacher() );
        model.addAttribute("countStudent",dashboardService.countStudent() );
        model.addAttribute("countSubject",dashboardService.countSubject() );
        return "Dashboard/index";
    }



}
