import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Program 
{
	public static int counter = 1;
    public static void main(String[] args) throws Exception
    {
    	System.out.print("Enter a CAMEL CASED string and I will count how many words are in it. . .\nNote: Anything entered after a space will be ignored in this calculation.\nINPUT:");
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        calculate(s);
    }
    
    public static void calculate(String s)
    {
        String currentSubString = s;
        //Create an index for the last index of upper case letter
        int lastIndexOfUCL = lastIndexOfUCL(currentSubString);
        //If the last index is -1 then print the counter
        if(lastIndexOfUCL == -1)
        {
        	//Only one word
            counter = 1;
            System.out.println("There is only one word.");   
        }
        
        try
        {
        	//Count how many uppercase characters there are
            while(lastIndexOfUCL!=-1)
            {
                lastIndexOfUCL = lastIndexOfUCL(currentSubString);
                //Use the last index to create new substrings
                currentSubString = currentSubString.substring(0, lastIndexOfUCL(currentSubString));
                //Trim & Count      
                counter++;
            }    
        }
        catch(Exception e)
        {
            System.out.println("There are " + counter + " words.");    
        }
        
	}
    //Function utilizes contextual substring manipulation based on the last index of UCL
    public static int lastIndexOfUCL(String str) 
    {        
	    for(int i = str.length() - 1; i >= 0; i--) 
	    {
	        if(Character.isUpperCase(str.charAt(i))) 
	        {
	            return i;
	        }
	    }
	    return -1;
    }
}