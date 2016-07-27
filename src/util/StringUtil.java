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
package util;

/** String Utilities
 *
 * @author Aaron Rumpler
 */
public class StringUtil {
    /** Trims a string
     * 
     * @param input The string to trim
     * @param length The length of the output
     * @return The trimmed string
     */
    public static String trim(String input, int length) {
        // Check length parameter is valid
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be at least 1");
        }
        // Determine if the string is longer or shorter / same length as the requested trim size
        if (input.length() > length) {
            return input.substring(0, length) + "..."; // Trim the string
        } else {
            // String is shorter or same length as requested trim size
            return input;
        }
    }
    
    /** Repeat a String a number of times
     * 
     * @param repeat The string to repeat
     * @param number The number of times to repeat the string
     * @return The repeated string
     */
    public static String repeat(String repeat, int number) {
        String repeated = "";
        for (int i = 1; i <= number; i++) {
            // Just add the input the number of times given
            repeated = repeated.concat(repeat);
        }
        return repeated;
    }
}
