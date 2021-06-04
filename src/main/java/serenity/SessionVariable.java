package serenity;

import net.serenitybdd.core.Serenity;

public interface SessionVariable {

    default <T> void set(final T value) {
        Serenity.setSessionVariable(this).to(value);
    }

    default <T> T get() {
        return Serenity.sessionVariableCalled(this);
    }

    default void clear() {
        set(null);
    }
}
