//Gerard Patrick Gibbons, Junior Computer Science
//Program Designs and Abstraction
//October 22nd, 2017
//Strings methods programs. A list of methods which do various things to various Strings.



import java.util.Scanner;

public class StringMethods {

	

	    /* returns true if c is an upper case or lower case vowel
	     * or false otherwise */
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

	    /* returns the index of the first vowel in s or -1
	     * if s contains no vowels */
	    public static int indexOfFirstVowel(String s) {
	    	
	    for(int i = 0; i < s.length(); i++)
	    {
	    	if(isVowel(s.charAt(i)))
	    	{
	    		return i;
	    	}
	    	
	    }
	 
		return -1;
	    }

	    /* returns the index of the first occurrence of a vowel
	     * in s starting from index startPosition or -1 if
	     * there are no vowels in s at index startPosition or later */

	    /* notice that this method has the same name as the previous
	     * one, but that it takes a different number of arguments.
	     * This is perfectly legal in Java. It's called "method overloading" */
	    public static int indexOfFirstVowel(String s, int startPosition) {
	    
	    	for(int i = startPosition; i < s.length(); i++)
		    {
		    	if(isVowel(s.charAt(i)))
		    	{
		    		return i;
		    	}
		    	
		    }
		return -1;
	    }

	    /* returns the index of the last occurrence of a vowel in
	     * s or -1 if s contains no vowels */
	    public static int indexOfLastVowel(String s) {
	    	String t = reversed(s);
	    	int lastVowel = indexOfFirstVowel(t)+(s.length() -1);
		return lastVowel;
	    }

	    /* returns true if the first, last, and middle letter of s is the
	     * same ignoring case or false otherwise.
	     * Returns false if s is shorter than 3 characters
	     *
	     * (Note: when there are an odd number of letters in a word,
	     * for example, the word radar, it's clear what the middle
	     * letter is. What would it mean to be the middle letter
	     * for a word with an even number of letters?) */
	    public static boolean sameFirstLastMiddle(String s) {
	    if(s.charAt(0)==s.charAt(s.length()-1))
	    {
	    	if(s.charAt(0)==s.charAt((s.length()-1)/2))
	    	{
	    		return true;
	    	}
	    }
		return false;
	    }

	    /* returns s in reverse. For example, if s is "Apple", the method
	     * returns the String "elppA" */
	    
	    
	    public static String reversed(String s) {
//	    	//need to convert s to a character array that way I can make a for loop
//	    	//that stores the value in temp and swaps the values of the first and last characters.
//	    	
	    	char [] sArray = s.toCharArray();
	    	char temp;
	    	int count = 0;
	    	int last = sArray.length - 1;

	    	while (count < last)
	    	{
	    		
	    		temp = sArray[count];
	    		sArray[count] = sArray[last];
	    		sArray[last] = temp;
	    		last--;
	    		count++;
	    	}
	    
		return new String(sArray);
	    }
	    
	    /* returns the number of times that n occurs
	     * in h. For example, if h is "Mississippi" and n is "ss"
	     * the method returns 2. */
	    public static int numOccurrences(String h, String n){
	    	//We are going  to need the current index to keep updated and the check if the string
	    	//we are looking for is in the other.
	    	int position = 0;
	    	int occurences = 0;

	    	while(position != -1)
	    	{
	    	    position = h.indexOf(n,position);
	    	    if(position != -1)
	    	    {
	    	        occurences ++;
	    	        position += n.length();
	    	    }
	    	}
	    	
		return occurences;
	    }

	    /* returns true if s is the same backwards and forwards
	     * and false otherwise */
	    public static boolean sameInReverse(String s) {
	    
	    	  int slength = s.length();
	    	  //we only need to test one half of the string checking each time
	    	  //if the letters at each mirror'd index is the same, returning false immediately
	    	  //if it is not the same. Super efficient.
	    	  for (int i = 0; i < (slength/2); i++) 
	    	  {
	    	     if (s.charAt((slength- i)- 1) != s.charAt(i))
	    	     {
	    	         return false;
	    	     }
	    	  }
	    	  return true;
	    }

	    /* returns a new String which is the same as s, but with
	     * all of the vowels removed. For example, if s is "summer vacation"
	     * the method returns "smmr vctn" */
	    public static String devoweled(String s) {
	    	//found this nifty String method :D 
	    	s= s.replaceAll("[AEIOUaeiou]", "");
	    	return s;
	    }

	    /* Returns a new string consisting of all of the characters of s1
	     * and s2 interleaved with each other. For example, if s1 is
	     * "Spongebob" and s2 is "Patrick", the
	     * function returns the string "SPpaotnrgiecbkob" */
	    public static String zipped(String s1, String s2) {
	    	int totalLength = s1.length() + s2.length();
	    	String combo = "";
	    	for(int i=0;i < totalLength; i++)
	    	{
	    		if(i < s1.length()  )
	    		{
	    		combo += s1.charAt(i);
	    		}
	    		if(i < s2.length() )
	    		{
	    		combo += s2.charAt(i);
	    		}
	    	}
		return combo;
	    }

	    /* returns a new String consisting of all of the letters
	     * of s, but where tab characters ('\t') are replaced
	     * with n spaces */
	    public static String tabToSpace(String s, int n) {
	    	String spaces = "";
	    	int count = 0;
	    	while (count < n)
	    	{
	    		spaces += " ";
	    		count++;
	    	}
	    	s= s.replaceAll("\t" , spaces);
	    	
	    	return s;
	    			
	    }

	    /* returns true if all of the characters in chars are
	     * found in the String s, or false otherwise */
	    public static boolean containsAll(String s, String chars) {
	    	if(s.contains(chars))
	    	{
	    		return true;
	    	}
		return false;
	    }

	    /* returns the index of the first occurrence of any of the
	     * characters in chars in String s or -1 if none of the characters
	     * in chars are found in s. */
	    public static int indexOfAny(String s, String chars) {
	    	for(int i = 0; i < chars.length(); i++)
		    {
	    		for(int n=0; n < s.length(); n++)
	    		{
		    	if(s.charAt(n) == chars.charAt(i))
		    		{
		    		return n;
		    		}
	    		}
		    }
	    	return -1;
	    }
								  
	    public static void main(String args[]) {
	    if(isVowel('A') != true)
	    {
	    	System.out.println("isVowel(): not okay");
	    }
	    else
	    {
		System.out.println("isVowel(): passed");
	    }
	    
	    if(indexOfFirstVowel("Banana")!=1)
	    {
	    	System.out.println("indexOfFirstVowel: error.");
	    }
	    else
	    {
	    	System.out.println("indexOfFirstVowel: passed");
	    }
	    
	    if(indexOfFirstVowel("Banana", 2)!=3)
	    {
	    	System.out.println("indexOfFirstVowel(s,n): failed");
	    }
	    else
	    {
	    	System.out.println("indexOfFirstVowel: passed");
	    }
	    
	    if(indexOfLastVowel("Banana") != 5)
	    {
	    	System.out.println("indexOfLastVowel: failed");
	    }
	    else
	    {
	    	System.out.println("indexOfLastVowel: passed");
	    }
	    
	    if(sameFirstLastMiddle("abbabba") != true)
	    {
	    	System.out.println("sameFirstLastMiddle(): failed");
	    }
	    else
	    {
	    	System.out.println("sameFirstLastMiddle(): passed");
	    }
	    
	    if(reversed("Gerard").equals("drareG") == false)
	    {
	    	System.out.println("reversed(): failed");
	    }
	    else
	    {
	     	System.out.println("reversed(): passed");
	    }
	    
	    if(numOccurrences("HelloHiHeyHey", "Hey") !=2)
	    {
	     	System.out.println("numOccurrences(): failed");
	    }
	    else
	    {
	    	System.out.println("numOccurrences(): passed");
	    }
	    
	    if(sameInReverse("racecar") != true)
	    {
	    	System.out.println("sameInReverse(): failed");
	    }
	    else
	    {
	    	System.out.println("sameInReverse(): passed");
	    }
	    
	    if(devoweled("Summer Vacation").equals("Smmr Vctn") == false)
	    {
	    	System.out.println("devoweled(): failed");
	    }
	    else
	    {
	    	System.out.println("devoweled(): passed");
	    }
	    
	    if(zipped("Spongebob", "Patrick").equals("SPpaotnrgiecbkob") == false)
	    {
	    	System.out.println("zipped(): failed");
	    }
	    else
	    {
	    	System.out.println("zipped(): passed");
	    }
	    
	    if(tabToSpace("banana	space", 15).equals("banana               space") == false)
	    {
	    	System.out.println("tabToSpace: failed");
	    }
	    else
	    {
	    	System.out.println("tabToSpace: passed");
	    }
	    
	    if(containsAll("Hello, world", "world") != true)
	    {
	    	System.out.println("containsAll: failed");
	    }
	    else
	    {
	    	System.out.println("containsAll: passed");
	    }
	    
	    if(indexOfAny("The Librarian's book", "books") != 6)
	    {
	    	System.out.println("indexOfAny(): failed");
	    }
	    else
	    {
	    	System.out.println("indexOfAny(): passed");
	    }
	    //end of main
	    }
	}
