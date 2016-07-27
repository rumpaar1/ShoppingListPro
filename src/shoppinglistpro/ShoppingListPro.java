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
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/** The main class of Shopping List Pro, a GUI-based Shopping List app written in Java
 *
 * @author Aaron Rumpler
 */
public class ShoppingListPro {
    /** The main window of the application */
    private JFrame mainWindow;
    /** The content pane of the main window */
    private ShopGUI panel;
    
    /** The main method, which warns the user that the app is not done yet and then launches the app if the user clicks yes */
    public static void main(String[] args) {
        // Beta Version Warning
        if (JOptionPane.showConfirmDialog(null, "Warning!\nThis software is in development. It doesn't even work yet.\nAre you sure you want to continue?", "Warning!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0) {
            // Only launch app if user says yes
            new ShoppingListPro();
        }
    }
    
    /** Change the title of the main window 
     * @param title The new title for the window
     */
    void changeTitle(String title) {
        // Package visability, only accessable to ShopGUI and ToolbarsMenus
        mainWindow.setTitle(title);
    }
    
    /** Attempt to close the window, has a confirmation dialog */
    public void close() {
        mainWindow.dispatchEvent(new WindowEvent(mainWindow, WindowEvent.WINDOW_CLOSING));
        // This supposedly does the same thing as the X button, which is give the JFrame a closing event
    }
    
    public void newShopingListWindow() {
        new ShoppingListPro(); // Just make a new ShoppingListPro.
        // Don't keep a reference to it, as I don't want it. It is a seperate window which I want nothing to do with.
    }
    
    /** Creates the new JFrame to hold the content pane of the main window, which is also created here */
    ShoppingListPro() {
        // Make the window and content pane
        mainWindow = new JFrame("Shopping List Pro");
        panel = new ShopGUI(this); // Pass the main window through so we can change the title from the content pane
        mainWindow.getContentPane().add(panel);
        mainWindow.setMinimumSize(new Dimension(640, 480)); // This might hopefully stop the window getting too small
        // Extra required stuff, fairly self explanitory
        mainWindow.setVisible(true);
        mainWindow.pack();
        mainWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Handle this manually
        mainWindow.addWindowListener(new windowListen());
        
    }
    
    private class windowListen extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            // Overide method and add own code
            // Confirm exit
            int exitOption = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            boolean toExit = false; // Variable to be set to true if yes was chosen
            if (exitOption == 0) {
                // Set toExit to true if yes was chosen
                toExit = true;
            }
            if (toExit) {
                // Only close if yes was clicked
                e.getWindow().setVisible(false); // Hide Window
                e.getWindow().dispose(); // Dispose of window
            }
        }
    }
}
