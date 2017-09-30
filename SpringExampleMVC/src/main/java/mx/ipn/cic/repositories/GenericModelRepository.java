package mx.ipn.cic.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GenericModelRepository<T> {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<T> fetchAll(Class<T> classType) {

		Session session = null;
		List<T> registers = null;

		try {

			session = this.sessionFactory.openSession();
			registers = (List<T>) session.createCriteria(classType).list();

		} catch (HibernateException e) {

		} finally {
			session.close();
		}

		return registers;

	}

	@SuppressWarnings("unchecked")
	public T fetchById(Class<T> classType, Integer id) {

		Session session = null;
		T register = null;

		try {

			session = this.sessionFactory.openSession();

			register = (T) session.get(classType, id);

		} catch (HibernateException e) {

			System.out.println(e.getStackTrace());

		} finally {
			session.close();
		}

		return register;

	}

	public T save(T entity) {

		Session session = null;

		try {

			session = this.sessionFactory.openSession();

			session.save(entity);

		} catch (HibernateException e) {

			entity = null;

		} finally {

			session.close();

		}

		return entity;

	}

	public T update(T entity) {

		Session session = null;

		try {
			
			session = this.sessionFactory.openSession();
			
			Transaction transaction = session.beginTransaction();

			session.update(entity);
			
			transaction.commit();

		} catch (HibernateException e) {

			entity = null;
			
			System.out.println(e.getStackTrace());

		} finally {

			session.close();

		}

		return entity;

	}

	public boolean delete(T entity) {

		Session session = null;
		boolean success;

		try {

			session = this.sessionFactory.openSession();
			
			Transaction transaction = session.beginTransaction();

			session.delete(entity);

			transaction.commit();
			
			success = true;

		} catch (HibernateException e) {

			success = false;
			
			System.out.println(e.getStackTrace());

		} finally {

			session.close();

		}

		return success;

	}
}