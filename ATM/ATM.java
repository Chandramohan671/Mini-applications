import java.util.*;

import javax.lang.model.util.ElementScanner14;


class ATM{

private static Scanner sc;

static int [] a1 = {2000,500,200,100};
static int [] ar ={0,0,0,0};
static ArrayList<UserBean> kj= new ArrayList<>();
static int x=0;
ArrayList<Integer> ht = new ArrayList<>();
static int pin=0;
static String re ="SBI";
public static int temp=0;
static boolean fag=false;
static int[] fds = new int[3];
static int bn=0;
public static ArrayList<String> ds = new ArrayList<>();

    public static boolean user(String a,String b,ArrayList<UserBean> ob)
    {
        boolean flag = false;
        for(int i=0;i<ob.size();i++)
        {
           if(ob.get(i).name.equals(a) && ob.get(i).password.equals(b) && fag==false)
           {
               flag=true;
               temp=i;
           }
        }
        return flag;
    }

   public static void valid(ArrayList<UserBean> ob)
   {

       System.out.println();
       System.out.println("ATM User");
       System.out.println("1.Amount Withdrawal");
       System.out.println("2.Balance Check");
       System.out.println("3.Amount Deposit");
       System.out.println("4.Transaction Details");
       System.out.println("5.Pin change");
       System.out.println("6.Mini Statement");
       System.out.println("7.Transfer");
       System.out.println("8.Exit");

       int o = sc.nextInt();

       switch(o)
       {
           case 1:
           System.out.println("Enter the ATM pin ");
           String we=sc.next();

           if(ob.get(temp).id.equals(we))
           {
                for(int i=0;i<fds.length;i++)
                {
                    fds[i]=0;
                }
                System.out.println("Enter the amount to withdrawal :");
                int in = sc.nextInt();
                int fg=in;
                int tot=0;

                ArrayList<Integer> al = new ArrayList<>();
                ArrayList<Integer> sd = new ArrayList<>();

                 for(int i=0;i<a1.length;i++)
                 {
                     tot=tot+(a1[i]*ar[i]);
                     if(ar[i]>0)
                     {
                        al.add(a1[i]);
                        sd.add(ar[i]);
                    }
                  }
         
                      int[] gh = new int[sd.size()];
                      //System.out.println(tot);
           
                if(tot>=in)
                {
                    if(in>10000)
                    {
                      System.out.println("The withdrawal limit per day is Rs.10000");
                    }
                    else if(in%10!=0)
                    {
                       System.out.println("Invalid Input");
                    }
                    else if(ob.get(temp).amount<in)
                    {
                      System.out.println("Your account has an insufficient balance");
                    }
                    else 
                    {
                         int c=0;
                         for(int i=0;i<al.size();i++)
                        {
                             if(in<al.get(i))
                             {
                               c++;
                              }
                        }
                 
                        if(c==al.size())
                        {
                            System.out.println("Please enter amount in terms of ");
                             for(int i=0;i<al.size();i++)
                             {
                                System.out.print(al.get(i)+" ");
                             }
                             System.out.println();
                        }
                        else
                        {
                           int p=0;
                           int f=0,y=0,t=0;
                           int up=0,v=0;
                            while(in>0)
                            {
                      
                                for(int i=0;i<al.size();i++)
                                {
                                    if(in>=al.get(i) && sd.get(i)>0)
                                    {
                                        in=in-al.get(i);
                                        up=up+al.get(i);
                                         v=sd.get(i);
                                         sd.set(i,v--);
                                          gh[i]++;

                                        for(int j=0;j<a1.length;j++)
                                        {
                                            if(al.get(i)==a1[j])
                                            {
                                              ar[j]=ar[j]-1;
                                            }
                                        }
                                      break;
                                    }
                                }
        
                            }
                  
                   
                           ob.get(temp).amount=ob.get(temp).amount-up;

                           ob.get(temp).transaction+="The amount debited by "+fg+" on "+ob.get(temp).id+" and current balance is "+ob.get(temp).amount+"\n";
                           ds.add("The amount debited by "+fg+" on "+ob.get(temp).id+" and current balance is "+ob.get(temp).amount);
                                
                           int r=0;
                            if(!we.contains(re))
                            {
                               ob.get(temp).amount=ob.get(temp).amount-10;
                               r=10;
                            }
                             // int h=fg+r;
                              
                                for(int k=0;k<al.size();k++)
                                {
                                  System.out.println("The no of"+al.get(k)+" are "+gh[k]);
                                }
                                
                                System.out.println("Enter to continue");
                                sc.nextLine();
                        
                              String bf = sc.nextLine();
                             System.out.print("\033[H\033[2J");
                             System.out.flush();
                            }
                   } 
                }
                
                else
                {
                    System.out.println("An ATM has insufficient balance");
                }
                System.out.println("Enter to continue");
                
                sc.nextLine();
                String b = sc.nextLine();
                System.out.print("\033[H\033[2J");
                System.out.flush();
           }
           else
           {
            fds[bn]++;
            bn++;
            System.out.print("\033[H\033[2J");
            System.out.flush();
             
             System.out.println("Invalid ATM id");
             System.out.println("After continous third attempt your account is blocked");
             
             System.out.println("Enter to continue");
             sc.nextLine();
             String b = sc.nextLine();
              
           }
        
           break;


           case 2:
           System.out.println("Your Balance is : "+ob.get(temp).amount);
           System.out.println("Enter to continue");
                
           sc.nextLine();
           String c = sc.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();
           break;


           case 3:
           System.out.println("Enter the amount to deposit: ");
           int n=sc.nextInt();
           ob.get(temp).amount= ob.get(temp).amount+n;
           
           ob.get(temp).transaction+="Amount deposited by "+n+" on "+ob.get(temp).id+" and your balance is "+ob.get(temp).amount+"\n";
        
           ds.add("Amount deposited by "+n+" on "+ob.get(temp).id+" and your balance is "+ob.get(temp).amount);
              
           System.out.println("Amount Deposited successfully");

           System.out.println("Enter to continue");
                
           sc.nextLine();
           String k = sc.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            break;


            case 4:
            System.out.println("Transaction details");
            if(ob.get(temp).transaction.length()==0)
            {
                System.out.println("No transactions currently");
            }
            else
            {
               System.out.println(ob.get(temp).transaction);
            }
            System.out.println("Enter to continue");
            sc.nextLine();
        
             String df = sc.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            break;


            case 5:
            System.out.println("Enter old pin : ");
            String ui=sc.next();
            if(ob.get(temp).id.equals(ui))
            {
               System.out.println("Enter new pin : ");
               String lk= sc.next();
               ob.get(temp).id=lk;
               System.out.println("Pin changed successfully");
            }
            else
            {
               System.out.println("Incorrect old pin");
            }
            System.out.println("Enter to continue");
                
           sc.nextLine();
           String bo = sc.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();
           break;
           

           case 6:
            System.out.println("Mini Statement");

            //System.out.println("Enter the atm pin : ");
            //String bv = sc.next();
           
            if(ds.size()>=3)
            {
                for(int i=ds.size()-1;i>=ds.size()-3;i--)
                {
                   System.out.println(ds.get(i));
                }
            
            }
            else
            {
                System.out.println("Currently no transactions on Mini statement");
            }
            System.out.println("Enter to continue");
                
                sc.nextLine();
                String bq = sc.nextLine();
                 System.out.print("\033[H\033[2J");
                 System.out.flush();
            break;


           case 7:
             System.out.println("Enter the pin :");
             String ew = sc.next();
             if(ob.get(temp).id.equals(ew))
             { 
               System.out.println("Enter the end user IFSC code:"); 
               String ks=sc.next();
               if(ob.get(temp).Ifsc.equals(ks))
               {
                   System.out.println("Enter amount to transfer :");
                   int yu = sc.nextInt();

                   ob.get(temp).amount=ob.get(temp).amount-yu;
                   int bc=0;
                   for(int i=0;i<ob.size();i++)
                   {
                       if(ob.get(temp).Ifsc.equals(ks))
                       {
                          bc=i;
                       }
                   }
                   ob.get(bc).amount=ob.get(temp).amount+yu;
               }
               else 
               {
                System.out.println("Incorrect IFSC");
               }


             }
             else
             {
               System.out.println("Incorrect pin");
             }
             System.out.println("Enter to continue");
                
                sc.nextLine();
                String bz = sc.nextLine();
                 System.out.print("\033[H\033[2J");
                 System.out.flush();
             break;

           case 8:
           System.out.print("\033[H\033[2J");
            System.out.flush();
            first();
        
        }
           int sa=0;
           for(int i=0;i<fds.length;i++)
           {
               if(fds[i]==1)
               {
                 sa++;
               }
               else 
               {
                   break;
               }
           }
           if(sa<3)
           {
            valid(ob);
           }
           else 
           {
            for(int i=0;i<fds.length;i++)
            {
                fds[i]=0;
            }
            System.out.print("\033[H\033[2J");
            System.out.flush();   
            System.out.println("Your attempted three times for pin validation");
            System.out.println("Your account is temporarily blocked for 24 hours");
            fag=true;
            first();
           }
    }


       
   

    public static void admin()
    {
        System.out.println();
        System.out.println("ATM Admin");
        System.out.println("1.Addmoney");
        System.out.println("2.ShowMoney");
        System.out.println("3.Exit");
 
        int a = 0;
            a = sc.nextInt();

            switch(a){
                 
                case 1:
                System.out.println("Enter the denominations:");


                for(int i=0;i<ar.length;i++)
                {
                   System.out.println("Enter no of "+a1[i]+"rs : ");
                   ar[i]=ar[i]+sc.nextInt();
                }
                System.out.println("Enter to continue");
                
                sc.nextLine();
                String y = sc.nextLine();
                 System.out.print("\033[H\033[2J");
                 System.out.flush();
                
                break;


                case 2:
                 System.out.println("The denominations are :");
                 for(int i=0;i<ar.length;i++)
                 {
                     System.out.println("The no of "+a1[i]+"rs are = "+ar[i]);
                 }
                 System.out.println("ATM balance is :");
                 int sum=0;
                 for(int i=0;i<a1.length;i++)
                 {
                    sum=sum+(a1[i]*ar[i]);
                 }
                 System.out.println(sum);
                 System.out.println("Enter to continue");
                
                sc.nextLine();
                String b = sc.nextLine();
                 System.out.print("\033[H\033[2J");
                 System.out.flush();
                
                 break;


                 case 3:
                 System.out.print("\033[H\033[2J");
                 System.out.flush();
                 first();
                 default:
                 System.out.println("Invalid Input");

                 
            }
            admin();
    }

    public static boolean check(String a,String b)
    {
        boolean flag =false;
        if(a.equals("adminkpr") && b.equals("kpr@1234"))
        {
            flag=true;
        }
        return flag;
    }

    public static void first(){
        System.out.println("ATM");

        System.out.println("Enter the choice: ");

        System.out.println("1.Admin login");

        System.out.println("2.User login");

        System.out.println("3.Exit");

        x = sc.nextInt();

        switch(x)
        {
            case 1:

            System.out.println("Enter username: ");
              String name = sc.next();
              System.out.println("Enter password: ");
              String pass= sc.next();

              boolean q=check(name,pass);

              if(q)
              {
                  admin();
              }
              else{
                  System.out.println("Invalid username or password");
              }
              break;
            case 2:
              System.out.println("Enter username: ");
              String n = sc.next();
              System.out.println("Enter password: ");
              String p= sc.next();
              
              //System.out.println(kj.get(0));
              if(user(n,p,kj))
              {
                  
                  valid(kj);
              }
              else 
              {
                  if(fag==false)
                  {
                   System.out.println("Invalid username or password");
                  }
                  else 
                  {
                    System.out.println("Your attempted three times for pin validation");
                    System.out.println("Your account is temporarily blocked for 24 hours");
                  }
              }

            break;
            
            case 3:
            System.exit(0);
            default:
            System.out.println("Invalid Input");
            break;
             
        }    

    first(); 

}
public static void creaetUser()
{
       kj.add(new UserBean("Chandra","123456","01IOB","","SBI12",500));
       kj.add(new UserBean("Mohan","098765","02KVB","","SBI23",34000));
       kj.add(new UserBean("Nighil","poiuytre","03HDFC","","SBI34",700));
       kj.add(new UserBean("Manjit","zxcvbn","04SBI","","SBI45",200));
}
    public static void main(String[] args)
    {
        sc = new Scanner(System.in);
       int x=0;

      creaetUser();
      first();
}
}

