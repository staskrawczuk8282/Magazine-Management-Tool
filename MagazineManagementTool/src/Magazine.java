import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Magazine implements Serializable {

    int MagID;
     static int LicznikID = SaveCreator.magIditer;
     double capacity;
     double capAviable;
     String adress;


     public List<Item> itemList = new ArrayList<>();

    public Magazine(double capacity, String adress){
        this.capacity = capacity;
        this.adress = adress;
        CreateID();
        capAviable = capacity;
    }
   private void CreateID(){
        MagID = LicznikID++;
   }

   public boolean addItem(Item a){
        if(capAviable>=a.volume){
            itemList.add(a);
            capAviable-=a.volume;
            return true;
        }
        return false;
   }

   public void removeItem(Item a){
        if(itemList.remove(a)){
        capAviable+=a.volume;}
   }
}
