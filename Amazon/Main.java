import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {

static ArrayList<Vendor>  ve = new ArrayList<>();  

static ArrayList<Vendor> rt = new ArrayList<>();

static ArrayList<Product> pr = new ArrayList<>();

static ArrayList<User> us = new ArrayList<>();

static ArrayList<String> at = new ArrayList<>();

static ArrayList<Product> wk = new ArrayList<>();

static ArrayList<Order> oe = new ArrayList<>();

static ArrayList<String> frq = new ArrayList<>();

static ArrayList<String> ydg = new ArrayList<>();

static int de=0;

static int ct=1001;

static int pd=2001; 

static int he=3001;

static int ck=0;

static int dq =4001;

static int dqw=0;

static int qki=0; 

public static void cat()
{
    System.out.println("1.View Cart");
    System.out.println("2.Remove product from cart");
    int vp = sc.nextInt();

    if(vp==1)
    {
        if(wk.size()==0)
        {
            System.out.println("Currently no products availabe");
        }
        else 
        {
            for(int i=0;i<wk.size();i++)
            {
                System.out.println(i+1+" . "+wk.get(i));
            }
        }
    }
    else if(vp==2)
    {
        if(wk.size()==0)
        {
            System.out.println("Currently no products availabe");
        }
        else 
        {
        for(int i=0;i<wk.size();i++)
        {
                System.out.println(i+1+" . "+wk.get(i));
        }
    }
      System.out.println("Enter product id to remove");
      String co = sc.next();
      boolean vgt = false;
      
      for(int i=0;i<wk.size();i++)
      {
          if(wk.get(i).proid.equals(co))
          {
              vgt=true;
              pr.add(new Product(wk.get(i).proid,wk.get(i).venid,wk.get(i).proname,wk.get(i).price,wk.get(i).dis,wk.get(i).quantity,wk.get(i).saled));
              wk.remove(i);
              break;
          }
      }
      if(vgt)
      {
          System.out.println("Product removed successfully");
      }
      else 
      {
          System.out.println("Product does not exist");
      }
    }
    else 
    {
        System.out.println("Invalid input");
    }
}

public static void ord(int jg)
{
    System.out.println("Order Products");

    System.out.println("Enter the product name");

    String pnam = sc.next();

    boolean vk = false;

    int hi = 0;

    ArrayList<Product> in = new ArrayList<>();

    for(int i=0;i<pr.size();i++)
    {
          if(pr.get(i).proname.equals(pnam))
          {
              vk=true;
              in.add(pr.get(i));
              //System.out.println(pr.get(i));
              System.out.println("Product name : "+pr.get(i).proname+" Product price : "+pr.get(i).price+" Product discount : "+pr.get(i).dis+" Product quantity : "+pr.get(i).quantity);
              hi=i;
          }
    }

    if(!vk)
    {
        System.out.println("No results found");
    }
    else 
    {
        if(in.size()==1)
        {
        System.out.println("1.Add to cart");
        System.out.println("2.Purchase");

        int du = sc.nextInt();
        
        if(du==1)
        {
            wk.add(new Product(pr.get(hi).proid,pr.get(hi).venid,pr.get(hi).proname,pr.get(hi).price,pr.get(hi).dis,pr.get(hi).quantity,pr.get(hi).saled));
           System.out.println("Added to cart successfully");

           oe.add(new Order(String.valueOf(dq),pr.get(hi).proid,String.valueOf(us.get(jg).id),pr.get(hi).venid,pr.get(hi).price,pr.get(hi).dis,"Added to cart"));
        }
        else 
        {

        int ter = Math.abs((int)(pr.get(hi).price-(int)pr.get(hi).dis*(pr.get(hi).price/100)));
        

        if(us.get(jg).cash<ter)
        {
            System.out.println("Your wallet has an insufficient balance");
            System.out.println("Proceed with cash on delivery");

            System.out.println("1.Cancel the order");
            System.out.println("2.Cash on delivery");

            int dz = sc.nextInt();

            if(dz==1)
            {
               System.out.println("Cancelled successfully");

               System.out.println("Enter to continue");
                
              sc.nextLine();
              String un = sc.nextLine();
              System.out.print("\033[H\033[2J");
              System.out.flush();
              homuse(jg);
            }
            else if(dz==2)
            {
                pr.get(hi).quantity-=1;
                pr.get(hi).saled+=1;

                System.out.println("Ordered for cash on delivery");

                ydg.add("Ordered for cash on delivery");
                at.add(pr.get(hi).proname+" purchased on cash on delivery and price with discount is "+ter);
                System.out.println("Your product id is "+dq);
                System.out.println("Note it for future purpose");
                oe.add(new Order(String.valueOf(dq),pr.get(hi).proid,String.valueOf(us.get(jg).id),pr.get(hi).venid,pr.get(hi).price,pr.get(hi).dis,"Ordered for cash on delivery"));
                dq++;

            }
        }
     
        else 
        {
           
            System.out.println("You have an sufficient balance in wallet for purchase");
            System.out.println("1.Purchase");
            System.out.println("2.Cancel the order");
            int hnj = sc.nextInt();
            if(hnj==1)
            {
                pr.get(hi).quantity-=1;
                pr.get(hi).saled+=1;
                us.get(jg).cash=us.get(jg).cash-ter;
            System.out.println("Purchased successfully");
            ydg.add("Ordered using wallet");
            System.out.println("Your balance in wallet is "+us.get(jg).cash);

            at.add(pr.get(hi).proname+" purchased using wallet and price with discount is "+ter);
            System.out.println("Your product id is "+dq);
            System.out.println("Note it for future purpose");

            oe.add(new Order(String.valueOf(dq),pr.get(hi).proid,String.valueOf(us.get(jg).id),pr.get(hi).venid,pr.get(hi).price,pr.get(hi).dis,"Ordered using wallet"));
            dq++;
            }
            else 
            {
                System.out.println("Order is cancelled");
            }
        }
      }
      
    }
    else 
    {
          System.out.println("Enter vendor id");
          String aws = sc.next();
          boolean doi=false;
          for(int i=0;i<in.size();i++)
          {
              if(in.get(i).venid.equals(aws))
              {
                  doi = true;
                  break;
              }
          }

          if(!doi)
          {
              System.out.println("Invalid vendor id");
          }
          else 
          {
            System.out.println("1.Add to cart");
            System.out.println("2.Purchase");
    
            int du = sc.nextInt();
            
            if(du==1)
            {
               wk.add(new Product(pr.get(hi).proid,pr.get(hi).venid,pr.get(hi).proname,pr.get(hi).price,pr.get(hi).dis,pr.get(hi).quantity,pr.get(hi).saled));
               System.out.println("Added to cart successfully");
    
               oe.add(new Order(String.valueOf(dq),pr.get(hi).proid,String.valueOf(us.get(jg).id),pr.get(hi).venid,pr.get(hi).price,pr.get(hi).dis,"Added to cart"));
            }
            else 
            {
    
            int ter = Math.abs((int)(pr.get(hi).price-(int)pr.get(hi).dis*(pr.get(hi).price/100)));
            
    
            if(us.get(jg).cash<ter)
            {
                System.out.println("Your wallet has an insufficient balance");
                System.out.println("Proceed with cash on delivery");
    
                System.out.println("1.Cancel the order");
                System.out.println("2.Cash on delivery");
    
                int dz = sc.nextInt();
    
                if(dz==1)
                {
                   System.out.println("Cancelled successfully");
    
                   System.out.println("Enter to continue");
                    
                  sc.nextLine();
                  String un = sc.nextLine();
                  System.out.print("\033[H\033[2J");
                  System.out.flush();
                  homuse(jg);
                }
                else if(dz==2)
                {
                    pr.get(hi).quantity-=1;
                    pr.get(hi).saled+=1;
    
                    System.out.println("Ordered for cash on delivery");
    
                    ydg.add("Ordered for cash on delivery"+pr.get(hi).proid+pr.get(hi).venid);
                    at.add(pr.get(hi).proname+" purchased on cash on delivery and price with discount is "+ter);
                    System.out.println("Your product id is "+dq);
                    System.out.println("Note it for future purpose");
                    oe.add(new Order(String.valueOf(dq),pr.get(hi).proid,String.valueOf(us.get(jg).id),pr.get(hi).venid,pr.get(hi).price,pr.get(hi).dis,"Ordered for cash on delivery"));
                    dq++;
    
                }
            }
         
            else 
            {
               
                System.out.println("You have an sufficient balance in wallet for purchase");
                System.out.println("1.Purchase");
                System.out.println("2.Cancel the order");
                int hnj = sc.nextInt();
                if(hnj==1)
                {
                    pr.get(hi).quantity-=1;
                    pr.get(hi).saled+=1;
                    us.get(jg).cash=us.get(jg).cash-ter;
                System.out.println("Purchased successfully");
                ydg.add("Ordered using wallet"+pr.get(hi).proid+pr.get(hi).venid);
                System.out.println("Your balance in wallet is "+us.get(jg).cash);
    
                at.add(pr.get(hi).proname+" purchased using wallet and price with discount is "+ter);
                System.out.println("Your product id is "+dq);
                System.out.println("Note it for future purpose");
    
                oe.add(new Order(String.valueOf(dq),pr.get(hi).proid,String.valueOf(us.get(jg).id),pr.get(hi).venid,pr.get(hi).price,pr.get(hi).dis,"Ordered using wallet"));
                dq++;
                }
                else 
                {
                    System.out.println("Order is cancelled");
                }
            }
          }
          
          }

    }
  }
}



public static void homuse(int gj)
{
    System.out.println("User");
    System.out.println("1.Cart");
    System.out.println("2.Order");
    System.out.println("3.Order History");
    System.out.println("4.Wallet");
    System.out.println("5.Password change");
    System.out.println("6.Exit");

    int hq = sc.nextInt();

    switch(hq)
    {
        case 1:
        cat();
         System.out.println("Enter to continue");
                
         sc.nextLine();
         String fd = sc.nextLine();
         System.out.print("\033[H\033[2J");
         System.out.flush();
        break;

        case 2:
        ord(gj);

        System.out.println("Enter to continue");
                
         sc.nextLine();
         String df = sc.nextLine();
         System.out.print("\033[H\033[2J");
         System.out.flush();
        break;

        case 3:
            if(at.size()==0)
            {
                System.out.println("Currently no order history");
            }
            else 
            {
                for(int i=0;i<at.size();i++)
                {
                    System.out.println(i+1+". "+at.get(i));
                }
            }
            System.out.println("Enter to continue");
                
            sc.nextLine();
            String fi = sc.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            break;

            case 4:
            System.out.println("Your balance is "+us.get(gj).cash);

            System.out.println("1.Add amount");
            System.out.println("2.Remove amount");
            System.out.println("3.Exit");

            int aty = sc.nextInt();

            if(aty==1)
            {
               System.out.println("Enter amount to add");
               us.get(gj).cash+=sc.nextInt();
               System.out.println("Amount added successfully");
            }
            else if(aty==2)
            {
                System.out.println("Enter amount to remove");
                us.get(gj).cash-=sc.nextInt();
                System.out.println("Amount removed successfully");
            }
            System.out.println("Enter to continue");
                
            sc.nextLine();
            String bp = sc.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            break;

            case 5:
            System.out.println("Enter old password:");
            String ope = sc.next();
            boolean gbf =false;
            int coi =0;
            for(int i=0;i<us.size();i++)
            
            {
                if(us.get(i).pass.equals(ope))
                {
                    gbf=true;
                    coi=i;
                    break;
                }
            }

            if(!gbf)
            {
               System.out.println("Incorrect old password");
            }
            else 
            {
                System.out.println("Enter new password");
                us.get(coi).pass=sc.next();
                System.out.println("Password changed successfully");
            }
            System.out.println("Enter to continue");
                
            sc.nextLine();
            String qn = sc.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            break;
            case 6:
            System.out.print("\033[H\033[2J");
            System.out.flush();
            cus();
            break;

            default:
            System.out.println("Invalid input");

    }
    homuse(gj);
}



public static void cus()
{
    System.out.println("Customer");

    System.out.println("1.New User");
    System.out.println("2.Existing User");
    System.out.println("3.Exit");

    int zd = sc.nextInt();

    switch(zd)
    {
        case 1:
         System.out.println("Enter user name :");
         String un = sc.next();
         System.out.println("Enter password :");
         String nu = sc.next();
         System.out.println("Enter the vallet amount ");
         int vf = sc.nextInt();
         
         us.add(new User(un,nu,he,vf));
         System.out.println("Your user id is :"+he);
         System.out.println("Note it for future login purpose");

         he++;

         break;

         case 2:
         System.out.println("Enter user name :");
         String ft = sc.next();
         System.out.println("Enter password :");
         String tf = sc.next();
         System.out.println("Enter user id:");
         String np = sc.next();
         
         int gj = 0;
         boolean dl = false;
         for(int i=0;i<us.size();i++)
         {
             if(us.get(i).name.equals(ft) && us.get(i).pass.equals(tf) && String.valueOf(us.get(i).id).equals(np))
             {
                 dl=true;
                 gj=i;
                 break;
             }
         }

         if(dl)
         {
             homuse(gj);
         }
         else 
         {
            System.out.println("Incorrect name or password or id");
         }
        break;
        case 3:
        System.out.print("\033[H\033[2J");
        System.out.flush();
        home();

    }
    cus();
}




public static void rem()
{
    System.out.println("Enter the product id to remove");
    String fid=sc.next();
    boolean fre=false;
    for(int i=0;i<pr.size();i++)
    {
        if(pr.get(i).proid.equals(fid))
        {
           pr.remove(i);
           fre=true;
           break;
        }
    }

    if(fre)
    {
        System.out.println("Product removed successfully");
    }
    else 
    {
        System.out.println("Product does not exit");
    }
}



public static void add()
{
    System.out.println("Enter vendor id: ");
    String ji = sc.next();
    System.out.println("Enter product type : ");
    String qw = sc.next();

    if(ve.get(de).type.equals(qw) && String.valueOf(ve.get(de).id).equals(ji))
    {
        
        System.out.println("Enter product name : ");
        String fr = sc.next();
        System.out.println("Enter product price : ");
        int as = sc.nextInt();
        System.out.println("Enter discount for product : ");
        int hg = sc.nextInt();

        System.out.println("Enter quantity of products : ");
        int vc = sc.nextInt();
        pr.add(new Product(String.valueOf(pd),ji,fr,as,hg,vc,0));
        

        System.out.println("Product Added successfully");

        System.out.println("The product id  is "+pd);

        System.out.println("Note the product id for future purpose");
        pd++;
    }
    else 
    {
        System.out.println("Invalid vendor id or product type");
    }
    
}



public static void view()
{
    System.out.println("Product overview");

    System.out.println("1.Single Product Overview");
    System.out.println("2.All products Overview");
    System.out.println("3.Exit");

    int fw=sc.nextInt();

    switch(fw)
    {
        case 1:
         System.out.println("Enter the product id ");
         String or=sc.next();

         boolean md=false;
         for(int i=0;i<pr.size();i++)
         {
             if(pr.get(i).proid.equals(or))
             {
                 System.out.println(pr.get(i));
                 md=true;
                 break;
             }
         }
         
         if(!md)
         {
             System.out.println("Product does not exist");
         }
         System.out.println("Enter to continue");
                
         sc.nextLine();
         String fd = sc.nextLine();
         System.out.print("\033[H\033[2J");
         System.out.flush();
         break;

         case 2:
           if(pr.size()==0)
           {
             System.out.println("Currently no products for review");
           }
           else 
           {
              for(int i=0;i<pr.size();i++)
              {
                  System.out.println(i+1+". "+pr.get(i));
              }
           }
            
           System.out.println("Enter to continue");
                
         sc.nextLine();
         String df = sc.nextLine();
         System.out.print("\033[H\033[2J");
         System.out.flush();
         
           break;
           case 3:
           System.out.print("\033[H\033[2J");
           System.out.flush();
           hovend(dqw);
    }
    view();
}



public static void edit(int xs)
{
    
         System.out.println("1.Add additional count of products");
         System.out.println("2.Edit the price");
         System.out.println("3.Edit the discount");
         System.out.println("4.Exit");

        int add = sc.nextInt();

      switch(add){

        case 1:
        
           System.out.println("1.Add count");
           System.out.println("2.Reduce count");
           int qb = sc.nextInt();

           if(qb==1)
           {
            System.out.println("Enter quantity to add");
             pr.get(xs).quantity+=sc.nextInt();
            System.out.println("Quantity added successfully");
        
           }
           else 
           {
            System.out.println("Enter quantity to reduce");
            pr.get(xs).quantity-=sc.nextInt();
           System.out.println("Quantity reduced successfully");
           }

           
         System.out.println("Enter to continue");
                
         sc.nextLine();
         String cf = sc.nextLine();
         System.out.print("\033[H\033[2J");
         System.out.flush();
        break;

        case 2:
        System.out.println("1.Add amount");
        System.out.println("2.Reduce amount");
        int nt = sc.nextInt();

        System.out.println("Enter amount");
        int gf = sc.nextInt();

        if(nt==1)
        {
            pr.get(xs).price+=gf;
        }
        else 
        {
            pr.get(xs).price-=gf;
        }
        System.out.println("Updated successfully");
     
        System.out.println("Enter to continue");
             
        sc.nextLine();
        String fc = sc.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        break;

        case 3:
         
        System.out.println("1.Add discount");
        System.out.println("2.Reduce discount");
        int sl = sc.nextInt();

        System.out.println("Enter discount");
        int nd = sc.nextInt();

        if(sl==1)
        {
            pr.get(xs).dis+=nd;
        }
        else 
        {
            pr.get(xs).dis-=nd;
        }
        System.out.println("Updated successfully");
     
        System.out.println("Enter to continue");
             
        sc.nextLine();
        String ve = sc.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
            
        break;

        case 4:
        System.out.print("\033[H\033[2J");
        System.out.flush();
        hovend(dqw);

    }

  edit(xs);
}



public static void othve()
{
        if(pr.size()==0) 
        {
            System.out.println("No other products reveiw  available at present");
        }
        else 
        {
            System.out.println("Enter the your  product id :");
            String wk = sc.next();
            boolean mw = false;
            for(int i=0;i<pr.size();i++)
            {
                if(!String.valueOf(pr.get(i).proid).equals(wk))
                {
                    mw=true;
                    System.out.println(pr.get(i));
                }
            }

            if(!mw)
            {
                System.out.println("No other products reveiw available at present");
            }
        }

    
}




public static void hovend(int ide)
{
    System.out.println("Admin approved");

    System.out.println("1.Add Product");
    System.out.println("2.Remove Product");
    System.out.println("3.Review Product");
    System.out.println("4.Edit Product");
    System.out.println("5.View products of other vendors");
    System.out.println("6.Frequent customer");
    System.out.println("7.Most Saled Product");
    System.out.println("8.Sales Report");
    System.out.println("9.Exit");

    System.out.println("Enter choice :");

    int re = sc.nextInt();

    int xs =0;
    switch(re)
    {
        case 1:
         add();
         System.out.println("Enter to continue");
                
         sc.nextLine();
         String fd = sc.nextLine();
         System.out.print("\033[H\033[2J");
         System.out.flush();
         break;
         case 2:
          rem();
          System.out.println("Enter to continue");
                
         sc.nextLine();
         String h = sc.nextLine();
         System.out.print("\033[H\033[2J");
         System.out.flush();
         break;

         case 3:
        
          view();

          System.out.println("Enter to continue");
                
          sc.nextLine();
          String hq = sc.nextLine();
          System.out.print("\033[H\033[2J");
          System.out.flush();
          break;

          case 4:

          System.out.println("Enter the product id : ");
          String er = sc.next();
  
          boolean hw = false;
         
          for(int i=0;i<pr.size();i++)
          {
              if(pr.get(i).proid.equals(er))
              {
                 xs=i;
                 hw=true;
                 break;
              }
          }

          if(hw)
          {
           edit(xs);
          }
          else 
          {
            System.out.println("Invalid product id");
          }
          System.out.println("Enter to continue");
                
          sc.nextLine();
          String hf = sc.nextLine();
          System.out.print("\033[H\033[2J");
          System.out.flush();
          break;

          case 5:
          
           othve();
           System.out.println("Enter to continue");
                
           sc.nextLine();
           String ha = sc.nextLine();
           System.out.print("\033[H\033[2J");
           System.out.flush();
           break;

          case 6:
            
          HashMap<String,Integer> hm = new HashMap<>();
          for(int i=3001;i<us.size()+3001;i++)
          {
              int ser=0;
              for(int j=0;j<oe.size();j++)
              {
                  if(String.valueOf(ide).equals(oe.get(j).selid) && String.valueOf(i).equals(oe.get(j).buyid))
                  {
                     ser++;
                  }
              }
             hm.put(us.get(i).name,ser);
          }
          if(hm.size()>0)
          {
          int bty=0;
          String hrt="";
          for(Map.Entry me : hm.entrySet())
          {
              if((int)me.getValue()>bty)
              {
                 bty=(int)me.getValue();
                 hrt=(String)me.getKey();
              }
          }
          System.out.println("Frequent user is "+hrt);
         }
         else 
         {
             System.out.println("No frequent customer at present");
         }
          System.out.println("Enter to continue");
                
          sc.nextLine();
          String qo = sc.nextLine();
          System.out.print("\033[H\033[2J");
          System.out.flush();
          break;

          case 7:
          HashMap<String,Integer> mh = new HashMap<>();
          for(int i=2001;i<pr.size()+2001;i++)
          {
              int ser=0;
              for(int j=0;j<oe.size();j++)
              {
                  if(String.valueOf(ide).equals(oe.get(j).selid) && String.valueOf(i).equals(oe.get(j).prid))
                  {
                     ser++;
                  }
              }
              for(int k=0;k<pr.size();k++)
              {
                  if(pr.get(k).proid.equals(i))
                  {
                    mh.put(pr.get(k).proname,ser);
                    break;
                  }
              }
            
          }
          if(mh.size()>0)
          {
          int dio=0;
          String jko="";
          for(Map.Entry em : mh.entrySet())
          {
              if((int)em.getValue()>dio)
              {
                 dio=(int)em.getValue();
                 jko=(String)em.getKey();
              }
          }
          System.out.println("Most sold product is "+jko);
        }
        else 
        {
            System.out.println("No most saled product at present");
        }
          System.out.println("Enter to continue");
                
          sc.nextLine();
          String oq = sc.nextLine();
          System.out.print("\033[H\033[2J");
          System.out.flush();
          break;
          case 8:

           if(ydg.size()==0)
           {
               System.out.println("Currently no sales report");
           }
          else
          {
            int dlo=0;
            int mku=0;

        for(int j=3001;j<pr.size()+3001;j++)
        {  for(int i=0;i<ydg.size();i++)
          {
              if(ydg.get(i).contains("cash") && ydg.get(i).contains("j") && ydg.get(i).contains("ide"))
              {
                   dlo++;
              }
              else if(ydg.get(i).contains("wallet") && ydg.get(i).contains("j") && ydg.get(i).contains("ide"))
              {
                 mku++;
              }
          }
          if(dlo>0 || mku>0)
          {
            System.out.println(" Product id : "+j+" Ordered for cash on delivery : "+dlo+" Ordered with wallet : "+mku);
          }
          else 
          {
            System.out.println("Currently no sales report available");
          }
        }
         
        }
        System.out.println("Enter to continue");
                
          sc.nextLine();
          String vo = sc.nextLine();
          System.out.print("\033[H\033[2J");
          System.out.flush();
          break;
          case 9:
          System.out.print("\033[H\033[2J");
          System.out.flush();
          vend();
    }
    hovend(dqw);
}





public static void vend()
{
    System.out.println("Vendor Amazon");
    System.out.println("1.New User");
    System.out.println("2.Existing User");
    System.out.println("3.Exit");

     System.out.println("Enter your choice");
     int y = sc.nextInt();

     switch(y)
     {
         case 1:
         
         System.out.println("Enter user name :");
         String nam= sc.next();
         System.out.println("Enter password : ");
         String pa=sc.next();
         System.out.println("Enter the type of things to add : ");
         String ty=sc.next();

         rt.add(new Vendor(nam, pa, ct, ty,"Approval bending"));

         ck++;

         System.out.println("Your id is "+ct);
         System.out.println("Please note your id for future login purpose \n");
          ct++;

          System.out.println("Your invitation is send to admin for approval");

         System.out.println("Enter to continue");
                
         sc.nextLine();
         String b = sc.nextLine();
         System.out.print("\033[H\033[2J");
         System.out.flush();
         break;

         case 2:
         System.out.println("Enter username : ");
         String as = sc.next();

         System.out.println("Enter password : ");
         String fd = sc.next();

         System.out.println("Enter vendor id : ");
         String gh = sc.next();

        boolean fla = false;
        boolean gey=false;
         for(int i=0;i<ve.size();i++)
         {
             if(ve.get(i).name.equals(as) && ve.get(i).password.equals(fd) && String.valueOf(ve.get(i).id).equals(gh))
             {
            
                    dqw=i;
                    fla=true;
                    gey=true;
                    break;
                 
             }
         }

         if(fla && ve.get(de).status.equals("approved"))
         {
                hovend(dqw);
    
         }
         else 
         {
             boolean hyu=false;
            for(int i=0;i<rt.size();i++)
            {
                if(rt.get(i).name.equals(as) && rt.get(i).password.equals(fd) && String.valueOf(rt.get(i).id).equals(gh))
                {
                    hyu=true;
                    break;
                }
            }

             if(ck>0 && hyu)
             {
                System.out.println("Admin appoval is bending");
             }
             else 
             {
               System.out.println("Incorrect username or password & vendor id");
             }
             
         }
         System.out.println("Enter to continue");
                
        sc.nextLine();
        String k = sc.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        break;

        case 3:
        System.out.print("\033[H\033[2J");
        System.out.flush();
        home();
        break;
        default:
        System.out.println("Invalid input");
        System.out.print("\033[H\033[2J");
        System.out.flush();
     }
    
     vend();
}




    public static void admin(){
        
        System.out.println("Admin");
        System.out.println("1.Vendor Appoval");
        System.out.println("2.Add Vendor");
        System.out.println("3.Remove Vendor");
        System.out.println("4.View Vendor");
        System.out.println("5.Exit");

        System.out.println("Enter choice :");
        int x = sc.nextInt();
        
        switch(x)
        {
            case 1:
            System.out.println("Vendor Approval");

            if(rt.size()==0)
            {
                System.out.println("Currently no Vendor request Approval");
            }
            else 
            {
                for(int i=0;i<rt.size();i++)
                {
                    System.out.println(rt.get(i));
                   
                }
                System.out.println("These are the invitations");
                System.out.println("1.Proceed to approve");
                System.out.println("2.Exit");
                int sd=sc.nextInt();
                if(sd==1)
                {
                    for(int i=0;i<rt.size();i++)
                   {
                    rt.get(i).status="approved";
                    ve.add(new Vendor(rt.get(i).name,rt.get(i).password,rt.get(i).id,rt.get(i).type,rt.get(i).status));
                    rt.remove(i);
                   }
                 System.out.println("The bending vendor invitations approved sucessfully");
                }
            }
            System.out.println("Enter to continue");
                
                sc.nextLine();
                String nb = sc.nextLine();
                 System.out.print("\033[H\033[2J");
                 System.out.flush();
            break;

            case 2:
            System.out.println("Add Vendor");
            System.out.println("Enter Vendor name :");
            String a=sc.next();
            System.out.println("Enter Vendor password :");
            String b=sc.next();
            System.out.println("Enter Vendor Products type :");
            String d=sc.next();

            ve.add(new Vendor(a,b,ct,d,"approved"));

            System.out.println("Your id is "+ct);
            System.out.println("Please note your id for future login purpose");
            ct++;
            System.out.println("Vendor added successfully");

            System.out.println("Enter to continue");
                
            sc.nextLine();
            String lk = sc.nextLine();
             System.out.print("\033[H\033[2J");
             System.out.flush();
            break;

            case 3:
             System.out.println("Remove Vendor");

             if(ve.size()==0)
             {
                System.out.println("Currently no Vendor available");
             }

             else 
             {
             System.out.println("Enter the Vendor id to remove :");

             String k=sc.next();

             boolean fag=false;
             for(int i=0;i<ve.size();i++)
             {
                 if(String.valueOf(ve.get(i).id).equals(k))
                 {
                     ve.remove(i);
                     fag=true;
                     break;
                 }
             }
             if(fag)
             {
                 System.out.println("Vendor removed successfully");
             }
             else 
             {
                 System.out.println(k+" Vendor does not exist");
             }

            }
             System.out.println("Enter to continue");
                
             sc.nextLine();
             String df = sc.nextLine();
              System.out.print("\033[H\033[2J");
              System.out.flush();
             break;

             case 4:
               if(ve.size()==0)
               {
                  System.out.println("Currently no vendors in vendor list");
               }
               else 
               {
                 for(int i=0;i<ve.size();i++)
                 {
                     System.out.println(i+1+". "+ve.get(i));
                 }
               }
               System.out.println("Enter to continue");
                
               sc.nextLine();
               String se = sc.nextLine();
              System.out.print("\033[H\033[2J");
              System.out.flush();
               break;
             case 5:
              System.out.print("\033[H\033[2J");
              System.out.flush();
              home();
              break;
            default:
            System.out.println("Invalid Input");
            System.out.print("\033[H\033[2J");
              System.out.flush();

        }
        admin();
    }



    public static void home()
    {
       System.out.println("Amazon");
       System.out.println("1.Admin login");
       System.out.println("2.Vendor login");
       System.out.println("3.Customer login");
       System.out.println("4.Exit");

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
             vend();
             break;
             case 3:
              cus();
              break;
            case 4:
               System.exit(0);

       }
       home();
    }
    private static Scanner sc;
    public static void main(String[] args)
    {
        sc=new Scanner(System.in);

        home();
    }
}
