import java.util.*;

class Job {
    int id, deadline, profit;
    Job(int id,int d,int p){
        this.id=id; deadline=d; profit=p;
    }
}

public class JobScheduling {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter number of jobs: ");
        int n=sc.nextInt();

        Job jobs[]=new Job[n];

        for(int i=0;i<n;i++){
            System.out.println("Enter id, deadline, profit:");
            jobs[i]=new Job(sc.nextInt(),sc.nextInt(),sc.nextInt());
        }

        Arrays.sort(jobs,(a,b)->b.profit-a.profit);

        int res[]=new int[n];
        Arrays.fill(res,-1);

        int profit=0;

        for(Job j:jobs){
            for(int k=Math.min(n,j.deadline)-1;k>=0;k--){
                if(res[k]==-1){
                    res[k]=j.id;
                    profit+=j.profit;
                    break;
                }
            }
        }

        System.out.println("Jobs selected:");
        for(int i:res)
            if(i!=-1) System.out.print("J"+i+" ");

        System.out.println("\nProfit="+profit);
    }
}

/*
Sample Output
Enter number of jobs: 3
Enter id, deadline, profit:
1 2 100
2 1 50
3 2 10
Jobs selected:
J1 J2
Profit=150
*/