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

/** A class to simplify adding toolbars
 *
 * @author Aaron Rumpler
 */
public class SimpleToolbar extends JToolBar {
    /** Constructor for this class
     * 
     * @param name The name of the toolbar
     * @param toolbarItems The SimpleToolbarItems to add
     */
    public SimpleToolbar(String name, SimpleToolbarItem[] toolbarItems, boolean isFloatable) {
        this.setName(name); // Set the name of the toolbar (I think this has a use, if not I'll remove it
        this.setFloatable(isFloatable); // Set whether it is floatableor not
        for (SimpleToolbarItem toolbarItem : toolbarItems) {
            // Take the list of menu items, determine if it is a button or 'spacer', then act accordingly
            if (toolbarItem.getClass() == SimpleToolbarButton.class) {
                this.add((JButton)toolbarItem);
            } else if (toolbarItem.getClass() == SimpleToolbarSpacer.class) {
                this.addSeparator();
            }
        }
    }
}
