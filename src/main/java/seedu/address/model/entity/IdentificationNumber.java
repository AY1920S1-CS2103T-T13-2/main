package seedu.address.model.entity;

//@@author shaoyi1997

import static java.util.Objects.requireNonNull;

import java.util.Objects;

import seedu.address.model.entity.body.Body;
import seedu.address.model.entity.fridge.Fridge;
import seedu.address.model.entity.worker.Worker;

/**
 * Represents the ID number of each entity.
 * Guarantees: immutable, unique ID number will be generated from within the class
 */
public class IdentificationNumber {

    public static final String MESSAGE_CONSTRAINTS =
        "IdentificationNumber should have either of the following formats:\n" + "- B########\n" + "- W#####" + "- F##";

    private static final String ID_PREFIX_BODY = "B";
    private static final String ID_PREFIX_WORKER = "W";
    private static final String ID_PREFIX_FRIDGE = "F";

    private static UniqueIdentificationNumberMaps uniqueIds = new UniqueIdentificationNumberMaps();

    private int idNum;

    private String typeOfEntity;

    protected IdentificationNumber(Entity entity) {
        requireNonNull(entity);
        idNum = uniqueIds.addEntity(entity);
        if (entity instanceof Worker) {
            typeOfEntity = "W";
        } else if (entity instanceof Body) {
            typeOfEntity = "B";
        } else {
            typeOfEntity = "F";
        }
    }

    //@@author ambervoong
    protected IdentificationNumber(Entity entity, int id) {
        requireNonNull(entity);
        idNum = id;
        UniqueIdentificationNumberMaps.addEntity(entity, id);
        if (entity instanceof Worker) {
            typeOfEntity = "W";
        } else if (entity instanceof Body) {
            typeOfEntity = "B";
        } else {
            typeOfEntity = "F";
        }
    }
    //@@author

    private IdentificationNumber(String typeOfEntity, int idNum) {
        this.typeOfEntity = typeOfEntity;
        this.idNum = idNum;
    }

    public static IdentificationNumber generateNewBodyId(Body body) {
        return new IdentificationNumber(body);
    }

    public static IdentificationNumber generateNewBodyId(Body body, int id) {
        return new IdentificationNumber(body, id);
    }

    public static IdentificationNumber generateNewWorkerId(Worker worker) {
        return new IdentificationNumber(worker);
    }

    public static IdentificationNumber generateNewWorkerId(Worker worker, int id) {
        return new IdentificationNumber(worker, id);
    }

    public static IdentificationNumber generateNewFridgeId(Fridge fridge) {
        return new IdentificationNumber(fridge);
    }

    public static IdentificationNumber generateNewFridgeId(Fridge fridge, int id) {
        return new IdentificationNumber(fridge);
    }

    public static IdentificationNumber customGenerateId(String typeOfEntity, int idNum) {
        return new IdentificationNumber(typeOfEntity, idNum);
    }

    private static boolean isValidIdPrefix (String prefix) {
        return prefix.equalsIgnoreCase(ID_PREFIX_BODY) || (
                prefix.equalsIgnoreCase(ID_PREFIX_FRIDGE) || prefix.equalsIgnoreCase(ID_PREFIX_WORKER));
    }

    /**
     * Checks if given {@code String id} is a valid identification number.
     */
    public static boolean isValidIdentificationNumber(String fullIdString) {
        int idLength = fullIdString.length();
        if (idLength < 3) {
            return false;
        }
        String idPrefix = fullIdString.charAt(0) + "";
        if (isValidIdPrefix(idPrefix)) {
            int numberLength = idLength - 1;
            switch (idPrefix) {
            case ID_PREFIX_BODY:
                return numberLength == 8;
            case ID_PREFIX_WORKER:
                return numberLength == 5;
            case ID_PREFIX_FRIDGE:
                return numberLength == 2;
            default:
                return false;
            }
        }
        return false;
    }

    /**
     * Checks if given {@code String fullIdString} already exists in Mortago.
     */
    public static boolean isExistingIdentificationNumber(String fullIdString) {
        String typeOfEntity = fullIdString.charAt(0) + "";
        int idNum = Integer.parseInt(fullIdString.substring(1));
        switch (typeOfEntity) {
        case ID_PREFIX_BODY:
            return uniqueIds.containsBodyId(idNum);
        case ID_PREFIX_FRIDGE:
            return uniqueIds.containsFridgeId(idNum);
        case ID_PREFIX_WORKER:
            return uniqueIds.containsWorkerId(idNum);
        default:
            return false;
        }
    }

    /**
     * Checks if given {@code IdentificationNumber id} already exists in Mortago.
     */
    public static boolean isExistingIdentificationNumber(IdentificationNumber id) {
        return isExistingIdentificationNumber(id.toString());
    }

    public String getTypeOfEntity() {
        return typeOfEntity;
    }

    public int getIdNum() {
        return idNum;
    }

    @Override
    public String toString() {
        String paddedId;
        switch (typeOfEntity) {
        case ID_PREFIX_BODY:
            paddedId = String.format("%08d", idNum);
            break;
        case ID_PREFIX_WORKER:
            paddedId = String.format("%05d", idNum);
            break;
        case ID_PREFIX_FRIDGE:
            paddedId = String.format("%02d", idNum);
            break;
        default:
            paddedId = "Invalid ID";
        }
        return typeOfEntity + paddedId;
    }

    /**
     * Removes the mapping of the Id Number to its entity in the respective UniqueEntityList.
     */
    public void removeMapping() {
        switch (typeOfEntity) {
        case ID_PREFIX_BODY:
            uniqueIds.removeBodyId(idNum);
            break;
        case ID_PREFIX_WORKER:
            uniqueIds.removeWorkerId(idNum);
            break;
        case ID_PREFIX_FRIDGE:
            uniqueIds.removeFridgeId(idNum);
            break;
        default:
            return;
        }
    }

    public Entity getMapping() {
        return uniqueIds.getMapping(typeOfEntity, idNum);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IdentificationNumber that = (IdentificationNumber) o;
        return idNum == that.idNum && typeOfEntity.equals(that.typeOfEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfEntity + idNum);
    }
}
