package T3H.QuanLySinhVien.Repository;

import T3H.QuanLySinhVien.Converter.TeacherConverter;
import T3H.QuanLySinhVien.Entities.dao.AccountDao;
import T3H.QuanLySinhVien.Entities.dto.AccountDto;
import T3H.QuanLySinhVien.Entities.dto.InforDto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepository {
    TeacherConverter getUpdateTeacher();
    void updateAccount(InforDto inforDto, AccountDto accountDto);
}
