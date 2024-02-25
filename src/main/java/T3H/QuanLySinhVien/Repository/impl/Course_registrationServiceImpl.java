package T3H.QuanLySinhVien.Repository.impl;

import T3H.QuanLySinhVien.Converter.ClassroomConverter;
import T3H.QuanLySinhVien.Converter.Course_registrationConverter;
import T3H.QuanLySinhVien.Entities.dto.Module_subjectDto;
import T3H.QuanLySinhVien.Repository.Course_registrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public class Course_registrationServiceImpl implements Course_registrationRepository {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public List<Course_registrationConverter> getAllCourse_registrationForView() {
        String sql="select s.subject_name,i.fullname,m.current_student,m.maximum_student,m.start_at,m.end_at,c.updated_at" +
                " from course_registrations c" +
                " left outer join module_subjects m on c.module_subject_id=m.module_subject_id" +
                " left outer join subjects s on m.subject_id=s.subject_id" +
                " left outer join teachers t on t.teacher_id=m.teacher_id" +
                " left outer join infors i on t.infor_id=i.infor_id";
        return namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Course_registrationConverter.class));
    }

    @Override
    public void plusCurrentStudent(Module_subjectDto module_subjectDto) {
        String sql="UPDATE module_subjects " +
                "SET subject_id=:subject_id,current_student=:current_student,updated_at=:updated_at " +
                "WHERE module_subject_id=:module_subject_id";
        MapSqlParameterSource nameParameters=new MapSqlParameterSource()
                .addValue("current_student",module_subjectDto.getMaximum_student()+1)
                .addValue("updated_at", LocalDateTime.now());
        namedParameterJdbcTemplate.update(sql,nameParameters);
    }
}
