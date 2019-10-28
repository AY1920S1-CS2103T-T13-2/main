package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import seedu.address.model.entity.fridge.Fridge;

//@@ author shaoyi1997
/**
 * An UI component that displays information of a {@code Fridge}.
 */
public class FridgeCard extends UiPart<Region> {

    private static final String FXML = "FridgeListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Fridge fridge;

    @FXML
    private VBox cardPane;
    @FXML
    private Label status;
    @FXML
    private StackPane fridgeIdPlaceholder;
    @FXML
    private Label body;

    public FridgeCard(Fridge fridge) {
        super(FXML);
        this.fridge = fridge;
        fridgeIdPlaceholder.getChildren().add(new FridgeIdLabel(fridge.getIdNum()).getRoot());
        status.setText(fridge.getFridgeStatus().toString());
        if (fridge.getBody().isPresent()) {
            body.setText(fridge.getBody().get().getIdNum().toString());
            body.getStyleClass().add("selectedBodyId");
        } else {
            body.setText("No body assigned");
        }
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof FridgeCard)) {
            return false;
        }

        // state check
        FridgeCard card = (FridgeCard) other;
        return fridge.equals(card.fridge);
    }
}
//@@ author
