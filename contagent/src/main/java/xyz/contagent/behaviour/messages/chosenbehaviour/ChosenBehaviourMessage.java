package xyz.contagent.behaviour.messages.chosenbehaviour;

import xyz.contagent.behaviour.Behaviour;
import xyz.contagent.behaviour.agents.behaviourdecision.BehaviourDecisionAgent;
import xyz.contagent.core.messages.Message;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class ChosenBehaviourMessage implements Message {
    private final @NotNull UUID uuid;
    private final @NotNull UUID sender;
    private final @NotNull UUID destination;

    private final @NotNull Behaviour chosenBehaviour;

    public ChosenBehaviourMessage(final @Nullable UUID uuid, final @NotNull BehaviourDecisionAgent sender,
                                  final @NotNull UUID destination, final @NotNull Behaviour chosenBehaviour) {
        this.uuid = uuid == null ? UUID.randomUUID() : uuid;
        this.sender = sender.getUUID();
        this.destination = destination;
        this.chosenBehaviour = chosenBehaviour;
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

    public @NotNull Behaviour getChosenBehaviour() {
        return chosenBehaviour;
    }
}
