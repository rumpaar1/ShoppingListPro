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
import shoppinglistpro.*;
import SimpleMenubar.*;
import SimpleToolbar.*;
import icons.*;
import ButtonListeners.*;

/** A class implementing a menu bar and toolbar for this application
 *
 * @author Aaron Rumpler
 */
class ToolbarsMenus extends JPanel {
    // Has package only visibility as only classes in this package need it
    /** The menu bar being displayed */
    private SimpleMenubar menubar;
    /** The toolbar being displayed */
    private SimpleToolbar toolbar;
    /** The Main Window of the application */
    private ShopGUI mainWindow;
    /** The menus on the menu bar */
        private SimpleMenu[] menus = { // These are the menu items I am going to have
            new SimpleMenu("File", // SimpleMenu takes a String for its name and an array of SimpleMenuButtons to add
                    new SimpleMenuItem[]{
                        new SimpleMenuButton("New List", new SimpleAction(){
                            public void doAction() {
                                mainWindow.getShoppingListProJFrame().newShopingListWindow(); // Make a new window
                            }
                        }, icons.newlist), // SimpleMenuButton takes a String for its name and an Action to be performed when clicked
                        new SimpleMenuButton("Save List", new SimpleAction(){
                            public void doAction() {
                                mainWindow.getDialogCreator().JSON();
                            }
                        }, icons.savelist),
                        new SimpleMenuButton("Export HTML List", new SimpleAction(){
                            public void doAction() {
                                mainWindow.getDialogCreator().html();
                            }
                        }, icons.exporthtml),
                        new SimpleMenuButton("Export Plain Text List", new SimpleAction(){
                            public void doAction() {
                                mainWindow.getDialogCreator().plainText();
                            }
                        }, icons.exporttxt), 
                        new SimpleMenuSpacer(),
                        new SimpleMenuButton("Exit", new SimpleAction(){
                            public void doAction() {
                                mainWindow.getShoppingListProJFrame().close(); // Close the window
                            }
                        }, icons.exit)
                    }), 
            new SimpleMenu("Edit", 
                    new SimpleMenuItem[]{
                        new SimpleMenuButton("Edit List Name", new SimpleAction(){
                            public void doAction() {
                                mainWindow.getDialogCreator().renameList();
                            }
                        }, icons.rename), 
                        new SimpleMenuSpacer(),
                        new SimpleMenuButton("Create Category", new SimpleAction(){
                            public void doAction() {
                                mainWindow.getDialogCreator().addCategory();
                            }
                        }, icons.addcat), 
                        new SimpleMenuButton("Edit Category", new SimpleAction(){
                            public void doAction() {
                                mainWindow.getDialogCreator().editCategory();
                            }
                        }, icons.editcat), 
                        new SimpleMenuButton("Delete Category", new SimpleAction(){
                            public void doAction() {
                                mainWindow.getDialogCreator().deleteCategory();
                            }
                        }, icons.delcat), 
                        new SimpleMenuSpacer(),
                        new SimpleMenuButton("Create Item", new SimpleAction(){
                            public void doAction() {
                                mainWindow.getDialogCreator().addItem();
                            }
                        }, icons.additem), 
                        new SimpleMenuButton("Edit Item", new SimpleAction(){
                            public void doAction() {
                                mainWindow.getDialogCreator().editItem();
                            }
                        }, icons.edititem), 
                        new SimpleMenuButton("Delete Item", new SimpleAction(){
                            public void doAction() {
                                mainWindow.getDialogCreator().deleteItem();
                            }
                        }, icons.delitem)
                    }), 
            new SimpleMenu("Help", 
                    new SimpleMenuItem[]{
                        new SimpleMenuButton("Help", new SimpleAction(){
                            public void doAction() {
                                mainWindow.getDialogCreator().help(); // Display help screen
                            }
                        }, icons.help), 
                        new SimpleMenuButton("About", new SimpleAction(){
                            public void doAction() {
                                mainWindow.getDialogCreator().about(); // Display about screen
                            }
                        }, icons.about)
                    })
        };
        
        private SimpleToolbarItem[] toolbarItems = { // The toolbarItems I will use
            new SimpleToolbarButton("New List", new SimpleAction(){
                            public void doAction() {
                                mainWindow.getShoppingListProJFrame().newShopingListWindow(); // Make a new window
                            }
                        }, icons.newlist),
            new SimpleToolbarButton("Save List", new SimpleAction(){
                            public void doAction() {
                                mainWindow.getDialogCreator().JSON();
                            }
                        }, icons.savelist),
            new SimpleToolbarButton("Export HTML List", new SimpleAction(){
                            public void doAction() {
                                mainWindow.getDialogCreator().html();
                            }
                        }, icons.exporthtml),
            new SimpleToolbarButton("Export Plain Text List", new SimpleAction(){
                            public void doAction() {
                                mainWindow.getDialogCreator().plainText();
                            }
                        }, icons.exporttxt),
            new SimpleToolbarSpacer(),
            new SimpleToolbarButton("Edit List Name", new SimpleAction(){
                public void doAction() {
                    mainWindow.getDialogCreator().renameList();
                }
            }, icons.rename), 
            new SimpleToolbarSpacer(),
            new SimpleToolbarButton("Create Category", new SimpleAction(){
                            public void doAction() {
                                mainWindow.getDialogCreator().addCategory();
                            }
                        }, icons.addcat), 
            new SimpleToolbarButton("Edit Category", new SimpleAction(){
                            public void doAction() {
                                mainWindow.getDialogCreator().editCategory();
                            }
                        }, icons.editcat), 
            new SimpleToolbarButton("Delete Category", new SimpleAction(){
                            public void doAction() {
                                mainWindow.getDialogCreator().deleteCategory();
                            }
                        }, icons.delcat), 
            new SimpleToolbarSpacer(),
            new SimpleToolbarButton("Create Item", new SimpleAction(){
                            public void doAction() {
                                mainWindow.getDialogCreator().addItem();
                            }
                        }, icons.additem), 
            new SimpleToolbarButton("Edit Item", new SimpleAction(){
                            public void doAction() {
                                mainWindow.getDialogCreator().editItem();
                            }
                        }, icons.edititem), 
            new SimpleToolbarButton("Delete Item", new SimpleAction(){
                            public void doAction() {
                                mainWindow.getDialogCreator().deleteItem();
                            }
                        }, icons.delitem)
            
        };

    /** Constructor for this class */
    public ToolbarsMenus(ShopGUI mainWindow) {
        menubar = new SimpleMenubar("Main Menubar",menus);
        toolbar = new SimpleToolbar("Main Toolbar", toolbarItems, false);
        this.mainWindow = mainWindow;
        this.setLayout(new BorderLayout());
        this.add(menubar, BorderLayout.NORTH);
        this.add(toolbar, BorderLayout.SOUTH);
        // Hopefully this will stop the BoxLayout housing this from squashing it
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, (int)this.getPreferredSize().getHeight()));
            // Not limiting max width
        this.setMinimumSize(this.getPreferredSize());
    }
}
