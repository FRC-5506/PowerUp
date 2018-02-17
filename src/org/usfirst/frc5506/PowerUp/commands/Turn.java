/**
 * 
 */
package org.usfirst.frc5506.PowerUp.commands;

import org.usfirst.frc5506.PowerUp.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Dan McKeon
 * Sorry Y'all for the weird format, This was handcrafted
 *	No robot builder involved
 */
public class Turn extends Command {
	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.command.Command#isFinished()
	 */
	
	public Turn(double angle) {
		requires(Robot.driveBase);
		
		this.angle = angle;
		distanceAngle = angle*(0.195258710066866);//s=r(theta) -> ~17.57in = 11.1875in * (90deg=pi/2) --> 17.57in/90deg = 0.19... in / deg
		//a positive angle is right, negative is left
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}
	
	//Called periodically while this Command is scheduled to run
	@Override
	protected void execute() {
			Robot.driveBase.drive(0, 0.25);
	}
	
	@Override
	protected boolean isFinished() {
		if(Robot.driveBase.leftRevs.getDistance() >= distanceAngle)
			return true;
		else
			return false;
	}
	
	@Override
	protected void end() {
		
	}
	
	@Override
	protected void interrupted() {
		
	}

	protected double angle;
	protected double distanceAngle;
}
