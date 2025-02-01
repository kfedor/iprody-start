package lesson20.interfaces;

import lesson20.exceptions.ObjectNotFoundException;

/**
 * The implementation of this interface stores information about the location of objects associated with this storage.
 */
public interface ObjectStorage<T> {

    /**
     * Method puts object to Object storage.
     *
     * @param namespace describes the space where the object should be added
     * @param name      of an object
     * @param object    object to put to storage
     */
    void put(String namespace, String name, T object);

    /**
     * The method gets and returns from Object storage the object associated with the passed name and namespace.
     *
     * @param namespace describes the space where the object should be added.
     * @param name of an object.
     * @return the object associated with the passed name and namespace.
     * @throws ObjectNotFoundException if there is no any object associated with the passed name and namespace.
     */
    T get(String namespace, String name) throws ObjectNotFoundException;
}
