package T3H.QuanLySinhVien.Repository.impl;

import T3H.QuanLySinhVien.Entities.dto.DepartmentDto;
import T3H.QuanLySinhVien.Repository.DashboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DashboardRepositoryImpl implements DashboardRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public String getUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String sql="select i.fullname " +
                "from infors i " +
                "inner join teachers t on t.infor_id=i.infor_id " +
                "inner join accounts a on t.account_id=a.account_id " +
                "where a.username=:loggedInUser";
        MapSqlParameterSource nameParameters=new MapSqlParameterSource()
                .addValue("loggedInUser",authentication.getName());
        return namedParameterJdbcTemplate.queryForObject(sql,nameParameters,String.class);
    }

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
