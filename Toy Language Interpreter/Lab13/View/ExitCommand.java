package View;

import Model.MyException;

public class ExitCommand extends Command {
    public ExitCommand(String key, String desc) {
        super(key, desc);
    }

    @Override
    public void execute() throws MyException {
        throw new MyException("Exit");
    }
}
