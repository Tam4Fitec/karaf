package com.leguide.backoffice.karaf.dao.brands;

import com.leguide.backoffice.karaf.brands.common.business.model.AbstractBO;
import com.leguide.backoffice.karaf.dao.brands.entity.AbstractDTO;

public interface IDAO<BO extends AbstractBO, DTO extends AbstractDTO> {

    /**
     * To synchronize the persistent context with the DB.
     */
    void flush();

    /**
     * To put an entity in the persistent context.
     * 
     * @param entity the entity to persist
     */
    BO persist(BO entity);

    /**
     * Remove an entity from the persistent context.
     * 
     * @param Long id of the entity to delete
     */
    void delete(Long id);

    /**
     * Merge an entity with the object of the persistence context with the same
     * primary key.
     * 
     * @param entity to merge
     * @return the object T of the persistence context
     */
    BO merge(BO entity);

    /**
     * Put an entity in the persistent context the object from the DB found by
     * its id.
     * 
     * @param id the primary key
     * @return An entity
     */
    BO findById(Long id);

    /**
     * Check if an entity is in the current persistent context.
     * 
     * @param modelObject to check
     * @return a boolean
     */
    boolean isTransient(BO modelObject);

}
