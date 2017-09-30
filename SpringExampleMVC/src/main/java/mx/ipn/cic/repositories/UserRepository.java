package mx.ipn.cic.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mx.ipn.cic.model.User;

@Repository
public class UserRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public List<User> fetchAll() {

		Session session = null;
		List<User> users = null;

		try {

			session = this.sessionFactory.openSession();
			users = session.createCriteria(User.class).list();

		} catch (HibernateException e) {

		} finally {
			session.close();
		}

		return users;

	}

	/**
	 * Método para obtener un usuario por su identificador
	 * 
	 * @param id
	 *            Identificador del usuario a buscar
	 * @return El usuario encontrado o "null" si no existe
	 */
	public User fetchById(Integer id) {

		Session session = null;
		User user = null;

		try {

			session = this.sessionFactory.openSession();

			user = (User) session.get(User.class, id);

		} catch (HibernateException e) {
			
			System.out.println(e.getStackTrace());

		} finally {
			session.close();
		}

		return user;

	}

	public User save(User user) {

		Session session = null;

		try {

			session = this.sessionFactory.openSession();

			session.save(user);

		} catch (HibernateException e) {

			user = null;

		} finally {

			session.close();

		}

		return user;

	}

	public User update(User user) {

		Session session = null;

		try {

			session = this.sessionFactory.openSession();

			session.update(user);

		} catch (HibernateException e) {

			user = null;

		} finally {

			session.close();

		}

		return user;

	}

	public boolean delete(User user) {

		Session session = null;
		boolean success;

		try {

			session = this.sessionFactory.openSession();

			session.delete(user);

			success = true;

		} catch (HibernateException e) {

			success = false;

		} finally {

			session.close();

		}

		return success;

	}

}
