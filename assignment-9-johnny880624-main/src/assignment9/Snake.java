package assignment9;

import java.awt.Color;
import java.util.LinkedList;

import edu.princeton.cs.introcs.StdDraw;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	private BodySegment head1; 
	private BodySegment tail;
	
	public Snake() {
		//FIXME - set up the segments instance variable
		this.segments = new LinkedList<>();
		this.head1 = new BodySegment(0.5, 0.5, SEGMENT_SIZE);
		this.segments.add(head1);
		this.tail= head1;
		this.deltaX = 0;
		this.deltaX = 0;
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	
	public void move() {
	    // Calculate new position for the head
	    double newHeadX = head1.getX() + this.deltaX;
	    double newHeadY = head1.getY() + this.deltaY;

	    // Move the body segments (excluding the head)
	    for (int i = segments.size() - 1; i > 0; i--) {
	        BodySegment current = segments.get(i);
	        BodySegment ahead = segments.get(i - 1);
	        current.setX(ahead.getX());
	        current.setY(ahead.getY());
	    }

	    // Update the head position
	    head1.setX(newHeadX);
	    head1.setY(newHeadY);
	}


	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		//FIXME
		int count = 0;
//		for (int i =0; i < segments.size(); i ++) {
//			segments.get(i).draw();
//		}
		for (BodySegment var : segments) {
		    var.draw();
		    System.out.println(count+1);
		    System.out.print(var.getX());
//		    StdDraw.setPenColor(Color.BLUE);
//			StdDraw.filledCircle(var.getX(), var.getY(), SEGMENT_SIZE);
		}
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {
		//FIXME
		if(Math.sqrt(Math.pow(f.getX() - head1.getX(), 2) + Math.pow(f.getY() - head1.getY(), 2)) <SEGMENT_SIZE*2) {
			double tailX = this.tail.getX();
	        double tailY = this.tail.getY();
			this.move();
			BodySegment newSegment = new BodySegment(tailX,tailY,SEGMENT_SIZE);
			this.segments.add(newSegment);
			//this.tail = newSegment;
			return true;
		}
		return false;
	}
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
		//FIXME
		if (this.head1.getX() < SEGMENT_SIZE || this.head1.getX() > 1-SEGMENT_SIZE || this.head1.getY() < SEGMENT_SIZE || this.head1.getY() > 1-SEGMENT_SIZE) {
			return false;
		}
		return true;
	}
//	public void move1() {
//		//FIXME
//		// old segments
//		LinkedList<BodySegment> segments_temp = new LinkedList<>();
//		for (int i=0; i<this.segments.size(); i++) {
//			segments_temp.add(segments.get(i));
//		}
//		//Head
//		BodySegment head = this.segments.getFirst();
//		head.setX(head.getX()+this.deltaX);
//		head.setY(head.getY()+this.deltaY);
//		
//		//Body
//		for (int i=0; i<this.segments.size()-1; i++) {
//			segments.set(i+1, segments_temp.get(i));
//		}
//		
//		// tail
//		this.tail = segments_temp.getLast();
//	}

}
