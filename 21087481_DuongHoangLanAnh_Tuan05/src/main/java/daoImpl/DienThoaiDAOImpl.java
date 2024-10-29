package daoImpl;


import java.util.List;

import dao.DienThoaiDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import models.DienThoai;


@SuppressWarnings("unchecked")
public class DienThoaiDAOImpl implements DienThoaiDAO {
	private EntityManager entityManager;
	
	
	/**
	 * Constructor
	 */
	public DienThoaiDAOImpl (EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	/**
	 * Add a new phone 
	 */
	@Override
	public DienThoai themDienThoai (DienThoai dt) {
		EntityTransaction transaction = null;
		
		try {
			transaction = this.entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(dt);
			transaction.commit();
			return dt;
		} catch (Exception e) {
			e.printStackTrace();
			
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
		}
		
		return null;
	}


	/**
	 * Update an existing phone
	 */
	@Override
	public DienThoai capNhatDienThoai (DienThoai dt) {
		EntityTransaction transaction = null; 
		
		try {
			transaction = this.entityManager.getTransaction();
			transaction.begin();
			entityManager.merge(dt);
			transaction.commit();
			return dt;
		} catch (Exception e) {
			e.printStackTrace();
			
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
		}
		
		return null;
	}


	/**
	 * Delete a phone
	 */
	@Override
	public boolean xoaDienThoai(int ma) {
		EntityTransaction transaction = null;
		
		try {
            transaction = this.entityManager.getTransaction();
            transaction.begin();
            DienThoai dt = entityManager.find(DienThoai.class, ma);
            if (dt != null) {
            	entityManager.remove(entityManager.contains(dt) ? dt : entityManager.merge(dt));
            }
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        }
		
		return false;
	}


	/**
	 * Find a phone by ID
	 */
	@Override
	public DienThoai timDienThoaiTheoMa(int ma) {
		try {
			return entityManager.find(DienThoai.class, ma);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public List<DienThoai> layDanhSachDienThoai() {
		try {
			return entityManager.createQuery("FROM DienThoai", DienThoai.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
