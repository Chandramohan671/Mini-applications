public class UserBean {
    public String name;
    public String password;
    public String id;
    public String transaction;
    public String Ifsc;
    public int amount;

    public UserBean(String name,String password,String d,String t,String hj,int l)
    {
       this.name=name;
       this.password=password;
       id=d;
       transaction=t;
       Ifsc=hj;
       amount=l;
    }

    
}
