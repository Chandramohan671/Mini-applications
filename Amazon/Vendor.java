public class Vendor {
    public String name;
    public String password;
    public int id;
    public String type;
    public String status;

    Vendor(String a,String b,int c,String d,String e)
    {
        name=a;
        password=b;
        id=c;
        type=d;
        status=e;

        
    }
    public  String toString(){
        return "Name : "+name+" Password : ******* "+"id : "+id+" Type : "+type+" Approval status : "+status;
   }
}
