package xyz.contagent.behaviour.agents.behaviourdecision.bybelief;

import org.jetbrains.annotations.NotNull;
import xyz.contagent.behaviour.Behaviour;
import xyz.contagent.belief.Belief;

public record PerformanceRelationship(@NotNull Belief belief, @NotNull Behaviour behaviour, double relationship) {
}
