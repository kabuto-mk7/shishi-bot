package Main;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class BotStartup {
    public static String prefix = "-";
    public static void main(String[] args)throws LoginException{
        JDABuilder jda = JDABuilder.createDefault("OTQwMDI0NTMzMTE1NjIxMzg2.YgBYEQ.M8MZ42tn-HhfyposnTwLg7htQ2g");
        jda.setActivity(Activity.playing("-info"));
        jda.setStatus(OnlineStatus.ONLINE);
        jda.addEventListeners(new Commands());
        jda.build();
    }
}
