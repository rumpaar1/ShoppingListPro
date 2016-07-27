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

// This is going to be fairly similar to ShoppingListCategory, so I'll use that as a template
// Still have some proofreading to do

/** A class for a shopping list
 *
 * @author Aaron Rumpler
 */
public class ShoppingList {
    /** The name of the list */
    private String name;
    /** The array list of ShoppingListCategories */
    private ArrayList<ShoppingListCategory> categories = new ArrayList<ShoppingListCategory>();
    /** The recommended length to trim strings from this class down to */
    public static final int trimLength = 20;
    
    /** Constructor for this class 
     * 
     * @param name Name of the list
     */
    public ShoppingList(String name) throws IllegalArgumentException {
        if (name.isEmpty()) {
            // Set the name in case the caller uses the object
            this.name = "Unnamed List";
            // Throw exception
            throw new IllegalArgumentException("Name must not be blank.");
        } else {
            this.name = name;
        }
    }
    
    /** Sets the name of this list
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
    
    /** Gets the name of this list
     * 
     * @return The name of this category
     */
    public String getName() {
        return this.name;
    }
    
    /** Adds an category to this list
     * 
     * @param category The category to add
     */
    public void addCategory(ShoppingListCategory category) {
        if (!this.categories.contains(category)) {
            this.categories.add(category); // Only add an category if it is not already in the list
            //else do nothing as the category is already in the list
        }
    }
    
    /** Adds multiple categories to this list
     * 
     * @param categories The categories to add
     */
    public void addCategories(ShoppingListCategory[] categories) {
        for (ShoppingListCategory category: categories) {
            this.addCategory(category); // Fairly self explanatory
            // I am calling my addCategory method instead of doing it directly so I can change how adding is done in one place
        }
    }
    
    /** Returns an array of the categories in this list
     * 
     * @return The categories in this list
     */
    public ShoppingListCategory[] getCategories() {
        // return (ShoppingListCategory[])this.categories.toArray(); 
        // This can't fail as categories can only hold ShoppingListCategories, or so I thought
        // Yeah, Java won't cast an Object[] to a ShoppingListCategory[] even if the Object[] is filled solely woth ShoppingListCategory
        return this.categories.toArray(new ShoppingListCategory[0]); // Apparently this works
        // Giving it a list to use. Should work, I hope :)
    }
    
    /** Removes the category from this list
     * 
     * @param category Category to remove
     */
    public void removeCategory(ShoppingListCategory category) {
        // Remove method only removes the first occurance
        // I'm going to have to work arround that
        // Might have a look to see if we could prevent multiple occurances
        //      of the same category being added in the first place as well - Done
        // Good to cover this stuff multiple times, just in case :)
        while (this.categories.contains(category)) {
            this.categories.remove(category); // This will keep going until all of them are gone
        }
    }
    
    /** Removed the provides array of categories from the list
     * 
     * @param categories Categories to remove
     */
    public void removeCategories(ShoppingListCategory[] categories) {
        for (ShoppingListCategory category: categories) {
            this.removeCategory(category); // Again, does what it says on the tin and is fairly self explanatory
        }
    }
    
    /** Gets the number of categories in the list
     * 
     * @return The number of categories in the list
     */
    public int getCategoryCount() {
        return this.categories.size(); // Self Explanatory
    }
    
    /** Clears the category */
    public void clearList() {
        this.categories.clear(); // Self Explanatory
    }
    
    // Just need to add the toString method now
    
    /** Returns a String detailing the name of, and number of categories in this list
     * 
     * @return A String detailing the name of, and number of categories in this list, with name trimmed to a recommended length
     */
    public String toString() {
        // Get these now
        String name = this.getName();
        name = util.StringUtil.trim(name, trimLength);
        String categoryUnit;
        int categoryCount = this.getCategoryCount();
        // Determine whether to use Category or Categories
        if (categoryCount == 1) {
            categoryUnit = "Category";
        } else {
            categoryUnit = "Categories";
        }
        // Return our string
        return name + ": " + Integer.toString(categoryCount) + " " + categoryUnit;
    }
}
