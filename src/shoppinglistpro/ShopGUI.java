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
package shoppinglistpro;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import SimpleMenubar.*;
import ButtonListeners.*;
import ShoppingList.*;
import ShoppingListGUI.*;

/** Class for the main window of the application
 *
 * @author Aaron Rumpler
 */
public class ShopGUI extends JPanel{
    /** The JFrame housing this content pane */
    private ShoppingListPro mainWindow;
    /** The ToolbarsMenu used */
    private ToolbarsMenus toolbarsmenus;
    /** The ShoppingList for this GUI */
    private ShoppingList list;
    /** The ShoppingListGUI for the bottom of the window */
    private ShoppingListGUI listgui;
    /** A ScrollPane for the ShoppingListGUI */
    private JScrollPane scrollPane;
    /** The ShoppingListDialogs used for Dialog Box input */
    private ShoppingListDialogs dialogs;
    
    /** Constructor to set up the window 
    *@param mainWindow The JFrame hosting this content pane 
    */
    public ShopGUI(ShoppingListPro mainWindow) {
        this.dialogs = new ShoppingListDialogs(this); // Make the dialog object and store
        this.mainWindow = mainWindow; // Take in Main Window
        // Use a Box Layout as it respects min and max sizes and seems to
        // cause less issues
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // Add the toolbar and menubar
        toolbarsmenus = new ToolbarsMenus(this);
        this.add(toolbarsmenus);
        
        // Set up the list
        list = new ShoppingList("List"); // Use a default name
        
        // <debugcode>
        list.addCategories(new ShoppingListCategory[]{
            new ShoppingListCategory("Treats"),
            new ShoppingListCategory("Baked Goods and Other Yummy Goodness that is Yummy but not very good for you")
        });
        list.getCategories()[0].addItems(new ShoppingListItem[]{
            new ShoppingListItem("Chocholate", "Bar", "Bars"),
            new ShoppingListItem("Lollies", "Bag", "Bags"),
            new ShoppingListItem("Ice Cream", "Tub", "Tubs")
        });
        list.getCategories()[1].addItems(new ShoppingListItem[]{
            new ShoppingListItem("Cake", "Cake", "Cakes"),
            new ShoppingListItem("Muffins", "Bag", "Bags"),
            new ShoppingListItem("Big Huge MEGA MUFFINS for the Big Huge MEGA MUFFIN Festival", "Crate", "Shipping Containers Full Of MEGA MUFFINS")
        });
        // </debugcode>
        
        listgui = new ShoppingListGUI(list, this); // Add the new ShoppingListGUI
        scrollPane = new JScrollPane(
                listgui, 
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        ); // Add a ScrollPane so if window is resized too small, user can still see everything.
        
        this.add(scrollPane);
        
        this.update();
    }
    
    /** Update the Title of the Main Window  and the ShoppingListGUI*/
    public void update() {
        mainWindow.changeTitle(list.getName() + " - Shopping List Pro");
        listgui.update();
        validate(); // This should fix the no update till resize issue
        repaint();
    }
    
    /** Returns the ShoppingList this is a GUI for 
     * 
     * @return The ShoppingList this is a GUI for
     */
    public ShoppingList getList() {
        return list;
    }
    
    /** Returns a ShoppingListDialogs object, which can be used to create dialogs for various tasks
     * 
     * @return The ShoppingListDialogs object for this window
     */
    public ShoppingListDialogs getDialogCreator() {
        return dialogs;
    }
    
    /** Returns the ShoppingListPro object this is used in
     * 
     * @return The ShoppingListPro object 
     */
    public ShoppingListPro getShoppingListProJFrame() {
        return mainWindow;
    }
}
