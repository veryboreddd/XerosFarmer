package utilities;

/**
 * @author Fluffyman
 * @data 10/20/2021
 */
public class FarmTimer extends Timer {

    /**
     * Initializes a new timer instance and loads the default client game timer.
     * @param time time in seconds.
     * @param id timer id.
     */
    public FarmTimer(final int time, final int id) {
        super(time);
        // TODO: 10/20/2021 direct call to static object.
        context.keyboard.sendKeys("::starttimer" + " " + id + " " + time);
    }
}
