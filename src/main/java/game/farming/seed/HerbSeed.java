package game.farming.seed;

import simple.api.wrappers.SimpleGameObject;
import simple.api.wrappers.SimpleItem;

import java.util.Map;

/**
 * @author Fluffyman
 * @data 10/20/2021
 */
public class HerbSeed extends Seed {
    /**
     * Herb Seed enum object.
     */
    private final HSeed herbSeed;

    /**
     * Map of the herb seeds.
     */
    private final Map<Integer, HSeed> HERB_SEED_MAP = Map.of(
            5291, HSeed.GUAM
    );

    /**
     * Initialize a new herb seed instance.
     * @param id id of the seed
     */
    public HerbSeed(int id) {
        this.herbSeed = HERB_SEED_MAP.get(id);
    }

    /**
     * Initialize a new herb seed instance.
     * @param herb item
     */
    public HerbSeed(SimpleItem herb) {
        this.herbSeed = HERB_SEED_MAP.get(herb.getId());
    }

    /**
     * Get the inventory item for this herb.
     * @return SimpleItem herb seed
     */
    public SimpleItem getHerbSeed() {
        return context.inventory.populate().filter(herbSeed.getId()).next();
    }

    /**
     * Plant the herb.
     * @param patch the patch to plant at.
     * @return Success.
     */
    public boolean plant(SimpleGameObject patch) {
        return this.plant(patch, getHerbSeed());
    }

    /**
     * Get the plant time for this herb.
     * @return Plant time.
     */
    public int getPlantTime() {
        return this.herbSeed.getPlantTime();
    }
}
