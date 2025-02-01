package lesson20.interfaces;

import java.util.List;

/**
 * The implementation of this interface is designed to read an object located in the storage
 * associated with this ObjectStorageReader.
 */
public interface ObjectStorageReader {

    /**
     * This method reads the entire contents of the object and returns it as an array of bytes.
     *
     * @param nameSpace describes the space from which the object should read
     * @param name      of the object
     * @return representation of the object as a byte array.
     */
    byte[] read(String nameSpace, String name);

    /**
     * This method reads the contents of the object in parts based on the passed argument,
     * and returns it as a list from an array of bytes.
     *
     * @param nameSpace describes the space from which the object should read
     * @param name      of the object
     * @param chunkSize the abstract size of one part of an associated object
     * @return list from an array of bytes
     */
    List<byte[]> read(String nameSpace, String name, int chunkSize);
}
