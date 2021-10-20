package game.client;

import simple.api.ClientContext;

/**
 * @author Fluffyman
 * @data 10/20/2021
 */
public interface Accessible {
    /**
     * Access to client context across any class which implements this interface.
     */
    ClientContext context = ClientContext.instance();
}
