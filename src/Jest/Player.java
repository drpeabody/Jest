package Jest;

import Util.Command;

import java.util.HashMap;

import static Util.Util.*;

/**
 * @author Abhishek
 * @since 02 Jun, 2019
 *
 * This class represents the player, handles the commands
 *
 */

public class Player {

    public final HashMap<String, Command> commands;
    public boolean gaming;

    public Player() {
        gaming = true;
        commands = new HashMap();
        initComands();
    }

    public final void initComands(){
        commands.put("kill", (args) -> { gaming = false; });
        commands.put("uname", (args) -> { log(Jest.getVersion()); });
    }

    public boolean isGaming(){
        return gaming;
    }

    public void Do(String cmd){

        String[] tokens = cleanCommand(cmd);

        log(tokens);

        if(commands.containsKey(tokens[0])){
            commands.get(tokens[0]).execute(tokens);
        } else log("Unknown Command.");
    }

}
