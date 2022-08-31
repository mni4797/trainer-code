package com.revature.dao;

import java.util.List;

//CRUD
public interface Dao<T> {

    /**
     * Will add a pokemon row in our Pokemon table
     * @param instance - This object will be used to add to the database
     * @return - Will return the object with the generated Id
     */
    public T addInstance(T instance);

    /**
     * Will return a list of pokemon objects from the database
     * @return - Will return a list object collection
     */
    public List<T> getAllInstance();

    public T updateInstance(T instance);

    public T deleteInstance(T instance);
}
