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
	/**
	 * Returns List of Template Object Exception
	 * 
	 * @return List of Template Object
	 * @throws DatabaseException
	 */
	public List<T> findAll() throws DatabaseException;

	/**
	 * Returns object by Id
	 * 
	 * @param int
	 * @return Optional<T>
	 * @throws DatabaseException
	 */
	public Optional<T> findById(int id);

	/**
	 * Create Template Object
	 * 
	 * @param t
	 * @return boolean
	 * @throws DatabaseException
	 */
	public boolean create(T t) throws DatabaseException;

	/**
	 * Update Template Object
	 * 
	 * @param t
	 * @return boolean
	 * @throws DatabaseException
	 */
	public boolean update(T t) throws DatabaseException;

	/**
	 * Delete Template Object
	 * 
	 * @param t
	 * @return boolean
	 * @throws DatabaseException
	 */
	public boolean delete(T t) throws DatabaseException;
}
