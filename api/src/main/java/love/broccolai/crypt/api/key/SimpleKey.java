package love.broccolai.crypt.api.key;

import java.util.Comparator;
import java.util.Objects;
import org.jspecify.annotations.NullMarked;

@NullMarked
final class SimpleKey implements Key {

    static final Comparator<? super Key> COMPARATOR = Comparator.comparing(Key::namespace).thenComparing(Key::value);

    private final String namespace;
    private final String value;

    SimpleKey(final String namespace, final String value) {
        this.namespace = namespace;
        this.value = value;
    }

    @Override
    public String namespace() {
        return this.namespace;
    }

    @Override
    public String value() {
        return this.value;
    }

    @Override
    public Key key() {
        return this;
    }

    @Override
    public String toString() {
        return this.namespace + SEPARATOR + this.value;
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Key)) {
            return false;
        }

        Key that = (Key) other;
        return Objects.equals(this.namespace, that.namespace()) && Objects.equals(this.value, that.value());
    }

    @Override
    public int hashCode() {
        int result = this.namespace.hashCode();
        result = (31 * result) + this.value.hashCode();
        return result;
    }

    @Override
    public int compareTo(final Key that) {
        return COMPARATOR.compare(this, that);
    }
}
