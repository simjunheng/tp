package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.image.Image;

/**
 * Unmodifiable view of a strategy board
 */
public interface ReadOnlyStrategyBoard {
    /**
     * Returns an unmodifiable view of the player list.
     * This list will not contain any duplicate players.
     */
    ObservableList<String> getPlayerList();

    /**
     * Returns the background image of the Strategy Board.
     */
    Image getImage();
}
