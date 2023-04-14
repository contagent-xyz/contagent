package xyz.contagent.belief;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.contagent.behaviour.Behaviour;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CoreBelief implements Belief {
    private final @NotNull UUID uuid;

    private final @NotNull String name;

    private final @NotNull Map<UUID, Double> perceptions = new HashMap<>();

    private final @NotNull Map<UUID, Double> relationships = new HashMap<>();

    public CoreBelief(final @Nullable UUID uuid, final @NotNull String name) {
        this.uuid = uuid == null ? UUID.randomUUID() : uuid;
        this.name = name;
    }

    @Override
    public @Nullable Double getPerception(@NotNull final Behaviour behaviour) {
        return perceptions.get(behaviour.getUUID());
    }

    @Override
    public void setPerception(@NotNull final Behaviour behaviour, @Nullable final Double perception) {
        perceptions.put(behaviour.getUUID(), perception);
    }

    @Override
    public @Nullable Double getRelationship(@NotNull final Belief belief) {
        return relationships.get(belief.getUUID());
    }

    @Override
    public void setRelationship(@NotNull final Belief belief, @Nullable final Double relationship) {
        relationships.put(belief.getUUID(), relationship);
    }

    @Override
    public @NotNull String getName() {
        return name;
    }

    @Override
    public @NotNull UUID getUUID() {
        return uuid;
    }
}
