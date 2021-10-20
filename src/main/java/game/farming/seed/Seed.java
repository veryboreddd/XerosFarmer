package game.farming.seed;

import game.client.Accessible;
import game.client.Interactable;
import simple.api.actions.SimpleItemActions;
import simple.api.wrappers.SimpleGameObject;
import simple.api.wrappers.SimpleItem;

/**
 * @author Fluffyman
 * @data 10/20/2021
 */
public class Seed extends Interactable implements Plantable, Accessible {

    /**
     * Plants a seed at a patch.
     * @param patch patch object
     * @param seed seed item
     * @return condition met
     */
    @Override
    public boolean plant(SimpleGameObject patch, SimpleItem seed) {
        if(this.interact(seed, SimpleItemActions.USE, () -> true)) {
            if(this.interact(patch, 62, () -> context.players.getLocal().isAnimating())) {
                return true;
            }
        }
        return false;
    }
}
