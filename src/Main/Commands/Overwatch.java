package Main.Commands;

import Main.BotStartup;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Overwatch extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent event) {
        Random random = new Random();
        final String[] owChars = {"Ana", "Ashe", "Baptiste", "Bastion",
                "Brigitte", "Cassidy", "D.VA", "Doomfist",
                "Echo", "Genji", "Hanzo", "Junkrat", "lucio",
                "Mei", "Mercy", "Moira", "Orisa", "Pharah",
                "Reaper", "Reinhardt", "Roadhog", "Sigma",
                "Soldier 76", "Sombra", "Symmetra", "Torbjorn",
                "Tracer", "Widowmaker", "Winston", "Wrecking Ball",
                "Zarya", "Zenyatta"};
        final String[] owTeam =  {"your", "their"};
        final String[] owEvent = {"instakilled", "ran into a wall then died to",
                "uninstalled the game after dying to",
                "typed gg 5 seconds after dying to", "lost a 1v1 to",
                "tried to make friends with", "missed an easy ult on"};
        final String[] outCome = {"You won! GG WP", "You lost lmao L"};

        final String[] args = event.getMessage().getContentRaw().split(" ");
        if (args[0].equalsIgnoreCase(BotStartup.prefix + "overwatch")){
            int teamIndex = random.nextInt(owTeam.length);
            int char01 = random.nextInt(owChars.length);
            int char02 = random.nextInt(owChars.length);
            int event01 = random.nextInt(owEvent.length);
            int outcome01 = random.nextInt(outCome.length);
            event.getChannel().sendTyping().queue();
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage("calculating outcome of your next Overwatch game...").queue();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            event.getChannel().sendMessage(owTeam[teamIndex] + " " + owChars[char01] + " " + owEvent[event01] + " " + owChars[char02] + "... " + outCome[outcome01]).queue();
        }
        if (args[0].equalsIgnoreCase(BotStartup.prefix + "nuke")) {
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage("Nuking messages...").queue();
        }
    }

}
