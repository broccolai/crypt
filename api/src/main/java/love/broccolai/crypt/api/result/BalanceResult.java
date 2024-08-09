package love.broccolai.crypt.api.result;

import org.jspecify.annotations.NullMarked;

@NullMarked
public interface BalanceResult {

    static Success success(final double result) {
        return new Success(result);
    }

    static Failure failure(final Throwable reason) {
        return new Failure(reason);
    }

    final class Success implements BalanceResult {

        private final double result;

        Success(final double result) {
            this.result = result;
        }

        public double result() {
            return this.result;
        }
    }

    final class Failure implements BalanceResult {

        private final Throwable reason;

        Failure(final Throwable reason) {
            this.reason = reason;
        }

        public Throwable reason() {
            return this.reason;
        }
    }

}
