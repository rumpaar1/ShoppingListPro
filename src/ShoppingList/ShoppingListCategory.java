/*
 * Copyright (C) 2016 Aaron Rumpler
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ShoppingList;
import java.util.ArrayList;

/** A class for shopping list categories
 *
 * @author Aaron Rumpler
 */
public class ShoppingListCategory {
    /** The name of the category */
    private String name;
    /** The array list of ShoppingListItems */
    private ArrayList<ShoppingListItem> items = new ArrayList<ShoppingListItem>();
    /** The recommended length to trim strings from this class down to */
    public static final int trimLength = 20;
    
    /** Constructor for this class 
     * Name must not be blank.
     * If it is, it will throw an Exception.
     * Please be prepared to catch it.
     * If you receive an exception, discard this object, and don't use it.
     * 
     * @param name Name of the category
     */
    public ShoppingListCategory(String name) throws IllegalArgumentException {
        if (name.isEmpty()) {
            // Set the name in case the caller uses the object
            this.name = "Unnamed Category";
            // Throw exception
            throw new IllegalArgumentException("Name must not be blank.");
        } else {
            this.name = name;
        }
    }
    
    /** Sets the name of this category.
     * Throws an exception if name is blank.
     * 
     * @param name The new name
     */
    public void setName(String name) throws IllegalArgumentException {
        if (name.isEmpty()) {
            // Throw exception as name is empty
            // Object already has name, so leave it at that
            throw new IllegalArgumentException("Name must not be blank.");
        } else {
            this.name = name;
        }
    }
    
    /** Gets the name of this category
     * 
     * @return The name of this category
     */
    public String getName() {
        return this.name;
    }
    
    /** Adds an item to this category
     * 
     * @param item The item to add
     */
    public void addItem(ShoppingListItem item) {
        if (!this.items.contains(item)) {
            this.items.add(item); // Only add an item if it is not already in the list
            //else do nothing as the item is already in the list
        }
    }
    
    /** Adds multiple items to this category
     * 
     * @param items The items to add
     */
    public void addItems(ShoppingListItem[] items) {
        for (ShoppingListItem item : items) {
            this.addItem(item); // Fairly self explanatory
            // I am calling my addItem method instead of doing it directly so I can change how adding is done in one place
        }
    }
    
    /** Returns an array of the items in this category
     * 
     * @return The items in this category
     */
    public ShoppingListItem[] getItems() {
        return this.items.toArray(new ShoppingListItem[0]); // This can't fail as items can only hold ShoppingListItems
    }
    
    /* What else should I add?
    How about:
    - Removing an item - Done
    - Removing multiple items - Done
    - Getting item count - Done
    - Clearing the category - Done
    That seems like everything. */
    
    /** Removes the item from this category
     * 
     * @param item Item to remove
     */
    public void removeItem(ShoppingListItem item) {
        // Remove method only removes the first occurance
        // I'm going to have to work arround that
        // Might have a look to see if we could prevent multiple occurances
        //      of the same item being added in the first place as well - Done
        // Good to cover this stuff multiple times, just in case :)
        while (this.items.contains(item)) {
            this.items.remove(item); // This will keep going until all of them are gone
        }
    }
    
    /** Removed the provides array of items from the category
     * 
     * @param items Items to remove
     */
    public void removeItems(ShoppingListItem[] items) {
        for (ShoppingListItem item: items) {
            this.removeItem(item); // Again, does what it says on the tin and is fairly self explanatory
        }
    }
    
    /** Gets the number of items in the category
     * 
     * @return The number of items in the category
     */
    public int getItemCount() {
        return this.items.size(); // Self Explanatory
    }
    
    /** Clears the category */
    public void clearCategory() {
        this.items.clear(); // Self Explanatory
    }
    
    // I think that's everything, I'm going to commit and push now. :)
    
    // toString() method
    
    /** Returns a String detailing the name of, and number of items in this category
     * 
     * @return A String detailing the name of, and number of items in this category, with name trimmed to a recommended length
     */
    public String toString() {
        // Get these now
        String name = this.getName();
        name = util.StringUtil.trim(name, trimLength);
        String itemUnit;
        int itemCount = this.getItemCount();
        // Determine whether to use Item or Items
        if (itemCount == 1) {
            itemUnit = "Item";
        } else {
            itemUnit = "Items";
        }
        // Return our string
        return name + ": " + Integer.toString(itemCount) + " " + itemUnit;
    }
}
