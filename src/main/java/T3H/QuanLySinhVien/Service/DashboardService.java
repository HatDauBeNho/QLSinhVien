package T3H.QuanLySinhVien.Service;

import T3H.QuanLySinhVien.Repository.DashboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {
    @Autowired
    DashboardRepository dashboardRepository;
    public int countDeparment()
    {
        return dashboardRepository.countDepartment();
    }
    public int countTeacher()
    {
        return dashboardRepository.countTeacher();
    }
    public int countStudent()
    {
        return dashboardRepository.countStudent();
    }
    public int countSubject()
    {
        return dashboardRepository.countSubject();
    }
    public int countMajor()
    {
        return dashboardRepository.countMajor();
    }
}
