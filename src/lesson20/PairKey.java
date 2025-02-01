package lesson20;

import java.util.Objects;

/**
 * The class creates a custom key which is used to get path to objects in storage.
 */
public class PairKey {

    private final String namespace;
    private final String name;

    /**
     * Constructs a pair key.
     * @param namespace
     * @param name
     */
    public PairKey(String namespace, String name) {
        this.namespace = namespace;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairKey pairKey = (PairKey) o;
        return Objects.equals(namespace, pairKey.namespace) && Objects.equals(name, pairKey.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(namespace, name);
    }
}
