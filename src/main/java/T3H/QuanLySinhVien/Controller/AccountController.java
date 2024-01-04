package T3H.QuanLySinhVien.Controller;

import T3H.QuanLySinhVien.Converter.TeacherConverter;
import T3H.QuanLySinhVien.Entities.dto.AccountDto;
import T3H.QuanLySinhVien.Entities.dto.InforDto;
import T3H.QuanLySinhVien.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

//@RestController // Dùng cho app springboot, trả về Json
@Controller // Dùng cho app MVC, mỗi API endpoint trả về tên file html
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @GetMapping("/account")
    public String getUpdateTeacher( Model model)
    {

        model.addAttribute("teacher",accountService.getUpdateTeacher());

        return "Dashboard/infor";
    }
    @PostMapping("/updateAccount")
    public String updateAccount(@ModelAttribute("infor") InforDto inforDto,
                                @ModelAttribute("account") AccountDto accountDto)
    {
        accountService.updateAccount(inforDto,accountDto);
        return "redirect:/account";
    }

//    @GetMapping("/account")
//    public String getAllAccounts(Model model) {
//        List<Account> result = accountService.getAllAccounts();
//        model.addAttribute("accountList", result);
//        return "ManagerClass/index";
//    }

//    @PostMapping("/account")
//    public ResponseEntity<List<Account>> addAccount(@RequestBody Account account) {
//        List<Account> result = accountService.addAccount(account);
//        return ResponseEntity.status(HttpStatus.CREATED).body(result);
//    }
//
//    @DeleteMapping("/account/{id}")
//    public ResponseEntity<List<Account>> deleteAccountByIdForAdmin(@PathVariable int id) {
//        List<Account> result = accountService.deleteAccountByIdForAdmin(id);
//        return ResponseEntity.ok(result);
//    }
//
//    @PutMapping("/account/{id}")
//    public ResponseEntity<List<Account>> updateAccountById(@RequestBody Account account) {
//        List<Account> result = accountService.updateAccountById(account);
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
//    }


}
