//Gerard Patrick Gibbons, Junior Computer Science major
//Program changing script of Jaws to be in a (Amity?) accent
//October 27, 2017
import java.io.*;
import java.net.*;
public class AmityBrody {
	public static void main(String []args)
	{
		//getting the script from the website.
		String url = "https://cis.temple.edu/~jfiore/2017/fall/1068/assignments/07/files/jaws.txt";
		String fullStr =getWebContents(url);
	
		String newScript = changeToBostie(fullStr);
		System.out.println(newScript);
		saveDoc(newScript, "Jaws.txt");
	}
	public static String changeToBostie(String scriptJaws)
	{
		//creating a new String to store the new script in that way I can fill it as I go as not to make any
		//off by one errors. (initially thought of doing a Character Array.
		String newScript = "";
		for(int i = 0; i < scriptJaws.length(); i++)
	    {
			if((i + 4) < scriptJaws.length()){
				
			
			if(i > 0){
	    	if((scriptJaws.charAt(i) == 'r') && (isVowel(scriptJaws.charAt(i-1))))
	    	{
	    		newScript += 'h';//replace with h	
	    	}else if((scriptJaws.charAt(i) == 'a') && (Character.isLetter(scriptJaws.charAt(i - 1)))
	    			&& (!Character.isLetter(scriptJaws.charAt(i+1))))
	    	{
	    		newScript += "ar";
	    	}else if((!Character.isLetter(scriptJaws.charAt(i-1))) && (scriptJaws.charAt(i) == 'v') && (scriptJaws.charAt(i + 1) == 'e') &&
	    			(scriptJaws.charAt(i + 2) == 'r') && (scriptJaws.charAt(i + 3) == 'y') )
	    	{
	    		newScript += "wicked";
	    	}
	    	else if(((!Character.isLetter(scriptJaws.charAt(i-1))) && (scriptJaws.charAt(i) == 'V') && (scriptJaws.charAt(i + 1) == 'e') &&
	    			(scriptJaws.charAt(i + 2) == 'r') && (scriptJaws.charAt(i + 3) == 'y')))
	    			{
	    		newScript += "Wicked";
	    			}
	    	else if(((!Character.isLetter(scriptJaws.charAt(i+1))) && (scriptJaws.charAt(i) == 'r')) 
	    			&& (scriptJaws.charAt(i-1) == 'i' || ((scriptJaws.charAt(i-1) == 'e') && scriptJaws.charAt(i-2) == 'e')))
	    			{
	    		newScript += "yah";
	    			}
	    	else if((((!Character.isLetter(scriptJaws.charAt(i+1))) && (scriptJaws.charAt(i) == 'r')) && ((scriptJaws.charAt(i-1) == 'o') && scriptJaws.charAt(i-2) == 'o')))
	    	{
	    		newScript += "wah";
	    	}else
	    	{
	    		newScript += scriptJaws.charAt(i);
	    	}
	    	
	    }}else 
	    	{
	    	newScript += scriptJaws.charAt(i);
	    	}
	    	}
		return newScript;
	}
	//my vowel function from a previous project that we did.
	public static boolean isVowel(char c) {
    	switch(c)
    	{
    	case 'A': return true;
    	case 'a': return true;
    	case 'E': return true;
    	case 'e': return true;
    	case 'I': return true;
    	case 'i': return true;
    	case 'O': return true;
    	case 'o': return true;
    	case 'U': return true;
    	case 'u': return true;
    	case 'Y': return true;
    	case 'y': return true;
    	default: return false;
    	}

    }
 
	public static String getWebContents(String url) {
	    BufferedReader br = null;
	    String result = null;
	    try {
		URL toFetch = new URL(url);
		br = new BufferedReader(new InputStreamReader(toFetch.openStream()));
		StringBuilder ret = new StringBuilder();
		String line = br.readLine();
		while (line != null) {
		    ret.append(line+'\n');
		    line = br.readLine();
		}
		result = ret.toString();
	    } catch (MalformedURLException ex) {
		ex.printStackTrace();
		System.err.println("Malformed URL:  " + url);
	    } catch (IOException ioe) {
		ioe.printStackTrace();
		System.err.println("Error reading from URL:  " + url);
	    } finally {
		if(br!=null) {
		    try {
			br.close();
		    } catch (IOException ex) {
			ex.printStackTrace();
			System.err.println("Couldn't close connection to url properly:  " + url);
		    }
		}
		return result;
	    }
	}
	public static void saveDoc(String contents, String filename) {
	    PrintWriter pw = null;
	    try {
		pw = new PrintWriter(new FileWriter(new File(filename)));
		pw.print(contents);
	    } catch (IOException ioe) {
		ioe.printStackTrace();
		System.err.println("Error writing to file:  " + filename);
	    } finally {
		if(pw!=null) {
		    pw.close();
		}
	    }
	}
}

