package lk.sipsewanaInstitute.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProgramStudent implements SuperEntity {
    @Id
    private String registrationID;
    private String date;
    private String time;
    @ManyToOne
    @JoinColumn(name ="programId",referencedColumnName ="programid",nullable = false )
    private Program programId;
    @ManyToOne
    @JoinColumn(name ="studentId",referencedColumnName ="studentid",nullable = false )
    private Student studentId;

    public ProgramStudent() {
    }

    public ProgramStudent(String registrationID, String date, String time, Program programId, Student studentId) {
        this.registrationID = registrationID;
        this.date = date;
        this.time = time;
        this.programId = programId;
        this.studentId = studentId;
    }

    public String getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(String registrationID) {
        this.registrationID = registrationID;
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

    public Program getProgramId() {
        return programId;
    }

    public void setProgramId(Program programId) {
        this.programId = programId;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "ProgramStudent{" +
                "registrationID='" + registrationID + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", programId=" + programId +
                ", studentId=" + studentId +
                '}';
    }
}
