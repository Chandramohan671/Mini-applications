public class Product {
    
    public String proid;
    public String venid;
    public String proname;
    public int price;
    public int dis;
    public int quantity;
    public int saled;

    Product(String a,String b,String ng,int d,int e,int f,int g)
    {
        proid=a;
        venid=b;
        proname=ng;
        price=d;
        dis=e;
        quantity=f;
        saled=g;
    }

    public  String toString(){
        return "Product id : "+proid+" Vendor id : "+venid+" Product name : "+proname+"  "+"Price : "+price+" Discount : "+dis+" Quantity : "+quantity+" Sales : "+saled;
   }
}
