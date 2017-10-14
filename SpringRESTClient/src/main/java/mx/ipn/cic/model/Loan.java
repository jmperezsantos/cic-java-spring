package mx.ipn.cic.model;

import java.io.Serializable;
import java.util.Date;


public class Loan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private User user;

	private Book book;

	
	private Date date;

	public Loan(User user, Book book, Date date) {
		super();
		this.user = user;
		this.book = book;
		this.date = date;
	}

	public Loan() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Loan [id=" + id + ", user=" + user + ", book=" + book + ", date=" + date + "]";
	}

}
