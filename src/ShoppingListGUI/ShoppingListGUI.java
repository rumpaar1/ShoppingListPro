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
package ShoppingListGUI;

// Again, this is going to be very similar to ShoppingListCategoryGUI
// So I'm going to use that as a template

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.event.*;
import ShoppingList.*;
import icons.*;
import ButtonListeners.*;
import java.util.ArrayList;
import shoppinglistpro.*;

/** A GUI interface for a ShoppingList
 *
 * @author Aaron Rumpler
 */
public class ShoppingListGUI extends JPanel {
    /** The ShoppingList this represents */
    private ShoppingList list;
    /** The Main Window of the app */
    private ShopGUI mainWindow;
    
    /** Constructor for this class
     * 
     * @param list The ShoppingList to create a GUI for
     * @param mainWindow The Main Window of the app
     */
    public ShoppingListGUI(ShoppingList list, ShopGUI mainWindow) {
        this.list = list; // Start by taking the given list and storing it
        this.mainWindow = mainWindow; // Store the Main Window
        
        // This is going to directly house the SHoppingListCategoryGUIs
        // Box Layout so they are in rows but not fixed size
        BoxLayout categoryLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(categoryLayout); // 1 column and auto rows

        this.update(); // Update the GUI with the actual stuff from the list it represents
    }
    
    /** Updates the category info, ensures the ShoppingListItemGUIs match up 
     * with the ShoppingListItems added to the category and that they are all updated
     * 
     */
    public void update() {
        // Update the categories pane so it matches the categories the list has
        // I'll do this by removing all the CategoryGUIs and adding new ones for each category
        this.removeAll(); // Remove all CategoryGUIs
        ShoppingListCategory[] currentCategories = list.getCategories(); // Get the categories
        for (ShoppingListCategory category : currentCategories) {
            this.add(new ShoppingListCategoryGUI(category, mainWindow)); // Add a new GUI for each category
        }
        this.add(Box.createVerticalGlue()); // Keep everything top aligned
        mainWindow.validate(); // This should fix the no update till resize issue
        mainWindow.repaint();
    }
    
    /** Gets the list this GUI represents
     * 
     * @return The list this GUI represents
     */
    public ShoppingList getList() {
        return this.list;
    }
}