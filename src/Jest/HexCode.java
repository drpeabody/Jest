package Jest;

import Util.Screen;

/**
 * @author Abhishek
 * @since 02 Jun, 2019
 */

public abstract class HexCode {

    /*
    HexCodes are theitems of this game.

        -> 0x HexCodes are Permission Badges. Higher second digit means higher privilege.

    */

    private String code, description;

    private HexCode(String code, String desc){
        this.code = code;
        this.description = desc;
    }

    public String getName() {
        return code;
    }
    public String getDescription() {
        return description;
    }

    public String toString(){
        return Screen.RED + code  + Screen.CYAN + " : " + description + Screen.RESET;
    }

    public static class PublicAccessHex extends HexCode{
        public PublicAccessHex(){
            super("00", "Provides access to public places.");
        }
    }
    public static class ProtectedAccessHex extends HexCode{
        public ProtectedAccessHex(){
            super("01", "Provides access to protected places.");
        }
    }
    public static class PrivateAccessHex extends HexCode{
        public PrivateAccessHex(){
            super("02", "Provides access to private places.");
        }
    }

}
