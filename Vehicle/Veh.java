public class Veh {
    public String type;
    public String model;
    public int id;
    public int charge;
    public String status;
    public int travel;
    public int fines;

    Veh(String ty,String mode,int d,int charg,String stat,int trav,int fin)
    {
        type=ty;
        model=mode;
        id=d;
        charge=charg;
        status=stat;
        travel=trav;
        fines=fin;
    }
    public String toString()
    {
        return "Vehicle type : "+type+" Vehicle name : "+model+" Vehicle id : "+id+" Rental charge : "+charge+" Travel distance "+travel;
    }
}
