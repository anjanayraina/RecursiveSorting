/**
 * Name:
 * Due Date:
 * Description: This is a program that allows users to purchase TVs
 *              from the store
 * Version: 1.0
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Driver implements Configuration{

    public static int readFile(Stack stack){
        int lastID = EMPTY;

        File file = new File("C:\\Users\\anjan\\IdeaProjects\\RecursiveSorting\\src\\stack.txt");
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNext()){
                String line = sc.nextLine();
                lastID = Integer.parseInt(line.split("-")[1]);
                TV tv = new TV(line);
                stack.push(tv);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lastID;
    }

    private static void displayInventory(Stack stack){
        if(stack.empty()){
            System.out.println(emptyStackMessage);
        }else{
            System.out.println("The following "+stack.size()+" TV's are left in inventory");
            for(Object tv: stack){
                tv = (TV) tv;
                System.out.println(tv);
            }
        }
    }

    private static void startInformation(){
        System.out.println(NAME);
        System.out.println(copyrightStatement);
        System.out.println(TITLE);
    }

    private static void readCustomerFile(CustomerData list){
        File file = new File(CUSTOMER_FILE);
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNext()){
                Customer c = new Customer(sc.nextLine(), sc.nextLine());
                list.addCustomer(c);
            }

        } catch (FileNotFoundException e) {
            System.out.println(CUSTOMER_FILE_ERROR);
        }
    }

    private static void menu(Stack stack, LinkedList queue){
        int lastID = readFile(stack);
        int option;
        CustomerData data = new CustomerData();
        readCustomerFile(data);
        boolean done = false;
        TV tv;
        Customer c;
        Scanner sc = new Scanner(System.in);
        boolean added = false;
        while(!done){
            try{
                System.out.print(menu);
                option = Integer.parseInt(sc.nextLine());
                switch (option){
                    case STOCK_SHELVES:
                        if(stack.size() < SHELF_SIZE){
                            System.out.println(stockFailMessage);
                        }else{
                            System.out.println(stockSuccessMessage);
                            for(int i = EMPTY; i < SHELF_SIZE; i++){
                                System.out.println(stack.pop());
                            }
                            System.out.println("There are "+stack.size()+" TV's left in inventory");
                        }
                        break;
                    case FILL_WEB_ORDER:
                        if(stack.empty()){
                            System.out.println(fillFailMessage);
                        }else{
                            System.out.println(fillSuccessMessage);
                            System.out.println(stack.pop());
                            System.out.println("There are "+stack.size()+" TV's left in inventory");
                        }
                        break;
                    case RESTOCK_RETURN:
                        lastID++;
                        tv = new TV("ABC12-"+lastID);
                        stack.push(tv);
                        System.out.println(restock1Message);
                        break;
                    case RESTOCK_INVENTORY:
                        for(int i = EMPTY; i < SHELF_SIZE; i++) {
                            lastID++;
                            TV t = new TV("ABC12-" + lastID);
                            stack.push(t);
                        }
                        System.out.println(restock5Message);
                        break;
                    case DISPLAY_INVENTORY:
                        displayInventory(stack);
                        break;
                    case END_PROGRAM:
                        if(!queue.isEmpty()){
                            System.out.println(endFailMessage);
                        }else{
                            if(added){
                                System.out.print(saveWarning);
                                String input = sc.nextLine();
                                while(!input.equalsIgnoreCase(yes) && !input.equalsIgnoreCase(no)){
                                    System.out.println(invalidEntry);
                                    System.out.print(saveWarning);
                                    input = sc.nextLine();
                                }
                                if(input.equalsIgnoreCase("n"))
                                    done = true;
                            }else{
                                done = true;
                            }
                            if(done){
                                displayInventory(stack);
                                System.out.println(goodByeMessage);
                            }
                        }
                        break;
                    case CUSTOMER_PURCHASE:
                        if(stack.empty()){
                            System.out.println(emptyStackMessage);
                        }else{
                            data.display();
                            Customer cust;
                            System.out.print(accEnquiryMessage);
                            String accNo = sc.nextLine();

                            if(accNo.equalsIgnoreCase("none")){
                                System.out.print(newAccNo);
                                accNo = sc.nextLine();
                                while(data.findCustomer(accNo) != null){
                                    System.out.println(accExists+"\n");
                                    System.out.print(newIdPrompt);
                                    accNo = sc.nextLine();
                                }
                            }

                            int numPurchased = EMPTY;
                            String name ="";
                            if(data.findCustomer(accNo) == null){
                                System.out.print(nameEnquiryMessage);
                                name = sc.nextLine();
                                cust = new Customer(name, accNo);
                                data.addCustomer(cust);
                                added = true;
                            }else{
                                name = data.findCustomer(accNo).getName();
                            }

                            while(numPurchased <= EMPTY|| numPurchased >= stack.size()){
                                System.out.print(numBoughtEnquiryMessage);
                                try{
                                    numPurchased = Integer.parseInt(sc.nextLine());
                                    if(numPurchased <= EMPTY){
                                        System.out.println(minBuyMessage);
                                    }else if(numPurchased > stack.size()){
                                        System.out.println(maxBuyMessage);
                                    }
                                }catch (Exception e){
                                    System.out.println(numBoughtFailMessage);
                                }
                            }
                            ArrayList bought = new ArrayList();
                            System.out.println("Customer "+name+" purchased the following TVs:");
                            for(int i = EMPTY; i < numPurchased; i++){
                                tv = (TV) stack.pop();
                                System.out.println(tv);
                                bought.add(tv.getTvId());
                            }
                            c = new Customer(name, accNo, numPurchased, bought);
                            queue.add(c);
                            System.out.println("There are "+stack.size()+" TV's left in inventory");
                        }
                        break;
                    case CUSTOMER_CHECKOUT:
                        if(queue.isEmpty()){
                            System.out.println(emptyQueueMessage);
                        }else{
                            c = (Customer) queue.remove(EMPTY);
                            System.out.println(c);
                            System.out.println("\nThere are "+queue.size()+" customers left to check out");
                        }
                        break;
                    case CUSTOMER_UPDATE:
                        customerUpdate(data, added);
                        added = false;
                    default:
                        System.out.println(wrongChoiceMessage);
                }
            }catch (Exception e){
                System.out.println(invalidChoiceMessage);
            }
        }
    }

    private static void customerUpdate(CustomerData data, boolean added) {

        Scanner sc = new Scanner(System.in);
        boolean done = false;
        boolean saved = !added;
        int option;
        String name, accNo, input;
        Customer c;
        while(!done){
            try{
                System.out.print(sub_menu);
                option = Integer.parseInt(sc.nextLine());
                switch (option){
                    case ADD_CUSTOMER:
                        System.out.println(addCustTitle);
                        System.out.print(custNamePrompt);
                        name = sc.nextLine();
                        System.out.print(idNumPrompt);
                        accNo = sc.nextLine();
                        while(data.findCustomer(accNo) != null){
                            System.out.println(accExists+"\n");
                            System.out.print(idNumPrompt);
                            accNo = sc.nextLine();
                        }
                        c = new Customer(name, accNo);
                        data.addCustomer(c);
                        saved = false;
                        break;
                    case DELETE_CUSTOMER:
                        System.out.println(delCustTitle);
                        System.out.print(idNumPrompt);
                        accNo = sc.nextLine();
                        while(data.findCustomer(accNo) == null){
                            System.out.println(noAcc+"\n");
                            System.out.print(idNumPrompt);
                            accNo = sc.nextLine();
                        }
                        data.removeCustomer(accNo);
                        saved = false;
                        break;
                    case UPDATE_CUSTOMER:
                        System.out.println(updateCustTitle);
                        System.out.print(idNumPrompt);
                        accNo = sc.nextLine();
                        while(data.findCustomer(accNo) == null){
                            System.out.println(noAcc+"\n");
                            System.out.print(idNumPrompt);
                            accNo = sc.nextLine();
                        }
                        System.out.print(newCustomerName);
                        name = sc.nextLine();
                        data.updateCustomer(accNo, name);
                        saved = false;
                        break;
                    case SAVE_DATA:
                        System.out.println(saveFilePrompt);
                        input = sc.nextLine();
                        File file = new File(input);
                        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                        for(Customer cu: data){
                            writer.write(cu.getName());
                            writer.newLine();
                            writer.write(cu.getAcNo());
                            writer.newLine();
                        }
                        writer.close();
                        saved = true;
                        break;
                    case DISPLAY_DATA:
                        data.display();
                        break;
                    case RETURN:
                        data.display();
                        if(!saved){
                            System.out.print(saveWarning);
                            input = sc.nextLine();
                            while(!input.equalsIgnoreCase(yes) && !input.equalsIgnoreCase(no)){
                                System.out.println(invalidEntry);
                                System.out.print(saveWarning);
                                input = sc.nextLine();
                            }
                            if(input.equalsIgnoreCase("y"))
                                done = true;
                        }else{
                            done = true;
                        }
                        break;
                    default:
                        System.out.println(wrongChoiceMessage);
                }
            }catch (Exception e){
                System.out.println(invalidChoiceMessage);
            }
        }
    }

    public static void main(String[] args) {
        startInformation();
        Stack stack = new Stack();
        LinkedList queue = new LinkedList();
        menu(stack, queue);
    }
}
