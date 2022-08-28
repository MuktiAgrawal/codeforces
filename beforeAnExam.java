import java.util.*;
public class beforeAnExam {
    public static void main(String[]args)
    {
        try(Scanner sc=new Scanner(System.in))
        {
            int d,sumTime,minTime[],maxTime[],sumMax=0,sumMin=0;
            d=sc.nextInt();
            minTime=new int[d];
            maxTime=new int[d];
            sumTime=sc.nextInt();
            for(int i=0;i<d;i++)
            {
                minTime[i]=sc.nextInt();
                maxTime[i]=sc.nextInt();
                sumMax+=maxTime[i];
                sumMin+=minTime[i];
            }
            if(sumMax<sumTime || sumTime<sumMin)
            {
                System.out.println("NO");
            }
            else if(sumMin==sumTime)
            {
                System.out.println("YES");
                for(int i=0;i<d;i++)
                    System.out.print(minTime[i]+" ");
            }
            else if(sumMax==sumTime)
            {
                System.out.println("YES");
                for(int i=0;i<d;i++)
                    System.out.print(maxTime[i]+" ");
            }
            else
            {
                int req=sumMax-sumTime;
                for(int i=0;i<d && req!=0;i++)
                {
                    if(maxTime[i]-minTime[i]>=req)
                    {
                        maxTime[i]-=req;
                        req=0;
                    }
                    else
                    {
                        req-=maxTime[i]-minTime[i];
                        maxTime[i]=minTime[i];
                    }
                }
                System.out.println("YES");
                for(int i=0;i<d;i++)
                    System.out.print(maxTime[i]+" ");
            }
        }
    }
}
