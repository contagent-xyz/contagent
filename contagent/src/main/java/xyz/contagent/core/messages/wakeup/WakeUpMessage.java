package xyz.contagent.core.messages.wakeup;

import xyz.contagent.core.agents.Agent;
import xyz.contagent.core.messages.Message;
import xyz.contagent.core.simulationmanager.SimulationManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * A {@link WakeUpMessage} is a {@link Message} that is sent to an {@link Agent} at a specific time.
 *
 * @author Robert Greener
 * @since v0.0.1
 */
public class WakeUpMessage implements Message {
    /**
     * The {@link UUID} of the {@link Agent} that this {@link WakeUpMessage} is sent to and from.
     *
     * @since v0.0.1
     */
    private final @NotNull UUID agentUuid;

    /**
     * The {@link UUID} of this {@link WakeUpMessage}.
     *
     * @since v0.0.1
     */
    private final @NotNull UUID uuid;

    /**
     * The time that this {@link WakeUpMessage} is sent.
     *
     * @since v0.0.1
     */
    private final @NotNull ZonedDateTime wakeTime;

    /**
     * Create a new {@link WakeUpMessage}.
     * If the {@link UUID} is null, a new {@link UUID} will be generated.
     *
     * @param simulationManager The {@link SimulationManager} that this {@link WakeUpMessage} is sent to.
     * @param uuid              The {@link UUID} of this {@link WakeUpMessage}.
     * @param agent             The {@link Agent} that this {@link WakeUpMessage} is sent to and from.
     * @param wakeTime          The time that this {@link WakeUpMessage} is sent.
     * @author Robert Greener
     * @since v0.0.1
     */
    public WakeUpMessage(final @NotNull SimulationManager simulationManager, final @Nullable UUID uuid,
                         final @NotNull Agent agent, final @NotNull ZonedDateTime wakeTime) {
        this.uuid = uuid == null ? UUID.randomUUID() : uuid;
        this.wakeTime = wakeTime;
        this.agentUuid = agent.getUUID();

        simulationManager.scheduleMessage(this, getWakeTime());
    }

    /**
     * Get the {@link UUID} of the {@link Agent} that this {@link WakeUpMessage} is sent to and from.
     *
     * @return The {@link UUID}.
     * @author Robert Greener
     * @since v0.0.1
     */
    @Override
    public @NotNull UUID getDestination() {
        return agentUuid;
    }

    /**
     * Get the {@link UUID} of the {@link Agent} that this {@link WakeUpMessage} is sent to and from.
     *
     * @return The {@link UUID}.
     * @author Robert Greener
     * @since v0.0.1
     */
    @Override
    public @NotNull UUID getSender() {
        return agentUuid;
    }

    /**
     * Get the {@link UUID} of this {@link WakeUpMessage}.
     *
     * @return The {@link UUID}.
     * @author Robert Greener
     * @since v0.0.1
     */
    @Override
    public @NotNull UUID getUUID() {
        return uuid;
    }

    /**
     * Get the time that this {@link WakeUpMessage} is sent.
     *
     * @return The time that this {@link WakeUpMessage} is sent.
     * @since v0.0.1
     */
    public @NotNull ZonedDateTime getWakeTime() {
        return wakeTime;
    }

    /**
     * Get a {@link String} representation of this {@link WakeUpMessage}.
     *
     * @return The {@link String} representation of this {@link WakeUpMessage}.
     * @since v0.0.1
     */
    @Override
    public String toString() {
        return "WakeUpMessage{" + "sender=" + getSender() + ", destination=" + getDestination() + ", uuid=" + uuid +
                ", wakeTime=" + wakeTime + '}';
    }
}
