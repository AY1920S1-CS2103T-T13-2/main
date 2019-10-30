package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.model.Model;
import seedu.address.ui.NotificationButton;

/**
 * Displays the notifications popover.
 */
public class ShowNotificationsCommand extends Command {

    public static final String COMMAND_WORD = "showNotifs";

    public static final String MESSAGE_SUCCESS = "Notifications shown.";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        NotificationButton.getInstantiatedNotifButton().showNotifications();
        return new CommandResult(MESSAGE_SUCCESS);
    }

}
