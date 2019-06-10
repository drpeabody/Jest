package Jest;

import Util.Screen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static Util.Screen.*;
import static Util.Util.*;

public class Jest {

	public static final String VERSION_MAJOR = "0";
	public static final String VERSION_MINOR = "1";

	public static final String getVersion() {
		return String.format("Jest v%s.%s", VERSION_MAJOR, VERSION_MINOR);
	}

	public static void draw(Screen s){
		s.clearScreen();
		s.drawText(Screen.RED_BG, 0, 0);
		s.fillLne("  ", 0);
		s.fillLne("  ", 1);
		s.fillLne("  ", 2);
		s.fillLne("  ", 3);
		String title = getVersion();
		s.drawText(title, 2, (s.getWidth() - title.length())/2);
		s.refresh();
	}

	public static void main(String args[]){

		Screen s;

		if(args.length < 2){
			s = new Screen(80, 40);
		} else {
			s = new Screen(Integer.parseInt(args[1]), Integer.parseInt(args[0]));
		}

		Player p = new Player();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String Prompt = BLUE + "thinking>" + GREEN;

//		log("Welcome to Jest!");
//		log(RED + "JEST ADMIN:" + RESET + " Your Process ID is "
//				+ RED + "66" + RESET + ". Please do the following.");
//		log("Code unfollowed... my@*(Y@MO(<#)(...");

		while(p.isGaming()){
			try {
				draw(s);
//				logp(Prompt);
				p.Do(in.readLine());
			} catch (IOException e) {
				log("Jest IO Error.");
			}
		}


	}

//	public static void main(String[] args) throws IOException {
//
//
//	}
}