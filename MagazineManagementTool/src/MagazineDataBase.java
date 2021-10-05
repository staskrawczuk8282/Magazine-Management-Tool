import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MagazineDataBase implements Serializable {

     static List<Magazine> magazineList = new ArrayList<>();


    static void addMag(Magazine m){
        magazineList.add(m);
    }

}
