package vendingmachine.helper;

public class Bucket<E, V> {
    private E first;
    private V second;

    public Bucket(E first, V second) {
        this.first = first;
        this.second = second;
    }

    public E getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    //todo
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
