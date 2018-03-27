package org.usfirst.frc5506.PowerUp.commands;

import org.usfirst.frc5506.PowerUp.Robot;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TeleopDrive extends Command {

	private double forward;
	private double turn;
	
	Joystick joystick;
	private double elbowSpeed;
	private double elbowDown;
	private double elbowUp;
	private boolean driveMode;
	
	public TeleopDrive() {
		requires(Robot.driveBase);
	}
	
	@Override
	protected void initialize() {
		driveMode = Robot.driveMode;
		joystick = Robot.oi.getjoystick();
	}
	
	@Override
	protected void execute() {
		forward = -1*joystick.getY();//forward is always left y axis
        
        if(driveMode) {
        	turn = 0.8*joystick.getX();
        	if(joystick.getRawAxis(5)<0)
        		elbowSpeed = 0.8*joystick.getRawAxis(5);
        	else
        		elbowSpeed = 0.85*joystick.getRawAxis(5);
        } else {
        	turn = -1*joystick.getRawAxis(5);//make sure this is scaled the same as forward (left side)
        	elbowDown = joystick.getRawAxis(2);//left trigger
        	elbowUp = joystick.getRawAxis(3);//right trigger
        	
        	elbowSpeed = Math.max(elbowDown, elbowUp);//figure out which one is being pushed, then use it as elbowSpeed
        	if(elbowUp>elbowDown)//if going down,
        		elbowSpeed *= -0.8;//make sure motor runs in reverse
        }
        //find which value is highest, and set rumble to that value, use absolute value so rumble method is happy
        Robot.oi.getjoystick().setRumble(RumbleType.kLeftRumble, (float) Math.max(Math.abs(forward), Math.abs(turn)));
        Robot.oi.getjoystick().setRumble(RumbleType.kRightRumble, (float) Math.max(Math.abs(forward), Math.abs(turn)));
        
        /*SmartDashboard.putNumber("ElbowSpeed", elbowSpeed);
        SmartDashboard.putBoolean("TeleopFORELS", Robot.elbow.getForeLS().get());
        SmartDashboard.putBoolean("TeleopREARLS", Robot.elbow.getRearLS().get());*/
        if( !(Robot.elbow.getForeLS().get()) && (elbowSpeed>0) )//front limit switch triggered, and trying to push down
    		elbowSpeed = 0;								//stop the motor!
    	
    	if( !(Robot.elbow.getRearLS().get()) && (elbowSpeed<0) )//rear limit switch triggered, and trying to push up
    		elbowSpeed = 0;							 // then stop the motor!
    	
        Robot.driveBase.drive(forward, turn);
    	Robot.elbow.rotateArm(elbowSpeed);
    	
    	SmartDashboard.putNumber("Elbow Encoder", Robot.elbow.getArmPos().getDistance());
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
}
