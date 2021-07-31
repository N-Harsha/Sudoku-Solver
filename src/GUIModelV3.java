import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIModelV3 {
    boolean flag = false;
    JFrame frame;
    JButton b;
    JButton b1;
    JButton b2;
    JTextField[][] a=new JTextField[9][9];
    JPanel[][] p2 = new JPanel[3][3];
    Color c = new Color(215, 97, 255);
    int[][] d={{3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}};
    public int checker(int num){
        if(num>=6&&num<9)
            return 2;
        else if(num>=3&&num<6)
            return 1;
        else
            return 0;
    }
    void execute(){
        frame=new JFrame("Sudoku Solver");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));

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
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                p.add(p2[i][j]);
        b = new JButton("Solve");
        b.setBackground(new Color(0, 255, 187));
        b.setForeground(Color.black);
        b.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        b.addActionListener(new NewAction());
        b.setSize(30,80);
        b.setFocusable(false);
        b.setHorizontalAlignment(JButton.RIGHT);

        b1=new JButton("Reset");
        b1.setFocusable(false);
        b1.addActionListener(new NewAction());
        b1.setBackground(new Color(47, 248, 118));
        b1.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        b1.setSize(30,80);
        b1.setForeground(new Color(0,0,0));
        b2 =new JButton("Modify");
        b2.setFocusable(false);
        b2.addActionListener(new NewAction());
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
        frame.add(p);
        frame.add(p1);
        frame.add(Box.createRigidArea(new Dimension(20,0)));
        frame.setVisible(true);
    }
        static class SudokuSolver{
        static int N=9;
        Color c = new Color(0, 179, 255);
        boolean is_valid(JTextField[][] a,int row,int col,int num){
        for(int i=0;i<9;i++) {
            int x;
            if(a[row][i].getText().isEmpty())
                x=0;
            else
                x=Integer.parseInt(a[row][i].getText());
            if (x==num)
                return false;
        }
            for(int i=0;i<9;i++) {
                int x;
                if (a[i][col].getText().isEmpty())
                    x=0;
                else
                    x=Integer.parseInt(a[i][col].getText());
                if (x==num)
                    return false;
            }
        for(int i=row-row%3;i<row-row%3+3;i++)
        {
            for(int j=col-col%3;j<col-col%3+3;j++)
            {
                int x;
                if (a[i][j].getText().isEmpty())
                    x=0;
                else
                    x= Integer.parseInt(a[i][j].getText());
                if(x==num)
                    return false;
            }
        }
        return true;
        }
        boolean solver(JTextField[][] a,int row, int col){
        if(row==N-1&&col==N)
            return true;
        if(col==N)
        {
            row++;
            col=0;
        }
            a[row][col].setBorder(BorderFactory.createLineBorder(c,4));
            int x;
        if(a[row][col].getText().isEmpty())
            x=0;
        else
            x=Integer.parseInt(a[row][col].getText());
        if(x!=0) {
            boolean b = solver(a, row, col + 1);
            if(!b)
                a[row][col].setBorder(BorderFactory.createLineBorder(new Color(215, 97, 255),3));
            else
                a[row][col].setBorder(BorderFactory.createLineBorder(c,4));
            return b;
        }
//        else{
            for(int i=1;i<10;i++)
            {
                if(is_valid(a,row,col,i)) {
                    a[row][col].setText(String.valueOf(i));
                    if(solver(a,row,col+1))
                        return true;
                }
                a[row][col].setText("");
            }
//        }
            a[row][col].setBorder(BorderFactory.createLineBorder(new Color(215, 97, 255),3));
            return false;
        }
}
        class NewAction implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
            if(e.getSource()==b2) {
                UIManager.put("Button.disabledText", new Color(34, 155, 194, 255));

                if(!flag) {
                    b.setEnabled(flag);
                    b1.setEnabled(flag);
                    flag=!flag;
                    b2.setText("Confirm");
                    for(int i=0;i<9;i++)
                        for(int j=0;j<9;j++)
                            a[i][j].setEditable(flag);
                }
                else {
                    b2.setText("Modify");
                    b.setEnabled(flag);
                    b1.setEnabled(flag);
                    flag=!flag;
                    for(int i=0;i<9;i++){
                        for(int j=0;j<9;j++) {
                            a[i][j].setEditable(flag);
                            if(a[i][j].getText().isEmpty())
                                d[i][j]=0;
                            else
                            d[i][j]=Integer.parseInt(a[i][j].getText());
                        }}
                }

            }
            else if(e.getSource()==b)
            {
            SudokuSolver s = new SudokuSolver();
            if(s.solver(a,0,0))
                System.out.println("Success...!");
            else {
                System.out.println("WTF.......!");
                JOptionPane.showMessageDialog(frame,"This Sudoku puzzle Cannot Be Solved\nPlease try another one");
            }
        }
            else if(e.getSource()==b1)
            {
                c=new Color(215, 97, 255);
                for(int i=0;i<9;i++){
                    for(int j=0;j<9;j++)
                    {
                        a[i][j].setBorder(BorderFactory.createLineBorder(c,3));
                        if(d[i][j]==0)
                            a[i][j].setText("");
                        else
                            a[i][j].setText(String.valueOf(d[i][j]));

                    }
                }
            }
}

}
    public static void main(String[] args) {
        GUIModelV3 w = new GUIModelV3();

        w.execute();
    }
}
