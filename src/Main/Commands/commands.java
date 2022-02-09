package Main.Commands;

import Main.BotStartup;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class commands extends ListenerAdapter {
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        final String[] args = event.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase(BotStartup.prefix + "commands")){
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("List of commands!");
            info.addField("Images used in commands are not moderated or chosen by the developer and are provided by public api's", "", false);
            info.setDescription("-info  Displays information about the bot.\n" +
                    "-anime  Posts a random anime image from a database.\n" +
                    "-cat  Posts a random cat image from a database (NOT YET IMPLEMENTED).\n" +
                    "-meme  Posts a random meme image from a database (NOT YET IMPLEMENTED).\n" +
                    "-play  plays a song from a provided youtube url\n" +
                    "-clear  (value) deletes a user defined amount of previous messages\n" +
                    "-commands  displays this information screen\n" +
                    "-Overwatch  predicts the outcome of your next Overwatch game\n" +
                    "-updateinfo displays the latest changes and new commands added to the bot");
            info.setColor(0x00a86b);
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessageEmbeds(info.build()).queue();
            info.clear();
        }
    }
}