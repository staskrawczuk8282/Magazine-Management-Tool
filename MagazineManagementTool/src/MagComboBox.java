import javax.swing.*;

public class MagComboBox extends JComboBox<String> {

    public MagComboBox(){

        for (Magazine x: MagazineDataBase.magazineList) {
            this.addItem("ul."+x.adress);
        }
    }

    public void Refresh(){
         this.removeAllItems();
         for(Magazine x : MagazineDataBase.magazineList){
             this.addItem("ul."+x.adress);
         }

    }
}
