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

/** A class to simplify the creation of menubars
 *
 * @author Aaron Rumpler
 */
public class SimpleMenubar extends JMenuBar{
    /** Constructor for this class */
        public SimpleMenubar(String name, SimpleMenu[] menus) {
            this.setName(name); // Set name as well
            for(JMenu menu: menus) {
                this.add(menu);
            }
        }
}
