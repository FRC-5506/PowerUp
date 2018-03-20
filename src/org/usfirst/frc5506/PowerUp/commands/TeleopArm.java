package org.usfirst.frc5506.PowerUp.commands;

import org.usfirst.frc5506.PowerUp.Robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public abstract class TeleopArm extends Command {
	
	/*private double elbowDown;
	private double elbowUp;
	private double elbowSpeed;
	private boolean driveMode;
	private Joystick joystick;

	public TeleopArm() {
		requires(Robot.arm);
	}
	
	protected void initialize() {
		driveMode = Robot.driveMode;
		joystick = Robot.oi.getjoystick();
	}
	
	protected void execute() {
		if(driveMode) {
        	//turn = 0.68*joystick.getX();
        	elbowSpeed = 0.75*joystick.getRawAxis(5);
        } else {
        	//turn = -0.75*joystick.getRawAxis(5);//make sure this is scaled the same as forward (left side)
        	elbowDown = joystick.getRawAxis(2);//left trigger
        	elbowUp = joystick.getRawAxis(3);//right trigger
        	
        	elbowSpeed = Math.max(elbowDown, elbowUp);//figure out which one is being pushed, then use it as elbowSpeed
        	if(elbowUp>elbowDown)//if going down,
        		elbowSpeed *= -1;//make sure motor runs in reverse
        }
        
    	if(Robot.elbow.getForeLS().get()&&elbowSpeed<0)//front limit switch triggered, and trying to push down
    		Robot.elbow.stop();								//stop the motor!
    	
    	if(Robot.elbow.getRearLS().get()&&elbowSpeed>0)//rear limit switch triggered, and trying to push up
    		Robot.elbow.stop();							 // then stop the motor!
		
        //Robot.driveBase.drive(forward, turn);
    	Robot.elbow.rotateArm(elbowSpeed);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
*/
}
