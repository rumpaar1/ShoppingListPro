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
package SimpleMenubar;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import ButtonListeners.*;

/** A class to simplify the creation of my menu items
 *
 * @author Aaron Rumpler
 */
public class SimpleMenuButton extends JMenuItem implements SimpleMenuItem{
    /** The action listener for this object */
    private ButtonActionListener actionListener;

    /** Constructor for a SimpleMenuItem that is a menu item
    * @param text The text to display on the menu item 
    * @param action The action to perform when clicked
    */
    public SimpleMenuButton(String text, SimpleAction action) {
        // This will take an action listener at some point as well
        // This adds the text
        init(text, null);
        actionListener = new ButtonActionListener(action); //Make our action listener, passing it the action we want it to perform
        this.addActionListener(actionListener); // Add the new action listener to the button
    }
    
    /** Constructor for a SimpleMenuItem that is a menu item, including a picture
    * @param text The text to display on the menu item 
    * @param action The action to perform when clicked
    * @param icon  The icon to display on the menu item
    */
    public SimpleMenuButton(String text, SimpleAction action, ImageIcon icon) {
        // This will take an action listener at some point as well
        // This adds the text and icon
        init(text, icon);
        this.setName(text); // Set name as well
        actionListener = new ButtonActionListener(action); //Make our action listener, passing it the action we want it to perform
        this.addActionListener(actionListener); // Add the new action listener to the button
    }

}
