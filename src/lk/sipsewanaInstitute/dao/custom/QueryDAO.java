package lk.sipsewanaInstitute.dao.custom;

import lk.sipsewanaInstitute.dao.SuperDAO;

import java.util.List;

public interface QueryDAO extends SuperDAO {
    public List<Object[]> getOrderDetailsFromOID() throws Exception;

    public List<Object[]> getCrsViseStd(String id) throws Exception;
}
