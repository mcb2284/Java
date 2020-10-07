/**
 * Represent a timestamp consisting of a date (day/month/year) and time 
 * in hours and minutes (24h format.
 */
public class DateTime implements Comparable<DateTime> {   //For part 4
    
    public int year;
    public int month;
    public int day; 
    public int hours;
    public int minutes;    
    public int seconds;
    public boolean pm; 

    
    public DateTime(int year, int day, int month, int h, int m) {        
        this.year = year; 
        this.month = month; 
        this.day = day;     
        this.hours = h; 
        this.minutes = m;                
    }
    
    public DateTime(String datetime) {
        String[] fields = datetime.split(" ");
        String[] dateFields = fields[0].split("/");
        month = Integer.parseInt(dateFields[0]);
        day = Integer.parseInt(dateFields[1]);
        year = Integer.parseInt(dateFields[2]);
        
        String[] timeFields = fields[1].split(":"); 
        hours = Integer.parseInt(timeFields[0]);
        minutes = Integer.parseInt(timeFields[1]);;
    }
    
    public String toString() {
        return Integer.toString(month)+"/"+Integer.toString(day)+"/"+Integer.toString(year)+"  "+
            String.format("%02d" , hours)+":"+String.format("%02d", minutes);
        
    } 
    
    
    
    public int hashCode(){
        int total = year * 100000 +
                    month * 10000 +
                    day * 1000 +
                    hours * 100 +
                    minutes * 10;
        return total % 37;
    }
    
    
    public boolean equals(DateTime dt){
        if(this.hashCode() == dt.hashCode())
            return true;        
        else
            return false;
        
    }
    
    
    public int compareTo(DateTime dt) {
        if(year > dt.year){
            return 1;
        }             
        if(year < dt.year){
            return -1;
        }
        else{
            if(month > dt.month){
                return 1;
            }
            if(month < dt.month){
                return -1;
            }
            else{
                if(day > dt.day){
                    return 1;
                }
                if(day < dt.day){
                    return -1;
                }
                else{
                    if(hours > dt.hours){
                        return 1;
                    }
                    if(hours < dt.hours){
                        return -1;
                    }
                    else{
                        if(minutes > dt.minutes){
                            return 1;
                        }
                        if(minutes < dt.minutes){
                            return -1;
                        }
                        else{
                            return 0;

                        }
                    }                    
                }

            }
        }
        
    }
    
}