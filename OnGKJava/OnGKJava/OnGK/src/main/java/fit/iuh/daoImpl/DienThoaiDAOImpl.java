package fit.iuh.daoImpl;

import java.util.List;

import fit.iuh.dao.DienThoaiDAO;
import fit.iuh.models.DienThoai;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DienThoaiDAOImpl implements DienThoaiDAO {
	private EntityManager entityManager;

	public DienThoaiDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<DienThoai> findAll() {
		try {
			return entityManager.createQuery("From DienThoai").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public DienThoai addDienThoai(DienThoai dt) {
		EntityTransaction transaction = null;
		try {
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(dt);
			transaction.commit();
			return dt;
		} catch (Exception e) {
			e.printStackTrace();
			
			if(transaction!=null && transaction.isActive()) {
				transaction.rollback();
			}
		}
		return null;
	}

	@Override
	public boolean remove(int maDT) {
		// TODO Auto-generated method stub
		return false;
	}

}
