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
	private static final double MAX_TURN_TIME = 3.5;//TODO: Test how long it take to turn 90deg
	private double angle;
	private boolean timed;
	private double distanceAngle;
	
	public Turn(double angle, boolean timed) {
		requires(Robot.driveBase);
		
		this.angle = angle;
		this.timed = timed;
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		distanceAngle = angle*(0.195258710066866);//s=r(theta) -> ~17.57in = 11.1875in * (90deg=pi/2) --> 17.57in/90deg = 0.19... in / deg
		//a positive angle is right, negative is left
		if(timed)
			angle = Math.abs(angle);//if running on time, no negative seconds
	}
	
	//Called periodically while this Command is scheduled to run
	@Override
	protected void execute() {
		if(distanceAngle<0) {
			Robot.driveBase.getMotors().arcadeDrive(0, 0.25);//turn at 25%
			
			if(timed)//if in time mode
				setTimeout((angle/90)*MAX_TURN_TIME);//turn degrees into percentage where 100% is 90deg,
													 //then multiply by time it takes to turn 90deg
		} else {
			Robot.driveBase.getMotors().arcadeDrive(0, -0.25);//TODO: Make sure it turns the right way
			
			if(timed)//if in time mode
				setTimeout((angle/90)*MAX_TURN_TIME);//turn degrees into percentage where 100% is 90deg,
													 //then multiply by time it takes to turn 90deg
		}
	}
	
	@Override
	protected boolean isFinished() {
		if(!timed) {//if based on distance, then average distance and see if we've gone far enough
			if( ( ( Robot.driveBase.getLeftRotation().getDistance() + Robot.driveBase.getRightRotation().getDistance() ) / 2 ) >= distanceAngle)
				return true;
			else
				return false;
		} else {//if based on time, are we done?
			return isTimedOut();
		}
	}
	
	@Override
	protected void end() {
		Robot.driveBase.stop();
	}
	
	@Override
	protected void interrupted() {
		
	}
}
