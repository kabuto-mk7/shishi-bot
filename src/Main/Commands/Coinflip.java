package Main.Commands;

import Main.BotStartup;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

public class Coinflip extends ListenerAdapter {
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        final String[] args = event.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase(BotStartup.prefix + "coinflip")){
            event.getChannel().sendTyping().queue();
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage("calculating heads or tails...").queue();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (Math.random() < 0.5){
                event.getChannel().sendTyping().queue();
                event.getChannel().sendTyping().queue();
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                event.getChannel().sendMessage("Heads").queue();
            }else{
                event.getChannel().sendTyping().queue();
                event.getChannel().sendTyping().queue();
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                event.getChannel().sendMessage("Tails").queue();
            }
        }
    }
}