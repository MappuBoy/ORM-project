package lk.sipsewanaInstitute.bo.custom;

import lk.sipsewanaInstitute.bo.SuperBO;
import lk.sipsewanaInstitute.dto.ProgramDTO;
import lk.sipsewanaInstitute.model.Program;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProgramBO extends SuperBO {
    boolean addProgram(ProgramDTO programDTO) throws Exception;

    boolean updateProgram(ProgramDTO programDTO) throws Exception;

    boolean deleteProgram(String id) throws Exception;

    ProgramDTO searchProgram(String id) throws Exception;

    ArrayList<ProgramDTO> getAllProgram() throws Exception;

}
