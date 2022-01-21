public class User {
    public String name;
    public String pass;
    public int id;
    public int wall;
    public String fine;
    public String renstat;
    User(String nam,String pas,int d,int wa,String fi,String rent)
    {
        name=nam;
        pass=pas;
        id=d;
        wall=wa;
        fine=fi;
        renstat=rent;
    }

    public String toString()
    {
        return "Name : "+name+" id : "+id+" wallet balance : "+wall+" fine "+fine;
    }
}
