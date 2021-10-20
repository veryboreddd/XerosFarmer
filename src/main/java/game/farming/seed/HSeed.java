package game.farming.seed;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Fluffyman
 * @data 10/20/2021
 */
@AllArgsConstructor
@Getter
public enum HSeed {
    GUAM(5291, 199, 5 * 60);

    private final int id;
    private final int resourceID;
    private final int plantTime;
}
