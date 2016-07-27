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
package ButtonListeners;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

/** An item listener to add to ckeckboxes and radio buttons that performs a SimpleAction
 *
 * @author Aaron Rumpler
 */
public class ButtonItemListener implements ItemListener{
    /** The Action to preform when triggered */
    private SimpleAction action;


    /** Constructor for this class */
    public ButtonItemListener(SimpleAction action) {
        this.action = action;
    }

    /** Run when this listener is triggered, preforms the Action action */
    public void itemStateChanged(ItemEvent e) {
        action.doAction(); // Carry out the action
    }
}
