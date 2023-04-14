package xyz.contagent.belief;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.contagent.behaviour.Behaviour;
import xyz.contagent.core.properties.Named;
import xyz.contagent.core.properties.UUIDd;

public interface Belief extends UUIDd, Named {
    @Nullable Double getPerception(@NotNull Behaviour behaviour);
    void setPerception(@NotNull Behaviour behaviour, @Nullable Double perception);
    @Nullable Double getRelationship(@NotNull Belief belief);
    void setRelationship(@NotNull Belief belief, @Nullable Double relationship);
}
