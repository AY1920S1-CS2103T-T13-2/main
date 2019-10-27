package seedu.address.logic.parser.utility;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import seedu.address.commons.util.CollectionUtil;
import seedu.address.model.entity.Entity;
import seedu.address.model.entity.IdentificationNumber;
import seedu.address.model.entity.PhoneNumber;
import seedu.address.model.entity.Sex;
import seedu.address.model.entity.body.Body;
import seedu.address.model.entity.body.BodyStatus;
import seedu.address.model.entity.body.Nric;
import seedu.address.model.person.Name;

//@@author ambervoong
/**
 * Stores the details to update the body with. Each non-empty field value will replace the
 * corresponding field value of the body.
 */
public class UpdateBodyDescriptor implements UpdateEntityDescriptor {
    private Name name;
    private Sex sex;
    private Nric nric;
    private String religion;

    private String causeOfDeath;
    private List<String> organsForDonation;
    private BodyStatus bodyStatus;
    private IdentificationNumber fridgeId;
    private Date dateOfBirth;
    private Date dateOfDeath;

    private Name nextOfKin;
    private String relationship;
    private PhoneNumber kinPhoneNumber;

    public UpdateBodyDescriptor() {

    }

    /**
     * Makes a copy of an existing UpdateBodyDescriptor.
     */
    public UpdateBodyDescriptor(UpdateBodyDescriptor toCopy) {
        setName(toCopy.name);
        setSex(toCopy.sex);
        setNric(toCopy.nric);
        setReligion(toCopy.religion);
        setCauseOfDeath(toCopy.causeOfDeath);
        setOrgansForDonation(toCopy.organsForDonation);
        setBodyStatus(toCopy.bodyStatus);
        setFridgeId(toCopy.fridgeId);
        setDateOfBirth(toCopy.dateOfBirth);
        setDateOfDeath(toCopy.dateOfDeath);
        setNextOfKin(toCopy.nextOfKin);
        setRelationship(toCopy.relationship);
        setKinPhoneNumber(toCopy.kinPhoneNumber);
    }

    /**
     * Makes a copy of a Body's current fields.
     * @param body the body to be copied.
     * @returns UpdateBodyDescriptor that contains the body's current fields.
     */
    public UpdateBodyDescriptor(Body body) {
        this.name = body.getName();
        this.sex = body.getSex();
        this.nric = body.getNric().orElse(null);
        this.religion = body.getReligion().orElse(null);
        this.causeOfDeath = body.getCauseOfDeath().orElse(null);
        this.organsForDonation = body.getOrgansForDonation();
        this.bodyStatus = body.getBodyStatus().orElse(null);
        this.fridgeId = body.getFridgeId().orElse(null);
        this.dateOfBirth = body.getDateOfBirth().orElse(null);
        this.dateOfDeath = body.getDateOfDeath().orElse(null);
        this.nextOfKin = body.getNextOfKin().orElse(null);
        this.relationship = body.getRelationship().orElse(null);
        this.kinPhoneNumber = body.getKinPhoneNumber().orElse(null);
    }

    /**
     * Returns true if at least one field is edited.
     */
    @Override
    public boolean isAnyFieldEdited() {
        return CollectionUtil.isAnyNonNull(name, sex, nric, religion, causeOfDeath, organsForDonation, bodyStatus,
                fridgeId, dateOfBirth, dateOfDeath, nextOfKin, relationship, kinPhoneNumber);
    }

    /**
     * Changes a {@code Body}'s fields according to the descriptor to the updated values in the
     * {@code UpdateEntityDescriptor} object if they are present and uses the existing values in the body otherwise.
     */
    @Override
    public Entity apply(Entity entity) {
        assert entity != null;
        Body body = (Body) entity;
        body.setName(this.getName().orElse(body.getName()));
        body.setSex(this.getSex().orElse(body.getSex()));
        body.setNric(this.getNric().orElse(body.getNric().orElse(null)));
        body.setReligion(this.getReligion().orElse(body.getReligion().orElse(null)));
        body.setCauseOfDeath(this.getCauseOfDeath().orElse(body.getCauseOfDeath().orElse(null)));
        body.setOrgansForDonation(this.getOrgansForDonation().orElse(body.getOrgansForDonation()));
        body.setBodyStatus(this.getBodyStatus().orElse(body.getBodyStatus().orElse(null)));
        body.setFridgeId(this.getFridgeId().orElse(body.getFridgeId().orElse(null)));
        body.setDateOfBirth(this.getDateOfBirth().orElse(body.getDateOfBirth().orElse(null)));
        body.setDateOfDeath(this.getDateOfDeath().orElse(body.getDateOfDeath().orElse(null)));
        body.setNextOfKin(this.getNextOfKin().orElse(body.getNextOfKin().orElse(null)));
        body.setRelationship(this.getRelationship().orElse(body.getRelationship().orElse(null)));
        body.setKinPhoneNumber(this.getKinPhoneNumber().orElse(body.getKinPhoneNumber().orElse(null)));
        return entity;
    }

    // Getters and Setters
    public Optional<Name> getName() {
        return Optional.ofNullable(name);
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Optional<Sex> getSex() {
        return Optional.ofNullable(sex);
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Optional<Nric> getNric() {
        return Optional.ofNullable(nric);
    }

    public void setNric(Nric nric) {
        this.nric = nric;
    }

    public Optional<String> getReligion() {
        return Optional.ofNullable(religion);
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public Optional<String> getCauseOfDeath() {
        return Optional.ofNullable(causeOfDeath);
    }

    public void setCauseOfDeath(String causeOfDeath) {
        this.causeOfDeath = causeOfDeath;
    }

    public Optional<List<String>> getOrgansForDonation() {
        return Optional.ofNullable(organsForDonation);
    }

    public void setOrgansForDonation(List<String> organsForDonation) {
        this.organsForDonation = organsForDonation;
    }

    public Optional<BodyStatus> getBodyStatus() {
        return Optional.ofNullable(bodyStatus);
    }

    public void setBodyStatus(BodyStatus bodyStatus) {
        this.bodyStatus = bodyStatus;
    }

    public Optional<IdentificationNumber> getFridgeId() {
        return Optional.ofNullable(fridgeId);
    }

    public void setFridgeId(IdentificationNumber fridgeId) {
        this.fridgeId = fridgeId;
    }

    public Optional<Date> getDateOfBirth() {
        return Optional.ofNullable(dateOfBirth);
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Optional<Date> getDateOfDeath() {
        return Optional.ofNullable(dateOfDeath);
    }

    public void setDateOfDeath(Date dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public Optional<Name> getNextOfKin() {
        return Optional.ofNullable(nextOfKin);
    }

    public void setNextOfKin(Name nextOfKin) {
        this.nextOfKin = nextOfKin;
    }

    public Optional<String> getRelationship() {
        return Optional.ofNullable(relationship);
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public Optional<PhoneNumber> getKinPhoneNumber() {
        return Optional.ofNullable(kinPhoneNumber);
    }

    public void setKinPhoneNumber(PhoneNumber kinPhoneNumber) {
        this.kinPhoneNumber = kinPhoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UpdateBodyDescriptor)) {
            return false;
        }
        UpdateBodyDescriptor that = (UpdateBodyDescriptor) o;
        return getName().equals(that.getName())
                && getSex().equals(that.getSex())
                && getNric().equals(that.getNric())
                && getReligion().equals(that.getReligion())
                && getCauseOfDeath().equals(that.getCauseOfDeath())
                && getOrgansForDonation().equals(that.getOrgansForDonation())
                && getBodyStatus().equals(that.getBodyStatus())
                && getFridgeId().equals(that.getFridgeId())
                && getDateOfBirth().equals(that.getDateOfBirth())
                && getDateOfDeath().equals(that.getDateOfDeath())
                && getNextOfKin().equals(that.getNextOfKin())
                && getRelationship().equals(that.getRelationship())
                && getKinPhoneNumber().equals(that.getKinPhoneNumber());

    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSex(), getNric(), getReligion(), getCauseOfDeath(), getOrgansForDonation(),
                getBodyStatus(), getFridgeId(), getDateOfBirth(), getDateOfDeath(), getNextOfKin(), getRelationship(),
                getKinPhoneNumber());
    }
}
