package lk.sipsewanaInstitute.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Program implements SuperEntity {
    @Id
    private String programid;
    private String programname;
    private String duration;
    private String fees;
    @OneToMany(mappedBy = "programId",cascade = {CascadeType.ALL})
    private List<ProgramStudent> programs;

    public Program() {
    }

    public Program(String programid, String programname, String duration, String fees) {
        this.programid = programid;
        this.programname = programname;
        this.duration = duration;
        this.fees = fees;
    }

    /*public Program(String programid, String programname, String duration, String fees, List<ProgramStudent> programs) {
        this.programid = programid;
        this.programname = programname;
        this.duration = duration;
        this.fees = fees;
        this.programs = programs;
    }*/

    public String getProgramid() {
        return programid;
    }

    public void setProgramid(String programid) {
        this.programid = programid;
    }

    public String getProgramname() {
        return programname;
    }

    public void setProgramname(String programName) {
        this.programname = programName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public List<ProgramStudent> getPrograms() {
        return programs;
    }

    public void setPrograms(List<ProgramStudent> programs) {
        this.programs = programs;
    }

    @Override
    public String toString() {
        return "Program{" +
                "programId='" + programid + '\'' +
                ", programName='" + programname + '\'' +
                ", duration='" + duration + '\'' +
                ", fees='" + fees + '\'' +
                ", programs=" + programs +
                '}';
    }
}
