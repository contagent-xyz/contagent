package xyz.contagent.behaviour;

import xyz.contagent.core.properties.Named;
import xyz.contagent.core.properties.UUIDd;

/**
 * A {@link Behaviour} is some action that an {@link xyz.contagent.core.agents.Agent Agent} can perform.
 * It is both {@link Named} and {@link UUIDd}.
 *
 * @author Robert Greener
 * @since v0.0.4
 */
public interface Behaviour extends UUIDd, Named {
}
