package exercise5;

import java.util.HashMap;

interface Bird {
	   void draw();
}

class AngryBird implements Bird {
    private String color;


    public AngryBird(String color){
       this.color = color;       
    }

    @Override
    public void draw() {
       System.out.println("Angry Bird: Draw() [Color : " + color);
    }
 }

class BirdFactory {
 
	private static final HashMap angrybirdMap = new HashMap();
 
    public static Bird getAngryBird(String color) {
    	AngryBird angrybird = (AngryBird)angrybirdMap.get(color);
 
        if(angrybird == null) {
        	angrybird = new AngryBird(color);
            angrybirdMap.put(color, angrybird);
            System.out.println("Creating Angry Bird of color : " + color);
          }
          return angrybird;
      }
 }

public class FlyweightPattern {
	private static final String colors[] = { "Red", "Orange", "Blue", "Yellow", "Pink" };
	
	public static void main(String[] args) {
	 
		for(int i=0; i < 20; ++i) {
			AngryBird angrybird = (AngryBird)BirdFactory.getAngryBird(getRandomColor());
	              
			angrybird.draw();
		}
	}
	private static String getRandomColor() {
		return colors[(int)(Math.random()*colors.length)];
	}
}
