package T3H.QuanLySinhVien.Repository;

import org.springframework.stereotype.Repository;

@Repository
public interface DashboardRepository {
    int countDepartment();
    int countMajor();
    int countTeacher();
    int countStudent();
    int countSubject();
}
