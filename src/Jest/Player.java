package Jest;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static Util.Util.*;

/**
 * @author Abhishek
 * @since 02 Jun, 2019
 *
 * This class represents the player, handles the commands
 *
 */

public class Player {

    public final HashMap<String, Runnable> commands;
    public boolean gaming;

    public Player() {
        gaming = true;
        commands = new HashMap<String, Runnable>();
        initComands();
    }

    public final void initComands(){
        commands.put("kill", () -> { gaming = false; });
        commands.put("uname", () -> { log(Jest.getVersion()); });
    }

    public boolean isGaming(){
        return gaming;
    }

    public void Do(String cmd){

        if(commands.containsKey(cmd)){
            commands.get(cmd).run();
        } else log("Unknown Command.");
    }

}
