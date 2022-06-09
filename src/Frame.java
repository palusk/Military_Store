import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Flow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener {
    public JButton Login;
    public JButton Register;
    public JButton Logout;

    public Frame(){
        super("Military shop");

        Login = new JButton("Login");
        Register = new JButton("Registration");

        Login.addActionListener(this);
        Register.addActionListener(this);
        setLayout(new FlowLayout());

        add(Login);
        add(Register);

        

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setPreferredSize(new Dimension(300, 300));
    pack();
    setVisible(true);
    }
}
