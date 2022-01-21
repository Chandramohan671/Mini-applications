public class Booktr {
    public String nam;
    public String from;
    public String to;
    public int usid;
    public int seaid;
    public int bookid;
    public int deptid;
    public String stat;

    Booktr(String name,String fro,String t,int usi,int soi,int boi,int dpid,String sat)
    {
        nam=name;
        from=fro;
        to=t;
        usid=usi;
        seaid=soi;
        bookid=boi;
        deptid=dpid;
        stat=sat;

    }

    public String toString()
    {
        return "User name : "+nam+" Departure : "+from+" Destination : "+to+" User id : "+usid+" Seat id : "+seaid+" Booking id : "+bookid+" Status : "+stat;
    }
}
