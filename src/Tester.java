import javax.swing.*;
import java.awt.*;

public class Tester{
    JFrame  f= new JFrame("tester");
    void execute(){
        f.setSize(500,500);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.BLACK);
        f.getContentPane().setLayout(new GridLayout(3,4));
        f.setLocationRelativeTo(null);
        JTextField tf = new JTextField();
//        tf.setSize(20,50);
        f.getContentPane().add(tf);
        f.setVisible(true);
//        System.out.println(tf.getText());
        if(tf.getText().isEmpty())
            System.out.println("yeah baby....");
    }

    public static void main(String[] args) {
        Tester t =new Tester();
        t.execute();
    }
}
