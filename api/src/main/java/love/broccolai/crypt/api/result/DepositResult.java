package love.broccolai.crypt.api.result;

import org.jspecify.annotations.NullMarked;

@NullMarked
public interface DepositResult {

    static Success success() {
        return new Success();
    }

    static Failure failure(final Throwable reason) {
        return new Failure(reason);
    }

    final class Success implements DepositResult {
    }

    final class Failure implements DepositResult {

        private final Throwable reason;

        Failure(final Throwable reason) {
            this.reason = reason;
        }

        public Throwable reason() {
            return this.reason;
        }
    }

}
