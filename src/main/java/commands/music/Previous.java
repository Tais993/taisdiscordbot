package commands.music;

import commands.ICommand;
import functions.AllowedToPlayMusic;
import music.PlayerManager;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class Previous implements ICommand {
    GuildMessageReceivedEvent e;

    String command = "previous";
    String commandAlias = "previous";
    String category = "music";
    String exampleCommand = "`!previous`";
    String shortCommandDescription = "Return to the previous song.";
    String fullCommandDescription = "Return to the previous song.";

    @Override
    public void command(GuildMessageReceivedEvent event, String[] args) {
        e = event;

        AllowedToPlayMusic allowedToPlayMusic = new AllowedToPlayMusic();
        if (!allowedToPlayMusic.allowedToPlayMusic(e, "previous")) {
            return;
        }

        PlayerManager manager = PlayerManager.getInstance();
        manager.playPreviousTrack(e.getGuild());
    }

    @Override
    public String getCommand() {
        return command;
    }

    @Override
    public String getCommandAlias() {
        return commandAlias;
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
}
