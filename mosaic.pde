import oscP5.*;
import netP5.*;
OscP5 oscP5;

boolean debug=false;


PImage i1, syd, a,s;

float x1,y1,x2,y2;


void setup()
{
  size(1280, 800);
  oscP5 = new OscP5(this,12000);
  a = loadImage("1.png");
  s = loadImage("spot.png");
}
void draw()
{
  background(0);
  tint(255, 126);  // Apply transparency without changing color
  image(a, 0, 0);
  noStroke();
  fill(255);
  //ellipse(mouseX, mouseY, 400, 400);
  image(s, map(x1,0,1,0,width)-300, map(y1,0,1,0,height)-300,600,600);
  image(s, map(x2,0,1,0,width)-300, map(y2,0,1,0,height)-300,600,600);
    image(s, map(x1,0,1,0,width)-300, map(y1,1,0,0,height)-300,600,600);
  image(s, map(x2,0,1,0,width)-300, map(y2,1,0,0,height)-300,600,600);
  blend(a, 0, 0, 1280, 800, 0, 0, 1280, 800, DARKEST);
}


void oscEvent(OscMessage theOscMessage) {

    String addr = theOscMessage.addrPattern();
    println(addr);
    if (debug) {
      text("message OSC : "+ addr , 20, 20);
    }
    
    if(theOscMessage.checkAddrPattern("/1/xy")==true) {
    /* check if the typetag is the right one. */
     //xy pad writes to values to one address
      
      x1 = theOscMessage.get(1).floatValue();
      y1= theOscMessage.get(0).floatValue();//XYpad[0] = theOscMessage.get(1).floatValue(); //buttons dont work if i put this(get(1)) into a float at begining of function...???
      println(x1+","+y1);
    }
     if(theOscMessage.checkAddrPattern("/2/xy")==true) {
    /* check if the typetag is the right one. */
     //xy pad writes to values to one address
      
      x2 = theOscMessage.get(1).floatValue();
      y2= theOscMessage.get(0).floatValue();//XYpad[0] = theOscMessage.get(1).floatValue(); //buttons dont work if i put this(get(1)) into a float at begining of function...???
      println(x1+","+y1);
    }

}

public void keyPressed() {
  if (key == 'd' || key == 'D')
    debug=!debug;
}
