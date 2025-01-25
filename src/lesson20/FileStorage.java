package lesson20;

import lesson20.exceptions.ObjectNotFoundException;
import lesson20.interfaces.ObjectStorage;

import java.util.HashMap;
import java.util.Map;

/**
 * The class stores information about the location of files located on the local device.
 *
 * @param <Path> to files located on the local device.
 */
public class FileStorage<Path> implements ObjectStorage<Path> {

    /**
     * Map that represents the storage of information.
     *
     * key - costom key includes a pair of namespace and name.
     * value - path to the file on local storage.
     */
    private final Map<PairKey, Path> fileMap = new HashMap<>();

    @Override
    public void put(String namespace, String name, Path path) {
        fileMap.put(new PairKey(namespace, name), path);
    }

    @Override
    public Path get(String namespace, String name) throws ObjectNotFoundException {
        PairKey key = new PairKey(namespace, name);
        if (fileMap.containsKey(key)) {
            return fileMap.get(key);
        } else {
            throw new ObjectNotFoundException("There is no such object in the storage.");
        }
    }
}
