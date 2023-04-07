import java.util.*;
public class ActivitySelection {

    static class Pair{
        int first, second;

        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    static void selectActivity(int s[], int f[]){
        // vector to store result
        ArrayList<Pair> ans = new ArrayList<>();

        //Minimum priority queue in ascending order of finshing time
        PriorityQueue<Pair> p = new PriorityQueue<>(
            (p1, p2) -> p1.first - p2.first
        );

        for(int i=0; i< s.length; i++)
            p.add(new Pair(f[i], s[i]));

        Pair item = p.poll();
        int start = item.second;
        int end = item.first;

        ans.add(new Pair(start, end));

        while(!p.isEmpty()){
            Pair itr = p.poll();
            if(itr.second >= end){
                start = itr.second;
                end = itr.first;
                ans.add(new Pair(start, end));
            }
        }

        System.out.println("Following activities should be selected: ");
 
        for (Pair itr : ans) 
            System.out.println(
            "Activity started at " + itr.first
            + " and ends at " + itr.second);
    }
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);

        System.out.println("Enter num of activities: ");
        int n = key.nextInt();
        int s[] = new int[n], f[] = new int [n];
        System.out.println("Enter when the activities start: ");
        for(int i=0; i<n; i++)
            s[i] = key.nextInt();

        System.out.println("Enter when the activities end: ");
        for(int i=0; i<n; i++)
            f[i] = key.nextInt();
        
        selectActivity(s, f);

        key.close();
    }
}
