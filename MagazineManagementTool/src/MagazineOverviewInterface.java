import javax.swing.*;

public class MagazineOverviewInterface extends JPanel {

    static UsageDisplayer usageOverview;


    public MagazineOverviewInterface(){

        setLayout(null);
        usageOverview = new UsageDisplayer(MagazineDataBase.magazineList.get(LoginInterface.comboIndex));
        JLabel magazineName;
        JLabel adressName;
        JLabel maxCapLabel;
        JLabel avbCapLabel;
        String magNameStr = "ID: " + MagazineDataBase.magazineList.get(LoginInterface.comboIndex).MagID;
        String adressStr = "Adress: " + MagazineDataBase.magazineList.get(LoginInterface.comboIndex).adress;
        String maxCapStr = "Max. Capacity: " + MagazineDataBase.magazineList.get(LoginInterface.comboIndex).capacity;
        String avbCapStr = "Aviable Capacity: " + MagazineDataBase.magazineList.get(LoginInterface.comboIndex).capAviable;
        magazineName = new JLabel(magNameStr);
        adressName = new JLabel(adressStr);
        maxCapLabel = new JLabel(maxCapStr);
        avbCapLabel = new JLabel(avbCapStr);

        JButton back = new JButton("Back");

        back.addActionListener(
                e -> {
                    LoginInterface.cl.show(LoginInterface.contentPanel,"listMenu");
                }
        );

        magazineName.setBounds(15,30,80,30);
        adressName.setBounds(15,70,200,30);
        avbCapLabel.setBounds(15,140,150,30);
        maxCapLabel.setBounds(15,180,150,30);
        back.setBounds(80,210,60,30);
        usageOverview.setBounds(210, 120,100,100);

        add(magazineName);
        add(adressName);
        add(avbCapLabel);
        add(maxCapLabel);
        add(back);
        add(usageOverview);


    }


}
