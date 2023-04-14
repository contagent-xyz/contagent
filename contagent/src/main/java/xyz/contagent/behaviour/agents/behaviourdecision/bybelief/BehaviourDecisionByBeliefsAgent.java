package xyz.contagent.behaviour.agents.behaviourdecision.bybelief;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.contagent.behaviour.Behaviour;
import xyz.contagent.behaviour.agents.behaviourdecision.BehaviourDecisionAgent;
import xyz.contagent.belief.Belief;
import xyz.contagent.belief.BeliefActivation;
import xyz.contagent.core.messages.Message;

import java.util.*;

public class BehaviourDecisionByBeliefsAgent implements BehaviourDecisionAgent {
    private final @NotNull UUID uuid;

    private final @NotNull Collection<Behaviour> behaviours;

    private final @NotNull Collection<BeliefActivation> beliefActivations;

    private final @NotNull Map<Belief, Map<Behaviour, PerformanceRelationship>> performanceRelationships;

    public BehaviourDecisionByBeliefsAgent(@Nullable final UUID uuid, @NotNull final Collection<Behaviour> behaviours
            , @NotNull final Collection<BeliefActivation> beliefActivations,
                                           @NotNull final Collection<PerformanceRelationship> performanceRelationships) {
        this.uuid = uuid == null ? UUID.randomUUID() : uuid;
        this.behaviours = behaviours;
        this.beliefActivations = beliefActivations;
        this.performanceRelationships = new HashMap<>();
        for (final PerformanceRelationship pr : performanceRelationships) {
            final var belief = pr.belief();
            final var behaviour = pr.behaviour();
            final var map = this.performanceRelationships.getOrDefault(belief, new HashMap<>());
            map.put(behaviour, pr);
            this.performanceRelationships.put(belief, map);
        }
    }

    @Override
    public Behaviour chooseBehaviour() {
        final var probabilities = calculateUnnormalizedProbabilities().stream().sorted().toList();
        final var lastElement = probabilities.get(probabilities.size() - 1);
        if (lastElement.probability() < 0) {
            return lastElement.behaviour();
        }

        final var filteredProbabilities = probabilities.stream().filter(p -> p.probability() >= 0.0).toList();
        if (filteredProbabilities.size() == 1) {
            return filteredProbabilities.get(0).behaviour();
        }

        final var normalizingFactor = filteredProbabilities.stream().mapToDouble(BehaviourProbability::probability).sum();

        final var normalizedProbabilities = filteredProbabilities.stream().map(p -> new BehaviourProbability(p.behaviour(), p.probability() / normalizingFactor)).toList();

        var chosenBehaviour = normalizedProbabilities.get(normalizedProbabilities.size() - 1).behaviour();

        var rv = new Random().nextDouble();
        for (final var probability : normalizedProbabilities) {
            rv -= probability.probability();
            if (rv <= 0.0) {
                chosenBehaviour = probability.behaviour();
                break;
            }
        }

        return chosenBehaviour;
    }

    private List<BehaviourProbability> calculateUnnormalizedProbabilities() {
        var probabilities = new ArrayList<BehaviourProbability>(behaviours.size());
        for (final var behaviour : behaviours) {
            var probability = 0.0;
            for (final var activation : beliefActivations) {
                var prsMap = performanceRelationships.get(activation.belief());
                if (prsMap == null) {
                    continue;
                }
                var pr = prsMap.get(behaviour);
                if (pr == null) {
                    continue;
                }
                probability += activation.activation() * pr.relationship();
            }
            probabilities.add(new BehaviourProbability(behaviour, probability));
        }
        return probabilities;
    }

    @Override
    public void handleMessage(final @NotNull Message message) {
        throw new UnsupportedOperationException("This agent handles no messages");
    }

    @Override
    public @NotNull UUID getUUID() {
        return uuid;
    }
}
