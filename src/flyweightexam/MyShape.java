/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyweightexam;
import java.awt.Color;
import java.awt.Graphics;

public interface MyShape {
	public void draw(Graphics g, int x, int y, int width, int height,
			Color color, boolean fill, String font);
}
