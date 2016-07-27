package Testing;

import ShoppingList.*;

public class ShoppingListTest {
    
    private static ShoppingList list;

    public static void main(String[] args) {
        /* ShoppingList list = new ShoppingList("MyList");
        list.addCategories(new ShoppingListCategory[]{
            new ShoppingListCategory("Cat1"), 
            new ShoppingListCategory("Cat2"), 
            new ShoppingListCategory("Cat3")});
        for (ShoppingListCategory category : list.getCategories()) { // Seen that getCategories fails, have fixed
            System.out.println(category.getName());
        } */
        
        // As ShoppingList is very similar to ShoppingListCategory, I will use the tests for that as a template
        
        // The ShoppingListItem and ShoppingListCategory classes are all tested, so we can trust them
        
        // Make some empty ShoppingListCategories
        ShoppingListCategory[] cats1 = {
            new ShoppingListCategory("Category Set 1 - Category 1"),
            new ShoppingListCategory("Category Set 1 - Category 2"),
            new ShoppingListCategory("Category Set 1 - Category 3")
        };
        
        ShoppingListCategory[] cats2 = {
            new ShoppingListCategory("Category Set 2 - Category 1"),
            new ShoppingListCategory("Category Set 2 - Category 2"),
            new ShoppingListCategory("Category Set 2 - Category 3")
        };
        
        ShoppingListCategory cat1 = new ShoppingListCategory("Category 1");
        ShoppingListCategory cat2 = new ShoppingListCategory("Category 2");
        ShoppingListCategory cat3 = new ShoppingListCategory("Category 3");
        
        // Initailise the list
        list = new ShoppingList("List");
        printStuff();
        list.setName("New Name");
        printStuff();
        // That's all the basics
        // How about adding and removing ctegories
        list.addCategory(cat1);
        printStuff();
        list.addCategory(cat2);
        printStuff();
        list.addCategory(cat3);
        printStuff();
        list.addCategories(cats1);
        printStuff();
        list.addCategories(cats2);
        printStuff();
        // Let's remove the 3rd category
        list.removeCategory(list.getCategories()[2]); // I know this is dirty as it fails if the array is less than 3 long
        printStuff();
        // Removing an array of categories
        list.removeCategories(cats2);
        printStuff();
        // A category that doesn't exist
        list.removeCategory(new ShoppingListCategory("Test Cat"));
        printStuff();
        list.removeCategories(new ShoppingListCategory[]{
            new ShoppingListCategory("Test 1"), 
            new ShoppingListCategory("Test 2"), 
            new ShoppingListCategory("Test 3")
        });
        printStuff();
        // Let's try clearing
        list.clearList();
        printStuff();

        // The toString() method I made for ShoppignList is tested in printStuff(), so that's everything.
        
        // Everything looks good. Testing done!
        
        // Test error checking
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            
        }
        
        // Clear category out
        list.setName("New");
        list.clearList();
        
        try {
            list = new ShoppingList("");
        } catch (Exception e) {
            
        }
        
        printStuff();
        
        // So it seems that throwing the exception will mean that with or without the try catch block,
        // as an exception is thrown, the object reference is never saved to a variable, which is good
        
        try {
            list.setName("");
        } catch (Exception e) {
            
        }
        
        printStuff();
        
        // Same for that method. Good. Testing all done.
        
        // Yes, I did check that it works here as well.
    }
    
    private static void printStuff() {
        System.out.println("List Name: " + list.getName());
        System.out.println("Category Count: " + list.getCategoryCount());
        System.out.println(list.toString());
        System.out.println();
        for (ShoppingListCategory item : list.getCategories()) {
            System.out.println(item.toString());
        }
        System.out.println();
        System.out.println("------------------------------");
        System.out.println();
    }
}
