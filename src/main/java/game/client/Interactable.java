package game.client;

import simple.api.actions.SimpleItemActions;
import simple.api.actions.SimpleObjectActions;
import simple.api.wrappers.SimpleGameObject;
import simple.api.wrappers.SimpleItem;

import java.util.function.BooleanSupplier;

/**
 * @author Fluffyman
 * @data 10/20/2021
 */
public class Interactable implements Accessible {

    /**
     * Interacts with a Simple Game Object.
     * @param intractable Game object to interact with.
     * @param action Action id.
     * @param condition Expression to be met.
     * @return Status of condition.
     */
    public boolean interact(SimpleGameObject intractable, SimpleObjectActions action, BooleanSupplier condition) {
        if(intractable.interact(action)) {
            if(context.onCondition(condition, 500, 20)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Interacts with a Simple Game Object.
     * @param intractable Game object to interact with.
     * @param action Action id.
     * @param condition Expression to be met.
     * @return Status of condition.
     */
    public boolean interact(SimpleGameObject intractable, SimpleObjectActions action, BooleanSupplier condition, int timeout, int times) {
        if(intractable.interact(action)) {
            if(context.onCondition(condition, timeout, times)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Interacts with a Simple Game Object.
     * @param intractable Game object to interact with.
     * @param action Action id.
     * @param condition Expression to be met.
     * @return Status of condition.
     */
    public boolean interact(SimpleGameObject intractable, int action, BooleanSupplier condition) {
        if(intractable.interact(action)) {
            if(context.onCondition(condition, 500, 20)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Interacts with a Simple Game Object.
     * @param intractable Game object to interact with.
     * @param action Action id.
     * @param condition Expression to be met.
     * @return Status of condition.
     */
    public boolean interact(SimpleGameObject intractable, int action, BooleanSupplier condition, int timeout, int times) {
        if(intractable.interact(action)) {
            if(context.onCondition(condition, timeout, times)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Interacts with a Simple Item.
     * @param intractable Item to interact with.
     * @param action Action id.
     * @param condition Expression to be met.
     * @return Status of condition.
     */
    public boolean interact(SimpleItem intractable, SimpleItemActions action, BooleanSupplier condition) {
        if(intractable.interact(action)) {
            if(context.onCondition(condition, 500, 20)) {
                return true;
            }
        }
        return false;
    }
}
