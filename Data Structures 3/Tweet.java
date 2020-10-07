/**
 * Represent a tweet, including the content, author's username
 * and time when it was posted. 
 */
public class Tweet {
    
    public String user;
    public DateTime datetime; 
    public String content;
    
    public Tweet(String user, DateTime datetime, String content) {
            this.user = user; 
            this.datetime = datetime;
            this.content = content;       
    }
    
    public String toString(){
        return "@"+this.user+" ["+datetime.toString()+"]: "+content;
    }
    
    
    public int hashCode(){
        return (user.hashCode() + datetime.hashCode() + content.hashCode()) % 37;
    }
    
    
    public boolean equals(Tweet t){
        if(this.hashCode() == t.hashCode())
            return true;
        else
            return false;
    }
    
}