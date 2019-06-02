package Jest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

import static Util.Util.*;

public class Jest {

	public static final String VERSION_MAJOR = "0";
	public static final String VERSION_MINOR = "1";

	public static final String getVersion() {
		return String.format("Jest v%s.%s", VERSION_MAJOR, VERSION_MINOR);
	}



	public static void main(String args[]){
		log("Initialising System...");

		Player p = new Player();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String Prompt = ANSI_BLUE + "thinking>" + ANSI_GREEN;

		log("Welcome to Jest!");
		log(ANSI_RED + "JEST ADMIN:" + ANSI_RESET + " Your Process ID is "
				+ ANSI_RED + "66" + ANSI_RESET + ". Please do the following.");
		log("Code unfollowed... my@*(Y@MO(<#)(...");

		while(p.isGaming()){
			try {
				logp(Prompt);
				p.Do(in.readLine());
			} catch (IOException e) {
				log("Jest IO Error.");
			}
		}


	}

//	public static void main(String[] args) {
//		Stream<String> t = Arrays.asList(new String[]{ "", "cmd", "efe", "", "op"}).stream();
//		t.filter((String s) ->  !s.isEmpty() )
//		 .forEach((String p)->  { logp(p); logp(" "); } );
//	}
}