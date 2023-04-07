import java.util.*;
public class Knapsack{  

    public static void main(String args[]){  
        int j=0,max_qty, m, n;  
        float sum = 0,max;  

        Scanner key = new Scanner(System.in);
        System.out.println("Enter no of items");  
        n = key.nextInt(); 
        int array[][]=new int[2][n];  

        System.out.println("Enter the weights of each items");
        for(int i=0;i<n;i++)  
            array[0][i]=key.nextInt();    

        System.out.println("Enter the values of each items");
        for(int i=0;i<n;i++)  
            array[1][i]=key.nextInt(); 

        System.out.println("Enter maximum volume of knapsack :");  
        max_qty = key.nextInt();  

        m = max_qty;  

        while(m>=0){
            max=0;  

            for(int i=0;i<n;i++){  
                if(((float)array[1][i])/((float)array[0][i])>max){  
                    max=((float)array[1][i])/((float)array[0][i]);  
                    j=i;  
                }  
            }  

            if(array[0][j]>m){  
                System.out.println("Quantity of item number: " +  (j+1) + " added is " +m);
                sum += (m*max);  
                m = -1;
            }  

            else{  
                System.out.println("Quantity of item number: " + (j+1) + " added is " + array[0][j]);
                m -= array[0][j];  
                sum += (float)array[1][j];  
                array[1][j] = 0;  
            }  
        }  

        System.out.println("The total profit is " + sum);

        key.close();

    }  

}