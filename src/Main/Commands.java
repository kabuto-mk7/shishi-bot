package Main;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Commands extends ListenerAdapter {
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
        if (args[0].equalsIgnoreCase(BotStartup.prefix + "shootah")){
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage("Teddy is on your block right now good luck").queue();
        }
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
        if (args[0].equalsIgnoreCase(BotStartup.prefix + "nuke")){
            event.getChannel().
    }
}



