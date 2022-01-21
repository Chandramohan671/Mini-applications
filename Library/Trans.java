public class Trans {
    
    public String na;
    public String auth;
    public int isb;
    public int odid;
    public int uid;
    public int price;
    public int qty;
   

    Trans(String name,String at,int a,int b,int c,int d,int e)
    {
        na=name;
        auth=at;
        isb=a;
        odid=b;
        uid=c;
        price=d;
        qty=e;
        
    }

    public String toString()
    {
        return "User name : "+na;
    }
}
