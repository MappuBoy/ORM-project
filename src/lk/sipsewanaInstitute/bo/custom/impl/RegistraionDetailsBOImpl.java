package lk.sipsewanaInstitute.bo.custom.impl;

import lk.sipsewanaInstitute.bo.custom.RegistrationDetailsBO;
import lk.sipsewanaInstitute.dto.ProgramDTO;
import lk.sipsewanaInstitute.dto.RegistrationDetailsDTO;

import java.util.List;

public class RegistraionDetailsBOImpl implements RegistrationDetailsBO {

    @Override
    public boolean addRegistration(RegistrationDetailsDTO registrationDetailsDTO) throws Exception {
        return false;
    }

    @Override
    public List<ProgramDTO> getAllCourses() throws Exception {
        return null;
    }

    @Override
    public ProgramDTO findCourse(String id) throws Exception {
        return null;
    }

    @Override
    public int getLastId() throws Exception {
        return 0;
    }

    @Override
    public List<RegistrationDetailsDTO> getAllRegistration() throws Exception {
        return null;
    }
}
