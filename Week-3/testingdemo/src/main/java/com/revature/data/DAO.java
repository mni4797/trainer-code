package com.revature.data;

import java.util.ArrayList;

/***
 * DAO interface
 * 
 * @author Marielle Nolasco
 ***/
public interface DAO<T, K> {
    void addInstance(T newInstance);

    T getInstanceById(K id);

    ArrayList<T> getAllInstances();

    void updateInstance(T updatedInstance);

    void deleteInstanceById(K id);
}
