package game.farming.patch;

import com.client.definitions.h;
import game.client.Interactable;
import game.object.ObjectDef;
import simple.api.wrappers.SimpleGameObject;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author Fluffyman
 * @data 10/20/2021
 */
public class Patch extends Interactable implements Rakeable, Pickable {
    /**
     * List of the growing herb models.
     */
    private final List<Integer> HERB_GROWING_MODELS = Arrays.asList(7871, 7872, 7873, 7874, 7875);

    /**
     * Rakes a herb patch.
     * @param patch the patch to interact with.
     * @return condition met.
     */
    @Override
    public boolean rakePatch(SimpleGameObject patch) {
        return this.interact(patch, 502, () -> isRaked(patch) && context.players.getLocal().getAnimation() != 2273, 500, 50);
    }

    /**
     * Checks if the patch is raked.
     * @param patch the patch to check.
     * @return patch raked.
     */
    @Override
    public boolean isRaked(SimpleGameObject patch) {
        h objectDefinition = ObjectDef.getObjectDefinition(patch.getId());
        if(Objects.nonNull(objectDefinition)) {
            return objectDefinition.t[0] == 7794;
        }
        return false;
    }

    /**
     * Picks a herb from the patch.
     * @param patch pick the patch.
     * @return success
     */
    @Override
    public boolean pickPatch(SimpleGameObject patch) {
        return this.interact(patch, 502, () -> !isPickable(patch), 500, 50);
    }

    /**
     * Checks if the patch has a herb growing on it.
     * @param patch the patch to check.
     * @return patch picked.
     */
    @Override
    public boolean isHerbGrowing(SimpleGameObject patch) {
        h objectDefinition = ObjectDef.getObjectDefinition(patch.getId());
        if(Objects.nonNull(objectDefinition)) {
            for(int modelID : objectDefinition.t) {
                if(HERB_GROWING_MODELS.contains(modelID)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if the patch has a finished herb on it.
     * @param patch patch to check.
     * @return patch pickable.
     */
    @Override
    public boolean isPickable(SimpleGameObject patch) {
        h objectDefinition = ObjectDef.getObjectDefinition(patch.getId());
        if(Objects.nonNull(objectDefinition)) {
            return objectDefinition.t[0] == 7875;
        }
        return false;
    }
}
