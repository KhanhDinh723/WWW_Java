package edu.iuh.fit.se.nhathuoc.dao;

import edu.iuh.fit.se.nhathuoc.utils.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

/**
 * Author: Khánh Đinh
 * Date:   9/30/2025
 * Time:   6:00 PM
 */
public class GenerateDAO<T> {
    private Class<T> type;

    public GenerateDAO(Class<T> type) {
        this.type = type;
    }

    public List<T> findAll(){
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        try{
            String jpql
                    = """
                    SELECT e FROM %s e
                    """.formatted(type.getSimpleName());
            TypedQuery<T> query = em.createQuery(jpql, type);
            return query.getResultList();


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            em.close();
        }
        return null;

    }

    public T findById(Long id){
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        try{
            return em.find(type, id);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            em.close();
        }
        return null;

    }

    public void save (T entity){
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            em.close();
        }

    }
}
