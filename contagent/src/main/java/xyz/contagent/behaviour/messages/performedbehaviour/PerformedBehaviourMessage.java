package xyz.contagent.behaviour.messages.performedbehaviour;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.contagent.behaviour.Behaviour;
import xyz.contagent.core.messages.Message;

import java.util.UUID;

/**
 * A {@link PerformedBehaviourMessage} is a {@link Message} that is delivered when an {@link xyz.contagent.core.agents.Agent Agent}
 * has performed a {@link Behaviour}.
 *
 * @author Robert Greener
 * @since v0.0.4
 */
public class PerformedBehaviourMessage implements Message {
    /**
     * The {@link UUID} of the {@link PerformedBehaviourMessage}.
     * @since v0.0.4
     */
    private final @NotNull UUID uuid;

    /**
     * The {@link UUID} of the sending {@link xyz.contagent.core.agents.Agent Agent}; i.e., the one that performed the behaviour.
     * @since v0.0.4
     */
    private final @NotNull UUID sender;

    /**
     * The {@link UUID} of the receiving {@link xyz.contagent.core.agents.Agent Agent}.
     * @since v0.0.4
     */
    private final @NotNull UUID destination;

    /**
     * The {@link Behaviour} that was performed.
     * @since v0.0.4
     */
    private final @NotNull Behaviour performedBehaviour;

    /**
     * Create a new {@link PerformedBehaviourMessage}.
     * @param uuid The {@link UUID} of the message. If {@code null}, one is {@linkplain UUID#randomUUID() generated randomly}.
     * @param sender The {@link UUID} of the sender. i.e., the {@link UUID} of the {@link xyz.contagent.core.agents.Agent Agent}
     *               that performed the {@link Behaviour}.
     * @param destination The destination {@link UUID} of the message. If {@code null}, as could be the case if enclosed in a social message,
     *                    this is then set to the 0 {@link UUID}.
     * @param performedBehaviour The {@link Behaviour} that was performed.
     * @author Robert Greener
     * @since v0.0.4
     */
    public PerformedBehaviourMessage(@Nullable final UUID uuid, @NotNull final UUID sender,
                                     @Nullable final UUID destination, @NotNull final Behaviour performedBehaviour) {
        this.uuid = uuid == null ? UUID.randomUUID() : uuid;
        this.sender = sender;
        // If destination is null, as could be case if enclosed in a SocialMessage, then set it to 0 uuid.
        this.destination = destination == null ? new UUID(0, 0) : destination;
        this.performedBehaviour = performedBehaviour;
    }

    @Override
    public @NotNull UUID getDestination() {
        return destination;
    }

    @Override
    public @NotNull UUID getSender() {
        return sender;
    }

    @Override
    public @NotNull UUID getUUID() {
        return uuid;
    }

    public @NotNull Behaviour getPerformedBehaviour() {
        return performedBehaviour;
    }
}
