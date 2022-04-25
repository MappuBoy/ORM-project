package lk.sipsewanaInstitute.dao;

import lk.sipsewanaInstitute.dao.custom.impl.ProgramDAOimpl;
import lk.sipsewanaInstitute.dao.custom.impl.StudentDAOimpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getInstance(){
        return null == daoFactory ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        STUDENT,PROGRAM,REGISTRATIONDETAILS,QUERY;
    }

    public SuperDAO getDAO(DAOTypes daoTypes) {
        switch (daoTypes){
            case STUDENT:
                return new StudentDAOimpl();
            case PROGRAM:
                return new ProgramDAOimpl();
            /*case REGISTRATIONDETAILS:
                return new RegistrationDetailsDAOImpl();

            case QUERY:
                return new QueryDAOImpl();*/
            default:
                return null;
        }
    }

}
