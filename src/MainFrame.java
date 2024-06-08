import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class MainFrame extends JFrame {


    JPanel panel;
    JButton income;
    JButton expense;
    JButton extract_of_account;
    JLabel label_text;


    MainFrame(){



        panel = new JPanel();
        panel.setBackground(new Color(240,200,140));
        panel.setBounds(0,0,400,400);
        panel.setLayout(null);

        label_text = new JLabel("Please select the action you want to perform.");
        label_text.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        label_text.setBounds(15, 30, 380, 30);
        panel.add(label_text);


        income = new JButton("Income");
        income.setBounds(50,120,100,30);

        expense = new JButton("Expense");
        expense.setBounds(250,120,100,30);

        extract_of_account = new JButton("Extract of Account");
        extract_of_account.setBounds(125,200,150,30);

        panel.add(income);
        panel.add(expense);
        panel.add(extract_of_account);

        this.setSize(400,400);
        this.setLayout(null);
        this.add(panel);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);


        income.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == income) {

                    new Income();
                }

            }
        });

        expense.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new Expense();
            }
        });

        extract_of_account.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {
                    new ExtractOfAccount();
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

    }
}
