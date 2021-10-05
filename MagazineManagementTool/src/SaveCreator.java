import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaveCreator {

    public static int itemIter;
    public static int magIditer;

    public static void Save (List<Magazine> list) throws IOException {

        String fileName;
        for(int i=0; i<list.size(); i++){
            fileName="src/MagazineSaves/" + list.get(i).adress + ".txt";
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(list.get(i));
        }

    }

    public static void Load () throws IOException, ClassNotFoundException {
        File saveDir = new File("src/MagazineSaves");
        File [] saves = saveDir.listFiles();
            if(saves != null){
                for(File save : saves){
                   try{
                    ObjectInputStream in = new ObjectInputStream(new FileInputStream(save));
                            Magazine mag = (Magazine) in.readObject();
                            MagazineDataBase.magazineList.add(mag);
                            itemIter += mag.itemList.size();

                    }catch (EOFException e){
                       System.out.println("all files read");
                   }
                   magIditer++;
                }
                Magazine.LicznikID = magIditer;
            }
    }
}
