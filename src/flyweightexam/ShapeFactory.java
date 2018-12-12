/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyweightexam;
import java.util.HashMap;

public class ShapeFactory {

	private static final HashMap shapes = new HashMap();

	public static MyShape getShape(String label) {
		MyShape concreteShape = (MyShape) shapes.get(label);

		if (concreteShape == null) {
			if (label.equals("R")) {
				concreteShape = new MyRectangle(label);
			} else if (label.equals("O")) {
				concreteShape = new MyOval(label);
			}
			shapes.put(label, concreteShape);
		}
		return concreteShape;
	}
}