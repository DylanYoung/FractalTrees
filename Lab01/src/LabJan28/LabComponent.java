package LabJan28;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.awt.Graphics2D;
//import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.util.List;

import javax.swing.JComponent;

public class LabComponent extends JComponent implements MouseMotionListener, MouseListener	{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	final double DEGREE = Math.PI/180; 

	private double shrinkFactor = .65;
	private double branchAngle = DEGREE*30;
	private Color colour = Color.black;
	private double length = 150;
	List<Double> ends;
	private int w;
	private double [] treePosition = new double [15];
	public void setLength(int i){
		length = i;
	}
	
	public double getLength(){
		return length;
	}
	
	public void setShrinkFactor(double i){
		shrinkFactor = i;
	}
	
	public void setBranchAngle(int i){
		branchAngle = DEGREE*(i%90);
	}
	
	public double getShrinkFactor(){
		return shrinkFactor;
	}
	
	public double getBranchAngle(int i){
		return branchAngle;
	}
	
	public Color getColour(){
		return colour;
	}
	
	public Color setColour(Color c){
		return colour = c;
	}
	
	
	public LabComponent(){
		colour = Color.black;
		
		
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		w = getWidth();
		double h = getHeight();
		
		g2.setBackground(getBackground());
		setLength((int)h/2);
		treePosition[0] = 0.5;

		//Rectangle r = this.getBounds();
		
		for (int i = 0; i<treePosition.length;i++)
			if (treePosition[i] != 0)
					drawBranch(g2, treePosition[i]*w, h, getLength(), Math.PI);
		System.out.println(branchAngle);
		System.out.println(shrinkFactor);
		//repaint();
		
		
		
	}
	
	public void drawBranch( Graphics2D g, 
			double startx, 
			double starty, 
			double length, 
			double angle) 
	{ 
			//The equation used by the branches in order to expand 
			double endx = startx + Math.sin(angle) * Math.random () * length; 
			double endy = starty + Math.cos(angle) * Math.random () * length; 

			//attributes of branches 
			if( 1 < length ) { 
			g.setColor( length < 5 ? Color.green : Color.black ); 
			Line2D line = new Line2D.Double((int)startx, (int)starty, (int)endx, (int)endy ); 
			g.draw(line);
			drawBranch( g, endx, endy, length * shrinkFactor, angle - branchAngle); 
			drawBranch( g, endx, endy, length * shrinkFactor, angle + branchAngle); 
			drawBranch( g, endx, endy, length * shrinkFactor, angle); 
	
			}
	} 

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		double w = 1.5*(getWidth());
		double x = arg0.getX(); 
		setShrinkFactor(x/w);
		setBranchAngle(arg0.getY());
		repaint();
		
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		
		// TODO Auto-generated method stub

		repaint();
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		int j = 0;
		for (int i = 1; i < treePosition.length; i++){
			if (treePosition[i]==0){
				j = i;
				i = treePosition.length;
			}
		}	
		if (j != 0) treePosition[j] = Math.random();

		repaint();
		
	}
}
		

