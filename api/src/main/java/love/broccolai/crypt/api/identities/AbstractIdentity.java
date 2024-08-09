package love.broccolai.crypt.api.identities;

import java.util.Comparator;
import java.util.Objects;
import org.jspecify.annotations.NullMarked;

@NullMarked
public abstract class AbstractIdentity implements Identity {

    static final Comparator<? super Identity> COMPARATOR = Comparator.comparing(Identity::namespace).thenComparing(Identity::value);

    private final String namespace;
    private final String value;

    //todo: maybe move all the implementations to the same directory so this can be package private
    public AbstractIdentity(final String namespace, final String value) {
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
    public String toString() {
        return this.namespace + SEPARATOR + this.value;
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Identity)) {
            return false;
        }

        Identity that = (Identity) other;
        return Objects.equals(this.namespace, that.namespace()) && Objects.equals(this.value, that.value());
    }

    @Override
    public int hashCode() {
        int result = this.namespace.hashCode();
        result = (31 * result) + this.value.hashCode();
        return result;
    }

    @Override
    public int compareTo(final Identity that) {
        return COMPARATOR.compare(this, that);
    }
}
