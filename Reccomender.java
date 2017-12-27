//Gerard Patrick Gibbons, Junior-year Computer Science
//Netflix Assignment, reads in from two text files and your scores of movies, returns what movie you should watch.
//Date: November 15, 2017
package Reccomender;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Reccomender {
    public static void main(String args[])
    {
        String movies = getWebContents("https://cis.temple.edu/~jfiore/2017/fall/1068/assignments/09/files/movies.txt");
        String ratings = getWebContents("https://cis.temple.edu/~jfiore/2017/fall/1068/assignments/09/files/ratings.txt");
        System.out.println(movies);
        Scanner s = new Scanner(movies);
        Scanner r = new Scanner(ratings);
        String [] movs = new String [20];
        int [][] rats = new int [30][20];
        int [] userRats = new int [20];
        int [] recRats = new int [20];
        double [] weight = new double [30];
        int update = 0;
        
        //while loop to fill movie array (movs)
        while(s.hasNextLine())
        {
         movs[update] = s.nextLine();
         update++;
        }
        //for loop to fill ratings 2-D array (rats)
            for(int i = 0; i < 30; i++)
            {
                for(int j = 0; j < 20; j++)
                {
                    rats[i][j] = r.nextInt();
                }
            }
            System.out.print("Please Enter your ratings for each of these movies"
                    + "\n(rate 1-5 stars, -1 if you haven't seen the movie.)\n");
            //reads user ratings. (userRats
        for(int i = 0; i < 20; i++)
        {
            System.out.print(movs[i] + " :");
            Scanner t = new Scanner (System.in);
            userRats[i] = t.nextInt();
        }
        //calculate the average for each movie and store them in an array. (recRats)
        weight = similarityScore(rats, userRats);
        for(int i = 0; i < 20; i++){
            int sum = 0;
            int count = 0;
            for(int j = 0; j < 30; j++)
            {
                if(rats[j][i] != -1)
                {
                sum += rats[j][i] * (1 - weight[j]);
                count++;
                }
            }
            recRats[i] = sum / count;
        }
        int largest = 0;
        int indexLargest = 0;
        //finds the movie index with the highest score in the reccomended movies array.
        for(int i = 0; i < 20; i++)
        {
            if(recRats[i] > largest)
            {
                if(userRats[i] == -1){
                largest = recRats[i];
                indexLargest = i;
            }}
            
        }
        System.out.print("We reccomend: " + movs[indexLargest]);
    }
    //Will calculate a weight based on how similar your ratings are to someone elses.
    //a bit rudementary, but it works :D
    public static double [] similarityScore(int [][] rats, int [] userRats)
    {
        double [] result = new double [20];
        double [] simScores = new double [30];
        for(int i = 0; i < 30; i++)
        {
            int difference = 0;
            for(int j = 0; j < 20; j++)
            {
                if(rats[i][j] != -1)
                {
                    if(userRats[j] != -1)
                    {
                        if(userRats[j] > rats[i][j])
                        {
                            result[j] = (userRats[j] - rats[i][j]);
                        }
                        else
                        {
                            result[j] = (rats[i][j] - userRats[j]);
                        }
                    }else
                    {
                        result[j] = 2.5;
                    }
                }else
                {
                    result[j] = 2.5;
                }
            }
            for(int z = 0; z < 20; z++)
            {
                difference += result[z];
            }
            simScores[i] = (difference / 100);
        }
        return simScores ;
    }
    
    
    //using the method from assignment 07 we were given for the Jaws Script in order to read from the web.
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
    
}
