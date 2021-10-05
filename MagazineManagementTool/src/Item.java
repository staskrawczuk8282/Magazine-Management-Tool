import java.io.Serializable;

public class Item  implements Serializable {

    double volume;
    String name;
    String description;
    int ItemID;
    static int licznikID = SaveCreator.itemIter;

        public Item (double volume, String name, String description){
            this.volume = volume;
            this.name = name;
            this.description = description;
            CreateID();
        }
        private void CreateID(){
            ItemID=licznikID++;
        }
}
