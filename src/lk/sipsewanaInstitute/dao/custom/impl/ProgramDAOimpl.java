package lk.sipsewanaInstitute.dao.custom.impl;

import lk.sipsewanaInstitute.dao.custom.ProgramDAO;
import lk.sipsewanaInstitute.entity.Program;
import lk.sipsewanaInstitute.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class ProgramDAOimpl implements ProgramDAO {

    @Override
    public boolean add(Program entity) throws Exception {
            Session session = FactoryConfiguration.getInstance().getSession();
            Transaction transaction = session.beginTransaction();

            session.save(entity);

            transaction.commit();
            return true;

    }

    @Override
    public boolean delete(String s) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Program course = session.load(Program.class, s);
        session.delete(course);

        transaction.commit();
        return true;
    }

    @Override
    public boolean update(Program entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();
        return true;
    }

    @Override
    public Program find(String s) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from Program where programid=?1");
//        Query query = session.createQuery("from Program");

        query.setParameter(1,s);

        //Program progeam = (Program) query.uniqueResult();

        transaction.commit();

        return null; //progeam;
    }

    @Override
    public List<Program> findAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from Program");

        List<Program> list = (List<Program>) ((org.hibernate.query.Query<?>) query).list();

        transaction.commit();

        return list;
    }
}
