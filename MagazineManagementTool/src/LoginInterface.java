
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import javax.swing.*;
import java.awt.*;

public class LoginInterface extends JFrame {

    static CardLayout cl =  new CardLayout();
    static JPanel contentPanel = new JPanel();
    static int comboIndex =0;

    static MagazineOverviewInterface overviewMag = new MagazineOverviewInterface();
    static ItemListInterface itemList = new ItemListInterface();
    static DeleteItemInterface deleteItem = new DeleteItemInterface();

    public LoginInterface(){

        MenuInterface menu = new MenuInterface();
        RegisterInterface register = new RegisterInterface();
        CreateItemInterface createItem = new CreateItemInterface();
        ChoosMagazineInterface chooseMag = new ChoosMagazineInterface();
        AddMagazineInterface addMag = new AddMagazineInterface();
        MagazineListInterface listMag = new MagazineListInterface();
        MagazineListMenu listMenu = new MagazineListMenu();
        JPanel panel = new JPanel();
        contentPanel.setLayout(cl);


        panel.setLayout(null);
        JTextField givenUsername = new JTextField();
        JPasswordField givenPassword = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        JOptionPane errWindow = new JOptionPane(null , JOptionPane.ERROR_MESSAGE);
        errWindow.setSize(500,200);
        JDialog dialog = errWindow.createDialog(null);
        dialog.setSize(500,200);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(false);

        usernameLabel.setBounds(30,20,80,30);
        givenUsername.setBounds(120,20,160,30);
        passwordLabel.setBounds(30, 60, 80,30);
        givenPassword.setBounds(120,60,160,30);
        loginButton.setBounds(80,100,80,30);
        registerButton.setBounds(170,100,80,30);

        registerButton.addActionListener(
                (e)-> cl.show(contentPanel,"register")
                );

        loginButton.addActionListener(
                (e)->{
                    String user = givenUsername.getText();
                    String pass = givenPassword.getText();

                        if(UserLogin.isPassCorrect(user,pass)){
                            setSize(new Dimension(300,300));
                            cl.show(contentPanel,"menu");
                        }
                        else{
                            errWindow.setMessage("Wrong username or password");
                            dialog.setTitle("LOGIN ERROR");
                            dialog.setVisible(true);
                        }
                    }

        );


        panel.add(usernameLabel);
        panel.add(givenUsername);
        panel.add(passwordLabel);
        panel.add(givenPassword);
        panel.add(loginButton);
        panel.add(registerButton);

        contentPanel.add("login",panel);
        contentPanel.add("register", register);
        contentPanel.add("menu",menu);
        contentPanel.add("createItem", createItem);
        contentPanel.add("chooseMags",chooseMag);
        contentPanel.add("addMag",addMag);
        contentPanel.add("listMag",listMag);
        contentPanel.add("listMenu",listMenu);
        contentPanel.add("overviewMag",overviewMag);
        contentPanel.add("itemList",itemList);
        contentPanel.add("deleteItem",deleteItem);

        cl.show(contentPanel,"login");



        getContentPane().add(contentPanel);



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(300,200));
        setResizable(false);
        setVisible(true);


    }

}
