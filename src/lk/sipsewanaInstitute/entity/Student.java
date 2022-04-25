package lk.sipsewanaInstitute.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student implements SuperEntity {
    @Id
    private String studentid;
    private String name;
    private String address;
    private String tpnumber;
    private String nic;
    private String email;
    @OneToMany(mappedBy = "studentId",cascade = {CascadeType.ALL})
    private List<ProgramStudent> programStudents;

    public Student() {
    }

    public Student(String studentid, String name, String address, String tpnumber, String nic, String email) {
        this.studentid = studentid;
        this.name = name;
        this.address = address;
        this.tpnumber = tpnumber;
        this.nic = nic;
        this.email = email;
    }

    /*public Student(String studentid, String name, String address, String tpnumber, String nic, String email, List<ProgramStudent> programStudents) {
        this.studentid = studentid;
        this.name = name;
        this.address = address;
        this.tpnumber = tpnumber;
        this.nic = nic;
        this.email = email;
        this.programStudents = programStudents;
    }*/

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentId) {
        studentid = studentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTpnumber() {
        return tpnumber;
    }

    public void setTpnumber(String tpnumber) {
        this.tpnumber = tpnumber;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ProgramStudent> getProgramStudents() {
        return programStudents;
    }

    public void setProgramStudents(List<ProgramStudent> programStudents) {
        this.programStudents = programStudents;
    }

    @Override
    public String toString() {
        return "Student{" +
                "StudentId='" + studentid + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", tpnumber='" + tpnumber + '\'' +
                ", nic='" + nic + '\'' +
                ", email='" + email + '\'' +
                ", programStudents=" + programStudents +
                '}';
    }
}
