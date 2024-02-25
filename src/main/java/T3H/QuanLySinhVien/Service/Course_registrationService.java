package T3H.QuanLySinhVien.Service;


import T3H.QuanLySinhVien.Converter.Course_registrationConverter;
import T3H.QuanLySinhVien.Entities.dto.Module_subjectDto;
import T3H.QuanLySinhVien.Repository.Course_registrationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Course_registrationService {
    @Autowired
    Course_registrationRepository course_registrationRepository;
    public List<Course_registrationConverter> getAllCourse_registrationForView()
    {
        return  course_registrationRepository.getAllCourse_registrationForView();
    }
    public  void plusCurrentStudent(Module_subjectDto module_subjectDto)
    {
        course_registrationRepository.plusCurrentStudent(module_subjectDto);
    }
}

