public class User {
    
    public String name;
    public String pass;
    public int id;
    public int cash;

    User(String na,String pa,int de,int ca)
    {
        name=na;
        pass=pa;
        id=de;
        cash=ca;
    }

    public String toString()
    {
        return "Username : "+name+" Password :"+pass+" Id :"+id;
    }
}
