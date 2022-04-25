package lk.sipsewanaInstitute.tm;

public class StudentTM {
    private String StudentId;
    private String name;
    private String address;
    private String tpnumber;
    private String nic;
    private String email;

    public StudentTM() {
    }

    public StudentTM(String studentId, String name, String address, String tpnumber, String nic, String email) {
        StudentId = studentId;
        this.name = name;
        this.address = address;
        this.tpnumber = tpnumber;
        this.nic = nic;
        this.email = email;
    }

    public String getStudentId() {
        return StudentId;
    }

    public void setStudentId(String studentId) {
        StudentId = studentId;
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

    @Override
    public String toString() {
        return "Student{" +
                "StudentId='" + StudentId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", tpnumber='" + tpnumber + '\'' +
                ", nic='" + nic + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
