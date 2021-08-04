import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GUIModelV4 extends JPanel {
boolean flag = false;
Color c = new Color(215, 97, 255);
int[][] d;
    JButton b;
    JButton b1;
    JButton b2;
JTextField[][] a;
JPanel[][] p2 = new JPanel[3][3];
SwingWorker<Void,Void> temp;

GUIModelV4(){
    d= new int[][]{{3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}};
    setBackground(Color.black);
    setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
    JPanel p = new JPanel();
    p.setBackground(Color.BLACK);
    p.setLayout(new GridLayout(3,3,10,10));
    p.setBorder(new EmptyBorder(new Insets(20,20,20,20)));
    a =new JTextField[9][9];
    for(int i=0;i<3;i++)
        for(int j=0;j<3;j++) {
            p2[i][j] = new JPanel();
            p2[i][j].setBackground(Color.BLACK);
            p2[i][j].setLayout(new GridLayout(3,3,3,3));
            this.add(p2[i][j]);
        }
    for(int i=0;i<9;i++)
    {
        for(int j=0;j<9;j++)
        {
            if(d[i][j]!=0)
                a[i][j]=new JTextField(String.valueOf(d[i][j]));
            else
                a[i][j]=new JTextField();
            a[i][j].setEditable(flag);
            a[i][j].setBackground(Color.white);
            a[i][j].setOpaque(true);
            a[i][j].setFont(new Font("MV Boli",Font.BOLD,15));
            a[i][j].setHorizontalAlignment(JTextField.CENTER);
//                a[i][j].setVerticalAlignment(JTextField.CENTER);
            a[i][j].setBorder(BorderFactory.createLineBorder(c,3));
            p2[checker(i)][checker(j)].add(a[i][j]);
        }
    }
    b = new JButton("Solve");
    b.setBackground(new Color(0, 255, 187));
    b.setForeground(Color.black);
    b.setFont(new Font("Comic Sans MS",Font.BOLD,15));
//    b.addActionListener(new GUIModelV3.NewAction());
    b.setSize(30,80);
    b.setFocusable(false);
    b.setHorizontalAlignment(JButton.RIGHT);

    b1=new JButton("Reset");
    b1.setFocusable(false);
//    b1.addActionListener(new GUIModelV3.NewAction());
    b1.setBackground(new Color(47, 248, 118));
    b1.setFont(new Font("Comic Sans MS",Font.BOLD,15));
    b1.setSize(30,80);
    b1.setForeground(new Color(0,0,0));
    b2 =new JButton("Modify");
    b2.setFocusable(false);
//    b2.addActionListener(new GUIModelV3.NewAction());
    b2.setBackground(new Color(182, 255, 64));
    b2.setFont(new Font("Comic Sans MS",Font.BOLD,15));
    b2.setSize(30,80);
    b2.setForeground(new Color(0,0,0));

    JPanel p1 = new JPanel();
    p1.setLayout(new BoxLayout(p1,BoxLayout.LINE_AXIS));
    p1.setBorder(new EmptyBorder(new Insets(0,0,20,0)));
    p1.setBackground(Color.BLACK);
    p1.add(b);
    p1.add(Box.createRigidArea(new Dimension(100,0)));
    p1.add(b2);
    p1.add(Box.createRigidArea(new Dimension(100,0)));
    p1.add(b1);
    add(p);
    add(p1);
    add(Box.createRigidArea(new Dimension(20,0)));
    setVisible(true);
}
//    public void paintComponent(Graphics g){
//    super.paintComponent(g);
//
//    }
    public int checker(int num){
        if(num>=6&&num<9)
            return 2;
        else if(num>=3&&num<6)
            return 1;
        else
            return 0;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame j = new JFrame("Sudoku Solver");
                j.setSize(500,500);
                j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                j.setContentPane(new GUIModelV4());
                j.setVisible(true);
            }
        });
    }
}
