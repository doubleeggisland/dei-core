package com.ioiox.dei.core.vo;

public class DeiKeyValueHolder<K, V> {
    private K key;
    private V value;

    public DeiKeyValueHolder() {

    }

    public DeiKeyValueHolder(final K key, final V value) {
        this.key = key;
        this.value = value;
    }

    private DeiKeyValueHolder(final Builder<K, V> builder) {
        this.key = builder.key;
        this.value = builder.value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public static class Builder<K, V> {
        private K key;
        private V value;
        public Builder<K, V> key(final K key) {
            this.key = key;
            return this;
        }
        public Builder<K, V> value(final V value) {
            this.value = value;
            return this;
        }
        public DeiKeyValueHolder<K, V> build() {
            return new DeiKeyValueHolder<>(this);
        }
    }
}
