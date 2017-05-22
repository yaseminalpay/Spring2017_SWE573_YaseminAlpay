package com.funtweet.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wordnik.swagger.annotations.ApiOperation;

/**
 * Defines the CRUD operations.
 * @author Yasemin Alpay
 *
 * @param <T> Entity object
 */
public abstract class CRUDController <T> {
	
	@Autowired
	private JpaRepository<T, Long> repository;

	/**
	 * Lists all entities.
	 * @return Entity list
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value= "list", notes = "Lists all items.")
	public List<T> list()
	{
		return repository.findAll();
	}
	
	/**
	 * List one entity object with id.
	 * @param id 
	 * @return entity object
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value= "get", notes = "Get item by ID.")
	public T get(@PathVariable Long id)
	{
		return repository.findOne(id);
	}
	
	/**
	 * Creates new entity object.
	 * @param entity
	 * @return updated entity object
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value= "create", notes = "Creates an item.")
	public T create(@RequestBody T entity)
	{
		return repository.saveAndFlush(entity);
	}
	
	/**
	 * Updates entity object with id.
	 * @param id
	 * @param entity
	 * @return created entity object
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ApiOperation(value= "update", notes = "Updates an item.")
	public T update(@PathVariable Long id, @RequestBody T entity)
	{
		T existingEntity = repository.findOne(id);
		BeanUtils.copyProperties(entity, existingEntity);
		return repository.saveAndFlush(existingEntity);
	}
	
	/**
	 * Deletes entity object with id.
	 * @param id
	 * @return deleted object
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value= "delete", notes = "Deletes item by ID.")
	public T delete(@PathVariable Long id)
	{
		T existingEntity = repository.findOne(id);
		repository.delete(existingEntity);
		return existingEntity;
	}

}
