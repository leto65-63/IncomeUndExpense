import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Expense extends JFrame {

    JPanel panel = new JPanel();

    JLabel expense_type = new JLabel();

    JLabel expense_amount = new JLabel();

    JComboBox expense_type_combo = new JComboBox();

    JTextField expense_amount_field = new JTextField();

    JButton button_add = new JButton();

    public Expense() {

        expense_type.setText("EXPENSE TYPE :");
        panel.add(expense_type);
        expense_type.setBounds(30,100,120,20);

        expense_amount.setText("EXPENSE AMOUNT :");
        panel.add(expense_amount);
        expense_amount.setBounds(30,150,150,20);

        panel.add(expense_type_combo);
        expense_type_combo.setBounds(200,100,150,20);

        expense_type_combo.addItem("RENT");
        expense_type_combo.addItem("KITCHEN DRAIN");
        expense_type_combo.addItem("TRANSPORTATION");
        expense_type_combo.addItem("EDUCATION");
        expense_type_combo.addItem("UTILITY");
        expense_type_combo.addItem("ANOTHER");

        panel.add(expense_amount_field);
        expense_amount_field.setBounds(200,150,150,20);

        button_add.setText("ADD");
        button_add.setBounds(150,250,100,20);
        panel.add(button_add);


        panel.setLayout(null);
        panel.setBackground(Color.ORANGE);
        this.add(panel);
        this.setTitle("Expense");
        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);


        button_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == button_add) {



                    try ( BufferedWriter writer = new BufferedWriter(new FileWriter("expense.txt",true))){


                        writer.write(expense_type_combo.getSelectedItem().toString()+","+expense_amount_field.getText()+"\n");


                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }


                }

            }
        });

    }
}
