package T3H.QuanLySinhVien.Repository.impl;

import T3H.QuanLySinhVien.Repository.DashboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DashboardRepositoryImpl implements DashboardRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public int countDepartment() {
        String countDepartment="SELECT COUNT(*) AS CountDepartment FROM departments";
        return jdbcTemplate.queryForObject(countDepartment,Integer.class);
    }

    @Override
    public int countMajor() {
        String countMajor="SELECT COUNT(*) AS CountMajor FROM majors";
        return jdbcTemplate.queryForObject(countMajor,Integer.class);
    }

    @Override
    public int countTeacher() {
        String countTeacher="SELECT COUNT(*) AS CountTeacher FROM teachers";

        return jdbcTemplate.queryForObject(countTeacher,Integer.class);
    }

    @Override
    public int countStudent() {
        String countStudent="SELECT COUNT(*) AS CountStudent FROM students";

        return jdbcTemplate.queryForObject(countStudent,Integer.class);
    }

    @Override
    public int countSubject() {
        String countSubject="SELECT COUNT(*) AS CountSbuject FROM subjects";
        return jdbcTemplate.queryForObject(countSubject,Integer.class);
    }
}
