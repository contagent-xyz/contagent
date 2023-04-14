package xyz.contagent.behaviour.agents.behaviourdecision.bybelief;

import org.jetbrains.annotations.NotNull;
import xyz.contagent.behaviour.Behaviour;

public record BehaviourProbability(@NotNull Behaviour behaviour, double probability) implements Comparable<BehaviourProbability> {
    @Override
    public int compareTo(@NotNull final BehaviourProbability o) {
        return Double.compare(probability, o.probability);
    }
}
