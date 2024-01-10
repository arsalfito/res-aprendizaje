package com.unisangil.resultados.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.unisangil.resultados.service.ServiciosBase;

public class ControladorBase<T, ID> implements IControladorBase<T, ID> {

	@Autowired
	private ServiciosBase<T, ID> t;

	@Override
	@PostMapping("/")
	public ResponseEntity<T> create(@RequestBody T entity) {
		T db = t.create(entity);
		return new ResponseEntity<T>(db, HttpStatus.ACCEPTED);
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<T> update(@PathVariable("id") ID id, @RequestBody T entity) {
		T db = t.update(id, entity);
		return new ResponseEntity<T>(db, HttpStatus.ACCEPTED);
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<T> findById(@PathVariable("id") ID id) {
		T db = t.findById(id);
		return new ResponseEntity<T>(db, HttpStatus.ACCEPTED);
	}

	@Override
	@GetMapping("/")
	public ResponseEntity<List<T>> findAll() {
		List<T> list = t.findAll();
		return new ResponseEntity<List<T>>(list, HttpStatus.ACCEPTED);
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteById(@PathVariable("id") ID id) {
		t.deleteById(id);
		return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
	}

}

