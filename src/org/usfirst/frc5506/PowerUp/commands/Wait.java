package org.usfirst.frc5506.PowerUp.commands;

import org.usfirst.frc5506.PowerUp.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * 
 * NOTE: This command will robustly ONLY stop the drive base, it could stop elbow and pneumatics,
 * but I am not sure and if it does it is not as robustly coded.
 * 
 * @author Dan
 *
 */
public class Wait extends Command {

	private double time;
	
	public Wait(double time) {
		requires(Robot.driveBase);//Only requires driveBase -- reason not as robust, can only require one subsystem
		
		this.time = time;
	}
	
	@Override
	protected void execute() {
		setTimeout(time);
	}
	
	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

}
