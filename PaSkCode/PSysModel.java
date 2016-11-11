package PaSkCode;

import java.util.ArrayList;

public class PSysModel {
    // ArrayList or similar of particles
    // each particle: x, y, velX, velY, radius
    ArrayList<Particle> particleList;

    PSysModel() {
	// instantiate list of particles
    	particleList = new ArrayList<Particle>();
    }
    
    // add a particle to list
    void add(int rad, int x, int y, int vx, int vy) {
    	particleList.add(new Particle(rad, x, y, vx, vy));
    	System.out.print("Added a particle...\n");
    	System.out.println(particleList.get(particleList.size() - 1).toString());
    }
    
    // update state of each particle in list
    void update(int bw, int bh) {
    	int radius, x, y, velX, velY;
    	
    	for (int i = 0; i < particleList.size(); i++){
    		
    		//Get radius, x, y, velX, velY of particle
    		radius = pRadius(i);
    		x = pX(i);
    		y = pY(i);
    		velX = particleList.get(i).getVX();
    		velY = particleList.get(i).getVY();
    		
    		x += velX;
	    	y += velY;
	
	    	if (x >= bw - radius && velX > 0){
	    		velX = -velX;
	    	}
	    	else if (x < radius && velX < 0){
	    		velX = -velX;
	    	}
	    	
	    	if (y >= bh - radius && velY > 0){
	    		velY = -velY;
	    	}
	    	else if (y < radius && velY < 0){
	    		velY = - velY;
	    	}
	    	
	    	//Update Particle
	    	particleList.get(i).update(x, y, velX, velY);
    	}
    }
    
    /**
     * Gets radius of Particle object
     * 
     * @param  i Current index of particleList
     * @return   Radius of particle
     */
    public int pRadius(int i){
    	return particleList.get(i).getRad();
    }
    
    /**
     * Gets horizontal position of Particle
     * 
     * @param  i Current index of particleList
     * @return   Horizontal position of particle
     */
    public int pX(int i){
    	return particleList.get(i).getX();
    }
    
    /**
     * Gets vertical position of Particle
     * 
     * @param  i Current index of particleList
     * @return   Vertical position of particle
     */
    public int pY(int i){
    	return particleList.get(i).getY();
    }
    
    /**
     * Get horizontal velocity of Particle
     * 
     * @param  i Current index of particleList
     * @return   Horizontal velocity of particle
     */
    public int pVX(int i){
    	return particleList.get(i).getVX();
    }
    
    /**
     * Get vertical velocity of Particle
     * @param  i Current index of particleList
     * @return   Vertical velocity of Particle
     */
    public int pVY(int i){
    	return particleList.get(i).getVY();
    }
    
    /**
     * Get size of ArrayList of Particles
     * 
     * @return Size of particleList
     */
    public int getSize(){
    	return particleList.size();
    }
    
    private class Particle{
    	//Declare particle variables
    	private int x, y, velX, velY, radius;
    	
    	/**
    	 * Constructs a particle object
    	 * 
    	 * @param  rad Radius
    	 * @param  x   Horizontal Position
    	 * @param  y   Vertical Position
    	 * @param  vx  Horizontal Velocity
    	 * @param  vy  Vertical Position
    	 */
    	public Particle (int rad, int x, int y, int vx, int vy){
    		radius = rad;
    		this.x = x;
    		this.y = y;
    		velX = vx;
    		velY = vy;
    	}
    	
    	/**
    	 * Get horizontal position of current particle
    	 * 
    	 * @return Horizontal Position
    	 */
    	public int getX (){
    		return x;
    	}
    	
    	/**
    	 * Get vertical position of current particle
    	 * 
    	 * @return Vertical position
    	 */
    	public int getY (){
    		return y;
    	}
    	
    	/**
    	 * Get horizontal velocity of current particle
    	 * 
    	 * @return Horizontal Velocity
    	 */
    	public int getVX(){
    		return velX;
    	}
    	
    	/**
    	 * Get vertical velocity of current particle
    	 * 
    	 * @return Vertical Velocity
    	 */
    	public int getVY(){
    		return velY;
    	}
    	
    	/**
    	 * Get radius of particle
    	 * 
    	 * @return Particle Radius
    	 */
    	public int getRad(){
    		return radius;
    	}

    	/**
    	 * Updates the current particle with new values
    	 * 
    	 * @param px New Horizontal Position
    	 * @param py New Vertical Position
    	 * @param vx New Horizontal Velocity
    	 * @param vy New Vertical Velocity
    	 */
    	public void update(int px, int py, int vx, int vy){
    		x = px;
    		y = py;
    		velX = vx;
    		velY = vy;
    	}
    	
    	/**
    	 * Prints values of the particle
    	 * 
    	 * @return Values of the particle in String
    	 */
    	@Override
    	public String toString(){
    		return String.format("Radius:\t\t\t\t %5d\n"
    			+ "Horizontal Position (x):\t %5d\n"
    			+ "Vertical Position (y):\t\t %5d\n"
    			+ "Horizontal Velocity (velX):\t %5d\n"
    			+ "Vertical Velocity (velY):\t %5d\n\n",
    				radius, x, y, velX, velY);
    	}
    }
}
