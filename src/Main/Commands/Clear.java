package Main.Commands;

import Main.BotStartup;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Clear extends ListenerAdapter {
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        final String[] args = event.getMessage().getContentRaw().split(" ");
        if (args[0].equalsIgnoreCase(BotStartup.prefix + "clear")){
            if (args.length < 2){
                event.getChannel().sendTyping().queue();
                event.getChannel().sendMessage("Error, number of messages to clear is too low, must be greater than 2!!!").queue();
            }
            else{
                try{
                    List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
                    event.getTextChannel().deleteMessages(messages).queue();
                }catch(Exception e){
                    event.getChannel().sendTyping().queue();
                    event.getChannel().sendMessage("Error, can't delete messages...").queue();
                }

            }
        }

    }
}
