package com.gcu.data;

import java.util.List;

public interface DataAccessInterface<T> {
	public List<T> findAll();

	public T findById(int id);
	// TODO Update from boolean for exception handling
	public boolean create(T t);

	public boolean update(T t);

	public boolean delete(T t);
}
