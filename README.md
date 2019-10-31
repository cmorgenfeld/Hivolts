# Hivolts



INTRODUCTION
	The goal of this Hivolts project is to create a relatively complex game where You(displayed on the board 
	as a viking head) have the goal of killing all the Mhos(displayed as angsty storm clouds) while avoiding electric fences
	as well as avoiding being "killed" by the mhos. You are allowed to move up, right, down, left, up-right, up-left, down-right, 
	down-left, or stay at the same spot with the arrow keys "w, d, x, a, e, q, c, z, and s" respectively. During each turn, each mho
	moves towards you, where the direction of their move is determined by your relative position to theirs. You are also allowed to jump
	with the key "j", where you will move to a random spot on the 12x12 grid, and you are guaranteed to not land on an electric fence,
	but you may land on a mho, and die. 
	
FULFILLS THE SPECIFICATION
	It fulfills the specification because the game successfully runs. 
CURRENT ERRORS
	Right now, our code is not optimized, so if we had more time, we would go through our code and focus on making it efficient so that it
	would run smoothly without lag on all kinds of computers. 
STRUCTURE OF CODE
	1) GamePiece.java
		general code that all game pieces need; x and y coordinates; +1 for x is move right, +1 for y is move up
		there are also getters and setters
	2) Fence.java
		creates image of the sprite and the fence
	3) Grid.java
		has a public instance variable "field" that is a 2D array representation of the gameboard of Gamepieces
		has the init() method which randomly generates the mhos, fences, and where You start.
	4) MainDraw.java
		draws the board, You, mhos, and fence
	5) MainFrame.java
		package Mr. Kuszmaul provided; it implements the moving methods for the key events; different pressed keys creates different movements
		has the main method
	6) Mho.java
		has the method drawMho that uses a png to draw a sprite
		moves according to the postion of You (tries to move closer)
	7) You.java
		has the method drawYou that uses a png to draw a sprite
		method jump to move randomly once you press "j"; guaranteed to not be a fence
		stops moving if You hit a fence; "dies" if You hit fench or a m
		googledotcom
		
		
MAJOR CHALLENGES
	One major challenge was working as a group and figuring out how to be constantly updated on code that has 
	either just been written or recently revised. Although Github was a useful resource in approaching this challenge, 
	Github does not have a real-time projection of our group's code, so we often came to class all having slightly different code. 
ACKNOWLEDGEMENTS
	Creighton, Sergey, Jeffrey, and Connie were all equal contributors to this project. Mr. Kuszmaul took the role of advisor, mentor, and
	most importantly, moral support.



























































