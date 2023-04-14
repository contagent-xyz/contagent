package xyz.contagent.behaviour.agents.behaviourdecision;

import org.jetbrains.annotations.NotNull;
import xyz.contagent.behaviour.Behaviour;
import xyz.contagent.behaviour.messages.chosenbehaviour.ChosenBehaviourMessage;
import xyz.contagent.core.agents.Agent;
import xyz.contagent.core.simulationmanager.SimulationManager;

import java.util.UUID;

public interface BehaviourDecisionAgent extends Agent {
    Behaviour chooseBehaviour();

    default void chooseAndInformChosenBehaviour(@NotNull final SimulationManager simulationManager, @NotNull final UUID destination) {
        var behaviour = chooseBehaviour();
        var message = new ChosenBehaviourMessage(null, this, destination, behaviour);
        simulationManager.sendMessageNow(message);
    }
}
