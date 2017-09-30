package mx.ipn.cic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.ipn.cic.repositories.GenericModelRepository;

@Service
public class GenericModelService<T> {

	@Autowired
	private GenericModelRepository<T> genericRepository;

	public List<T> getAll(Class<T> classType) {

		List<T> entities = this.genericRepository.fetchAll(classType);

		return entities;

	}

	public T findById(Class<T> classType, Integer id) {

		T entity = this.genericRepository.fetchById(classType, id);

		return entity;

	}

	public T create(T entity) {

		entity = this.genericRepository.save(entity);

		return entity;
	}

	public T update(T entity) {

		entity = this.genericRepository.update(entity);
		
		return entity;

	}
	
	public boolean delete(Class<T> classType, Integer id) {

		T entity = this.findById(classType, id);
		
		boolean success = this.genericRepository.delete(entity);
		
		return success;
		
	}
}
