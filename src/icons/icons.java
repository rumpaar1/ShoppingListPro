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
package icons;
import java.awt.*;
import javax.swing.*;

/** A class containing only icons as public ImageIcons for use as icons
 *
 * @author Aaron Rumpler
 */
public class icons {
    // These don't need to be changed, so are final
    // Turns out you can use getResource to get a URL for something from a reltive path
    // As a relative path doesn't work for ImageIcon.setIcon()
    public static final ImageIcon about = new ImageIcon(icons.class.getResource("24/about.png"));
    public static final ImageIcon addcat = new ImageIcon(icons.class.getResource("24/addcat.png"));
    public static final ImageIcon additem = new ImageIcon(icons.class.getResource("24/additem.png"));
    public static final ImageIcon delcat = new ImageIcon(icons.class.getResource("24/delcat.png"));
    public static final ImageIcon delitem = new ImageIcon(icons.class.getResource("24/delitem.png"));
    public static final ImageIcon editcat = new ImageIcon(icons.class.getResource("24/editcat.png"));
    public static final ImageIcon edititem = new ImageIcon(icons.class.getResource("24/edititem.png"));
    public static final ImageIcon exit = new ImageIcon(icons.class.getResource("24/exit.png"));
    public static final ImageIcon exporthtml = new ImageIcon(icons.class.getResource("24/exporthtml.png"));
    public static final ImageIcon exporttxt = new ImageIcon(icons.class.getResource("24/exporttxt.png"));
    public static final ImageIcon help = new ImageIcon(icons.class.getResource("24/help.png"));
    public static final ImageIcon newlist = new ImageIcon(icons.class.getResource("24/newlist.png"));
    public static final ImageIcon rename = new ImageIcon(icons.class.getResource("24/rename.png"));
    public static final ImageIcon savelist = new ImageIcon(icons.class.getResource("24/savelist.png"));
    // Resised ones
    public static final ImageIcon about16 = new ImageIcon(icons.class.getResource("16/about.png"));
    public static final ImageIcon addcat16 = new ImageIcon(icons.class.getResource("16/addcat.png"));
    public static final ImageIcon additem16 = new ImageIcon(icons.class.getResource("16/additem.png"));
    public static final ImageIcon delcat16 = new ImageIcon(icons.class.getResource("16/delcat.png"));
    public static final ImageIcon delitem16 = new ImageIcon(icons.class.getResource("16/delitem.png"));
    public static final ImageIcon editcat16 = new ImageIcon(icons.class.getResource("16/editcat.png"));
    public static final ImageIcon edititem16 = new ImageIcon(icons.class.getResource("16/edititem.png"));
    public static final ImageIcon exit16 = new ImageIcon(icons.class.getResource("16/exit.png"));
    public static final ImageIcon exporthtml16 = new ImageIcon(icons.class.getResource("16/exporthtml.png"));
    public static final ImageIcon exporttxt16 = new ImageIcon(icons.class.getResource("16/exporttxt.png"));
    public static final ImageIcon help16 = new ImageIcon(icons.class.getResource("16/help.png"));
    public static final ImageIcon newlist16 = new ImageIcon(icons.class.getResource("16/newlist.png"));
    public static final ImageIcon rename16 = new ImageIcon(icons.class.getResource("16/rename.png"));
    public static final ImageIcon savelist16 = new ImageIcon(icons.class.getResource("16/savelist.png"));
}
