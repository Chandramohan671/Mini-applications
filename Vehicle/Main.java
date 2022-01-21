import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main {
    static ArrayList<User> use = new ArrayList<>();
    static ArrayList<Veh> vehi = new ArrayList<>();
    static ArrayList<Rent> ren = new ArrayList<>();
    static ArrayList<Veh> cat = new ArrayList<>();
    static ArrayList<Veh> ser = new ArrayList<>();

    static LocalDate d1=LocalDate.parse("2022-01-16");
    static int usd=1001;
    static int vid=2001;
    static String dr="";
    static String cs="";
    static String ki="";
    static String ko="";
    static int rid=3001;

    public static void valid()
    {
        System.out.println("1.Vehicle late return");
        System.out.println("2.Vehicle runs more than limited kilometers");
        System.out.println("3.Car damages");
        System.out.println("4.Exit");
        int wk=sc.nextInt();

        switch(wk)
        {
            case 1:
            System.out.println();
              if(ren.size()==0)
              {
                System.out.println("Currently no vehicles return");
              }
              else 
              {
                  LocalDate d2=LocalDate.now();
                  long cr;
                  for(int i=0;i<ren.size();i++)
                  {
                     cr=ChronoUnit.DAYS.between(d1,d2);
                     if(cr>0)
                     {
                         for(int j=0;j<use.size();j++)
                         {
                             if(String.valueOf(use.get(j).id).equals(String.valueOf(ren.get(i).uid)))
                             {
                                use.get(j).wall-=cr*10;
                                vehi.add(new Veh(ren.get(i).btype,ren.get(i).bmodel,ren.get(i).veid,ren.get(i).rcharge,ren.get(i).sat,ren.get(i).tra,ren.get(i).fin));
                                use.get(j).fine+="The fine for vehicle "+ren.get(i).bmodel+" late return is "+cr*10+"\n";
                                System.out.println("The fine is collected from "+use.get(j).name+" for late return for a vehicle "+ren.get(i).bmodel);
                                break;
                             }
                         }
                     }
                  }
                  System.out.println("Additional charge is collected for vehicle late return");
              }
              System.out.println("Enter to continue");
              sc.nextLine();
              String jg = sc.nextLine();
              System.out.print("\033[H\033[2J");
              System.out.flush();
              break;
              case 2:
              System.out.println();
              if(ren.size()==0)
              {
                System.out.println("Currently no vehicles return");
              }
              else 
              {
                System.out.println("Additional charge is collected for vehicles crossing the limited kilometers");
                boolean qas=false;
                for(int i=0;i<ren.size();i++)
              {
                System.out.println("Vehicle name : "+ren.get(i).bmodel+" Vehicle id : "+ren.get(i).veid+" User id : "+ren.get(i).uid);      
                System.out.println("Enter the kilometers travel by vehicle");
                int kio=sc.nextInt();

                if(kio>500)
                {
                    for(int j=0;j<use.size();j++)
                    {
                             if(String.valueOf(use.get(j).id).equals(String.valueOf(ren.get(i).uid)))
                             {
                                use.get(j).wall-=(int)(ren.get(i).rcharge/100)*15;
                                use.get(j).fine+="The fine for vehicle "+ren.get(i).bmodel+" crossing 500 kms is "+(ren.get(i).rcharge/100)*15+"\n";
                                qas=true;
                                System.out.println("The fine is collected from "+use.get(j).name+" for crossing 500 kms for a vehicle "+ren.get(i).bmodel);
                                for(int k=0;k<vehi.size();k++)
                                {
                                    if(String.valueOf(vehi.get(k).id).equals(String.valueOf(ren.get(i).veid)))
                                    {
                                        vehi.get(k).travel+=kio;
                                        vehi.get(k).fines+=(ren.get(i).rcharge/100)*15;
                                        break;
                                    }
                                }
                                break;
                             }
                    }
                }

              }
              if(qas)
              {
                System.out.println("Additional charge is collected for vehicles crossing kilometer limit");
              }
              else 
              {
                System.out.println("Currently no vehicles cross the limited kilometers");
              }
            }
            System.out.println("Enter to continue");
            sc.nextLine();
            String gj = sc.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            break;

            case 3:
            System.out.println();
            if(ren.size()==0)
            {
                System.out.println("Currently no vehicles available");
            }
            else 
            {
                System.out.println("1.Damage");
                System.out.println("2.No damage");
                int sl =sc.nextInt();

                if(sl==1)
                {
                    System.out.println("Enter the vehicle id");
                    String hq = sc.next();
                    System.out.println("Enter the vehicle type");
                    String li = sc.next();
                    System.out.println("Enter the user id");
                    String hd = sc.next();

                    boolean sd=false;
                    int sw=0;
                    for(int i=0;i<ren.size();i++)
                    {
                        if(String.valueOf(ren.get(i).veid).equals(hq) && ren.get(i).btype.equals(li))
                        {
                          sd=true;
                          sw=i;
                          break;
                        }
                    }

                    boolean zd=false;
                    int nd=0;
                    for(int i=0;i<use.size();i++)
                    {
                        if(String.valueOf(use.get(i).id).equals(hd))
                        {
                          zd=true;
                          nd=i;
                          break;
                        }
                    }

                    if(sd && zd)
                    {
                        System.out.println("Enter the level of damage");
                        String qh = sc.next();
                    if(qh.equals("Low"))
                    {
                      if(vehi.get(sw).fines==0)
                      {
                        use.get(nd).wall-=(vehi.get(sw).charge/100)*20;
                        use.get(nd).fine+="The fine for car "+vehi.get(sw).model+" is "+(vehi.get(sw).charge/100)*20+" with damage of low level"+"\n"; 
                        System.out.println("The fine for car "+vehi.get(sw).model+" is "+(vehi.get(sw).charge/100)*20+" with damage of low level");
                    }
                      else 
                      {
                        use.get(nd).wall-=(vehi.get(sw).fines/100)*20;
                        use.get(nd).fine+="The fine for car "+vehi.get(sw).model+" is "+(vehi.get(sw).fines/100)*20+" with damage of low level"+"\n"; 
                        System.out.println("The fine for car "+vehi.get(sw).model+" is "+(vehi.get(sw).fines/100)*20+" with damage of low level");
                    }
                    }
                    else if(qh.equals("Medium"))
                    {
                        if(vehi.get(sw).fines==0)
                       { 
                        use.get(nd).wall-=(vehi.get(sw).charge/100)*50;
                        use.get(nd).fine+="The fine for car "+vehi.get(sw).model+" is "+(vehi.get(sw).charge/100)*50+" with damage of medium level"+"\n"; 
                        System.out.println("The fine for car "+vehi.get(sw).model+" is "+(vehi.get(sw).charge/100)*50+" with damage of medium level");
                       }
                      else 
                      {
                        use.get(nd).wall-=(vehi.get(sw).fines/100)*50;
                        use.get(nd).fine+="The fine for car "+vehi.get(sw).model+" is "+(vehi.get(sw).fines/100)*50+" with damage of medium level"+"\n"; 
                        System.out.println("The fine for car "+vehi.get(sw).model+" is "+(vehi.get(sw).fines/100)*50+" with damage of medium level");
                    }
                    }
                    else if(qh.equals("High"))
                    {
                       if(vehi.get(sw).fines==0)
                      {
                        use.get(nd).wall-=(vehi.get(sw).charge/100)*75;
                        use.get(nd).fine+="The fine for car "+vehi.get(sw).model+" is "+(vehi.get(sw).charge/100)*75+" with damage of high level"+"\n"; 
                        System.out.println("The fine for car "+vehi.get(sw).model+" is "+(vehi.get(sw).charge/100)*75+" with damage of high level");
                    }
                      else 
                      {
                        use.get(nd).wall-=(vehi.get(sw).fines/100)*75;
                        use.get(nd).fine+="The fine for car "+vehi.get(sw).model+" is "+(vehi.get(sw).fines/100)*75+" with damage of high level"+"\n"; 
                        System.out.println("The fine for car "+vehi.get(sw).model+" is "+(vehi.get(sw).fines/100)*75+" with damage of high level");
                    }
                    }
                    System.out.println("Additional charge for car damage is collected");
                  }
                  else 
                  {
                    System.out.println("Invalid vehicle id or user id");
                  }
                }

            }
            System.out.println("Enter to continue");
            sc.nextLine();
            String nf = sc.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            break;
            case 4:
            admin();
              
        }
    }

    public static void modi(int u)
    {
        System.out.println("1.Edit rental amount");
        System.out.println("2.Exit");

      int sw = sc.nextInt();

    switch (sw) {
        case 1:
        System.out.println();
        System.out.println("1.Add rental amount");
        System.out.println("2.Reduce rental amount");

        int w = sc.nextInt();

        if(w==1)
        {
            System.out.println("Enter amount to add");
            vehi.get(u).charge+=sc.nextInt();
        }
        else 
        {
            System.out.println("Enter amount to reduce");
            vehi.get(u).charge-=sc.nextInt();
        }
        System.out.println("Amount updated successfully");
        System.out.println("Enter to continue");
        sc.nextLine();
        String jg = sc.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();

        break;
        case 2:
        System.out.println();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        admin();
    }
    modi(u);
    }

    public static void admin()
    {
        System.out.println("Vehicle Rental Admin");
        System.out.println("1.Add a vehicle");
        System.out.println("2.Modify vehicle");
        System.out.println("3.Delete vehicle");
        System.out.println("4.Review all vehicles");
        System.out.println("5.Search a vehicle");
        System.out.println("6.Edit user wallet deposit");
        System.out.println("7.Service the vehicles");
        System.out.println("8.Vehicle return and fine regulation");
        System.out.println("9.Vechicles not rented at all");
        System.out.println("10.Exit");

        int vg = sc.nextInt();
        switch(vg)
        {
            case 1:
            System.out.println();
            System.out.println("Add Vehicle");
            System.out.println("Enter Vehicle type :");
            String a=sc.next();
            System.out.println("Enter Vehicle name :");
            String b=sc.next();
            System.out.println("Enter rental charge :");
            int c=sc.nextInt();
    
            vehi.add(new Veh(a,b,vid,c,"",0,0));
            System.out.println("The vehicle added successfully");
            System.out.println("The vehicle id is "+vid);
            System.out.println("Note it for future access purpose");
            vid++;
            System.out.println("Enter to continue");
                
            sc.nextLine();
            String fd = sc.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            break;
            case 2:
            System.out.println();
            System.out.println("Enter the vehicle id : ");
          
            String er = sc.next();
      
            boolean hw = false;
    
            int xs=0;
             
              for(int i=0;i<vehi.size();i++)
              {
                  if(String.valueOf(vehi.get(i).id).equals(er))
                  {
                     xs=i;
                     hw=true;
                     break;
                  }
              }
    
              if(hw)
              {
                modi(xs);
              }
              else 
              {
                System.out.println("Invalid vehicle id");
              }
              System.out.println("Enter to continue");
              sc.nextLine();
              String ho = sc.nextLine();
              System.out.print("\033[H\033[2J");
              System.out.flush();
              break;
         case 3:
         System.out.println(); 
        System.out.println("Remove vehicle");
        if(vehi.size()==0)
        {
          System.out.println("Currently no vehicle available to remove");
        }
        else 
        {
        System.out.println("Enter the vehicle id to remove :");

        String k=sc.next();

        boolean flag=false;
        for(int i=0;i<vehi.size();i++)
        {
            if(String.valueOf(vehi.get(i).id).equals(k))
            {
                vehi.remove(i);
                flag=true;
                break;
            }
        }
        if(flag)
        {
            System.out.println("Vehicle removed successfully");
        }
        else 
        {
            System.out.println("The vehicle does not exist");
        }

       }
        System.out.println("Enter to continue");
        sc.nextLine();
        String kn = sc.nextLine();
         System.out.print("\033[H\033[2J");
         System.out.flush();
         break;
        case 4:
        System.out.println();
        String[] bo = new String[vehi.size()];
        if(vehi.size()==0)
        {
          System.out.println("Currently no vehicle available for review");
        }
        else 
        {
          
           for(int i=0;i<vehi.size();i++)
           {
               bo[i]="Vehicle type : "+vehi.get(i).type+" Vehicle name : "+vehi.get(i).model+" Rental amount :"+vehi.get(i).charge+" Vehicle id : "+vehi.get(i).id;
           }

           Arrays.sort(bo);
        }
        for(int i=0;i<bo.length;i++)
        {
           System.out.println(bo[i]);
        }
         
      System.out.println("Enter to continue");       
      sc.nextLine();
      String sd = sc.nextLine();
      System.out.print("\033[H\033[2J");
      System.out.flush();
      
        break;
        case 5:
        System.out.println();
        System.out.println("Enter the vehicle name ");
        String or=sc.next();

        boolean md=false;
        for(int i=0;i<vehi.size();i++)
        {
            if(String.valueOf(vehi.get(i).model).equals(or))
            {
                System.out.println(vehi.get(i));
                md=true;
           
            }
        }
        
        if(!md)
        {
            System.out.println("Vehicle does not exist");
        }
        System.out.println("Enter to continue");           
        sc.nextLine();
        String lo = sc.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        break;
        case 6:
        System.out.println();
        System.out.println("Enter the user id to edit the wallet");
        String jk = sc.next();
        boolean fg=false;
        int hty=0;
        for(int i=0;i<use.size();i++)
        {
            if(String.valueOf(use.get(i).id).equals(jk))
            {
                     fg=true;
                     hty=i;
                     break;
            }
        }
        if(!fg)
        {
                System.out.println("Incorrect user id");
        }
        else 
        {
            System.out.println("1.Add amount");
            System.out.println("2.Reduce amount");
    
            int w = sc.nextInt();
    
            if(w==1)
            {
                System.out.println("Enter amount to add");
                use.get(hty).wall+=sc.nextInt();
            }
            else 
            {
                System.out.println("Enter amount to reduce");
                use.get(hty).wall-=sc.nextInt();
            }
            System.out.println("Amount updated successfully");
        }
        
        System.out.println("Enter to continue");
        sc.nextLine();
        String jg = sc.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        break;
        
        case 7:
        System.out.println();
        service();
        System.out.println("Enter to continue");
        sc.nextLine();
        String ka = sc.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        break;
        case 8:
        System.out.println();
        valid();
        System.out.println("Enter to continue");
        sc.nextLine();
        String sy = sc.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        break;
        case 9:
        System.out.println();
        boolean dwr=false;
        for(int i=0;i<vehi.size();i++)
        {
            for(int j=0;j<ren.size();j++)
            {
                if(!String.valueOf(vehi.get(i).id).equals(String.valueOf(ren.get(j).veid)))
                {
                    System.out.println(vehi.get(i));
                    dwr=true;
                    break;
                }
            }
        }
        if(!dwr)
        {
            if(ren.size()==0)
            {
                for(int i=0;i<vehi.size();i++)
                {
                    System.out.println(vehi.get(i));
                }
            }
            else 
            {
                System.out.println("Currently all vehicles are rented");
            }
        }
        System.out.println("Enter to continue");
        sc.nextLine();
        String sk = sc.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        break;
        case 10:
          home();
        }
        admin();
    }

public static void service()
{
    System.out.println("1.Check for vehicle status to service");
    System.out.println("2.Service the vehicles");
    System.out.println("3.Exit");
    int dw = sc.nextInt();

    switch(dw)
    {
        case 1:
        if(vehi.size()==0)
        {
            System.out.println("Currently no vehicle available");
        }
        else 
        {
            boolean her=false;
            for(int i=0;i<vehi.size();i++)
            {
                if(vehi.get(i).type.equals("Bike") && vehi.get(i).travel%1500==0 && vehi.get(i).travel!=0)
                {
                    ser.add(new Veh(vehi.get(i).type,vehi.get(i).model,vehi.get(i).id,vehi.get(i).charge,vehi.get(i).status,vehi.get(i).travel,vehi.get(i).fines));
                    vehi.remove(i);
                    her=true;
                }
                else if(vehi.get(i).type.equals("Car") && vehi.get(i).travel%3000==0 && vehi.get(i).travel!=0)
                {
                    ser.add(new Veh(vehi.get(i).type,vehi.get(i).model,vehi.get(i).id,vehi.get(i).charge,vehi.get(i).status,vehi.get(i).travel,vehi.get(i).fines));
                    vehi.remove(i);
                    her=true;
                }
            }

            if(her)
            {
             System.out.println("Service stage vehicles ready for service and status updated successfully");
            }
            else 
            {
                System.out.println("Currently no vehicle at service stage");
            }
        }
        System.out.println("Enter to continue");
        sc.nextLine();
        String ka = sc.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        break;
        case 2:
        if(ser.size()==0)
        {
            System.out.println("Currently no vehicle available for service");
        }
        else 
        {
            boolean sjk=false;

            for(int i=0;i<ser.size();i++)
            {
                System.out.println(ser.get(i));
                sjk=true;
            }
            if(sjk)
            {
             System.out.println("The service staged vehicles are listed above");
             System.out.println("1.Proceed to service the vehicles");
            System.out.println("2.Exit");

            int qj = sc.nextInt();

            if(qj==1)
            {
                for(int i=0;i<ser.size();i++)
                {
                    ser.get(i).travel=0;
                    vehi.add(new Veh(ser.get(i).type,ser.get(i).model,ser.get(i).id,ser.get(i).charge,ser.get(i).status,ser.get(i).travel,ser.get(i).fines));
                    ser.remove(i);
                }
            }
            System.out.println("The vehicles serviced successfully");
            }
            else 
            {
                System.out.println("No vehicles available for service");
            }

        }
        System.out.println("Enter to continue");
        sc.nextLine();
        String ak = sc.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        break;
        case 3:
        admin();
    }
    service();
}

public static void huse(int br)
{
    System.out.println("1.Rent a vehicle");
    System.out.println("2.Add a vehicle to cart");
    System.out.println("3.Remove a vehicle from cart");
    System.out.println("4.View cart");
    System.out.println("5.Wallet balance");      
    System.out.println("6.Previous rentals");
    System.out.println("7.Fines");
    System.out.println("8.Exit");

    int km = sc.nextInt();
    int pos=0;
    switch(km)
    {
        case 1:
        if(vehi.size()==0)
        {
            System.out.println("1.Currently no vehicle available for renting");
        }
        else 
        {
            for(int i=0;i<vehi.size();i++)
            {
                System.out.println("Vehicle type : "+vehi.get(i).type+" Vehicle name : "+vehi.get(i).model+" Vehicle id :"+vehi.get(i).id+" Vehicle charge : "+vehi.get(i).charge);
            }
            System.out.println("All availble vehicles displayed above");
            System.out.println("One user cannot rent more than one bike and one car at a time");

            System.out.println("Enter vehicle id from displayed list");
            String kg = sc.next();

            boolean md=false;
         for(int i=0;i<vehi.size();i++)
         {
             if(String.valueOf(vehi.get(i).id).equals(kg))
             {
                 md=true;
                 pos=i;
                 break;
             }
         }
         
         if(md)
         {
            System.out.println("Vehicle type : "+vehi.get(pos).type+" Vehicle name : "+vehi.get(pos).model+" Vehicle id :"+vehi.get(pos).id+" Vehicle charge : "+vehi.get(pos).charge);
            
            System.out.println("1.Proceed to rent");
            System.out.println("2.Exit");
            int vf=sc.nextInt();

            if(vf==1)
            {
              if(vehi.get(pos).type.equals("Bike"))
              {
                  if(use.get(br).wall>=3000 && !vehi.get(pos).type.equals(dr))
                  {
                    System.out.println(vehi.get(pos).model+" rented successfully");
                    use.get(br).renstat+="Rent a "+vehi.get(pos).model+" and charge is "+vehi.get(pos).charge+" and vehicle id is "+vehi.get(pos).id+"\n";
                    ren.add(new Rent(vehi.get(pos).type,vehi.get(pos).model,vehi.get(pos).charge,vehi.get(pos).id,rid,use.get(br).id,vehi.get(pos).status,vehi.get(pos).travel,vehi.get(pos).fines));
                    System.out.println("Rented id is "+rid);
                    System.out.println("Note it for future access purpose");
                    use.get(br).wall-=vehi.get(pos).charge;
                    vehi.remove(pos);
                    dr="Bike";
                    rid++;
                  }
                  else 
                  {
                     if(use.get(br).wall<3000)
                     {
                        System.out.println("You should have an minimum deposit of 3000 for bike rent");
                        System.out.println("Your wallet deposit is "+use.get(br).wall);
                     }
                     else 
                     {
                        System.out.println("You can rent a bike only once at a time");
                     }
                  }
              }
              else if(vehi.get(pos).type.equals("Car"))
              {
                if(use.get(br).wall>=10000 && !vehi.get(pos).type.equals(cs))
                {
                  System.out.println(vehi.get(pos).model+" rented successfully");
                  use.get(br).renstat+="Rent a "+vehi.get(pos).model+" and charge is "+vehi.get(pos).charge+" and vehicle id is "+vehi.get(pos).id+"\n";
                  ren.add(new Rent(vehi.get(pos).type,vehi.get(pos).model,vehi.get(pos).charge,vehi.get(pos).id,rid,use.get(br).id,vehi.get(pos).status,vehi.get(pos).travel,vehi.get(pos).fines));
                  System.out.println("Rented id is "+rid);
                  System.out.println("Note it for future access purpose");
                  cs="Car";
                  use.get(br).wall-=vehi.get(pos).charge;
                  vehi.remove(pos);
                  rid++;
                }
                else 
                {
                   if(use.get(br).wall<10000)
                   {
                      System.out.println("You should have an minimum deposit of 10000 for car rent");
                      System.out.println("Your wallet deposit is "+use.get(br).wall);
                   }
                   else 
                   {
                      System.out.println("You can rent a car only once at a time");
                   }
                }

              }

            }
         }
         else 
         {
            System.out.println("Invalid vehicle id");
         }

         }
         System.out.println("Enter to continue");
                
        sc.nextLine();
        String fd = sc.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
         break;
         case 2:
         if(vehi.size()==0)
         {
             System.out.println("1.Currently no vehicle available ");
         }
         else 
         {
             for(int i=0;i<vehi.size();i++)
             {
                 System.out.println("Vehicle type : "+vehi.get(i).type+" Vehicle name : "+vehi.get(i).model+" Vehicle id :"+vehi.get(i).id+" Vehicle charge : "+vehi.get(i).charge);
             }
             System.out.println("One user cannot add more than one bike and one car to cart at a time");
             System.out.println("Enter vehicle id from displayed list");
             String kg = sc.next();
    
             boolean md=false;
            for(int i=0;i<vehi.size();i++)
            {
              if(String.valueOf(vehi.get(i).id).equals(kg))
              {
                  md=true;
                  pos=i;
                  break;
              }
            }

            if(md)
            {
                if(vehi.get(pos).type.equals("Bike"))
                {
                  if(!vehi.get(pos).type.equals(ki))
                  {
                    cat.add(new Veh(vehi.get(pos).type,vehi.get(pos).model,vehi.get(pos).id,vehi.get(pos).charge,vehi.get(pos).status,vehi.get(pos).travel,vehi.get(pos).fines));
                    System.out.println(vehi.get(pos).model+" add to cart successfully");
                    ki="Bike";
                    vehi.remove(pos);
                  }
                  else 
                  {
                    System.out.println("You cannot add more than bike to cart at a time");
                  }
                }
                else if(vehi.get(pos).type.equals("Car"))
                {
                    if(!vehi.get(pos).type.equals(ko))
                    {
                        cat.add(new Veh(vehi.get(pos).type,vehi.get(pos).model,vehi.get(pos).id,vehi.get(pos).charge,vehi.get(pos).status,vehi.get(pos).travel,vehi.get(pos).fines));
                      System.out.println(vehi.get(pos).model+" add to cart successfully");
                      ko="Car";
                      vehi.remove(pos);
                    }
                    else 
                    {
                      System.out.println("You cannot add more than car to cart at a time");
                    }
                }
            }
            else 
            {
                System.out.println("Invalid vehicle id");
            }
         }
         System.out.println("Enter to continue");
                
        sc.nextLine();
        String ds = sc.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
         break;

        case 3:
         if(cat.size()==0)
         {
            System.out.println("Currently no vehicles available");
         }
         else 
         {
            for(int i=0;i<cat.size();i++)
            {
                System.out.println(cat.get(i));
            }
            System.out.println("Vehicles in cart displayed above");
            System.out.println("Enter vehicle id to remove from the displayed list");
            String hb = sc.next();
            String yb="";
            boolean df=false;
            int sq=0;
            for(int i=0;i<cat.size();i++)
            {
               if(String.valueOf(cat.get(i).id).equals(hb))
               {
                   sq=i;
                   yb=hb;
                   df=true;
                   break;
               }
            }

            if(df)
            {
                System.out.println("Vehicle removed from cart successfully");   
               for(int i=0;i<vehi.size();i++)
               {
                   if(String.valueOf(vehi.get(i).id).equals(hb))
                   {
                       vehi.add(new Veh(cat.get(sq).type,cat.get(i).model,cat.get(i).id,cat.get(i).charge,cat.get(i).status,cat.get(i).travel,cat.get(i).fines));
                       break;
                   }
               }
            }
            else 
            {
                System.out.println("Invalid vehicle id");   
            }
         }
         System.out.println("Enter to continue");      
         sc.nextLine();
         String sd = sc.nextLine();
         System.out.print("\033[H\033[2J");
         System.out.flush();
         break;
         case 4:
           if(cat.size()==0)
           {
            System.out.println("Currently no vehicle available in cart");
           }
           else 
           {
              for(int i=0;i<cat.size();i++)
              {
                System.out.println(cat.get(i));
              }
           }
         System.out.println("Enter to continue");      
         sc.nextLine();
         String ak = sc.nextLine();
         System.out.print("\033[H\033[2J");
         System.out.flush();
         break;
         case 5:
         System.out.println("Your wallet balance is "+use.get(br).wall); 
         System.out.println("Enter to continue");      
         sc.nextLine();
         String al = sc.nextLine();
         System.out.print("\033[H\033[2J");
         System.out.flush();     
         break;
         case 6:
         if(use.get(br).renstat.length()==0)
         {
            System.out.println("No previous rental available at present");
         }
         else 
         {
            System.out.println(use.get(br).renstat);
         }
         System.out.println("Enter to continue");      
         sc.nextLine();
         String nj = sc.nextLine();
         System.out.print("\033[H\033[2J");
         System.out.flush();
         break;
         case 7:
         if(use.get(br).fine.length()==0)
         {
            System.out.println("Currently no fines available");
         }
         else 
         {
            System.out.println(use.get(br).fine);
         }
         System.out.println("Enter to continue");      
         sc.nextLine();
         String li = sc.nextLine();
         System.out.print("\033[H\033[2J");
         System.out.flush();
         break;
         case 8:
           user();
        }
        huse(br);
    }


    public static void user()
    {
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
            System.out.println("Enter minimum 500 for initial installment");
            int fr = sc.nextInt();

            if(fr<=500)
            {
                System.out.println("You should deposit 500 during registration");
            }
            else 
            {
                use.add(new User(b,c,usd,fr,"",""));
                System.out.println("Registration is completed");
                System.out.println("Your id is "+usd);
                System.out.println("Note it for future purpose");
                usd++;
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
        boolean fg=false;
        int ty=0;
        for(int i=0;i<use.size();i++)
        {

            if(use.get(i).name.equals(e) && use.get(i).pass.equals(f))
                 {
                     fg=true;
                     ty=i;
                     break;
                 }
        }
        if(!fg)
        {
                System.out.println("Incorrect username or password");
        }
        else 
        {
            huse(ty);
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
      user();
    }
    public static void home()
    {
       System.out.println("Vehicle Rental System");
       System.out.println("1.Admin login");
       System.out.println("2.User login");
       System.out.println("3.Exit");

       System.out.println("Enter your choice");
       int y = sc.nextInt();

       switch(y)
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
               user();
               break;
               case 3:
               System.exit(0);
            }
            home();
    }
    static Scanner sc;
    public static void main(String[] args)
    {
       sc=new Scanner(System.in);
       home();
    }
}
