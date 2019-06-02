
// The objective is to be able to write clean and quick OpenGL code

@author Abhishek
@date 21 - 04 - 2019

class Jest {

	public static final String VERSION_MAJOR = "0";
	public static final String VERSION_MINOR = "1";

	public static final String jsGetVersion() {
		return "Jest.Jest v" + VERSION_MAJOR + "." + VERSION_MINOR;
	}

	public static void jsLog(Object o[]){
		System.out.print("[ ");
		for(int i = 0; i < o.length-1; i++)
			System.out.print(o[i].toString() + ", ");
		if(o.length > 0)
			System.out.println(o[o.length-1].toString() +" ]");
		else 
			System.out.println("\b]");
	}

	public static void jsLog(Object o){
		System.out.println(o.toString());
	}

	public static void main(String args[]){
		jsLog(jsGetVersion());
		jsLog(args);


		Integer i[] = new Integer[]{1, 2, 3, 4, 5};

		jsLog(i);
	}
}
