/******************************************************************
 * I couldn't figure out part four, I know what I was doing wrong,
 * I wasn't implementing the hasmap or maybe the equals correctly
 * but you can see my attempt in the getTweetsByUser method.
 * 
 * I made three individual set methods for each of the maps. The reson
 * chose this implementaction was for the ready-ability. I understand 
 * that I end up itelating the list 3 times to instantciate the maps,
 * however it doesn't actually change the BigO so I decided it made
 *  sense to do it this way.
 ******************************************************************/ 

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap; 
import java.util.TreeMap; 
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.HashSet;


public class TweetDB {
   
    
    HashMap<String, List<Tweet>> tweetsPerUser;
    HashMap<String, List<Tweet>> tweetsPerKeyword;  
    TreeMap<DateTime, List<Tweet>> tweetsByTime;
    
    public TweetDB(String pathToFile) throws FileNotFoundException, IOException {
        tweetsPerUser = new HashMap<>();               
        tweetsPerKeyword = new HashMap<>();   
        tweetsByTime = new TreeMap<>();         
        
        BufferedReader br = new BufferedReader(new FileReader(pathToFile));
        CsvReader csv = new CsvReader(br);
        
        List<Tweet> tweet = new ArrayList<>();        
        String[] fields = csv.nextLine(); 

        while (fields != null) {
            tweet.add(setTweet(fields));
            fields = csv.nextLine();
        }
        tweetsPerUser = setTweetsPerUser(tweet);
        tweetsPerKeyword = setTweetsPerKeyword(tweet);
        tweetsByTime = setTweetsByTime(tweet);
              
    } 
    
    /*************************************************************************************
     * setTweet takes the data from the fields and instantiates a Tweet with the 
     * proper data to be stored in the hashmap or treemap.
     *************************************************************************************/
    public Tweet setTweet(String[] fields){ 
        
                
        DateTime tweetDT = new DateTime(fields[2]);
        Tweet userTweet = new Tweet(fields[0], tweetDT, fields[1]);
        
        return userTweet;
    }
    
    
    /*************************************************************************************
     * setTweetsPerUser takes the tweet list and adds the key value pairs 
     * per username and returns a hashmap.
     *************************************************************************************/          
    private HashMap<String, List<Tweet>> setTweetsPerUser(List<Tweet> tweets){
        
        HashMap<String, List<Tweet>> temp = new HashMap<>();
        List<Tweet> userTweet;
        
        for(Tweet x : tweets){
            
            if(temp.containsKey(x.user)){
                temp.get(x.user).add(x);
                                               
            }
            else{
                userTweet = new ArrayList<>();
                userTweet.add(x);
                temp.put(x.user, userTweet);
                
            }
        }       
        return temp;
    }
    
    
    
    /*************************************************************************************
     * setTweetsPerKeyword takes the tweet list and adds the key value pairs
     * per key word and returns a hashmap.
     *************************************************************************************/          
    private HashMap<String, List<Tweet>> setTweetsPerKeyword(List<Tweet> tweets){
        
        HashMap<String, List<Tweet>> temp = new HashMap<>();
        List<Tweet> userTweet;
        
        
        
        for(Tweet x : tweets){
            
            String no_punctuation = x.content.replaceAll("\\W"," ");
            String[] keyword = no_punctuation.split("\\s+");
            
            for(String y : keyword){
                
                if(temp.containsKey(y)){                    
                    temp.get(y).add(x);
                                        
                }
                else{                    
                    userTweet = new ArrayList<>();
                    userTweet.add(x);
                    temp.put(y, userTweet);

                }                
            }

        }       
        return temp;
    }
    
    
    /*************************************************************************************
     * setTweetsPerUser takes the tweet list and adds the key value pairs 
     * per username and returns a hashmap.
     *************************************************************************************/          
    private TreeMap<DateTime, List<Tweet>> setTweetsByTime(List<Tweet> tweets){
        
        TreeMap<DateTime, List<Tweet>> temp = new TreeMap<>();
        List<Tweet> userTweet;
        
        for(Tweet x : tweets){

            if(temp.containsKey(x.datetime)){
                temp.get(x.datetime).add(x);               
            }
            else{
                userTweet = new ArrayList<>();
                userTweet.add(x);
                temp.put(x.datetime, userTweet);
                
            }
        }       
        return temp;
    }    
        
    
    /*************************************************************************************
     * Returns the values of the key: user in the hashmap tweetsPerUser
     *************************************************************************************/    
    
    public List<Tweet> getTweetsByUser(String user) {   
        
        
        List<Tweet> tweets = new ArrayList<>(tweetsPerUser.get(user));      
        HashSet<Tweet> hashed_tweets = new HashSet<>();
        
        for(Tweet t : tweets){
            hashed_tweets.add(t);
        }
                
        System.out.println(hashed_tweets);
 
        
        return tweetsPerUser.get(user);
               
    }
    
    
    /*************************************************************************************
     * Returns the values of the key: kw in the hashmap tweetsPerKeyword
     *************************************************************************************/        
    public List<Tweet> getTweetsByKeyword(String kw) {
        
        return tweetsPerKeyword.get(kw);
        
    }
    
    
    /*************************************************************************************
     * For some reason I could not get the subMap func to work properly so I wrote my own 
     * function to get the range of dates. 
     *************************************************************************************/        
    public List<Tweet> getTweetsInRange(DateTime start, DateTime end) {
        
        List<Tweet> rangeList = new ArrayList<>();
 
        for(DateTime dt : tweetsByTime.keySet()){
            if(dt.compareTo(start) >= 0 && dt.compareTo(end) <= 0){
                rangeList.addAll(tweetsByTime.get(dt));
            }
        }
            
        return rangeList;
    }  
    
    
    
    
    public static void main(String[] args) {
          
        try {
            TweetDB tdb = new TweetDB("coachella_tweets.csv");

           // Part 1: Search by username 
            for(Tweet t : tdb.getTweetsByUser("MsHGolightly"))
                System.out.println(t);
            
              
            //Part 2: Search by keyword
           
            for(Tweet t : tdb.getTweetsByKeyword("music"))               
                System.out.println(t);
            
            
           // Part 3: Search by date/time interval          
            for(Tweet t : tdb.getTweetsInRange(new DateTime("1/6/15 00:00"), new DateTime("1/6/15 5:00")))
                System.out.println(t);
            
            
        } catch (FileNotFoundException e) {
            System.out.println(".csv File not found.");
        } catch (IOException e) {
            System.out.println("Error reading from .csv file.");
        }
        
        
        
        
    }
    
}