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

/** A GUI interface for a ShoppingListCategory
 *
 * @author Aaron Rumpler
 */
public class ShoppingListCategoryGUI extends JPanel {
    /** The ShoppingListCategory this represents */
    private ShoppingListCategory category;
    /** The name of the category */
    private JLabel name;
    /** The add item button */
    private JButton add;
    /** The edit button */
    private JButton edit;
    /** The delete button */
    private JButton delete;
    /** The buttons */
    private JPanel buttons;
    /** The top pane for category info */
    private JPanel info;
    /** The JPanel for the ShoppingListItemGUIs */
    private JPanel items;
    /** The Main Window of the app */
    private ShopGUI mainWindow;
    
    /** Constructor for this class
     * 
     * @param category The ShoppingListCategory to create a GUI for
     * @param mainWindow The Main Window of the app
     */
    public ShoppingListCategoryGUI(ShoppingListCategory category, ShopGUI mainWindow) {
        this.category = category; // Start by taking the given category and storing it
        this.mainWindow = mainWindow; // Store the Main Window
        // A lot of similar code to ShoppingListItemGUI here, but different enough that 
        // I'm going to just copy and paste it from there and edit
        // Set up the name
        name = new JLabel();
        Dimension sizing = new Dimension(360, 15); // Fix the sizing of this
        name.setMaximumSize(sizing);
        name.setPreferredSize(sizing);
        name.setMinimumSize(sizing);
        // Set up the buttons and add the listener to it
        add = new JButton(icons.additem16);
        add.addActionListener(new ButtonActionListener(new SimpleAction(){
                            public void doAction() {
                                mainWindow.getDialogCreator().addItem(category);
                            }
                        }));
        add.setToolTipText("Add Item to Category");
        edit = new JButton(icons.editcat16);
        edit.addActionListener(new ButtonActionListener(new SimpleAction(){
                            public void doAction() {
                                mainWindow.getDialogCreator().editCategory(category);
                            }
                        }));
        edit.setToolTipText("Edit Category");
        delete = new JButton(icons.delcat16);
        delete.addActionListener(new ButtonActionListener(new SimpleAction(){
                            public void doAction() {
                                mainWindow.getDialogCreator().deleteCategory(category);
                            }
                        }));
        delete.setToolTipText("Delete Category");
        // Set up the JPanel holding the buttons
        buttons = new JPanel(new GridLayout(1, 0)); // Horizontal this time
        buttons.add(add);
        buttons.add(edit);
        buttons.add(delete);
        // The buttons need size settings to stop them getting too big
        add.setMaximumSize(new Dimension(24, 24));
        add.setPreferredSize(new Dimension(24, 24));
        add.setMinimumSize(new Dimension(24, 24));
        edit.setMaximumSize(new Dimension(24, 24));
        edit.setPreferredSize(new Dimension(24, 24));
        edit.setMinimumSize(new Dimension(24, 24));
        delete.setMaximumSize(new Dimension(24, 24));
        delete.setPreferredSize(new Dimension(24, 24));
        delete.setMinimumSize(new Dimension(24, 24));
        buttons.setMaximumSize(new Dimension(24 * 3, 24)); // Set for this as well
        buttons.setPreferredSize(new Dimension(24 * 3, 24)); // Swap them as  the buttons are horizontal this time, not vertical
        buttons.setMinimumSize(new Dimension(24 * 3, 24));
        
        // The info pane
        info = new JPanel();
        // Needs to be a BoxLayout
        info.setLayout(new BoxLayout(info, BoxLayout.X_AXIS));
        // Also a border
        info.setBorder(new EmptyBorder(10, 10, 10, 10));
        // Add the stuff
        info.add(name);
        info.add(Box.createHorizontalGlue()); // Spacing between them
        info.add(Box.createRigidArea(new Dimension(20, 0)));
        info.add(buttons);
        
        // The pane of ShoppingListItemGUIs
        items = new JPanel();
        // Grid Layout for having them in rows
        BoxLayout itemLayout = new BoxLayout(items, BoxLayout.Y_AXIS);
        items.setLayout(itemLayout); // 1 column and auto rows
        
        // The main screen
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Border Layout
        this.add(info); // Add the info to the top
        this.add(items); // Add the items
        
        this.update(); // Update the GUI with the actual stuff from the category it represents
        
        /* To Do List
            - Layout
        */
    }
    
    /** Updates the category info, ensures the ShoppingListItemGUIs match up 
     * with the ShoppingListItems added to the category and that they are all updated
     * 
     */
    public void update() {
        // Update name
        this.name.setText(this.category.getName());
        this.name.setToolTipText(this.category.getName()); // Add a tooltip
        // Update the items pane so it matches the items the category has
        // I'll do this by removing all the ItemGUIs and adding new ones for each item
        this.items.removeAll(); // Remove all ItemGUIs
        ShoppingListItem[] currentItems = category.getItems(); // Get the items
        for (ShoppingListItem item : currentItems) {
            this.items.add(new ShoppingListItemGUI(item, mainWindow)); // Add a new GUI for each item
        }
        mainWindow.validate(); // This should fix the no update till resize issue
        mainWindow.repaint();
    }
    
    /** Gets the category this GUI represents
     * 
     * @return The category this GUI represents
     */
    public ShoppingListCategory getCategory() {
        return this.category;
    }
}