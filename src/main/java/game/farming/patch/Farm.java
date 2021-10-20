package game.farming.patch;

import lombok.AllArgsConstructor;
import lombok.Getter;
import simple.api.coords.WorldArea;
import simple.api.coords.WorldPoint;

/**
 * @author Fluffyman
 * @data 10/20/2021
 */
@AllArgsConstructor
@Getter
public enum Farm {
    FALADOR(8150, new WorldArea(new WorldPoint(3050, 3314, 0), new WorldPoint(3063, 3299, 0)), new String[]{"Skilling", "Farming"}, 1, false);

    private final int patchID;
    private final WorldArea farmArea;
    private final String[] teleportString;
    private final int dialogeOption;
    private final boolean useWizard;
}
