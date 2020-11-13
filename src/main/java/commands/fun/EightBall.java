package commands.fun;

import commands.CommandReceivedEvent;
import commands.ICommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class EightBall implements ICommand {
    Random r = new Random();

    CommandReceivedEvent e;
    ArrayList<String> commandAliases = new ArrayList<>(Arrays.asList("8ball", "eightball"));
    String category = "fun";
    String exampleCommand = "8ball <question>?";
    String shortCommandDescription = "Ask 8ball a question";
    String fullCommandDescription = "Ask 8ball a question, and get a totally real answer.\n" +
            "**Question mark is required.**";

    @Override
    public void command(CommandReceivedEvent event) {
        e = event;
        if (e.getMessage().getContentRaw().contains("?")) {
            int chance = Math.round(r.nextFloat()*10);

            switch (chance) {
                case 1, 2 -> e.getMessageChannel().sendMessage("For sure!").queue();
                case 3, 4 -> e.getMessageChannel().sendMessage("Yes.").queue();
                case 5, 6 -> e.getMessageChannel().sendMessage("Maybe").queue();
                case 7, 8 -> e.getMessageChannel().sendMessage("No.").queue();
                case 9, 10 -> e.getMessageChannel().sendMessage("Never...").queue();
            }
        } else {
            e.getMessageChannel().sendMessage(getShortHelp("You're supposed to ask a question, so it should contain a question mark!", e.getPrefix())).queue();
        }
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public String getExampleCommand() {
        return exampleCommand;
    }

    @Override
    public String getShortCommandDescription() {
        return shortCommandDescription;
    }

    @Override
    public String getFullCommandDescription() {
        return fullCommandDescription;
    }

    @Override
    public ArrayList<String> getCommandAliases() {
        return commandAliases;
    }
}
