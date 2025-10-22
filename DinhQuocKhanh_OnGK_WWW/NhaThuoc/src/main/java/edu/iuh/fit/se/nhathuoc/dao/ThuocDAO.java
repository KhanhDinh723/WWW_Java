package edu.iuh.fit.se.nhathuoc.dao;

import edu.iuh.fit.se.nhathuoc.model.Thuoc;
import edu.iuh.fit.se.nhathuoc.utils.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

/**
 * Author: Khánh Đinh
 * Date:   9/30/2025
 * Time:   6:00 PM
 */
public class ThuocDAO extends GenerateDAO<Thuoc> {

    public ThuocDAO() {
        super(Thuoc.class);
    }

    public List<Thuoc> findByLoaiThuocId(Long loaiThuocId) {
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        try {
            String jpql
                    = """
                    SELECT t FROM Thuoc t
                    WHERE t.loaiThuoc.id =:loaiThuocId
                    """;
            TypedQuery<Thuoc> query = em.createQuery(jpql, Thuoc.class);
            query.setParameter("loaiThuocId", loaiThuocId);
            return query.getResultList();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;

    }

}
