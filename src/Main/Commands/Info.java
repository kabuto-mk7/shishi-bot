package Main.Commands;

import Main.BotStartup;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;


public class Info extends ListenerAdapter {
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        final String[] args = event.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase(BotStartup.prefix + "info")){
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("ShiShi information");
            info.setImage("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fcdn.keycap-archivist.com%2Fkeycaps%2F250%2F4a7b0de9.jpg&f=1&nofb=1");
            info.addField("Creator", "kabuto", false);
            info.setDescription("An open source bot made in Java!\nCheck out the GitHub repo:\nhttps://bit.ly/3ouE2au\nA list of commands can be found here:\nhttps://bit.ly/3gudjGM");
            info.setColor(0x00a86b);
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessageEmbeds(info.build()).queue();
            info.clear();
        }
    }
}
