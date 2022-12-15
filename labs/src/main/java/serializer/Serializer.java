package serializer;

public interface Serializer {
    void serialize(Object obj, String path);

    <T> T deserialize(Class<T> className, String path);
}

