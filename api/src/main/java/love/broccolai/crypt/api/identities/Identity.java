package love.broccolai.crypt.api.identities;

import org.jspecify.annotations.NullMarked;

@NullMarked
public interface Identity extends Comparable<Identity> {

    char SEPARATOR = ':';

    String namespace();

    String value();

}
