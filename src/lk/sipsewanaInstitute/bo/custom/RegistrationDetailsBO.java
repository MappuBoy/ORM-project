package lk.sipsewanaInstitute.bo.custom;

import lk.sipsewanaInstitute.bo.SuperBO;
import lk.sipsewanaInstitute.dto.ProgramDTO;
import lk.sipsewanaInstitute.dto.RegistrationDetailsDTO;

import java.util.List;

public interface RegistrationDetailsBO extends SuperBO {
    public boolean addRegistration(RegistrationDetailsDTO registrationDetailsDTO) throws Exception;

    public List<ProgramDTO> getAllCourses() throws Exception;

    public ProgramDTO findCourse(String id) throws Exception;

    public int getLastId() throws Exception;

    public List<RegistrationDetailsDTO> getAllRegistration() throws Exception;

}
