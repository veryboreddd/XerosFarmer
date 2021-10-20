package game.farming.patch;

import simple.api.wrappers.SimpleGameObject;

/**
 * @author Fluffyman
 * @data 10/20/2021
 */
public interface Rakeable {
    boolean rakePatch(SimpleGameObject patch);
    boolean isRaked(SimpleGameObject patch);
}
