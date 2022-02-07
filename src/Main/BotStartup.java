package Main;

import Main.Commands.*;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class BotStartup {
    public static String prefix = "-";
    public static void main(String[] args)throws LoginException{
        JDABuilder jda = JDABuilder.createDefault("BOTTOKEN");
        jda.setActivity(Activity.playing("-info"));
        jda.setStatus(OnlineStatus.ONLINE);
        jda.addEventListeners(new Clear());
        jda.addEventListeners(new Overwatch());
        jda.addEventListeners(new Info());
        jda.addEventListeners(new Coinflip());
        jda.build();
    }
}
