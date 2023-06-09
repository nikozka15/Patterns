package commandpattern.simple.invoker;

import commandpattern.simple.command.Command;

public class SimpleRemoteControl {
  Command slot;
  public SimpleRemoteControl() {}

  public void setCommand(Command command) {
    this.slot = command;
  }

  public void buttonWasPressed() {
    slot.execute();
  }
}
