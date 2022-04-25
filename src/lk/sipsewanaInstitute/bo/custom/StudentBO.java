package lk.sipsewanaInstitute.bo.custom;

import lk.sipsewanaInstitute.bo.SuperBO;
import lk.sipsewanaInstitute.dto.StudentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentBO extends SuperBO {
    boolean addStudent(StudentDTO studentDTO) throws Exception;

    boolean updateStudent(StudentDTO studentDTO) throws Exception;

    boolean deleteStudent(String id) throws Exception;

    StudentDTO searchStudent(String id) throws Exception;

    ArrayList<StudentDTO> getAllStudent() throws Exception;

}
