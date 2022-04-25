package lk.sipsewanaInstitute.bo.custom.impl;

import lk.sipsewanaInstitute.bo.custom.StudentBO;
import lk.sipsewanaInstitute.dao.DAOFactory;
import lk.sipsewanaInstitute.dao.custom.ProgramDAO;
import lk.sipsewanaInstitute.dao.custom.StudentDAO;
import lk.sipsewanaInstitute.dto.StudentDTO;
import lk.sipsewanaInstitute.entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentBOImpl implements StudentBO {
    StudentDAO student =(StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENT);
    @Override
    public boolean addStudent(StudentDTO studentDTO) throws Exception {
        return student.add(new Student(studentDTO.getStudentId(),studentDTO.getName(),studentDTO.getAddress(), studentDTO.getTpnumber(), studentDTO.getNic(), studentDTO.getEmail()));
    }

    @Override
    public boolean updateStudent(StudentDTO studentDTO) throws Exception {
        return student.update(new Student(studentDTO.getStudentId(), studentDTO.getName(), studentDTO.getAddress(), studentDTO.getTpnumber(), studentDTO.getNic(), studentDTO.getEmail()));

    }
        @Override
    public boolean deleteStudent(String id) throws Exception {
        return student.delete(id);
    }

    @Override
    public StudentDTO searchStudent(String id) throws Exception {
        Student searshstudent= student.find(id);
        return new StudentDTO(searshstudent.getStudentid(), searshstudent.getName(), searshstudent.getAddress(), searshstudent.getTpnumber(), searshstudent.getNic(), searshstudent.getEmail());
    }

    @Override
    public ArrayList<StudentDTO> getAllStudent() throws Exception {
        ArrayList<Student> customerArrayList = (ArrayList<Student>) student.findAll();

        ArrayList<StudentDTO> studentDTOS = new ArrayList<>();

        customerArrayList.forEach(student1 -> {
            studentDTOS.add(new StudentDTO(student1.getStudentid(), student1.getName(), student1.getAddress(), student1.getTpnumber(), student1.getNic(), student1.getEmail()));
        });

        return studentDTOS;
    }


}
