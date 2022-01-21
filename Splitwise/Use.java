public class Use{
    public String name;
    public String pass;
    public int wal;
    public int id;
    public String upd;
    public String temp;
    public String stat;

    Use(String na,String pa,int wa,int d,String up,String tem,String sat)
    {
        name=na;
        pass=pa;
        wal=wa;
        id=d;
        upd=up;
        temp=tem;
        stat=sat;
    }

    public String toString()
    {
        return "Name : "+name+" user id : "+id+" Wallet balance : "+wal+" Sended requests : "+upd+" Payments history : "+temp+" Status of requests : "+stat;
    }
}
