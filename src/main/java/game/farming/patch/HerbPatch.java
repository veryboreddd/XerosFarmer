package game.farming.patch;

import game.farming.seed.HerbSeed;
import lombok.AllArgsConstructor;
import lombok.Getter;
import script.Farmer;
import simple.api.wrappers.SimpleGameObject;
import simple.api.wrappers.SimpleItem;
import utilities.FarmTimer;

import java.util.Objects;


/**
 * @author Fluffyman
 * @data 10/20/2021
 */
@AllArgsConstructor
@Getter
public class HerbPatch extends Patch {
    /**
     * The farm enum for this herb patch.
     */
    private final Farm farm;

    /**
     * List of all herb seeds.
     */
    private final int[] HERB_SEED_LIST = {5291};

    /**
     * Teleport to the farm.
     * @return teleport successful.
     */
    public boolean teleport() {
        if(context.players.getLocal().within(farm.getFarmArea())) {
            return true;
        } else {
            if(farm.isUseWizard()) {
                if(teleportByWizard()) {
                    return true;
                }
            } else {
                if(teleportByTeleporter()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Teleports using the wizard.
     * @return teleport successful.
     */
    // TODO: 10/20/2021 ADD
    private boolean teleportByWizard() {
        return false;
    }

    /**
     * Teleports using the teleporter.
     * @return teleport successful.
     */
    private boolean teleportByTeleporter(){
        if(context.teleporter.opened()) {
            if(context.teleporter.teleportStringPath(farm.getTeleportString()[0], farm.getTeleportString()[1])) {
                if(context.onCondition(() -> context.players.getLocal().within(farm.getFarmArea()))) {
                    return true;
                }
            }
        } else {
            if(context.teleporter.open()) {
                return teleportByWizard();
            }
        }
        return false;
    }

    /**
     * Gets the farming patch as a game object.
     * @return SimpleGameObject of the farming patch.
     */
    public SimpleGameObject getPatch() {
        return (SimpleGameObject) context.objects.populate().filter(farm.getPatchID()).nearest().next();
    }

    /**
     * Rake the current herb patch.
     * @return Raking successful.
     */
    public boolean rakePatch() {
        return super.rakePatch(getPatch());
    }

    /**
     * Check if the current herb patch is raked.
     * @return Raked?
     */
    public boolean isRaked() {
        return super.isRaked(getPatch());
    }

    /**
     * Pick the herb patch.
     * @return Picking Successful.
     */
    public boolean pickPatch() {
        return super.pickPatch(getPatch());
    }

    /**
     * Check if the patch has been picked.
     * @return picked?
     */
    public boolean isHerbGrowing() {
        return super.isHerbGrowing(getPatch());
    }

    /**
     * Check if the patch is currently pickable.
     * @return pickable?
     */
    public boolean isPickable() {
        return super.isPickable(getPatch());
    }

    /**
     * Plants a herb seed.
     * @return Planting Successful.
     */
    public boolean plantHerbSeed() {
        SimpleItem herb = context.inventory.populate().filter(HERB_SEED_LIST).next();
        if(Objects.nonNull(herb)) {
            HerbSeed herbSeed = new HerbSeed(herb);
            if(herbSeed.plant(getPatch())) {
                Farmer.PLANTED_HERBS.put(new FarmTimer(herbSeed.getPlantTime(), 7), this);
                return true;
            }
        }
        return false;
    }
}
