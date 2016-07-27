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

/** A class for shopping list items
 *
 * @author Aaron Rumpler
 */
public class ShoppingListItem {
    /** The name of the item */
    private String name;
    /** The singular of the unit for this item */
    private String singularUnit;
    /** The plural of the unit for this item */
    private String pluralUnit;
    /** Whether the item is checked or not */
    private boolean checked = false; // Set these now as they will always be this when first instantiated
    /** The quantity of the item */
    private int quantity = 0;
    /** The recommended length to trim strings from this class down to */
    public static final int trimLength = 20;
    
    /** Constructor for this class.
     * All parameters must not be blank.
     * If they are, it will throw an Exception.
     * Please be prepared to catch it.
     * If you receive an exception, discard this object, and don't use it.
     * 
     * @param name Name of this item
     * @param singularUnit Singular unit for this item (e.g. box)
     * @param pluralUnit Plural unit for this item (e.g. boxes)
     */
    public ShoppingListItem(String name, String singularUnit, String pluralUnit) throws IllegalArgumentException {
        // Set the name and units
        if (name.isEmpty() || singularUnit.isEmpty() || pluralUnit.isEmpty()) {
            // Don't allow any of these to be blank
            // Set the name and units in case the caller uses the object
            this.name = "Unnamed Item";
            this.singularUnit = "Unnamed Unit";
            this.pluralUnit = "Unnamed Units";
            // Throw the exception
            throw new IllegalArgumentException("The Name, Singular Unit and Plural Unit must not be blank.");
        } else {
            // If they aren't, then set them
            this.name = name;
            this.singularUnit = singularUnit;
            this.pluralUnit = pluralUnit;
        }
    }
    
    // A bunch of getter methods
    
    /** Returns the name of this item
     * 
     * @return The name of this item
     */
    public String getName() {
        return name;
    }
    
    /** Returns the singular unit
     * 
     * @return The singular unit
     */
    public String getSingularUnit() {
        return singularUnit;
    }
    
    /** Returns the plural unit
     * 
     * @return The plural unit
     */
    public String getPluralUnit() {
        return pluralUnit;
    }
    
    /** Returns the quantity of the item
     * 
     * @return The quantity of the item
     */
    public int getQuantity() {
        return quantity;
    }
    
    /** Returns whether the item is checked
     * 
     * @return A boolean representing whether the item is checked
     */
    public boolean isChecked() {
        return checked;
    }
    
    /** Returns the appropriate unit for quantity
     * 
     * @return The appropriate unit for quantity
     */
    public String getUnit() {
        // Fairly self explanatory
        if(quantity == 1) {
            return singularUnit;
        } else {
            return pluralUnit;
        }
    }
    
    /** Returns a formatted string of the Item
     * 
     * @return A formatted string of the Item, with name and unit trimmed to a recommended length
     */
    public String toString() {
        return util.StringUtil.trim(getName(), trimLength) + " - " + getQuantity() + " " + util.StringUtil.trim(getUnit(), trimLength);
    }
    
    // The Setter Methods
    
    /** Sets the name of the item.
     * Throws an exception if name is blank.
     * 
     * @param name The new name of the item
     */
    public void setName(String name) throws IllegalArgumentException {
        if (name.isEmpty()) {
            // Only set the name if it is not blank, else throw an exception
            // Object already has name, so leave it at that
            throw new IllegalArgumentException("Name must not be blank");
        } else {
            this.name = name;
        }
    }
    
    /** Sets the name of the singular unit.
     * Throws an exception if the unit is blank.
     * 
     * @param singularUnit The new name of the singular unit
     */
    public void setSingularUnit(String singularUnit) throws IllegalArgumentException {
        if (singularUnit.isEmpty()) {
            // Only set the unit if it is not blank, else throw an exception
            // Object already has unit, so leave it at that
            throw new IllegalArgumentException("Singular Unit must not be blank");
        } else {
            this.singularUnit = singularUnit;
        }
    }
    
    /** Sets the name of the plural unit.
    * Throws an exception if the unit is blank.
    * 
    * @param pluralUnit The new name of the plural unit
    */
    public void setPluralUnit(String pluralUnit) throws IllegalArgumentException {
        if (pluralUnit.isEmpty()) {
            // Only set the name if it is not blank, else throw an exception
            // Object already has unit, so leave it at that
            throw new IllegalArgumentException("Plural Unit must not be blank");
        } else {
            this.pluralUnit = pluralUnit;
        }
    }
    
    /** Sets whether the item is checked
     * 
     * @param checked A boolean representing whether the item is checked
     */
    public void setChecked(boolean checked) {
        this.checked = checked;
        // Yes, I am deliberately allowing checked items with a value of 0. 
        // I see use cases for explcietly saying 0 of something.
    }
    
    /* When setting the quantity to 0, I want it to automatically set the item to not checked
       I also want to check the item on any adjustmnt to the quantity (except 0) */
    
    /** Sets the quantity of the item. Also sets the item to unchecked if item is 0 and checked if otherwise.
     * Throws an exception if quantity is negative.
     * 
     * @param quantity The new quantity
     */
    public void setQuantity(int quantity) throws IllegalArgumentException {
        if (quantity >= 0) { // I don't want quantity to be negative. I would use an unsighed int but Java has none
            if (quantity == 0) { 
                this.setChecked(false); // Set the item to unchecked if quantity is 0
            } else {
                this.setChecked(true); // Otherwise set it to checked
            }
            this.quantity = quantity;
        } else {
            // Quantity is -ve, so throw an exception
            throw new IllegalArgumentException("Please provide a positive number of items to buy.");
        }
    }
}
