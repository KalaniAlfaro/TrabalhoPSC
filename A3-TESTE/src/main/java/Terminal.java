public class Terminal {
public static final String RESET = "\u001B[0m";
public static final String BLACK = "\u001B[30m";
public static final String RED = "\u001B[31m";
public static final String GREEN = "\u001B[32m";
public static final String YELLOW = "\u001B[33m";
public static final String BLUE = "\u001B[34m";
public static final String PURPLE = "\u001B[35m";
public static final String CYAN = "\u001B[36m";
public static final String WHITE = "\u001B[37m";
String base;

  public Terminal(int c){
    switch (c){
      case 0:
        base = Terminal.BLACK + "○" + Terminal.RESET;
        break;
      case 1:
        base = Terminal.RED + "○" + Terminal.RESET;
        break;
      case 2:
        base =  Terminal.BLUE+ "○" + Terminal.RESET;
        break;
      case 3:
        base = Terminal.GREEN + "○" + Terminal.RESET;
        break;
      case 4:
        base =  Terminal.YELLOW + "○" + Terminal.RESET;
        break;
      case 5:
        base =  Terminal.WHITE + "○"  + Terminal.RESET;
        break;
      case 6:
        base =  Terminal.PURPLE + "○"  + Terminal.RESET;
        break;
    }
  }

public String getBase() {
	return base;
}
public void setBase(String base) {
	this.base = base;
}
  
}

