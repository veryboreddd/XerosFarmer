package game.object;

import com.client.definitions.h;

import java.util.Objects;

/**
 * @author Fluffyman
 * @data 10/20/2021
 */
public class ObjectDef {
    /**
     * Obtains the object definition based on the objectID
     * @param objectID id of the object.
     * @return Object Definition
     * @NOTE The object must be in your region.
     */
    public static h getObjectDefinition(int objectID) {
        h objectDefinition = com.client.definitions.h.a(objectID);
        if (Objects.nonNull(objectDefinition.l)) {
            objectDefinition = objectDefinition.d();
            return objectDefinition;
        }
        return null;
    }

    /**
     * Gets the object definition of the object under your mouse.
     * @return Object definition.
     */
    public static h getObjectDefUnderMouse() {
        return getObjectDefinition(com.client.utilities.i.d(com.client.al.as[0]));
    }
}
