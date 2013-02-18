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

void setup()
{
  size(1280,800);
 a = loadImage("1.png");
}
void draw()
{
  background(0);
 tint(255, 126);  // Apply transparency without changing color
image(a, 0, 0);
 noStroke();
 fill(255);
 ellipse(mouseX,mouseY, 400, 400);
 blend(a,0,0,1280,800,0,0,1280,800,DARKEST);
 
}


