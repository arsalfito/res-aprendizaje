package com.unisangil.resultados.service;

import java.util.List;

public interface IServiciosBase<T, ID> {

	T create(T entity);

	T update(ID id, T entity);

	T findById(ID id);

	List<T> findAll();

	void deleteById(ID id);

}
