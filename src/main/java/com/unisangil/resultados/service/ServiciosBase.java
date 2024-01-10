package com.unisangil.resultados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class ServiciosBase<T, ID> implements IServiciosBase<T, ID> {

	@Autowired
	private JpaRepository<T, ID> t;

	@Override
	public T create(T entity) {
		return t.save(entity);
	}

	@Override
	public T update(ID id, T entity) {
		if (findById(id) == null)
			return null;
		return t.save(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(ID id) {
		return (T) t.findById(id);
	}

	@Override
	public List<T> findAll() {
		return t.findAll();
	}

	@Override
	public void deleteById(ID id) {
		t.deleteById(id);
	}

}

/*
 @Override
    public Optional<T> update(ID id, T entity) {
        if (findById(id).isPresent()) {
            return Optional.empty();
        }
        return Optional.of(t.save(entity));
    }

    @SuppressWarnings("unchecked")
    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(t.findById(id).orElse(null));
    }
 */
