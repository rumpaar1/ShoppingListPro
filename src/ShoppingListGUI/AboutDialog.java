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
import shoppinglistpro.*;
import icons.*;
import ButtonListeners.*;
import java.util.ArrayList;
import util.*;

/** A class for making about dialogs
 *
 * @author Aaron Rumpler
 */
public class AboutDialog {
    /** The title of the dialog */
    private String title;
    /** The text for the dialog */
    private String text;
    /** The dialog box */
    private JDialog dialog;
    /** The content panel of the dialog */
    private JPanel panel;
    /** The layout manager of the panel */
    private BoxLayout layout;
    /** The text area for displaying the text */
    private JTextArea textArea;
    /** The scroll pane for the text area */
    private JScrollPane scroll;
    /** The buttons in the dialog */
    private JPanel buttons;
    /** The layout for the buttons panel */
    private BoxLayout buttonsLayout;
    /** The ok button to exit the dialog */
    private JButton ok;
    /** The fixed size of the dialog */
    private Dimension size;
    
    /** Display an about dialog box 
     * 
     * @param title Title for dialog
     * @param text Text to display
     */
    public AboutDialog(String title, String text) {
        dialog = new JDialog(); // Make the new dialog
        panel = new JPanel(); // Panel
        dialog.getContentPane().add(panel); // Add to dialog
        dialog.setTitle(title); // Title
        layout = new BoxLayout(panel, BoxLayout.Y_AXIS); // My new favourite layout manager
        panel.setLayout(layout); 
        textArea = new JTextArea(text); // Display of text
        textArea.setEditable(false); // Prevent editing of the text
        scroll = new JScrollPane(textArea); // Scroll pane
        scroll.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20)); // Add a border
        panel.add(scroll); // Add the scrollpane to the panel
        ok = new JButton("OK"); // Button to exit dialog
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING)); // Close the window on button click
            }
        });
        buttons = new JPanel(); // Put the ok button in a JPanel so a border can be added
        buttonsLayout = new BoxLayout(buttons, BoxLayout.X_AXIS); // I've found this to be a good layout to use
        buttons.setLayout(buttonsLayout);
        buttons.add(ok);
        buttons.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20)); // Add a border
        panel.add(buttons); // Add the button
        // Fix the size
        dialog.setResizable(false); // Stop user from resizing
        size = new Dimension(600, 360); // Size to fix at
        dialog.setPreferredSize(size);
        // Standard stuff
        dialog.setVisible(true);
        dialog.pack();
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // Get rid of it when closed
    }
}
