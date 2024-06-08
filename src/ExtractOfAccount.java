import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ExtractOfAccount {

    ExtractOfAccount() throws FileNotFoundException {

        String line1 ;
        String line2 ;
        int total_income = 0;

        String [] array1;
        String [] array2;

        int rent = 0;
        int kitchen_drain = 0;
        int transportation = 0;
        int education = 0;
        int utility = 0;
        int another = 0;

        int total_expense = 0;

        try(Scanner reader1 = new Scanner(new FileReader("income.txt"));
            Scanner reader2 = new Scanner(new FileReader("expense.txt"))){


            while(reader1.hasNext()){

                line1 = reader1.nextLine();

                array1 = line1.split(",");

                total_income += Integer.parseInt(array1[1]);

            }
            while(reader2.hasNext()){

                line2 = reader2.nextLine();

                array2 = line2.split(",");

                if (array2[0].equals("RENT")){

                    rent += Integer.parseInt(array2[1]);
                }

                if (array2[0].equals("KITCHEN DRAIN")){

                    kitchen_drain += Integer.parseInt(array2[1]);
                }

                if (array2[0].equals("TRANSPORTATION")){

                    transportation += Integer.parseInt(array2[1]);
                }

                if (array2[0].equals("EDUCATION")){

                    education += Integer.parseInt(array2[1]);
                }

                if (array2[0].equals("UTILITY")){

                    utility += Integer.parseInt(array2[1]);
                }

                if (array2[0].equals("ANOTHER")){

                    another += Integer.parseInt(array2[1]);
                }


            }

            total_expense = rent + kitchen_drain + transportation + education + utility+ another;

            int total = total_income - total_expense;

            String message = "TOTAL INCOME : "+ total_income+"\n"
                    + "TOTAL EXPENSE : "+ total_expense+"\n"
                    + "Rent : "+ rent+"\n"
                    + "Kitchen Drain : "+ kitchen_drain+"\n"
                    + "Transportation : "+ transportation+"\n"
                    + "Education : "+ education+"\n"
                    + "Utility : "+ utility+"\n"
                    + "Another : "+ another+"\n"

                    +"LATEST SITUATION :"+total;


            JOptionPane.showMessageDialog(null,message);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

