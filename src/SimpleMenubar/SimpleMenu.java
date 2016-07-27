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

/** A class to simplify the creation of my menus
 *
 * @author Aaron Rumpler
 */
public class SimpleMenu extends JMenu {
    /**@param menuitems The menu items to add*/
    public SimpleMenu(String text, SimpleMenuItem[] menuitems) {
        this.setText(text);
        this.setName(text); // Set the name as well
        // This just takes in a list of menu items and adds them to itself
        for(SimpleMenuItem menuitem : menuitems) {
            if (menuitem.getClass() == SimpleMenuButton.class) {
                this.add((SimpleMenuButton)menuitem);
            } else if (menuitem.getClass() == SimpleMenuSpacer.class) 
                this.addSeparator();
        }
    }

}
