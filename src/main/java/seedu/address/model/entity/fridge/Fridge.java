package seedu.address.model.entity.fridge;

import java.util.Objects;
import java.util.Optional;

import seedu.address.model.entity.Entity;
import seedu.address.model.entity.IdentificationNumber;
import seedu.address.model.entity.body.Body;

//@@author arjavibahety
/**
 * Represents a fridge entry in Mortago.
 * Guarantees: fridgeIdNum and status are guaranteed to be present and not null
 */
public class Fridge implements Entity {

    // Identity field
    private final IdentificationNumber fridgeIdNum;

    // Data field
    private Optional<Body> body;
    private FridgeStatus fridgeStatus;

    public Fridge() {
        this.fridgeIdNum = IdentificationNumber.generateNewFridgeId(this);
        this.fridgeStatus = FridgeStatus.UNOCCUPIED;
        this.body = Optional.ofNullable(null);
    }

    public Fridge(boolean isTestFridge) {
        if (isTestFridge) {
            fridgeIdNum = IdentificationNumber.customGenerateTestId("F", 1);
        } else {
            this.fridgeIdNum = IdentificationNumber.generateNewFridgeId(this);
        }
        this.fridgeStatus = FridgeStatus.UNOCCUPIED;
        this.body = Optional.ofNullable(null);
    }

    public Fridge(Body body) {
        this.fridgeIdNum = IdentificationNumber.generateNewFridgeId(this);
        this.body = Optional.ofNullable(body);
        if (body == null) {
            this.fridgeStatus = FridgeStatus.UNOCCUPIED;
        } else {
            this.fridgeStatus = FridgeStatus.OCCUPIED;
        }
    }

    public Fridge(Body body, boolean isTestFridge) {
        if (isTestFridge) {
            this.fridgeIdNum = IdentificationNumber.customGenerateTestId("F", 1);
        } else {
            this.fridgeIdNum = IdentificationNumber.generateNewFridgeId(this);
        }
        this.body = Optional.ofNullable(body);
        if (body == null) {
            this.fridgeStatus = FridgeStatus.UNOCCUPIED;
        } else {
            this.fridgeStatus = FridgeStatus.OCCUPIED;
        }
    }

    public IdentificationNumber getIdNum() {
        return fridgeIdNum;
    }

    public FridgeStatus getFridgeStatus() {
        return fridgeStatus;
    }

    public Optional<Body> getBody() {
        return body;
    }

    public void setFridgeStatus(FridgeStatus fridgeStatus) {
        this.fridgeStatus = fridgeStatus;
    }

    public void setBody(Body body) {
        this.body = Optional.ofNullable(body);
        if (body == null) {
            setFridgeStatus(FridgeStatus.UNOCCUPIED);
        } else {
            setFridgeStatus(FridgeStatus.OCCUPIED);
        }
    }

    /**
     * Returns true if both fridge have the same identity fields.
     * This defines a weaker notion of equality between two fridges.
     */
    public boolean isSameFridge(Object otherFridge) {
        if (otherFridge == this) {
            return true;
        } else if (otherFridge instanceof Fridge) {
            return otherFridge != null
                && ((Fridge) otherFridge).getIdNum() == getIdNum();
        } else {
            return false;
        }
    }

    public boolean isSameEntity(Object otherFridge) {
        return isSameFridge(otherFridge);
    }
    /**
     * Returns true if both fridge have the same identity and data fields.
     * This defines a stronger notion of equality between two fridges.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Fridge)) {
            return false;
        }

        Fridge otherFridge = (Fridge) other;
        return otherFridge.getIdNum().toString().equals(getIdNum().toString())
                && otherFridge.getFridgeStatus().equals(getFridgeStatus())
                && otherFridge.getBody().equals(getBody());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(fridgeIdNum);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        if (getBody() != null) {
            builder.append(" Fridge ID: ")
                    .append(getIdNum())
                    .append(" Status: ")
                    .append(getFridgeStatus())
                    .append(" Body: ")
                    .append(getBody());
        } else {
            builder.append(" Fridge ID: ")
                    .append(getIdNum())
                    .append(" Status: ")
                    .append(getFridgeStatus());
        }
        return builder.toString();
    }
}
