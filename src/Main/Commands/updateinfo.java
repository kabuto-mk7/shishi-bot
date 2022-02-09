package Main.Commands;

import Main.BotStartup;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class updateinfo extends ListenerAdapter {
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        final String[] args = event.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase(BotStartup.prefix + "updateinfo")){
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("Latest update shiShi bot ver 0.05!");
            info.addField("- planned changes for future updates: cat and meme commands implemented, music bot functionality, levels / xp system", "", false);
            info.setDescription("- added the '-commands' command\n" +
                                "- added the '-updateinfo' command\n" +
                                "- added the '-anime' command\n");
            info.setColor(0x00a86b);
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessageEmbeds(info.build()).queue();
            info.clear();
        }
    }
}