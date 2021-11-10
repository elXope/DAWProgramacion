// Daniel Shiffman
// http://codingtra.in
// http://patreon.com/codingtrain
// Code for: https://youtu.be/AaGK-fj-BAM

let img;
function preload(){
  img = loadImage("./gorila.png")
}

function setup() {
  createCanvas(600, 600);
  image(img,10,10);
}