// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// November 7, 2021
// This is our own work

package com.gcu.data;

import java.util.List;
import java.util.Optional;
import com.gcu.util.DatabaseException;

public interface DataAccessInterface<T> {
	public List<T> findAll() throws DatabaseException;

	public Optional<T> findById(int id);
	// TODO Update from boolean for exception handling
	public boolean create(T t) throws DatabaseException;

	public boolean update(T t);

	public boolean delete(T t);
}
