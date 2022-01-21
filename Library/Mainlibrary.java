import java.util.*;
import java.util.Collections;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class Mainlibrary {

    static Scanner sc;
    static int usid=2001;
    static int isb=3001;
    static int ordid=4001;
    static ArrayList<User> us = new ArrayList<>();
    static ArrayList<Bok> bks = new ArrayList<>();
    static String cds="";
    static ArrayList<Trans> trs = new ArrayList<>();

    static ArrayList<String> bgf = new ArrayList<>();

    static int bocount=0;

    static LocalDate d1 = LocalDate.parse("2021-12-25");

    static ArrayList<String> cat = new ArrayList<>();

    static String hnm="";

public static void report()
{
    System.out.println("Report");
    System.out.println("1.Books with less quantity");
    System.out.println("2.Books that not borrwowd so far");
    System.out.println("3.Books that are heavily borrowed");
    System.out.println("4.Users with book return late");
    System.out.println("5.Book status");
    System.out.println("6.Exit");
    
    int kh = sc.nextInt();

    switch(kh)
    {
        case 1:
        System.out.println("Books with less quantity");
        boolean bgh = false;
        for(int i=0;i<bks.size();i++)
        {
            if(bks.get(i).qty<2)
            {
                System.out.println(bks.get(i));
                bgh=true;
            }
        }

        if(!bgh)
        {
            System.out.println("There are no books with less quantity");
        }

        System.out.println("Enter to continue");           
         sc.nextLine();
         String sb = sc.nextLine();
         System.out.print("\033[H\033[2J");
         System.out.flush();
        break;

        case 2:
        if(bks.size()==0)
        {
            System.out.println("Currently no books available");
        }
        else 
        {
        boolean gb = false;
        for(int i=0;i<bks.size();i++)
        {
            if(bks.get(i).sal==0)
            {
                System.out.println(bks.get(i));
                gb=true;
            }
        }
        if(!gb)
        {
            System.out.println("There no books with 0 sales");
        }
        }
        System.out.println("Enter to continue");           
         sc.nextLine();
         String sz = sc.nextLine();
         System.out.print("\033[H\033[2J");
         System.out.flush();
         break;
         case 3:
         if(bks.size()==0)
         {
            System.out.println("Currently no books available");
         }
         else
         {
         int fir = bks.get(0).sal;
         int infr =0;
          boolean knh = false;
          for(int i=0;i<bks.size();i++)
          {
             if(bks.get(i).sal>fir)
             {
                 fir=bks.get(i).sal;
                 infr=i;
                 knh=true;
             }
          }
          
          if(knh)
          {
            System.out.println("The book that heavily borrowed are "+bks.get(infr));
          }
          else 
          {
            System.out.println("There are no books with heavily borrowd"); 
          }
         }
          System.out.println("Enter to continue");           
          sc.nextLine();
          String zs = sc.nextLine();
          System.out.print("\033[H\033[2J");
          System.out.flush();

          break;

          case 4:
          if(bks.size()==0)
          {
            System.out.println("Currently no users with book late return");   
          }
          else 
          {
             for(int i=0;i<bgf.size();i++)
             {
                System.out.println(bgf.get(i));   
             }
          }

          System.out.println("Enter to continue");           
          sc.nextLine();
          String nh = sc.nextLine();
          System.out.print("\033[H\033[2J");
          System.out.flush();
          break;

          case 5:
          if(bks.size()==0)
          {
            System.out.println("Currently no books available to view status");   
          }
          else 
          {
           System.out.println("Enter isbn to view status");
           String ca = sc.next();

           boolean xs = false;
           boolean bf = false;
           for(int i=0;i<bks.size();i++)
           {
             if(String.valueOf(bks.get(i).isbn).equals(ca))
             {
                 if(bks.get(i).stat.length()>0)
                 {
                   System.out.println(bks.get(i).stat);
                   xs=true;
                   break;
                 }
                 else 
                 {
                    bf=true;
                    break;
                 }
             }
            }
            if(!xs)
            {
                if(!bf)
                {
                 System.out.println("Invalid isbn");
                }
                else 
                {
                    System.out.println("The status is empty currently");
                }
            }
            
        }
            System.out.println("Enter to continue");           
          sc.nextLine();
          String hn = sc.nextLine();
          System.out.print("\033[H\033[2J");
          System.out.flush();

          break;

          case 6:
          admin();
    }
    report();
}

public static void fine()
{
    System.out.println("Fine management");
    System.out.println("1.Check fine");
    System.out.println("2.Membership card lost");
    System.out.println("3.Book lost");
    System.out.println("4.Exit");

    int ws = sc.nextInt();

    switch(ws)
    {
        case 1:
        if(trs.size()==0)
        {
            System.out.println("Currently no borrowings to check for fine");
        }
        else 
        {
            LocalDate d2;
            long fr;
            for(int i=0;i<trs.size();i++)
            {
              d2=LocalDate.now();

              fr=ChronoUnit.DAYS.between(d1,d2);

              if(fr>15)
              {
                  int vg =0;

                 for(int j=0;j<us.size();j++)
                 {
                     if(String.valueOf(us.get(j).id).equals(String.valueOf(trs.get(i).uid)))
                     {
                          us.get(j).wallet-=(fr-15)*3;
                           us.get(j).fine+="The amount "+(fr-15)*3+" collected as fine for book "+trs.get(i).na+" for "+(fr-15)+" days late return"+"\n";
                          vg=j;
                          break;
                     }
                 }
                 boolean axd = false;

                 if(bgf.size()>0)
                 {
                 for(int k=0;k<bgf.size();k++)
                 {
                    if(bgf.get(k).contains(us.get(vg).name))
                    {
                        axd=true;
                        break;
                    }
                 }

                 if(!axd)
                 {
                     bgf.add("User "+us.get(vg).name+" not return the book"+trs.get(i).na+" on return date");
                 }
                }
                else 
                {
                    bgf.add("User "+us.get(vg).name+" not return the book"+trs.get(i).na+" on return date");
                }
              }
              
            }
            System.out.println("All fines are updated");
        }
        System.out.println("Enter to continue");           
         sc.nextLine();
         String dh = sc.nextLine();
         System.out.print("\033[H\033[2J");
         System.out.flush();
        break;

        case 2:
         System.out.println("Enter the membership id ");
         String vf = sc.next();
         
         boolean ser = false;

         for(int j=0;j<us.size();j++)
         {
            if(String.valueOf(us.get(j).id).equals(vf))
            {
                us.get(j).wallet-=10;
                us.get(j).fine+="The amount "+10+" rs collected as fine for membership card lost";
                ser=true;
                break;
            }
         }

         if(ser)
         {
            System.out.println("Fine allocated for membership card lost");
         }
         else 
         {
            System.out.println("Invalid membership id");
         }
         System.out.println("Enter to continue");           
         sc.nextLine();
         String sq = sc.nextLine();
         System.out.print("\033[H\033[2J");
         System.out.flush();
         break;

         case 3:
         System.out.println("Enter purchase id ");
         String cf = sc.next();

         boolean rse = false;

         for(int j=0;j<trs.size();j++)
         {
            if(String.valueOf(trs.get(j).odid).equals(cf))
            {
                int bg=(int)trs.get(j).price/2;
                int cj=trs.get(j).uid;
                for(int i=0;i<us.size();i++)
                {
                    if(String.valueOf(us.get(i).id).equals(String.valueOf(cj)))
                    {
                        us.get(i).wallet-=bg;
                        us.get(j).fine+="The amount "+bg+" rs collected as fine for book lost";
                        rse=true;
                        break;
                    }
                }
               
            }
         }

         if(rse)
         {
             System.out.println("The fine is issued for book lost");
         }
         else 
         {
             System.out.println("Invalid purchase id");
         }
         System.out.println("Enter to continue");           
         sc.nextLine();
         String dz = sc.nextLine();
         System.out.print("\033[H\033[2J");
         System.out.flush();
         break;

         case 4:
         admin();
    }
    fine();
}

public static void modify(int oi)
{
    System.out.println("1.Edit quantity");
    System.out.println("2.Edit price");
    System.out.println("3.Exit");

    int swe = sc.nextInt();

    switch (swe) {
        case 1:
        System.out.println("1.Add quantity");
        System.out.println("2.Reduce quantity");
        System.out.println("3.Exit");

        int sw = sc.nextInt();


        if(sw==1)
        {
            System.out.println("Enter quantity to add");
            bks.get(oi).qty+=sc.nextInt();
        }
        else 
        {
            System.out.println("Enter quantity to reduce");
            bks.get(oi).qty-=sc.nextInt();
        }
        System.out.println("Quantity updated successfully");
        System.out.println("Enter to continue");
        sc.nextLine();
        String df = sc.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        break;
    
        case 2:
        System.out.println("1.Add price");
        System.out.println("2.Reduce price");

        int s = sc.nextInt();

        if(s==1)
        {
            System.out.println("Enter price to add");
            bks.get(oi).price+=sc.nextInt();
        }
        else 
        {
            System.out.println("Enter price to reduce");
            bks.get(oi).price-=sc.nextInt();
        }
        System.out.println("Price updated successfully");
        System.out.println("Enter to continue");
        sc.nextLine();
        String jg = sc.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();

        break;
        case 3:
        admin();
    }
    modify(oi);
}   

public static void review()
{
    System.out.println("Product overview");

    System.out.println("1.Book review by search");
    System.out.println("2.All books review");
    System.out.println("3.Exit");

    int fw=sc.nextInt();

    switch(fw)
    {
        case 1:
         System.out.println("Enter the book title ");
         String or=sc.next();

         boolean md=false;
         for(int i=0;i<bks.size();i++)
         {
             if(String.valueOf(bks.get(i).title).equals(or))
             {
                 System.out.println(bks.get(i));
                 md=true;
            
             }
         }
         
         if(!md)
         {
             System.out.println("Book does not exist");
         }
         System.out.println("Enter to continue");           
         sc.nextLine();
         String lo = sc.nextLine();
         System.out.print("\033[H\033[2J");
         System.out.flush();
         break;

         case 2:
         String[] rebo = new String[bks.size()];
           if(bks.size()==0)
           {
             System.out.println("Currently no books for review");
           }
           else 
           {
              for(int i=0;i<bks.size();i++)
              {
                  rebo[i]="Book title : "+bks.get(i).title+" Book author : "+bks.get(i).author+" Book price :"+bks.get(i).price+" Book isbn : "+bks.get(i).isbn+" Book quantity : "+bks.get(i).qty+" Sales : "+bks.get(i).sal;
              }

              Arrays.sort(rebo);
        
           }
           for(int i=0;i<rebo.length;i++)
           {
              System.out.println(rebo[i]);
           }
            
         System.out.println("Enter to continue");       
         sc.nextLine();
         String sd = sc.nextLine();
         System.out.print("\033[H\033[2J");
         System.out.flush();
         
           break;
           case 3:
           System.out.print("\033[H\033[2J");
           System.out.flush();
           admin();
    }
    review();
}

public static void admin()
{
    System.out.println("Library Admin");
    System.out.println("1.Add a book");
    System.out.println("2.Modify book");
    System.out.println("3.Delete book");
    System.out.println("4.Add user");
    System.out.println("5.Review books");
    System.out.println("6.Manage fine");
    System.out.println("7.Reports");
    System.out.println("8.Exit");

    int er = sc.nextInt();
    switch(er)
    {
        case 1:
        System.out.println("Add book");
        System.out.println("Enter book title :");
        String a=sc.next();
        System.out.println("Enter book author :");
        String b=sc.next();
        System.out.println("Enter book price :");
        int c=sc.nextInt();
        System.out.println("Enter book quantity :");
        int e=sc.nextInt();

       bks.add(new Bok(a,b,c,isb,e,0,""));

        System.out.println("The book added successfully");
        System.out.println("The book isbn is "+isb);
        System.out.println("Note it for future access purpose");

        isb++;
        System.out.println("Enter to continue");
        sc.nextLine();
        String df = sc.nextLine();
         System.out.print("\033[H\033[2J");
         System.out.flush();
        break;
        case 2:
        if(bks.size()==0)
        {
            System.out.println("Currently no books available to edit");           
        }
        else 
        {
        System.out.println("Enter the isbn : ");
          
        String re = sc.next();
  
        boolean hw = false;

        int xs=0;
         
          for(int i=0;i<bks.size();i++)
          {
              if(String.valueOf(bks.get(i).isbn).equals(re))
              {
                 xs=i;
                 hw=true;
                 break;
              }
          }

          if(hw)
          {
            modify(xs);
          }
          else 
          {
            System.out.println("Invalid isbn");
          }
        }
          System.out.println("Enter to continue");
             sc.nextLine();
             String ho = sc.nextLine();
              System.out.print("\033[H\033[2J");
              System.out.flush();
          break;
        case 3:

        System.out.println("Remove book");

             if(bks.size()==0)
             {
                System.out.println("Currently no book available");
             }

             else 
             {
             System.out.println("Enter the isbn to remove :");

             String k=sc.next();

             boolean fag=false;
             for(int i=0;i<bks.size();i++)
             {
                 if(String.valueOf(bks.get(i).isbn).equals(k))
                 {
                     bks.remove(i);
                     fag=true;
                     break;
                 }
             }
             if(fag)
             {
                 System.out.println("Book removed successfully");
             }
             else 
             {
                 System.out.println("The book does not exist");
             }

            }
             System.out.println("Enter to continue");
             sc.nextLine();
             String fd = sc.nextLine();
              System.out.print("\033[H\033[2J");
              System.out.flush();
              break;
        case 4:
        System.out.println("Enter username");
        String tyu = sc.next();
        System.out.println("Enter password");
        String uyt = sc.next();
        System.out.println("Enter 1500 or above for initial installment for purchase");
        int sfr = sc.nextInt();

        if(sfr>=1500)
        {
        us.add(new User(tyu,uyt,usid,sfr,""));

        System.out.println("The user added successfully");
        System.out.println("User membership card is issued");
        System.out.println("The membership id is "+usid);
        System.out.println("Note it for future login purpose");
        usid++;
        }
        else 
        {
            System.out.println("You should deposit minimum 1500");
        }
        System.out.println("Enter to continue");
        sc.nextLine();
        String gk = sc.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        break;

        case 5:
         review();
         break;

        case 6:
        fine();
        break;

        case 7:
        report();
        break;
        case 8:
          home();
    }
  admin();
}

public static void uservie(int x)
{
    System.out.println("Purchase");
    System.out.println("1.Add to cart");
    System.out.println("2.Purchase using wallet");
    System.out.println("3.Exit");

    int sde = sc.nextInt();

    switch(sde)
    {
        case 1:
        System.out.println("1.By search a book");
        //System.out.println("2.By all books review");
        System.out.println("3.Exit");

        int fw=sc.nextInt();


      if(fw==1)
      {
       System.out.println("Enter the book title ");
       String or=sc.next();

       boolean md=false;
       for(int i=0;i<bks.size();i++)
       {
           if(String.valueOf(bks.get(i).title).equals(or))
           {
               System.out.println("Book title : "+bks.get(i).title+" Book author : "+bks.get(i).author+"Book isbn :"+bks.get(i).isbn+" Book price : "+bks.get(i).price+" Book quantity : "+bks.get(i).qty);
               md=true;
           }
       }
       
       if(!md)
       {
           System.out.println("Book does not exist");
       }
       else 
       {
          System.out.println("Enter isbn id from list above");

          String gh = sc.next();
          
          boolean sdf=false;
          int gbh=0;

          for(int i=0;i<bks.size();i++)
          {
              if(String.valueOf(bks.get(i).isbn).equals(gh))
              {
                   bks.get(i).qty-=1;
                   cat.add("Book title : "+bks.get(i).title+" Book author : "+bks.get(i).author+" Book price :"+bks.get(i).price+" Book isbn : "+bks.get(i).isbn+" Book quantity : "+1+"User id : "+us.get(x).id);
                   sdf=true;
                   gbh=i;
                   break;
              }
          }

          if(sdf)
          {
              System.out.println("Book added to cart successfully");
              bks.get(gbh).stat+="The book added to cart by "+us.get(x).name+"\n";  
          }
          else 
          {
            System.out.println("Invalid isbn");
          }
        }
        System.out.println("Enter to continue");           
    sc.nextLine();
    String hn = sc.nextLine();
    System.out.print("\033[H\033[2J");
    System.out.flush();
    }
    
        break;

        case 2:
          System.out.println("1.By search a book");
          //System.out.println("2.By all books review");
          System.out.println("3.Exit");

          int ke=sc.nextInt();


        if(ke==1)
        {
         System.out.println("Enter the book title ");
         String or=sc.next();

         boolean md=false;
         for(int i=0;i<bks.size();i++)
         {
             if(String.valueOf(bks.get(i).title).equals(or))
             {
                System.out.println("Book title : "+bks.get(i).title+" Book author : "+bks.get(i).author+"Book isbn :"+bks.get(i).isbn+" Book price : "+bks.get(i).price+" Book quantity : "+bks.get(i).qty);
                 md=true;
             }
         }
         
         if(!md)
         {
             System.out.println("Book does not exist");
         }
         else 
         {
            System.out.println("Enter isbn id from list above for purchase");

            String gh = sc.next();
            
            boolean sdf=false;
            boolean kjh = false;
            int gbh=0;

            for(int i=0;i<bks.size();i++)
            {
                if(String.valueOf(bks.get(i).isbn).equals(gh))
                {
                   if(us.get(x).wallet>=500 && bocount<=3 && !hnm.equals(gh))
                   {
                     bks.get(i).qty-=1;
                     sdf=true;
                     hnm=gh;
                     gbh=i;
                     break;
                   }
                   else 
                   {
                       kjh=true;
                       break;
                   }
                  
                }
            }

            if(sdf)
            {
                trs.add(new Trans(bks.get(gbh).title,bks.get(gbh).author,bks.get(gbh).isbn,ordid,us.get(x).id,bks.get(gbh).price,bks.get(gbh).qty));
                System.out.println("Book purchased successfully");
                us.get(x).wallet-=bks.get(gbh).price;
                bks.get(gbh).sal+=1;
                bks.get(gbh).stat+="The book borrowed by "+us.get(x).name+"\n";
                System.out.println("Your purchase id is "+ordid); 
                System.out.println("Note it for future purpose");
                ordid++;
                bocount++;
            }
            else 
            {
                if(kjh)
                {
                    if(bocount>3)
                    {
                        System.out.println("One user cannot borrow more than three books at a time");
                        System.out.print("\033[H\033[2J");
                        System.out.flush(); 
                        
                    }
                    else if(hnm.equals(gh))
                    {
                        System.out.println("One user cannot borrow same book twice"); 
                    }
                    else 
                    {
                     System.out.println("Your wallet balance is less than 500");  
                     System.out.println("You should hava an minimum 500 in wallet for purchase");  
                    }
                }
                else 
                {
                 System.out.println("Invalid isbn id");  
                }
            }
         }
         
        }
        
        else if(ke==3)
        {
           System.out.print("\033[H\033[2J");
           System.out.flush();
           uservie(x);
        }
        System.out.println("Enter to continue");           
         sc.nextLine();
         String jx = sc.nextLine();
         System.out.print("\033[H\033[2J");
         System.out.flush();
        break;
        case 3:
          homuse(x);
        }

    uservie(x);
}

public static void rep(int u)
{
    System.out.println("User report");
    System.out.println("1.Fines");
    System.out.println("2.Previous borrowings");
    System.out.println("3.Exit");

    int kn = sc.nextInt();

    switch(kn)
    {
        case 1:
         System.out.println("Enter user id : ");
         String xj = sc.next();

         boolean md=false;
         boolean al=false;
            for(int i=0;i<us.size();i++)
            {
                if(String.valueOf(us.get(i).id).equals(xj))
                {
                    if(us.get(i).fine.length()>0)
                    {
                     System.out.println(us.get(i).fine);
                     md=true;
                     break;
                    }
                    else 
                    {
                        al=true;
                        break;
                    }
                }
            }
            if(!md) 
            {
                if(al)
                {
                    System.out.println("Currently no fine available");
                }
                else 
                {
                    System.out.println("Invalid user id");
                }
            }
            System.out.println("Enter to continue");
                
         sc.nextLine();
         String cs = sc.nextLine();
         System.out.print("\033[H\033[2J");
         System.out.flush();
          break;
        case 2:
        System.out.println("Enter user id : ");
         String jx = sc.next();

         ArrayList<String> ubte = new ArrayList<>();

         boolean dn=false;
         for(int i=0;i<trs.size();i++)
         {
             if(String.valueOf(trs.get(i).uid).equals(jx))
             {
                ubte.add("Book name : "+trs.get(i).na+" Book author : "+trs.get(i).auth+" Book price "+trs.get(i).price+" Book qty : "+trs.get(i).qty+" Book isbn "+trs.get(i).isb);

                dn=true;
             }
         }

         if(!dn)
         {
            boolean nd=false;
            for(int i=0;i<cat.size();i++)
            {
                if(cat.get(i).contains(jx))
                {
                   ubte.add("Book name : "+trs.get(i).na+" Book author : "+trs.get(i).auth+" Book price "+trs.get(i).price+" Book qty : "+trs.get(i).qty+" Book isbn "+trs.get(i).isb);
   
                   nd=true;
                }
            }
   
            if(!nd)
            {
              System.out.println("Invalid user id");
            }
            else
            {
                for(int i=0;i<ubte.size();i++)
               {
                 System.out.println(ubte.get(i));
               }
            }
        } 
         
         else 
         {
            for(int i=0;i<ubte.size();i++)
            {
               System.out.println(ubte.get(i));
            }
         }
         System.out.println("Enter to continue");
                
         sc.nextLine();
         String xm = sc.nextLine();
         System.out.print("\033[H\033[2J");
         System.out.flush();
          break;
         case 3:
          homuse(u);
    }
}

public static void homuse(int x)
{
    System.out.println("User");
    System.out.println("Alert!! - For book lost,return delay tha amount will be atomatically reduced from wallet");
    System.out.println("1.Purchase books");
    System.out.println("2.View cart and edit cart");
    System.out.println("3.Wallet");
    System.out.println("4.Report");
    System.out.println("5.Exit");

    int du = sc.nextInt();

    switch(du)
    {
        case 1:
        uservie(x);
        break;
        case 2:
        car(x);
        break;
        case 3:
        System.out.println("Your wallet balance is "+us.get(x).wallet);

        System.out.println("1.Add amount");
        System.out.println("2.Exit");

        int de = sc.nextInt();

        if(de==1)
        {
            System.out.println("Enter amount to add");
            int ed = sc.nextInt();
            us.get(x).wallet+=ed;

            System.out.println("Added succesfully");

            System.out.println("Enter to continue");
                
         sc.nextLine();
         String cs = sc.nextLine();
         System.out.print("\033[H\033[2J");
         System.out.flush();
        }
        
        break;

        case 4:
        rep(x);
        break;
        case 5:
        use();
        

    }
    homuse(x);
}

public static void car(int x)
{
    if(cat.size()==0)
    {
        System.out.println("Currently no items in cart");
    }
    else 
    {
        for(int i=0;i<cat.size();i++)
        {
            System.out.println(cat.get(i));
        }

        System.out.println("1.Remove items from cart");
        System.out.println("2.Exit");
        int eru = sc.nextInt();

        if(eru==1)
        {
            System.out.println("Enter isbn to remove");
            String wsd = sc.next();

            boolean md=false;
            for(int i=0;i<bks.size();i++)
            {
                if(cat.get(i).contains(wsd))
                {
                    cat.remove(i);
                    md=true;
                }
            }

             if(md) 
             {
                System.out.println("Book removed from cart");
                for(int i=0;i<bks.size();i++)
               {
                   if(String.valueOf(bks.get(i).isbn).equals(wsd))
                   {
                       bks.get(i).qty+=1;
                       break;
                   }
               }
             }
             else 
             {
                 System.out.println("Invalid isbn");
             }
        }
        else 
        {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            homuse(x);
        }
    }

    System.out.println("Enter to continue");
                
     sc.nextLine();
    String cs = sc.nextLine();
    System.out.print("\033[H\033[2J");
    System.out.flush();
}

public static void use()
{
    System.out.println("Library Management");
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
        System.out.println("Enter atleast 1500 for initial installment");
        int sfr = sc.nextInt();

        if(sfr>=1500)
        {
        us.add(new User(b,c,usid,sfr,""));
        System.out.println("Your membership card is issued");
        System.out.println("Your membership id is "+usid);
        System.out.println("Note it for future purpose");
        usid++;
        }
        else 
        {
            System.out.println("You should deposit 1500 during registration");
        }
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
            homuse(hty);
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
    use();
}

    public static void home()
    {
       System.out.println("Library");
       System.out.println("1.Admin login");
       System.out.println("2.User login");
       System.out.println("3.Exit");

       System.out.println("Enter your choice");
       int x = sc.nextInt();

       switch(x)
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
              use();
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
