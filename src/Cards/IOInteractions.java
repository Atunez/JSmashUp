package Cards;

import java.util.Scanner;

public class IOInteractions {
    public static boolean getYesOrNo(){
        Scanner kb = new Scanner(System.in);
        String inp = "";
        while(!(inp.equalsIgnoreCase("Y") || inp.equalsIgnoreCase("N"))){
            inp = kb.next();
        }
        kb.close();
        return inp.equalsIgnoreCase("Y");
    }

    public static int getNumInRange(int minimum, int maximum){
        Scanner kb = new Scanner(System.in);
        while (true){
            String inp = kb.next();
            try{
                int num = Integer.parseInt(inp);
                if(num >= minimum && maximum >= num){
                    kb.close();
                    return num;
                }
            }catch (Exception e){
                // Non Number Entered...
                System.out.println("Please Enter a number in the range of: " + minimum + " and " + maximum);
            }
        }
    }
}
