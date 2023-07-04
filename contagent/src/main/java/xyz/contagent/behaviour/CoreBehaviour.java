package xyz.contagent.behaviour;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * {@link CoreBehaviour} is the basic implementation of {@link Behaviour}.
 *
 * @author Robert Greener
 * @since v0.0.4
 */
public class CoreBehaviour implements Behaviour {
    /**
     * The {@link UUID} of the {@link CoreBehaviour}.
     *
     * @since v0.0.4
     */
    private final @NotNull UUID uuid;

    /**
     * The name of the {@link CoreBehaviour}.
     *
     * @since v0.0.4
     */
    private final @NotNull String name;

    /**
     * Create a new {@link CoreBehaviour}.
     *
     * @param uuid The {@link UUID}. If {@code null} then {@linkplain UUID#randomUUID() generates} a random {@link UUID}.
     * @param name The name.
     * @author Robert Greener
     * @since v0.0.4
     */
    public CoreBehaviour(final @Nullable UUID uuid, final @NotNull String name) {
        this.uuid = uuid == null ? UUID.randomUUID() : uuid;
        this.name = name;
    }

    /**
     * Get the {@link UUID} of the {@link CoreBehaviour}.
     * @return The {@link UUID}.
     * @author Robert Greener
     * @since v0.0.4
     */
    @Override
    public @NotNull UUID getUUID() {
        return uuid;
    }

    /**
     * Get the name of the {@link CoreBehaviour}.
     * @return The name.
     * @author Robert Greener
     * @since v0.0.4
     */
    @Override
    public @NotNull String getName() {
        return name;
    }
}