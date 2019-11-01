package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIdentificationNumbers.FIRST_BODY_ID_NUM;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.GenReportCommand;

public class GenReportCommandParserTest {

    private GenReportCommandParser parser = new GenReportCommandParser();

    @Test
    public void parse_validArgs_returnsGenReportCommand() {
        assertParseSuccess(parser, "B1 /name Manager A",
                new GenReportCommand(Index.fromZeroBased(FIRST_BODY_ID_NUM.getIdNum()), "Manager A"));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        //No name given
        assertParseFailure(parser, "B1", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                GenReportCommand.MESSAGE_USAGE));

        //Invalid string
        assertParseFailure(parser, "B /name Manager A", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                GenReportCommand.MESSAGE_USAGE));

        //Invalid first char
        assertParseFailure(parser, "A1 /name Manager A", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                GenReportCommand.MESSAGE_USAGE));

        //No input given
        assertParseFailure(parser, "", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                GenReportCommand.MESSAGE_USAGE));
    }
}
