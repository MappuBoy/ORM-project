package lk.sipsewanaInstitute.util;


import lk.sipsewanaInstitute.entity.Program;
import lk.sipsewanaInstitute.entity.ProgramStudent;
import lk.sipsewanaInstitute.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private static SessionFactory sessionFactory;

    public FactoryConfiguration() {
        Configuration configuration = new Configuration().addAnnotatedClass(Program.class)
                .addAnnotatedClass(Student.class).addAnnotatedClass(ProgramStudent.class);
        sessionFactory = configuration.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance() {
        return (factoryConfiguration == null) ? factoryConfiguration = new FactoryConfiguration() : factoryConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
