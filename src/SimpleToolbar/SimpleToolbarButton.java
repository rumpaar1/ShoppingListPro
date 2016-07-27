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
package SimpleToolbar;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import ButtonListeners.*;

/** A class to simplify adding buttons to toolbars
 *
 * @author Aaron Rumpler
 */
public class SimpleToolbarButton extends JButton implements SimpleToolbarItem { 
    private ButtonActionListener actionListener;
    
    /** Constructor for this class
     * @param text The tooltip text for this button
     * @param action The action to be performed on click
     * @param icon The icon for this button
     */
    public SimpleToolbarButton(String text, SimpleAction action, ImageIcon icon) {
        super(icon); // Make new JButton with icon
        this.setToolTipText(text); // Set the tooltip text
        actionListener = new ButtonActionListener(action); // Make the listener witht he provided action
        this.addActionListener(actionListener); // Add the Listener
    }
}
