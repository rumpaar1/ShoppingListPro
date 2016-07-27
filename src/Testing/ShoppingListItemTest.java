package Testing;

import ShoppingList.*;

public class ShoppingListItemTest {

    private static ShoppingListItem item;
    
    public static void main(String[] args) {
        item = new ShoppingListItem("Eggs", "Carton", "Cartons");
        printStuff();
        item.setName("Yes");
        printStuff();
        item.setQuantity(5);
        printStuff();
        item.setQuantity(1);
        printStuff();
        item.setQuantity(2);
        printStuff();
        item.setQuantity(0);
        printStuff();
        item.setQuantity(6);
        printStuff();
        //item.setQuantity(-1);
        printStuff();
        //item.setQuantity(-2);
        printStuff();
        
        // First issue already, setting to -ve does nothing, will change so it sets to 0
        // Other than that, checked seems to be changing accordingly when quantity is changed
        
        item.setChecked(true);
        printStuff();
        item.setQuantity(6);
        printStuff();
        item.setChecked(false);
        printStuff();
        item.setChecked(true);
        printStuff();
        item.setQuantity(0);
        printStuff();
        
        // So good so far
        // All getters working fine, have yet to test the unit setters, but they're simple and probably fine
        // I'll test em now
        // All other setters are fine
        
        item.setPluralUnit("Boxes");
        printStuff();
        item.setSingularUnit("Box");
        printStuff();
        item.setQuantity(4);
        printStuff();
        item.setQuantity(0);
        printStuff();
        item.setQuantity(1);
        printStuff();
        
        // All done. Everything's working fine. Done!
        /* Authough I wonder if I should throw an exception instead. 
        As I intend to throw an error in the GUI When a -ve number is entered, 
        I think I should  throw an exception here, so the error checking is done
        in the logic class, which is reusable for other UIs. */
        
        // Lets test setting to a -ve number
        
        // Wait as exception seems to show in output before the setQuantity() that triggers it is called
        
        try {Thread.sleep(2000);} catch (Exception e) {}
        
        item.setQuantity(1);
        printStuff();
        item.setQuantity(0);
        printStuff();
//        item.setQuantity(-1);
//        printStuff();
//        item.setQuantity(-2);
//        printStuff(); // The testing below needs to actually run
        
        // That's working. Done finally!
        
        // Not yet. Let's try the new error checking for names and units
        
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            
        }
        
        // Clear category out
        item.setName("New");
        item.setSingularUnit("Unit");
        item.setPluralUnit("Units");
        
        try {
            item = new ShoppingListItem("", "", "");
        } catch (Exception e) {
            
        }
        
        printStuff();
        
        try {
            item = new ShoppingListItem("", "-", "-");
        } catch (Exception e) {
            
        }
        
        printStuff();
        
        try {
            item = new ShoppingListItem("-", "", "-");
        } catch (Exception e) {
            
        }
        
        printStuff();
        
        try {
            item = new ShoppingListItem("-", "-", "");
        } catch (Exception e) {
            
        }
        
        printStuff();
        
        // Same behavior as the ShoppingList and ShoppingListCategory
        // Good. Let's try the setter methods
        
        try {
            item.setName("");
        } catch (Exception e) {
            
        }
        
        printStuff();
        
        try {
            item.setSingularUnit("");
        } catch (Exception e) {
            
        }
        
        printStuff();
        
        try {
            item.setPluralUnit("");
        } catch (Exception e) {
            
        }
        
        printStuff();
        
        // Does the same for those methods as well. 
        // I know I have only run them in try catch blocks here, not outside them.
        // But I know that if I do that, it will throw an exception bringing the whole program down.
        // I don't need to test *that*. All my Exception Throwing Code is marked as such.
        // I just need to make sure I always try catch that. Which I will.
        // And that hopefully finally concludes testing for these classes. I hope. 
        // But I do want to test one more thing
        
        System.out.println("\n\n\n\n\n");
        
        item.setQuantity((int)Math.pow(2, 32));
        printStuff();
        
        item.setQuantity(item.getQuantity() + 3);
        printStuff();
        
        // So it throws an exception if you set it to higher than the max value it can store
        // However the way the method works is by taking in an int and setting quantity which is also an int to that value
        // So no risk of an exception being thrown there.
        // That exception is either because an int + int > max int value, or something like a long int > int max value
        // Being passed to something expecting an int. I don't think I can guard against that.
        // That is the maximum value for an int, it can't be passed anything bigger and have the code in setQuantity run. 
        // However, how other code that sets the quantity of an item through setQuantity() needs to be looked at
        // To see how it behaves. I'll do that now.
        
    }
    
    private static void printStuff() {
        System.out.println("Name: " + item.getName());
        System.out.println("Number: " + Integer.toString(item.getQuantity()));
        System.out.println("Singular Unit: " + item.getSingularUnit());
        System.out.println("Plural Unit: " + item.getPluralUnit());
        System.out.println("Unit: " + item.getUnit());
        System.out.println("Stuff: " + item.toString());
        System.out.println("Checked: " + Boolean.toString(item.isChecked()));
        System.out.println();
    }
    
    public static void printStuff(ShoppingListItem item) {
        System.out.println("Name: " + item.getName());
        System.out.println("Number: " + Integer.toString(item.getQuantity()));
        System.out.println("Singular Unit: " + item.getSingularUnit());
        System.out.println("Plural Unit: " + item.getPluralUnit());
        System.out.println("Unit: " + item.getUnit());
        System.out.println("Stuff: " + item.toString());
        System.out.println("Checked: " + Boolean.toString(item.isChecked()));
        System.out.println();
    }
}
