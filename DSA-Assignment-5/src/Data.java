public class Data<T> {

    String key;
    T value;

    public Data(String key, T value) {
        this.key = key;
        this.value = value;
    }

    // Getter Setter methods
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "key=" + key + ", value=" + value;
    }
}
