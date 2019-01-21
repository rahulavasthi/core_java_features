package designPatterns;

import designPatterns.patternInterfaces.ShapeInterface;

public class DecoratorPattern {
	public static void main(String[] args) {

	      ShapeInterface circle = new CircleD();

	      ShapeInterface redCircle = new RedShapeDecorator(new CircleD());

	      ShapeInterface redRectangle = new RedShapeDecorator(new RectangleD());
	      System.out.println("Circle with normal border");
	      circle.draw();

	      System.out.println("\nCircle of red border");
	      redCircle.draw();

	      System.out.println("\nRectangle of red border");
	      redRectangle.draw();
	   }	
}

 class RectangleD implements ShapeInterface {
   @Override
   public void draw() {
      System.out.println("Shape: Rectangle");
   }
}
 
 class CircleD implements ShapeInterface {
   @Override
   public void draw() {
      System.out.println("Shape: Circle");
   }
}
 
 abstract class ShapeDecorator implements ShapeInterface {
	   protected ShapeInterface decoratedShape;

	   public ShapeDecorator(ShapeInterface decoratedShape){
	      this.decoratedShape = decoratedShape;
	   }

	   public void draw(){
	      decoratedShape.draw();
	   }	
} 
 
class RedShapeDecorator extends ShapeDecorator {

	   public RedShapeDecorator(ShapeInterface decoratedShape) {
	      super(decoratedShape);		
	   }

	   @Override
	   public void draw() {
	      decoratedShape.draw();	       
	      setRedBorder(decoratedShape);
	   }

	   private void setRedBorder(ShapeInterface decoratedShape){
	      System.out.println("Border Color: Red");
	   }
}


/**
 * Output
 * Circle with normal border
Shape: Circle

Circle of red border
Shape: Circle
Border Color: Red

Rectangle of red border
Shape: Rectangle
Border Color: Red

 */
