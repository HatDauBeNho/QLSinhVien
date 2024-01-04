package T3H.QuanLySinhVien.Repository.impl;


import T3H.QuanLySinhVien.Converter.TeacherConverter;
import T3H.QuanLySinhVien.Entities.dto.AccountDto;
import T3H.QuanLySinhVien.Entities.dto.InforDto;
import T3H.QuanLySinhVien.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class AccountRepositoryImpl implements AccountRepository {
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public TeacherConverter getUpdateTeacher() {
        String sql = "SELECT * FROM teachers t " +
                "inner join accounts a on t.account_id=a.account_id " +
                "inner join infors i on t.infor_id = i.infor_id WHERE teacher_id =:teacher_id";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("teacher_id", 1);
        List<TeacherConverter> teachers = namedParameterJdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(TeacherConverter.class));
        return  teachers.get(0);
    }

    @Override
    public void updateAccount(InforDto inforDto, AccountDto accountDto) {
        String sql="UPDATE infors i " +
                "inner join teachers t on t.infor_id=i.infor_id " +
                "inner join accounts a on t.account_id=a.account_id " +
                "SET i.fullname=:fullname,i.phone_number=:phone_number,i.email=:email," +
                "i.date_of_birth=:date_of_birth,i.address=:address,i.gender=:gender,a.password=:password,i.updated_at=:updated_at" +
                " WHERE teacher_id=:teacher_id";
        MapSqlParameterSource nameParameters1=new MapSqlParameterSource()
                .addValue("teacher_id",1)
                .addValue("infor_id",inforDto.getInfor_id())
                .addValue("fullname",inforDto.getFullname())
                .addValue("phone_number",inforDto.getPhone_number())
                .addValue("email",inforDto.getEmail())
                .addValue("date_of_birth",inforDto.getDate_of_birth())
                .addValue("address",inforDto.getAddress())
                .addValue("gender",inforDto.getGender())
                .addValue("password",accountDto.getPassword())
                .addValue("updated_at", LocalDateTime.now());
        namedParameterJdbcTemplate.update(sql,nameParameters1);
    }
}
