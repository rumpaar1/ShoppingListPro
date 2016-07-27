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
package Export;
import shoppinglistpro.*;
import ShoppingList.*;
import java.util.ArrayList;
// 3rd Party Libraries
import org.json.simple.*; // https://code.google.com/archive/p/json-simple/
import org.apache.commons.lang3.StringEscapeUtils; // http://commons.apache.org/proper/commons-lang/
import static org.apache.commons.lang3.StringEscapeUtils.escapeHtml4; // Just so I can get to it easier

/** A class containing static methods for exporting ShoppingLists
 *
 * @author Aaron Rumpler
 */
public class Exporter {
    /** Generate a formatted HTML page of the shopping list
     * 
     * @param list The list to generate a HTML page for
     * @return The generated HTML page
     */
    public static String getHTML(ShoppingList list) {
        String HTML = "<html>\n" // HTML setup stuff
                + "<head><title>" + escapeHtml4(list.getName()) + "</title></head>\n" // Add the name as the page title
                + "<body>\n"
                + "<h1>" + escapeHtml4(list.getName()) + "</h1>\n"; // Add thename as a large title on the page
        for (ShoppingListCategory category : list.getCategories()) {
            // Iterate through categories and generate HTML for them
            String catHTML = "<h2>" + escapeHtml4(category.getName()) + "</h2>\n"; // Category name as a heading
            catHTML = catHTML.concat("<ul>\n"); // List of items
            for (ShoppingListItem item : category.getItems()) {
                // Itterate through items
                if (item.isChecked()){
                    // Only add to HTML if item is checked
                    // Formatted <li> for the item
                    String itemHTML = "<li>" + escapeHtml4(item.getName()) + " - " + escapeHtml4(Integer.toString(item.getQuantity())) + " " + escapeHtml4(item.getUnit()) + "</li>\n";
                    catHTML = catHTML.concat(itemHTML);
                }
            }
            catHTML = catHTML.concat("</ul>\n");
            HTML = HTML.concat(catHTML); // Add to the end of the existing HTML
        }
        HTML = HTML.concat("</body>\n"
                + "</html>");
        return HTML;
    }
    
    /** Generate a plain text page of the shopping list
     * 
     * @param list The list to generate a plain text page for
     * @return The generated plain text page
     */
    public static String getPlainText(ShoppingList list) {
        String text = list.getName() + "\n"; // Add the name as a title on the page
        text = text.concat(util.StringUtil.repeat("-", list.getName().length()) + "\n\n");
        for (ShoppingListCategory category : list.getCategories()) {
            // Iterate through categories and generate text for them
            String catText = category.getName() + "\n" + util.StringUtil.repeat("-", category.getName().length()); // Category name as a heading
            catText = catText.concat("\n"); // List of items
            for (ShoppingListItem item : category.getItems()) {
                // Itterate through items
                if (item.isChecked()){
                    // Only add to text if item is checked
                    // Formatted <li> for the item
                    String itemText = "    - " + item.getName() + " - " + item.getQuantity() + " " + item.getUnit() + "\n";
                    catText = catText.concat(itemText);
                }
            }
            catText = catText.concat("\n\n");
            text = text.concat(catText); // Add to the end of the existing text
        }
        return text;
    }
    
    /** Generate a JSON string of the shopping list
     * 
     * @param list The list to generate a JSON string from
     * @return The JSON string
     */
    public static String getJSON(ShoppingList list) {
        JSONObject json = new JSONObject(); // Make a JSON object
        json.put("name", JSONObject.escape(list.getName())); // Add name
        // Escaping strings so if I put a { or a [ or a : etc in, it doesn't break the json
        ArrayList<JSONObject> categories = new ArrayList<>(); // An arraylist of json objects for categories
        for (ShoppingListCategory category : list.getCategories()) {
            // Iterate through each category and generate json
            JSONObject catJson = new JSONObject(); // The JSON object for the category
            catJson.put("name", JSONObject.escape(category.getName())); // Add name
            ArrayList<JSONObject> items = new ArrayList<JSONObject>(); // Items
            for (ShoppingListItem item : category.getItems()) {
                // Itterate through items
                JSONObject itemJson = new JSONObject(); // JSON object for the item
                // Add the data
                itemJson.put("name", JSONObject.escape(item.getName()));
                itemJson.put("singularUnit", JSONObject.escape(item.getSingularUnit()));
                itemJson.put("pluralUnit", JSONObject.escape(item.getPluralUnit()));
                itemJson.put("checked", item.isChecked());
                itemJson.put("quantity", item.getQuantity());
                items.add(itemJson); // Add to the list of item json objects
            }
            catJson.put("items", items); // Add the items to the json object
            categories.add(catJson); // Add the category to the categories list
        }
        json.put("categories", categories);  // Add the categories to the json object
        return json.toJSONString(); // Return it as a string
    }
}
