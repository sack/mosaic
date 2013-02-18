import processing.core.*; 
import processing.xml.*; 

import oscP5.*; 
import netP5.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class mosaic extends PApplet {



OscP5 oscP5;



PImage i1, syd, a,s;

float x1,y1,x2,y2;


public void setup()
{
  size(1280, 800);
  oscP5 = new OscP5(this,12000);
  a = loadImage("1.png");
  s = loadImage("spot.png");
}
public void draw()
{
  background(0);
  tint(255, 126);  // Apply transparency without changing color
  image(a, 0, 0);
  noStroke();
  fill(255);
  //ellipse(mouseX, mouseY, 400, 400);
  image(s, map(x1,0,1,0,width)-300, map(y1,0,1,0,height)-300,600,600);
  image(s, map(x2,0,1,0,width)-300, map(y2,0,1,0,height)-300,600,600);
    image(s, map(x1,0,1,0,width)-300, map(y1,0,1,0,height)-300,600,600);
  image(s, map(x2,0,1,0,width)-300, map(y2,0,1,0,height)-300,600,600);
  blend(a, 0, 0, 1280, 800, 0, 0, 1280, 800, DARKEST);
}


public void oscEvent(OscMessage theOscMessage) {

    String addr = theOscMessage.addrPattern();
    println(addr);
    if(theOscMessage.checkAddrPattern("/1/xy")==true) {
    /* check if the typetag is the right one. */
     //xy pad writes to values to one address
      
      x1 = theOscMessage.get(0).floatValue();
      y1= theOscMessage.get(1).floatValue();//XYpad[0] = theOscMessage.get(1).floatValue(); //buttons dont work if i put this(get(1)) into a float at begining of function...???
      println(x1+","+y1);
    }
     if(theOscMessage.checkAddrPattern("/2/xy")==true) {
    /* check if the typetag is the right one. */
     //xy pad writes to values to one address
      
      x2 = theOscMessage.get(0).floatValue();
      y2= theOscMessage.get(1).floatValue();//XYpad[0] = theOscMessage.get(1).floatValue(); //buttons dont work if i put this(get(1)) into a float at begining of function...???
      println(x1+","+y1);
    }

}

  static public void main(String args[]) {
    PApplet.main(new String[] { "--present", "--bgcolor=#666666", "--hide-stop", "mosaic" });
  }
}
