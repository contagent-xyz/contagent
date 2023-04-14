package xyz.contagent.core.properties;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * This interface is used to mark classes that have a UUID.
 *
 * @author Robert Greener
 * @since v0.0.1
 */
public interface UUIDd {
    /**
     * Get the UUID of the object.
     *
     * @return The UUID of the object.
     * @author Robert Greener
     * @since v0.0.1
     */
    @NotNull UUID getUUID();
}
