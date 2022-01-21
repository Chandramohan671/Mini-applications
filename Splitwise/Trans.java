public class Trans {
    public String fname;
    public int rid;
    public int seid;
    public int tid;
    
    Trans(String fnam,int ri,int si,int ti)
    {
        fname=fnam;
        rid=ri;
        seid=si;
        tid=ti;
    }

    public String toString(){
        return "Food name : "+fname+" Request id : "+rid+" Sender id : "+seid+" Transaction id : "+tid;
    }
}
