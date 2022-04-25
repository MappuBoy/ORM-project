package lk.sipsewanaInstitute.model;

public class RegistrationDetails {
    private String programId;
    private String studentId;
    private String date;
    private String time;

    public RegistrationDetails() {
    }

    public RegistrationDetails(String programId, String studentId, String date, String time) {
        this.programId = programId;
        this.studentId = studentId;
        this.date = date;
        this.time = time;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "RegistrationDetails{" +
                "programId='" + programId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
