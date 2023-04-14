package xyz.contagent.behaviour.messages.performedbehaviour;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.contagent.behaviour.Behaviour;
import xyz.contagent.core.messages.Message;

import java.util.UUID;

public class PerformedBehaviourMessage implements Message {
    private final @NotNull UUID uuid;
    private final @NotNull UUID sender;
    private final @NotNull UUID destination;

    private final @NotNull Behaviour performedBehaviour;

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
