import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Main {
    
    static Scanner sc;
    static int usid=1001; 
    static int reqid=2001;
    static int trid=3001;
    static ArrayList<Use> us = new ArrayList<>();
    static ArrayList<Trans> trs = new ArrayList<>();
    static ArrayList<String> fd = new ArrayList<>();


    public static void req(int p)
    {
        System.out.println("Enter the food name eaten");
        String vb = sc.next();
        System.out.println("Enter the price for one person");
        int pr=sc.nextInt();

        int am = us.size()*pr;

        System.out.println("The total cost is "+am);

        System.out.println("Your wallet balance is "+us.get(p).wal);
        if(am<=us.get(p).wal)
        {
         us.get(p).wal-=am;

         System.out.println("After payment wallet balance is "+us.get(p).wal);

        for(int i=0;i<us.size();i++)
        {
            if(us.get(i).id!=us.get(p).id)
            {
              us.get(i).upd+="The food "+vb+" is eaten "+"your share is "+pr+" and request id is "+reqid+" benefiter id is "+us.get(p).id+" and benefiter name is "+us.get(p).name+"\n";
              us.get(p).temp+="The payment is request to "+us.get(i).name+" for food "+vb+" eaten"+" and request id is "+reqid+"\n";
            }

        }
        fd.add(vb);
        trs.add(new Trans(vb,reqid,us.get(p).id,trid));
        trid++;
        reqid++;
      }
      else 
      {
        System.out.println("You have an insufficient balance");
      }

    }

public static void resup(int h)
{
   if(us.get(h).upd.length()==0)
   {
    System.out.println("Currently no request availble");
   }
   else 
   {
   System.out.println(us.get(h).upd);
   System.out.println("Enter the request id from mentioned above for payment");
   String k = sc.next();
   if(us.get(h).upd.contains(k))
   {
    //System.out.println("Your previous payment completed request");
    System.out.println("Your available balance is "+us.get(h).wal);
    System.out.println("Enter the amount for request");
    int fe=sc.nextInt();
    if(fe>us.get(h).wal)
    {
        System.out.println("You have an insufficient balance");
    }
    else 
    {
        
        String bg = "your share is "+fe+" and request id is "+k;        
        prevpay(h);
        System.out.println();
        System.out.println("Your previous payments history displayed above");
        System.out.println("Check the previous payments history for confirmation whether these requests are already paid or not");
        
        System.out.println("1.Already paid");
        System.out.println("2.Not paid");

        int vd=sc.nextInt(); 

        if(vd==1)
        {
            System.out.println("The request is already paid");
            System.out.println("Enter to continue");
            sc.nextLine();
            String fd = sc.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            house(h);
        }
        else 
        {
        if(us.get(h).upd.contains(bg))
        {
            us.get(h).wal-=fe;
            String fdna="";

            for(int j=0;j<fd.size();j++)
            {
                if(us.get(h).upd.contains(fd.get(j)))
                {
                   fdna+=fd.get(j);
                   break;
                }
            }
            System.out.println("The payment is successfull");
           
            for(int i=0;i<us.size();i++)
            {
                if(us.get(h).upd.contains(String.valueOf(us.get(i).id)))
                {
                   us.get(i).wal+=fe;
                   us.get(i).stat+="The payment done by "+us.get(h).name+" sender id is "+us.get(h).id+" for the food "+fdna+" eaten"+"\n";
                   us.get(h).temp+="The amount "+fe+" is paid to "+us.get(i).name+" for the food "+fdna+" eaten "+" and wallet balance is "+us.get(h).wal+"\n";
                   System.out.println("The amount is paid to "+us.get(i).name);
                   break;
                }
            }

        }
        else 
        {
            System.out.println("The invalid payment amount for payment request");
        }
    }
    }
   }
   else 
   {
     System.out.println("Invalid request id");
   }
}
}

public static void prevpay(int vf)
{
    if(us.get(vf).temp.length()==0)
    {
        System.out.println("Currently no previous payments");
    }
    else 
    {
        System.out.println(us.get(vf).temp);
    }
}

    public static void house(int y)
    {
        System.out.println("Home page");
        System.out.println("1.Send amount payment request to all");
        System.out.println("2.Check for payment request");
        System.out.println("3.Wallet");
        System.out.println("4.Previous payments and requests");
        System.out.println("5.Status of payment requests");
        System.out.println("6.Exit");

        int bg = sc.nextInt();

        switch(bg)
        {
            case 1:
            req(y);
            System.out.println("Enter to continue");
            sc.nextLine();
            String fd = sc.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            break;
            case 2:
            resup(y);
            System.out.println("Enter to continue");
            sc.nextLine();
            String df = sc.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();
             break;
            case 3:
            System.out.println("Your available balance is "+us.get(y).wal);
            System.out.println("1.Add amount to wallet");
            System.out.println("2.Exit");

            int v = sc.nextInt();

            if(v==1)
            {
                System.out.println("Enter the amount to add");
                int dc = sc.nextInt();
                us.get(y).wal+=dc;

                System.out.println("Amount added successfully");

                System.out.println("Enter to continue");
                sc.nextLine();
                String jn = sc.nextLine();
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
            break;

            case 4:
               prevpay(y);
               System.out.println("Enter to continue");
               sc.nextLine();
               String nj = sc.nextLine();
               System.out.print("\033[H\033[2J");
               System.out.flush();
               break;
            case 5:
             if(us.get(y).stat.length()==0)
             {
                System.out.println("Currently no updates availablle");
             }
             else 
             {
                System.out.println(us.get(y).stat);
             }
             System.out.println("Enter to continue");
             sc.nextLine();
             String kn = sc.nextLine();
             System.out.print("\033[H\033[2J");
             System.out.flush();
             break;
            
            case 6:
            home();
        }
        house(y);
    }



    public static void home()
    {
        System.out.println("Splitwise food sharing");
        System.out.println("1.New User");
        System.out.println("2.Existing User");
        System.out.println("3.Exit");

        int x = sc.nextInt();

        switch(x)
        {
            case 1:
            System.out.println("Enter name : ");
            String b = sc.next();
            System.out.println("Enter password : ");
            String c = sc.next();
            System.out.println("Enter minimum 500 wallet amount : ");
            int d = sc.nextInt();

            if(d>=500)
            {
               us.add(new Use(b,c,d,usid,"","",""));
               usid++;
            }
            else 
            {
                System.out.println("You should pay minimum 500 during registration");
            }
            System.out.println("Registered successfully");
            System.out.println("Enter to continue");
                
            sc.nextLine();
            String fd = sc.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            break;
            case 2:
            System.out.println("Enter name : ");
            String e = sc.next();
            System.out.println("Enter password : ");
            String f = sc.next();
            boolean fag=false;
            int hty=0;
            for(int i=0;i<us.size();i++)
            {
                if(us.get(i).name.equals(e) && us.get(i).pass.equals(f))
                     {
                         fag=true;
                         hty=i;
                         break;
                     }
            }
            if(!fag)
            {
                     System.out.println("Incorrect username or password");
            }
            else 
            {
                house(hty);
            }
            System.out.println("Enter to continue");
                    
             sc.nextLine();
             String ju = sc.nextLine();
             System.out.print("\033[H\033[2J");
             System.out.flush();
             break;
            case 3:
            System.exit(0);
        }
        home();
    }





    public static void main(String[] args)
    {
       sc=new Scanner(System.in);

       home();
    }
}
