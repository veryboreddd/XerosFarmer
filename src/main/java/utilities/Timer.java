package utilities;

import game.client.Accessible;
import org.apache.commons.lang3.time.StopWatch;
import java.util.concurrent.TimeUnit;

/**
 * @author Fluffyman
 * @data 10/20/2021
 */
public class Timer extends StopWatch implements Accessible {
    /**
     * The time in milliseconds.
     */
    private final long time;

    /**
     * Initializes a new instance of the timer class.
     * @param time seconds to run the timer for.
     */
    public Timer(final int time) {
        this.time = TimeUnit.MILLISECONDS.convert(time, TimeUnit.SECONDS);
        this.start();
    }

    /**
     * Check if this timer is finished. (Zero)
     * @return state of the timer.
     */
    public boolean finished() {
        return this.getTime() >= this.time;
    }

    /**
     * Get the remaining time.
     * @return time remaining for this timer instance.
     */
    public long getTimeRemaining() {
        return TimeUnit.MILLISECONDS.toSeconds(this.time - getTime());
    }
}
