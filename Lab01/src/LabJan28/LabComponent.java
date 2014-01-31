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
		branchAngle = DEGREE*(i);
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
		colour = Color.blue;
		
		
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		w = getWidth();
		double h = getHeight();
		
		setBackground(Color.blue);
		setLength((int)h/2);
		treePosition[0] = 0.5;

		int width = (int) ((w/20)*shrinkFactor);
		for (int i = 0; i<treePosition.length;i++)
			if (treePosition[i] != 0)
					drawBranch(g2, treePosition[i]*w, h, getLength(), width, Math.PI);
		
		
		
	}
	
	public void drawBranch( Graphics2D g, 
			double startx, 
			double starty, 
			double length, 
			double width,
			double angle) 
	{ 
			//The equation used by the branches in order to expand 
			double endx = startx + Math.sin(angle) * Math.random () * length; 
			double endy = starty + Math.cos(angle) * Math.random () * length; 

			//attributes of branches 
			if( 1 < length ) { 
			g.setColor( length < 20*shrinkFactor ? randomizeColour(Color.green) :randomizeColour(brown));

			for(int i = 0; i<width; i++){
				g.setColor( length < 20*shrinkFactor ? randomizeColour(g.getColor()) :randomizeColour(brown));
				Line2D line = new Line2D.Double((int)startx-(Math.cos(angle)*i), (int)starty-Math.sin(angle)*i, (int)endx-(Math.cos(angle)*i*shrinkFactor), (int)endy-Math.sin(angle)*i*shrinkFactor );
				g.draw(line);
				g.setColor(randomizeColour(g.getColor()));
				line = new Line2D.Double((int)startx-Math.cos(angle)*(Math.random()*i), (int)starty-Math.sin(angle)*(Math.random()*i), (int)endx-Math.cos(angle)*i*shrinkFactor, (int)endy-Math.sin(angle)*i*shrinkFactor); 
				g.draw(line);
				g.setColor( length < 20*shrinkFactor ? randomizeColour(g.getColor()) :randomizeColour(brown));
				line = new Line2D.Double((int)startx+Math.cos(angle)*i, (int)starty+Math.sin(angle)*i, (int)endx+Math.cos(angle)*i*shrinkFactor, (int)endy+Math.sin(angle)*i*shrinkFactor );
				g.draw(line);
				g.setColor(randomizeColour(g.getColor()));
				line = new Line2D.Double((int)startx+Math.cos(angle)*(Math.random()*i), (int)starty+Math.sin(angle)*i, (int)endx+Math.cos(angle)*i*shrinkFactor, (int)endy+Math.sin(angle)*i*shrinkFactor ); 
				g.draw(line);
			}
			int j; int k;
			if (Math.random()<0.5) 
					{j = -1; k = 1;}
			else {j = 1; k = -1; }
			drawBranch( g, endx, endy, length * shrinkFactor, width*shrinkFactor, angle + k * branchAngle); 
			drawBranch( g, endx, endy, length * shrinkFactor, width*shrinkFactor, angle); 
			drawBranch( g, endx, endy, length * shrinkFactor,width*shrinkFactor, angle + j * branchAngle); 
			
	
			}
	} 
	
	public Color brown = new Color(139,69,19);
	
	private Color randomizeColour(Color c)
	{
		if (Math.random()<0.5)
			return c.darker();
		else return c.brighter();
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		double w = 1.5*(getWidth());
		double x = arg0.getX(); 
		setShrinkFactor(x/w);
		setBranchAngle(90*arg0.getY()/getHeight());
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
		

