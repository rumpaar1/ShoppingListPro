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
package Testing;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import SimpleMenubar.*;
import ButtonListeners.*;
import ShoppingList.*;
import ShoppingListGUI.*;
/**
 *
 * @author Aaron Rumpler
 */
public class ShoppingListItemGUITest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        ShoppingListItem item = new ShoppingListItem("Chocholate", "Block", "Blocks");
        ShoppingListItemGUI itemgui = new ShoppingListItemGUI(item, null);
        frame.getContentPane().add(itemgui);
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println(); // I just need something to breakpoint on so I can run code semi-interactively for testing
    }
    
}
