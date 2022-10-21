/**
 * Name:
 * Due Date:
 * Description: This is the interface that provides the variables to
 *              be used in the driver program
 * Version: 1.0
 */

public interface Configuration {
    int EMPTY = 0;
    int SHELF_SIZE = 5;
    String NAME = "";
    String TITLE = "Queue Program";

    String FILE_NAME = "stack.txt";
    String CUSTOMER_FILE = "CustFile.txt";
    String menu = "CMSV 265 TV Inventory Control Program\n\n" +
            "Menu Options\n" +
            "1 - Stock Shelves\n" +
            "2 - Fill Web Order\n" +
            "3 - Restock Return\n" +
            "4 - Restock Inventory\n" +
            "5 - Customer Update\n" +
            "6 - Customer Purchase\n" +
            "7 - Customer Checkout\n" +
            "8 - Display Inventory\n" +
            "9 - End program\n" +
            "Please enter the menu choice: ";
    String sub_menu = "Customer Update Menu Options\n" +
            "1 - Add a Customer\n" +
            "2 - Delete a Customer\n" +
            "3 - Change Customer Name\n" +
            "4 - Save Changes\n" +
            "5 - Display Customer List\n" +
            "6 - Return to Main\n" +
            "Please enter the menu choice: ";
    int STOCK_SHELVES = 1;
    int FILL_WEB_ORDER = 2;
    int RESTOCK_RETURN = 3;
    int RESTOCK_INVENTORY = 4;
    int DISPLAY_INVENTORY = 8;
    int END_PROGRAM = 9;
    int CUSTOMER_PURCHASE = 6;
    int CUSTOMER_UPDATE = 5;
    int CUSTOMER_CHECKOUT = 7;

    int ADD_CUSTOMER = 1;
    int DELETE_CUSTOMER = 2;
    int UPDATE_CUSTOMER = 3;
    int SAVE_DATA = 4;
    int DISPLAY_DATA = 5;
    int RETURN = 6;

    String restock5Message = "5 TV's were added to the inventory";
    String restock1Message = "1 TV was restocked";
    String fillFailMessage = "There's no TV left to fill the order";
    String fillSuccessMessage = "The following TV has been shipped:";
    String stockFailMessage = "There's not enough inventory to restock the shelves";
    String stockSuccessMessage = "The following TV's have been placed on the floor for sale";
    String goodByeMessage = "Thank you for using the program";
    String wrongChoiceMessage = "Invalid Choice. Please try again";
    String invalidChoiceMessage = "Invalid Menu Input";
    String emptyStackMessage = "The Inventory is empty";
    String endFailMessage = "There are still some customers waiting to be checked out\n" +
            "Please make sure all customers are checked out before ending the program";
    String emptyQueueMessage = "There are no customers in the queue";
    String numBoughtFailMessage = "Please provide an integer";
    String minBuyMessage = "You must buy atleast 1 TV";
    String maxBuyMessage = "There are not enough TV's in stock to fulfil your request";
    String nameEnquiryMessage = "Please enter your name: ";
    String accEnquiryMessage = "Please enter your account number (or none): ";
    String numBoughtEnquiryMessage = "Enter the number of TV's purchased: ";
    String copyrightStatement = "Copyright @2022 - Howard College All rights reserved: Unauthorized duplication prohibited";
    String CUSTOMER_FILE_ERROR = "Cannot open customer file";

    String saveWarning = "Warning - you have not saved any changes. Do you want to return to the main menu? (y or n) ";
    String invalidEntry = "Error invalid entry, please try again!";
    String yes = "y";
    String no = "n";
    String saveFilePrompt = "Please enter the name of the file to save";
    String newCustomerName = "Please enter the new customer name: ";
    String idNumPrompt = "Please enter the customer ID number: ";
    String noAcc = "ERROR - This account does not exist, please reenter!!";
    String updateCustTitle = "Change the name of a customer in the system";
    String delCustTitle = "Remove a customer from the system";
    String accExists = "ERROR - This account already exists, please reenter!!";
    String custNamePrompt = "Please enter the customer name: ";
    String addCustTitle = "Add a new customer to the system";
    String newIdPrompt = "Enter the new customer's account number: ";
    String newAccNo = "Enter the new customer's account number: ";
}
