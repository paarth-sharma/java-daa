import java.util.*;
public class JobScheduling{
    static class Job {
        char job_id;
        int deadline;
        int profit;
        Job(char job_id, int deadline, int profit){
            this.deadline = deadline;
            this.job_id = job_id;
            this.profit = profit;
        }
    }
 
    static void printJobScheduling(ArrayList<Job> arr){
        int n = arr.size();

        Collections.sort(arr, (a, b) -> { return a.deadline - b.deadline;});
 
        // initialise the result array and maxHeap
        ArrayList<Job> result = new ArrayList<>();

        PriorityQueue<Job> maxHeap = new PriorityQueue<>((a, b) -> { return b.profit - a.profit; });
 
        // starting the iteration from the end
        for (int i = n - 1; i > -1; i--) {
            
            int slot;
           
            if (i == 0)
                slot = arr.get(i).deadline;
            else
                slot = arr.get(i).deadline - arr.get(i - 1).deadline;
            
 
            maxHeap.add(arr.get(i));
 
            while (slot > 0 && maxHeap.size() > 0) {
 
                Job job = maxHeap.remove();
                slot--;
                result.add(job);
            }
        }

        Collections.sort(result, (a, b) -> { return a.deadline - b.deadline; });
       
        for (Job job : result) 
            System.out.print(job.job_id + " ");
        
       
        System.out.println();
    }
 
    // Driver's Code
    public static void main(String[] args){
        ArrayList<Job> arr = new ArrayList<Job>();

        arr.add(new Job('a', 2, 100));
        arr.add(new Job('b', 1, 19));
        arr.add(new Job('c', 2, 27));
        arr.add(new Job('d', 1, 25));
        arr.add(new Job('e', 3, 15));
       
        System.out.println("Following is maximum " + "profit sequence of jobs");
 
        // Function call
        printJobScheduling(arr);
    }
}