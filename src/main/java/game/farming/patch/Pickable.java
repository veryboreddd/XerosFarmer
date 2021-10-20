package game.farming.patch;

import simple.api.wrappers.SimpleGameObject;

/**
 * @author Fluffyman
 * @data 10/20/2021
 */
public interface Pickable {
    boolean pickPatch(SimpleGameObject patch);
    boolean isHerbGrowing(SimpleGameObject patch);
    boolean isPickable(SimpleGameObject patch);
}
