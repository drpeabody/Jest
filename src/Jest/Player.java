package Jest;

import Util.Command;
import Util.Screen;

import java.util.ArrayList;
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
    ArrayList<HexCode> inventory;

    public Player() {
        gaming = true;
        commands = new HashMap();
        inventory = new ArrayList<>();
        inventory.add(new HexCode.PublicAccessHex());
        inventory.add(new HexCode.PrivateAccessHex());
        initComands();
    }

    public final void initComands(){
        commands.put("kill", (args) -> { gaming = false; });
        commands.put("uname", (args) -> { log(Jest.getVersion()); });
        commands.put("inventory", (args) -> { log(inventory.toArray()); });
    }

    public boolean isGaming(){
        return gaming;
    }

    public void Do(String cmd){

        String[] tokens = cleanCommand(cmd);

        logp(Screen.RESET);

        if(commands.containsKey(tokens[0])){
            commands.get(tokens[0]).execute(tokens);
        } else log("Unknown Command.");
    }

}
