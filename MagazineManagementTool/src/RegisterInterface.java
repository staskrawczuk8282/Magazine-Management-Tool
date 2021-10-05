import sun.rmi.runtime.Log;

import javax.swing.*;
import java.awt.*;

public class RegisterInterface extends JPanel {
    JTextField givenUsername;
    JPasswordField givenPassword;
    JPasswordField givenRepeat;
    JButton registerButton;
    JLabel usernameLabel;
    JLabel passwordLabel;
    JLabel repeatLabel;
    JLabel registerInfo;





    public RegisterInterface(){



         setLayout(null);
         givenUsername = new JTextField();
         givenPassword = new JPasswordField();
         givenRepeat = new JPasswordField();
         registerButton = new JButton("Register");
         usernameLabel = new JLabel("Username:");
         passwordLabel = new JLabel("Password:");
         repeatLabel = new JLabel("Repeat Pass.:");
         registerInfo = new JLabel();
         registerInfo.setForeground(Color.GREEN);


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
        repeatLabel.setBounds(30,100,100,30);
        givenRepeat.setBounds(120,100,160,30);
        registerButton.setBounds(170,140,80,30);
        registerInfo.setBounds(60,180,250,30);

        registerButton.addActionListener(
                (e)->{
                    String user = givenUsername.getText();
                    String pass = givenPassword.getText();
                    String pass2 = givenRepeat.getText();

                    if(!(user.equals("")||pass.equals(""))){

                    if(pass.equals(pass2)){
                        if(UserLogin.checkIfExists(user)){
                            UserLogin.Register(user,pass);
                            errWindow.setMessage("Registration Succeeded");
                            dialog.setTitle("Success");
                            dialog.setVisible(true);
                            LoginInterface.cl.show(LoginInterface.contentPanel, "login" );
                        }
                        else{
                            errWindow.setMessage("This username is taken");
                            dialog.setTitle("USERNAME ERROR");
                            dialog.setVisible(true);
                        }
                    }
                    else{
                        errWindow.setMessage("Passwords dont match");
                        dialog.setTitle("PASSWORD ERROR");
                        dialog.setVisible(true);

                    }}
                    else{
                        errWindow.setMessage("Username or Password cannot be empty");
                        dialog.setTitle("EMPTY SPACE");
                        dialog.setVisible(true);
                        }



                }
        );

        add(usernameLabel);
        add(givenUsername);
        add(passwordLabel);
        add(givenPassword);
        add(repeatLabel);
        add(givenRepeat);
        add(registerButton);
        add(registerInfo);


        setSize(new Dimension(300,300));
        setVisible(true);
    }

}
