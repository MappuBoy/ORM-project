package lk.sipsewanaInstitute.bo.custom.impl;

import lk.sipsewanaInstitute.bo.custom.ProgramBO;
import lk.sipsewanaInstitute.dao.DAOFactory;
import lk.sipsewanaInstitute.dao.custom.ProgramDAO;
import lk.sipsewanaInstitute.dao.custom.StudentDAO;
import lk.sipsewanaInstitute.dto.ProgramDTO;
import lk.sipsewanaInstitute.entity.Program;
import lk.sipsewanaInstitute.entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProgramBOImpl implements ProgramBO {
    ProgramDAO program =(ProgramDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PROGRAM);
    @Override
    public boolean addProgram(ProgramDTO programDTO) throws Exception {
        return program.add(new Program(programDTO.getProgramId(),
                programDTO.getProgramName(),
                programDTO.getDuration(),
                programDTO.getFees()));
    }

    @Override
    public boolean updateProgram(ProgramDTO programDTO) throws Exception {
        return program.update(new Program(programDTO.getProgramId(),programDTO.getProgramName(),programDTO.getDuration(),programDTO.getFees()));
    }

    @Override
    public boolean deleteProgram(String id) throws Exception {
        return program.delete(id);
    }

    @Override
    public ProgramDTO searchProgram(String id) throws Exception {
        Program searchProgram = program.find(id);
        return new ProgramDTO(searchProgram.getProgramid(), searchProgram.getProgramname(), searchProgram.getDuration(), searchProgram.getFees());
    }

    @Override
    public ArrayList<ProgramDTO> getAllProgram() throws Exception {
        ArrayList<Program> customerArrayList = (ArrayList<Program>) program.findAll();

        ArrayList<ProgramDTO> programDTOS = new ArrayList<>();

        customerArrayList.forEach(program1 -> {
            programDTOS.add(new ProgramDTO(program1.getProgramid(), program1.getProgramname(), program1.getDuration(), program1.getFees()));
        });
        return programDTOS;
    }
}
