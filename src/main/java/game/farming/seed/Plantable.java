package game.farming.seed;

import simple.api.wrappers.SimpleGameObject;
import simple.api.wrappers.SimpleItem;

/**
 * @author Fluffyman
 * @data 10/20/2021
 */
public interface Plantable {
    boolean plant(SimpleGameObject patch, SimpleItem seed);
}
