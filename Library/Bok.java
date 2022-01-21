public class Bok {
    public String title;
    public String author;
    public int price;
    public int isbn;
    public int qty;
    public int sal;
    public String stat;


    Bok(String nam,String aut,int pri,int isb,int qt,int h,String k)
    {
        title=nam;
        author=aut;
        price=pri;
        isbn=isb;
        qty=qt;
        sal=h;
        stat=k;
    }

    public String toString()
    {
        return "Book title : "+title+" Book author : "+author+" Book price : "+price+" Book isbn : "+isbn+" Book quantity : "+qty+" Sales : "+sal+" Status : "+stat;
    }
}
