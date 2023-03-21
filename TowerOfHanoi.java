import java.util.Scanner;
import java.util.Stack;

public class TowerOfHanoi
{
    static Stack<Integer> poleA=new Stack<>();
    static Stack<Integer> poleB=new Stack<>();
    static Stack<Integer> poleC=new Stack<>();
    public static void display(int disk) 
    {
        int arr1[]=new int[disk];
        int arr2[]=new int[disk];
        int arr3[]=new int[disk];
        
        for (int i = 0; i <poleA.size(); i++)
        {
            arr1[i]=poleA.get(i);
        }
        for (int i = 0; i <poleB.size(); i++)
        {
            arr2[i]=poleB.get(i);
        }
        for (int i = 0; i <poleC.size(); i++)
        {
            arr3[i]=poleC.get(i);
        }
        for (int i = disk-1; i >=0; i--)
        {
            if (arr1[i]!=0)
            {
                System.out.print("|"+arr1[i]+"|"+" ");
                
            }
            else 
            {
                System.out.print("|"+" "+"|"+" ");
            }
            if (arr2[i]!=0)
            {
                System.out.print("|"+arr2[i]+"|"+" ");
                
            }
            else 
            {
                System.out.print("|"+" "+"|"+" ");
            }
            if (arr3[i]!=0)
            {
                System.out.print("|"+arr3[i]+"|");
                
            }
            else 
            {
                System.out.print("|"+" "+"|");
            }

            System.out.println();


        }
        System.out.println(" a "+"  b "+"  c ");


    }
    
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to the game of tower of Hanoi ");
        System.out.print("choose number of disks: ");
        
        int disks=sc.nextInt();

        
        for (int i = disks; i > 0; i--)
        {
            poleA.push(i);  
        }
        display(disks);
        int moves=0;
        for (int i = 0;/*infinity loop */; i++)
        {
            if (poleC.size()==disks)
            {
                System.out.println("you won! ");
                System.out.println("number of moves: "+moves);
                break;
            }
            int key=0;
            System.out.print("remove disk from: ");
            char out=sc.next().charAt(0);
            // enter q to quit
            if (out=='q')
            {
                System.out.println("you surrendered");
                break;
                
            }
            if (out<97 || out>99)
            {
                System.out.println("choose from a,b and c");
                continue;
                
            }
            if (out=='a')
            {
                if (poleA.empty())
                {
                    System.out.println("pole a is empty");
                    continue;
                    
                }
                else if (!poleA.empty())
                {
                    key=poleA.pop();
                }
               
                
            }
            else if (out=='b')
            {
                if (poleB.empty())
                {
                    System.out.println("pole b is empty");
                    continue;
                    
                }
                else if (!poleB.empty())
                {
                    key=poleB.pop();
                }
                
            }
            else if (out=='c')
            {
                if (poleC.empty())
                {
                    System.out.println("pole c is empty");
                    continue;
                    
                }
                else if (!poleC.empty())
                {
                    key=poleC.pop();
                }
                
            }
        
            
           

            System.out.print("put disk in: ");
            char in=sc.next().charAt(0);
            // enter q to quit
            if (in=='q')
            {
                System.out.println("you surrendered");
                break;
                
            }
            if (in<97 || in>99)
            {
                System.out.println("choose from a,b and c");
                continue;
                
            }
            if (in=='a')
            {
                if (!poleA.empty())
                {
                    if (poleA.peek() <key)
                    {
                        System.out.println("can't put bigger disk on smaller disk try again");
                        if (out=='b')
                        {
                            poleB.push(key);
                        }
                        if (out=='c')
                        {
                            poleC.push(key);
                        }
                    }
                    else 
                    {
                        poleA.push(key);
                    }
                    
                }
                else 
                {
                    poleA.push(key);
                }
                
            }
            if (in=='b')
            {
                if (!poleB.empty())
                {
                    if (poleB.peek() <key)
                    {
                        System.out.println("can't put bigger disk on smaller disk");
                        if (out=='a')
                        {
                            poleA.push(key);
                        }
                        if (out=='c')
                        {
                            poleC.push(key);
                        }
                        continue;
                    }
                    else 
                    {
                        poleB.push(key);
                    }
                    
                }
                else 
                {
                    poleB.push(key);
                }
                
            }
            if (in=='c')
            {
                if (!poleC.empty())
                {
                    if (poleC.peek() <key)
                    {
                        System.out.println("can't put bigger disk on smaller disk");
                        if (out=='b')
                        {
                            poleB.push(key);
                        }
                        if (out=='a')
                        {
                            poleA.push(key);
                        }
                        continue;
                    }
                    else 
                    {
                        poleC.push(key);
                    }
                    
                }
                else 
                {
                    poleC.push(key);
                }
                
            }
           

            moves++;
            display(disks);

        }
    }

    
}

/*

 // optimal solutions
3-7
4-15
5-31
6-63


 */