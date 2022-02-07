package Main;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        if (args[0].equalsIgnoreCase(BotStartup.prefix + "info")){
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("mikuBot information");
            info.addField("Creator", "kabuto", false);
            info.setDescription("An open source bot made in Java!\nChek out the GitHub repo - ");
            info.setColor(0xf45642);
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessageEmbeds(info.build()).queue();
            info.clear();
        }
        if (args[0].equalsIgnoreCase(BotStartup.prefix + "shootah")){
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage("Teddy is on your block right now good luck").queue();
        }
    }
}



