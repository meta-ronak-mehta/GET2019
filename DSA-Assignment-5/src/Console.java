import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Console {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {

        File filename = new File("src/input.json");
        JSONParser parser = new JSONParser();
        JSONObject obj = null;
        BinarySearchTree<String> bst = null;
        try {
            obj = (JSONObject) parser.parse(new FileReader(filename));
            bst = new BinarySearchTree<String>(obj);
        } catch (FileNotFoundException e) {
            MyLogFile.writeToFile("File Not Found " + new Date());
            e.printStackTrace();
        } catch (IOException e) {
            MyLogFile.writeToFile("File I/O Exception " + new Date());
            e.printStackTrace();
        } catch (ParseException e) {
            MyLogFile.writeToFile("File Parsing Exception " + new Date());
            e.printStackTrace();
        }
        int choice = 0;
        while (choice != 9) {
            System.out.println("1 Add values to tree");
            System.out.println("2 delete values to tree");
            System.out.println("3 Search value by Key");
            System.out.println("4 get sorted tree data");
            System.out.println("5 get sorted tree data between 2 Key");
            System.out.println("9 EXIT!!!");
            choice = sc.nextInt();

            switch (choice) {

            case 1:
                sc.nextLine();
                System.out.println("key (String): ");
                String key = sc.nextLine();
                System.out.println("value (int): ");
                String value = sc.nextLine();
                try {
                    bst.addNode(key, value);
                } catch (AssertionError e) {
                    System.err.println("Error: " + e.getMessage());
                    MyLogFile.writeToFile(e.getMessage() + " " + new Date());
                }
                break;
            case 2:
                System.out.println("key to be deleted: ");
                sc.nextLine();
                key = sc.nextLine();
                try {
                    bst.deleteNode(key);
                } catch (AssertionError e) {
                    System.err.println("Error: " + e.getMessage());
                    MyLogFile.writeToFile(e.getMessage() + " " + new Date());
                }
                break;
            case 3:
                sc.nextLine();
                System.out.println("Key: ");
                key = sc.nextLine();
                value = bst.getValue(key);
                if (value != null)
                    System.out.println("Key: " + key + " Value: " + value);
                else
                    System.out.println("Key Not Found!!!");
                break;
            case 4:
                List<Data<String>> sortedList = bst.sortedOrder();
                for (Data<String> data : sortedList)
                    System.out.println(data);
                break;
            case 5:
                sc.nextLine();
                System.out.println("Key 1: ");
                String key1 = sc.nextLine();
                System.out.println("Key 2: ");
                String key2 = sc.nextLine();
                List<Data<String>> dataList = new ArrayList<Data<String>>();
                try {
                    dataList = bst.sortBetweenTwoKeyValue(key1, key2);
                } catch (AssertionError e) {
                    System.err.println("Error: " + e.getMessage());
                    MyLogFile.writeToFile(e.getMessage() + " " + new Date());
                }
                for (Data<String> data : dataList)
                    System.out.println(data);
                break;
            case 9:
                sc.close();
            default:
                System.out.println("Enter a valid choice");
            }
        }

    }
}
