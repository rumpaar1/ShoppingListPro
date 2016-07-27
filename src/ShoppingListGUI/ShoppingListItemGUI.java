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
import shoppinglistpro.*;

/** A GUI interface for a ShoppingListItem
 *
 * @author Aaron Rumpler
 */
public class ShoppingListItemGUI extends JPanel {
    /** The ShoppingListItem this ShoppingListItemGUI represents */
    private ShoppingListItem item;
    /** Used to set the item to checked or not checked */
    private JCheckBox checked;
    /** The name of the item */
    private JLabel name;
    /** Used to set the quantity of the item */
    private JSpinner quantity;
    /** The model for quantity */
    private SpinnerNumberModel spinModel;
    /** Shows the unit of the item */
    private JLabel unit;
    /** The edit button */
    private JButton edit;
    /** The delete button */
    private JButton delete;
    /** The buttons */
    private JPanel buttons;
    /** The Main Window of the app */
    private ShopGUI mainWindow;
    
    /** Constructor for this class
     * 
     * @param item The ShoppingListItem to create a ShoppingListItemGUI for
     * @param mainWindow The Main Window of the app
     */
    public ShoppingListItemGUI(ShoppingListItem item, ShopGUI mainWindow) {
        // Setup the GUI elements
        this.item = item;
        this.mainWindow = mainWindow; // Store the Main Window
        checked = new JCheckBox();
        name = new JLabel();
        // Fix the size of it
        Dimension sizing = new Dimension(180, 15);
        name.setMaximumSize(sizing);
        name.setPreferredSize(sizing);
        name.setMinimumSize(sizing);
        spinModel = new SpinnerNumberModel(0, 0, null, 1); // Start at 0 for now (update later), go up in increments of 1
        // And don't go below 0
        quantity = new JSpinner(spinModel); // Add that model to the new JSpinner
        unit = new JLabel();
        // Fix the size of it
        sizing = new Dimension(120, 15);
        unit.setMaximumSize(sizing);
        unit.setPreferredSize(sizing);
        unit.setMinimumSize(sizing);
        // Do the buttons as well and add the listener to it
        edit = new JButton(icons.edititem16);
        edit.addActionListener(new ButtonActionListener(new SimpleAction(){
                            public void doAction() {
                                mainWindow.getDialogCreator().editItem(item);
                            }
                        }));
        edit.setToolTipText("Edit Item");
        delete = new JButton(icons.delitem16);
        delete.addActionListener(new ButtonActionListener(new SimpleAction(){
                            public void doAction() {
                                mainWindow.getDialogCreator().deleteItem(item);
                            }
                        }));
        delete.setToolTipText("Delete Item");
        // Set up the JPanel holding the buttons
        buttons = new JPanel(new GridLayout(0, 1));
        buttons.add(edit);
        buttons.add(delete);
        // Set up the layout
        // Will use a BoxLayout as it allows easy Left and Right alignment with glue
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        // Also a border
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        // Set the components' maximum, minimum and prefered sizes
        quantity.setMaximumSize(new Dimension(400, 40));
        quantity.setPreferredSize(new Dimension(200, 40));
        quantity.setMinimumSize(new Dimension(40, 30));
        edit.setMaximumSize(new Dimension(24, 24));
        edit.setPreferredSize(new Dimension(24, 24));
        edit.setMinimumSize(new Dimension(24, 24));
        delete.setMaximumSize(new Dimension(24, 24));
        delete.setPreferredSize(new Dimension(24, 24));
        delete.setMinimumSize(new Dimension(24, 24));
        buttons.setMaximumSize(new Dimension(24, 48));
        buttons.setPreferredSize(new Dimension(24, 48));
        buttons.setMinimumSize(new Dimension(24, 48));
        // Add the gui items and then update them to represent the current state of the item it represents
        this.add(checked);
        this.add(Box.createRigidArea(new Dimension(5, 0)));
        this.add(name);
        this.add(Box.createRigidArea(new Dimension(10, 0)));
        this.add(quantity);
        this.add(Box.createRigidArea(new Dimension(5, 0)));
        this.add(unit);
        this.add(Box.createRigidArea(new Dimension(10, 0)));
        this.add(Box.createHorizontalGlue()); // Space in here
        this.add(buttons);
        this.update(); // Update everything
        
        // Add listeners
        // I am doing this now to avoid the previous update that puts initial values from trigering the listeners and 
        // Setting those again (causes issues with ShoppingListItemGUIs being created for unchecked items with a quantity != 0
        // (Value is set again which causes the box to be checked
        
        // Ultilising the ButtonListeners package I worked on earlier
        // pushedCheckedUpdate pushes only the ckeckbox status then updates the whole gui
        // Do this as sometimes changing one thing changes another, only want to push the item just changed in the qui
        // Or else we are pushing old stuff that was not changed in gui that may have just been changed by the underlying
        // Logic class
        checked.addItemListener(new ButtonItemListener(new pushCheckedUpdate()));
        // Same as before, just one for the JSpinner. Very important here as changes to the quantity actually cause
        // The ShoppingListItem class to call setChecked(), so pushing old checked states is a bad idea here
        quantity.addChangeListener(new ButtonChangeListener(new pushQuantityUpdate()));
    }
    
    /** Updates this ShoppingListItemGUI, so all displays of stuff are up to date */
    public void update() {
        // Update checkbox
        checked.setSelected(item.isChecked());
        
        // Update name
        name.setText(item.getName());
        name.setToolTipText(item.getName());
        
        // Update quantity
        quantity.setValue(item.getQuantity());
        
        // Update unit
        unit.setText(item.getUnit());
        unit.setToolTipText(item.getUnit());
        
        mainWindow.validate(); // This should fix the no update till resize issue
        mainWindow.repaint();
    }
    
    /** Gets the ShoppingListItem this is a GUI for
     * 
     * @return The ShoppingListItem this is a GUI for
     */
    public ShoppingListItem getItem() {
        return item;
    }
    
    /** Any instance of this object will update the ShoppingListItem's checked property when doAction() is called*/ 
    private class pushCheckedUpdate implements SimpleAction {
        public void doAction() {
            item.setChecked(checked.isSelected());
            update();
        }
    }
    
    /** Any instance of this object will update the ShoppingListItem's quantity property when doAction() is called*/ 
    private class pushQuantityUpdate implements SimpleAction {
        public void doAction() {
            item.setQuantity((int)quantity.getValue()); // Hopefully this should work
            update();
        }
    }
}
