package daoImpl;


import java.util.List;

import dao.NhaCungCapDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import models.NhaCungCap;


@SuppressWarnings("unchecked")
public class NhaCungCapDAOImpl implements NhaCungCapDAO {
	private EntityManager entityManager;
	
	
	/**
	 * Constructor
	 */
	public NhaCungCapDAOImpl (EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	/**
	 * Add a new supplier
	 */
	@Override
	public NhaCungCap themNhaCungCap(NhaCungCap ncc) {
		EntityTransaction transaction = null;
		
		try {
			transaction = this.entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(ncc);
			transaction.commit();
			return ncc;
		} catch (Exception e) {
			e.printStackTrace();

			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
		}
		
		return null;
	}


	/**
     * Update an existing supplier
     */
	@Override
	public NhaCungCap capNhatNhaCungCap(NhaCungCap ncc) {
		EntityTransaction transaction = null;
		
		try {
            transaction = this.entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(ncc);
            transaction.commit();
            return ncc;
        } catch (Exception e) {
            e.printStackTrace();
            
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        }
		
		return null;
	}


	/**
	 * Delete a supplier
	 */
	@Override
	public boolean xoaNhaCungCap(int ma) {
		EntityTransaction transaction = null;
		
		try {
            transaction = this.entityManager.getTransaction();
            transaction.begin();
            NhaCungCap ncc = entityManager.find(NhaCungCap.class, ma);
            if (ncc != null) {
                entityManager.remove(entityManager.contains(ncc) ? ncc : entityManager.merge(ncc));
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
	 * Get a list of all suppliers
	 */
	@Override
	public List<NhaCungCap> layDanhSachNhaCungCap() {
		try {
			return entityManager.createQuery("from NhaCungCap").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}


	/**
	 * Find a supplier by ID
	 */
	@Override
	public NhaCungCap timNhaCungCapTheoMa(int ma) {
		try  {
            return entityManager.find(NhaCungCap.class, ma);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return null;
	}


	/**
	 * Find a supplier by name
	 */
	@Override
	public NhaCungCap timNhaCungCapTheoTen(String ten) {
		try {
			return entityManager.createQuery("from NhaCungCap where ten = :ten", NhaCungCap.class)
					.setParameter("ten", ten).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}


	/**
     * Find a supplier by address
     */
	@Override
	public NhaCungCap timNhaCungCapTheoDiaChi(String diaChi) {
		try {
			return entityManager.createQuery("from NhaCungCap where diaChi = :diaChi", NhaCungCap.class)
					.setParameter("diaChi", diaChi).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}


	/**
     * Find a supplier by phone number
     */
	@Override
	public NhaCungCap timNhaCungCapTheoSDT(String sdt) {
		try {
			return entityManager.createQuery("from NhaCungCap where sdt = :sdt", NhaCungCap.class)
					.setParameter("sdt", sdt).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public List<NhaCungCap> timKiemNhaCungCap (String keyword) {
		try {
			// Check if the keyword is null or empty
			Integer maNhaCungCap = null;
			
			if (keyword != null && !keyword.isEmpty()) {
				try {
					maNhaCungCap = Integer.parseInt(keyword);
				} catch (NumberFormatException exc) {
					// Not a number, ignore the exception
					maNhaCungCap = null;
				}
			}
			
			// Create the query
			String queryStr = "from NhaCungCap where tenNhaCungCap like :keyword OR diaChi like :keyword OR soDienThoai like :keyword";
			if (maNhaCungCap != null) {
				queryStr += " OR maNhaCungCap = :maNhaCungCap";
			}
			
			var query = this.entityManager.createQuery(queryStr, NhaCungCap.class)
					.setParameter("keyword", "%" + keyword + "%");
			
			if (maNhaCungCap != null) {
				query.setParameter("maNhaCungCap", maNhaCungCap);
			}
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

}
