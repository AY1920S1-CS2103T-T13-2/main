package seedu.address.model.body;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

//@@author ambervoong
class StatusTest {

    @Test
    void enumerateStatus_indexOne_correct() {
        assertEquals(Status.CLEANED.toString(), "CLEANED");
    }

}

