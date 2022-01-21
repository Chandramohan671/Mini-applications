import java.awt.print.Book;
import java.util.*;

class Main {

static Scanner sc;
static int usid=1001;
static int seatid=2001;
static int bokid=3001;
static int d=1;
static int ar[][]= new int[7][1];

static ArrayList<Booktr> bk = new ArrayList<>();

//static ArrayList<Booktr> co = new ArrayList<>();

static ArrayList<Booktr> wi = new ArrayList<>();

static ArrayList<Usert> usi = new ArrayList<>();


static HashMap<String,String> hm = new HashMap<>();


public static void admin()
{
    System.out.println("Admin");
    System.out.println("1.Available tickets");
    System.out.println("2.Booked tickets");
    System.out.println("3.Confirmed tickets");
    System.out.println("4.Add train");
    System.out.println("5.Exit");

    int we = sc.nextInt();

    switch(we)
    {
        case 1:
        for(int i=0;i<ar.length;i++)
        {
            for(int j=0;j<ar[0].length;j++)
            {
                System.out.print(ar[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Enter to continue");     
        sc.nextLine();
        String aq = sc.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        break;

        case 2:
          System.out.println("Booked tickets");
          if(wi.size()==0)
          {
              System.out.println("Currently no booked tickets");
          }
          else 
          {

          for(int j=0;j<wi.size();j++)
          {
            System.out.println(wi.get(j));
          }
        }
        System.out.println("Enter to continue");     
        sc.nextLine();
        String gh = sc.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        break;
        case 3:
        if(bk.size()==0)
        {
            System.out.println("Currently no confirmed tickets");
        }
        else 
        {
            for(int i=0;i<bk.size();i++)
          {
              System.out.println(bk.get(i));
          }
        }
        System.out.println("Enter to continue");     
        sc.nextLine();
        String ji = sc.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        break;
        
        case 4:
             System.out.println("Enter train id");
             String dy = sc.next();
             String dl="";
             System.out.println("Train path may include 7 stations with destination");
        
             System.out.println("Enter "+7+" stations for train path ");

             for(int i=0;i<7;i++)
             {
                 dl=dl+sc.next()+" ";
             }
             hm.put(dy,dl);
             System.out.println("Train added successfully"); 
             System.out.println("Enter to continue");     
        sc.nextLine();
        String bk = sc.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
           break;
        case 5:
            home();
    }
    admin();
}


public static void canyi(int w)
{
    boolean ert = false;
    for(int i=0;i<wi.size();i++)
    {
        if(wi.get(i).from.equals(bk.get(w).from) && wi.get(i).to.equals(bk.get(w).to))
        {
            wi.get(i).stat="confirmed";
            bk.add(wi.get(i));

            int dc=wi.get(i).seaid;

        for(int j=0;j<ar.length;j++)
        {
            for(int k=0;k<ar[0].length;k++)
            {
                if(ar[j][k]==bk.get(w).seaid)
                {
                    ar[j][k]=dc;
                    break;
                }
            }
        }

            bk.remove(w);
            wi.remove(i);
            ert=true;
            break;
        }
    }

    if(!ert)
    {
       
        int cd=bk.get(w).seaid;

        for(int i=0;i<ar.length;i++)
        {
            for(int j=0;j<ar[0].length;j++)
            {
                if(ar[i][j]==cd)
                {
                    ar[i][j]=0;
                    break;
                }
            }
        }
        bk.remove(w);
    }
    System.out.println("Ticket cancelled successfully");
}

public static void homeuse(int x)
{
     System.out.println("Welcome");
     System.out.println("1.Book ticket");
     System.out.println("2.Ticket status");
     System.out.println("3.Cancel ticket");
     System.out.println("4.Exit");

     int de = sc.nextInt();
     int dpid=0;
     switch(de)
     {
         case 1:
         if(hm.size()==0)
         {
            System.out.print("No available trains ");
         }
         else 
         {
         System.out.println("Available trains - ");
         System.out.println("  Train id "+" : Train path");
         for(Map.Entry<String,String> mj : hm.entrySet())
         {
             System.out.println(d+". "+mj.getKey()+" - "+mj.getValue());
             d++;
         }
         System.out.println();

         System.out.println("Enter id");

         String fv = sc.next();
         boolean lkj = false;
        String ar2="";
        for(Map.Entry<String,String> jm : hm.entrySet())
        {
             if(jm.getKey().equals(fv))
             {
                ar2+=jm.getValue();
                 lkj=true;
                 break;
             }
         }

         if(!lkj)
         {
             System.out.println("Invalid train id");
         }
         else 
         {
             
         String un = usi.get(x).name;

         System.out.println("Train id is "+fv);

         System.out.println("Train path is ");

         String [] ar1=ar2.split(" ");

         for(int i=dpid;i<ar1.length-1;i++)
         {
               System.out.print(String.valueOf(ar1[i])+" ->");
         }
            System.out.println(String.valueOf(ar1[ar1.length-1]));

         System.out.println("Enter departure :");
         String nu = sc.next();
         boolean tyu = false;
        
         for(int i=0;i<ar1.length;i++)
         {
             if(ar1[i].equals(nu))
             {
                 dpid=i;
                 tyu=true;
                 break;
             }
         }
          
         if(!tyu)
         {
             System.out.println("Enter valid departure mentioned above");
         }
         else 
         {
            System.out.println("Available destination - "); 

            for(int i=dpid+1;i<ar1.length-1;i++)
            {
               System.out.print(ar1[i]+" ->");
            }
            System.out.println(ar1[ar1.length-1]);
          
            System.out.println("Enter destination ");
            String vf = sc.next();

            boolean nju = false;
        
            for(int i=dpid+1;i<ar1.length;i++)
            {
             if(ar1[i].equals(vf))
             {
                 nju=true;

                 break;
             }
         }
          
         if(!nju)
         {
             System.out.println("Enter valid destination mentioned above");
         }
         else 
         {
          boolean dvy =false;

          for(int i=dpid;i<dpid+1;i++)
          {
              for(int j=0;j<ar[0].length;j++)
              {
                  if(ar[i][j]==0)
                  {
                      ar[i][j]=seatid;
                      bk.add(new Booktr(un,nu,vf,usi.get(x).id,seatid,bokid,dpid,"Confirmed"));
                      dvy=true;
                      break;
                  }
              }
          }  
           if(!dvy)
           {
               wi.add(new Booktr(un,nu,vf,usi.get(x).id,seatid,bokid,dpid,"Booked"));
           }
          System.out.println("Your ticket is booked and book id is "+bokid);
          System.out.println("Note book id for future purpose");
          System.out.println("Visit Ticket status for confirmation");
         
          seatid++;
          bokid++;
         }
         }
        }
    }
          System.out.println("Enter to continue");     
          sc.nextLine();
          String aq = sc.nextLine();
          System.out.print("\033[H\033[2J");
          System.out.flush();
          break;


         case 2:
         System.out.println("Enter bookid :");
         String nj = sc.next();
         boolean flag=false;
         int frt=0;
         for(int i=0;i<bk.size();i++)
        {
            if(String.valueOf(bk.get(i).bookid).equals(nj))
            {
                     flag=true;
                     frt=i;
                     break;
            }
        }
        if(flag)
        {
           System.out.println("Ticket is "+bk.get(frt).stat);
        }
        else 
        {
            boolean kio = false;

            for(int i=0;i<wi.size();i++)
            {
                if(String.valueOf(wi.get(i).bookid).equals(nj))
                {
                         kio=true;
                         frt=i;
                         break;
                }
            }
            if(kio)
            {
                System.out.println("Ticket is "+wi.get(frt).stat);
                System.out.println("Your ticket is in waiting list"); 
             }
            else 
            {
               System.out.println("No such booking id");
             } 
        }
        
        
        System.out.println("Enter to continue");     
        sc.nextLine();
        String yu = sc.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush(); 
        break;
        
        case 3:
        System.out.println("Enter bookid :");
         String lo = sc.next();
         boolean fqw=false;
         int wer=0;
         for(int i=0;i<bk.size();i++)
        {

            if(String.valueOf(bk.get(i).bookid).equals(lo))
            {
                     fqw=true;
                     wer=i;
                     break;
            }
        }
        if(fqw)
        {
           canyi(wer);
        }
        else 
        {
            boolean qdf=false;

            int wsd=0;

            for(int i=0;i<wi.size();i++)
            {
    
                if(String.valueOf(wi.get(i).bookid).equals(lo))
                {
                         qdf=true;
                         wsd=i;
                         break;
                }
            }

            if(qdf)
            {
                wi.remove(wsd);
                System.out.println("Ticket cancelled sucessfully");
            }
            else 
            {        
                System.out.println("Invalid book id");
            }
        } 
          
          System.out.println("Enter to continue");     
          sc.nextLine();
          String cd = sc.nextLine();
          System.out.print("\033[H\033[2J");
          System.out.flush(); 
          break;
          case 4:
          homeu();
          break;
          case 5:
          System.out.println("Invalid input");

     }
     homeuse(x);
}

public static void homeu()
{
    System.out.println("Train ticket booking");
    System.out.println("1.New User");
    System.out.println("2.Existing User");
    System.out.println("3.Exit");

    int a = sc.nextInt();

    switch(a)
    {
        case 1:
        System.out.println("Enter name : ");
        String b = sc.next();
        System.out.println("Enter password : ");
        String c = sc.next();

        usi.add(new Usert(b,c,usid));
        System.out.println("Your id is "+usid);
        System.out.println("Note it for future purpose");
        usid++;

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
        for(int i=0;i<usi.size();i++)
        {

            if(usi.get(i).name.equals(e) && usi.get(i).pass.equals(f))
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
            homeuse(hty);
        }
        System.out.println("Enter to continue");
                
         sc.nextLine();
         String ju = sc.nextLine();
         System.out.print("\033[H\033[2J");
         System.out.flush();
         break;
         case 3:
            home();
    }
  homeu();
}

public static void home()
{
    System.out.println("Train ticket booking");
    System.out.println("1.Admin");
    System.out.println("2.User");
    System.out.println("3.Exit");

    int k = sc.nextInt();

    switch(k)
    {
    case 1:
    System.out.println("Admin login");
    System.out.println("Enter Username :");
    String s1 = sc.next();
    System.out.println("Enter Password :");
    String s2=sc.next();
      if(s1.equals("kpradmin") && s2.equals("admin@123"))
      {
         admin();
      }
      else 
      {
         System.out.println("Incorrect username or password");
      }
    break;
    case 2:
        homeu();
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
