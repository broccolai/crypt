package love.broccolai.crypt.api.key;

import org.jspecify.annotations.NullMarked;

@NullMarked
public interface Key extends Comparable<Key>, Keyed {

    char SEPARATOR = ':';

    static Key key(final String namespace, final String value) {
        return new SimpleKey(namespace, value);
    }

    String namespace();

    String value();

}
