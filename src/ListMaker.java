import java.util.ArrayList;

public class ListMaker {
    private static ArrayList<String> myArrList = new ArrayList<>();

    public static void main(String[] args) {
        char choice;
        do {
            displayMenu();
            choice = SafeInput.getRegExString("Enter your choice: [AaDdPpQq]", "[AaDdPpQq]").toUpperCase().charAt(0);

            switch (choice) {
                case 'A':
                    addItem();
                    break;
                case 'D':
                    deleteItem();
                    break;
                case 'P':
                    printList();
                    break;
                case 'Q':
                    if (confirmQuit()) {
                        System.out.println("Exiting the program. Goodbye!");
                        System.exit(0);
                    }
                    break;
            }
        } while (true);
    }

    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("A - Add an item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit");
        System.out.println("------------------------");
        System.out.println("Current List: " + myArrList);
    }

    private static void addItem() {
        String newItem = SafeInput.getString("Enter the item to add: ");
        myArrList.add(newItem);
        System.out.println("Item added successfully!");
    }

    private static void deleteItem() {
        if (myArrList.isEmpty()) {
            System.out.println("The list is empty. No items to delete.");
            return;
        }

        System.out.println("Current List:");
        displayNumberedMenu();
        int itemNumber = SafeInput.getRangedInt("Enter the item number to delete: ", 1, myArrList.size());

        String deletedItem = myArrList.remove(itemNumber - 1);
        System.out.println("Item '" + deletedItem + "' deleted successfully!");
    }

    private static void printList() {
        if (myArrList.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("Current List: " + myArrList);
        }
    }

    private static boolean confirmQuit() {
        return SafeInput.getYNConfirm("Are you sure you want to quit? (Y/N): ");
    }

    private static void displayNumberedMenu() {
        for (int i = 0; i < myArrList.size(); i++) {
            System.out.println((i + 1) + ": " + myArrList.get(i));
        }
    }
}
