/**
 * Read web server data and analyse hourly access patterns.
 * 
 *  Lab 7 Questions
 * 
 * 1. Busiest times of day are; 10am,2pm,6pm
 * 
 * 2.private Person[] people;
 * 
 * 3.private boolean[] vacant;
 * 
 * 4. hourCounts used: in constructor, and every method besides printData()
 * 
 * 5. int[] counts; boolean[] occupied;
 * 
 * 6. readings = new double[60]; urls= new String[90]; 
 * machines= TicketMachine[5];
 * 
 * 7. 20
 * 
 * 8. it is using round brackets, should be square. 
 * double[] prices= new double[50];
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader();
    }
    
    //Question 12
    /**
     * Create an object to analyze hourly web accesses. Reads files created 
     * in log
     
    public LogAnalyzer(String filename)
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];

    }
    */

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        //Question 10
        int hour = 0;
        while(hour < hourCounts.length) {
            System.out.println(hour + ":" + hourCounts[hour]);
            hour++;
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
    
    //Question 11
    /**
     * Print all the values in the marks array that are greater than mean
     * @param marks An array of mark values
     * @param mean The mean (average) mark
     */
    
    public void printGreater(double[] marks, double mean)
    {
        for(int index = 0; index < marks.length; index++) {
            if(marks[index] > mean) {
                System.out.println(marks[index]);
            }
        }
    }
    
    //Question 14
    /**
     * Return the number of accesses recorded in the log file
     */
    public int numberOfAccesses()
    {
        int total = 0;
        for(int index= 0; index < hourCounts.length; index++) {
            total ++;
        }
        return total;
    }
    
    //Question 15
    /** 
     * Returns the busiest hour according to data
     */
    public int busiestHour()
    {
        int max = hourCounts[0];
        for(int index= 0; index< hourCounts.length; index++ ) {
            if(hourCounts[index] > max)
            max = hourCounts[index];
        }
        return max;
    }
    
    //Question 16
    /**
     * Returns the least busy hour according to data
     */
    public int quiestestHour()
    {
        int min = hourCounts[0];
        for(int index = 0; index < hourCounts.length; index++) {
            if(hourCounts[index]<= min)
            min = hourCounts[index];
        }
        return min;
    }
    
}
