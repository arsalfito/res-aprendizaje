package com.unisangil.resultados.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface IControladorBase<T, ID> {

	ResponseEntity<T> create(T entity);

	ResponseEntity<T> update(ID id, T entity);

	ResponseEntity<T> findById(ID id);

	ResponseEntity<List<T>> findAll();

	ResponseEntity<Boolean> deleteById(ID id);

}
