import processing.core.*; 
import processing.xml.*; 

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

PImage i1,syd,a;
/**
void setup() {
  
   size(1280,800);
   
   i1 = loadImage("1.png");
   
}

void draw() {
 smooth();
  background(0);
 noStroke();
 
 fill(255);
 ellipse(mouseX, mouseY, 400, 400);
  image(i1,0,0);
 
 
 
 
   
}
/**/

public void setup()
{
  size(1280,800);
 a = loadImage("1.png");
}
public void draw()
{
  background(0);
 tint(255, 126);  // Apply transparency without changing color
image(a, 0, 0);
 noStroke();
 fill(255);
 ellipse(mouseX,mouseY, 400, 400);
 blend(a,0,0,1280,800,0,0,1280,800,DARKEST);
 
}


  static public void main(String args[]) {
    PApplet.main(new String[] { "--present", "--bgcolor=#666666", "--hide-stop", "mosaic" });
  }
}
