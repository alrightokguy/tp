package seedu.address.commons.core;

import java.awt.*;
import java.io.Serializable;
import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;

/**
 * A Serializable class that contains the GUI settings.
 * Guarantees: immutable.
 */
public record GuiSettings(double windowWidth, double windowHeight,
                          Point windowCoordinates) implements Serializable {

    private static final double DEFAULT_HEIGHT = 600;
    private static final double DEFAULT_WIDTH = 740;

    /**
     * Constructs a {@code GuiSettings} with the default height, width and position.
     */
    public GuiSettings() {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT, null); // null represent no coordinates
    }

    /**
     * Constructs a {@code GuiSettings} with the specified height, width and position.
     */
    public GuiSettings(double windowWidth, double windowHeight, int xPosition, int yPosition) {
        this(windowWidth, windowHeight, new Point(xPosition, yPosition));
    }

    @Override
    public Point windowCoordinates() {
        return windowCoordinates != null ? new Point(windowCoordinates) : null;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof GuiSettings otherGuiSettings)) {
            return false;
        }

        return windowWidth == otherGuiSettings.windowWidth
                && windowHeight == otherGuiSettings.windowHeight
                && Objects.equals(windowCoordinates, otherGuiSettings.windowCoordinates);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("windowWidth", windowWidth)
                .add("windowHeight", windowHeight)
                .add("windowCoordinates", windowCoordinates)
                .toString();
    }
}
