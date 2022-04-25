package lk.sipsewanaInstitute.bo;

import lk.sipsewanaInstitute.bo.custom.impl.ProgramBOImpl;
import lk.sipsewanaInstitute.bo.custom.impl.StudentBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    public BOFactory() {
    }
    public static BOFactory getInstance(){
        return null==boFactory?boFactory=new BOFactory():boFactory;
    }

    public enum BOTypes{
        STUDENT,PROGRAM,REGISTRATIONDETAILS,QUERY;
    }
    public SuperBO getBo(BOTypes boTypes){
        switch (boTypes){
            case STUDENT:
                return new StudentBOImpl();
            case PROGRAM:
                return new ProgramBOImpl();
            case REGISTRATIONDETAILS:
                return new RegistrationDetailsBOImpl();
            default:
                return null;
        }
    }
}
