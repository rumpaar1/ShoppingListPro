package Testing;

import ShoppingList.*;

public class ShoppingListCategoryTest {
    
    private static ShoppingListCategory category;

    public static void main(String[] args) {
        // The ShoppingListItem class is all tested, so we can trust that
        
        // Make some ShoppingListItems
        ShoppingListItem[] items1 = {
            new ShoppingListItem("List 1 Item 1", "Item", "Items"),
            new ShoppingListItem("List 1 Item 2", "Item", "Items"),
            new ShoppingListItem("List 1 Item 3", "Item", "Items")
        };
        
        ShoppingListItem[] items2 = {
            new ShoppingListItem("List 2 Item 1", "Item", "Items"),
            new ShoppingListItem("List 2 Item 2", "Item", "Items"),
            new ShoppingListItem("List 2 Item 3", "Item", "Items")
        };
        
        ShoppingListItem item1 = new ShoppingListItem("Item 1", "Item", "Items");
        ShoppingListItem item2 = new ShoppingListItem("Item 2", "Item", "Items");
        ShoppingListItem item3 = new ShoppingListItem("Item 3", "Item", "Items");
        
        // Initailise the category
        category = new ShoppingListCategory("Category");
        printStuff();
        category.setName("New Name");
        printStuff();
        // That's all the basics
        // How about adding and removing items
        category.addItem(item3);
        printStuff();
        category.addItem(item2);
        printStuff();
        category.addItem(item1);
        printStuff();
        category.addItems(items2);
        printStuff();
        category.addItems(items1);
        printStuff();
        // That's working fine
        // Let's remove the 3rd item
        category.removeItem(category.getItems()[2]); // I know this is dirty as it fails if the array is less than 3 long
        printStuff();
        // Cool, working
        category.removeItems(items2);
        printStuff();
        // Same
        // Let's try clearing
        category.clearCategory();
        printStuff();
        // Working as well
        
        // That's everything
        // Should I add a toString() method?
        // OK, ShoppingListItem has a toString() method that is tested.
        // I'll add one here
        // Will need to deal with singular
        // Done
        // Everything looks OK
        // Testing is now done
        System.out.println("\n----------\n");
        // Except I forgot something
        category.addItems(items1);
        category.addItems(items2);
        printStuff();
        // Let's try removing non-existant items
        category.removeItem(new ShoppingListItem("Bag", "Bag", "Bags"));
        printStuff();
        category.removeItems(new ShoppingListItem[]{
            new ShoppingListItem("Bagular", "Bag", "Baggage"),
            new ShoppingListItem("Double Bag", "Baggy", "Bagg")
        });
        printStuff();
        
        // No crashes, the code silently ignores the command to remove non-added items. Good.
        
        // Test error checking
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            
        }
        
        // Clear category out
        category.setName("New");
        category.clearCategory();
        
        try {
            category = new ShoppingListCategory("");
        } catch (Exception e) {
            
        }
        
        printStuff();
        
        // So it seems that throwing the exception will mean that with or without the try catch block,
        // as an exception is thrown, the object reference is never saved to a variable, which is good
        
        try {
            category.setName("");
        } catch (Exception e) {
            
        }
        
        printStuff();
        
        // Same for that method. Good. Testing all done.
    }
    
    private static void printStuff() {
        System.out.println("Category Name: " + category.getName());
        System.out.println("Item Count: " + category.getItemCount());
        System.out.println(category.toString());
        System.out.println();
        for (ShoppingListItem item : category.getItems()) {
            ShoppingListItemTest.printStuff(item);
        }
        System.out.println();
        System.out.println("------------------------------");
        System.out.println();
    }
    
}
