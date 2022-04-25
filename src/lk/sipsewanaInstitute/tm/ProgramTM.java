package lk.sipsewanaInstitute.tm;

public class ProgramTM {
    private String programId;
    private String programName;
    private String duration;
    private String fees;

    public ProgramTM() {
    }

    public ProgramTM(String programId, String programName, String duration, String fees) {
        this.programId = programId;
        this.programName = programName;
        this.duration = duration;
        this.fees = fees;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
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

    @Override
    public String toString() {
        return "Program{" +
                "programId='" + programId + '\'' +
                ", programName='" + programName + '\'' +
                ", duration='" + duration + '\'' +
                ", fees='" + fees + '\'' +
                '}';
    }
}
