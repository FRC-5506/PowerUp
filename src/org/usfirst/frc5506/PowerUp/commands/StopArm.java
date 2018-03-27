package org.usfirst.frc5506.PowerUp.commands;

import org.usfirst.frc5506.PowerUp.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class StopArm extends Command {
	
	public StopArm() {
		//requires(Robot.arm);
	}
	
	@Override
	protected void execute() {
		//Robot.arm.stop();
		//setTimeout(1);
		//Robot.armMoving = false;
		System.out.println("StopArm: "+Robot.armMoving);
		//SmartDashboard.putBoolean(Robot.armMoving);//For testing
	}

	@Override
	protected boolean isFinished() {
		return /*!(Robot.armMoving)*/true;
	}

}
