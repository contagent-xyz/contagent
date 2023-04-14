package xyz.contagent.belief;

import org.jetbrains.annotations.NotNull;

public record BeliefActivation(@NotNull Belief belief, double activation) {
}
