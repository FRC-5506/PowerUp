package org.usfirst.frc5506.PowerUp.commands;

import org.usfirst.frc5506.PowerUp.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TeleopArm extends Command {
	
	public TeleopArm() {
		requires(Robot.arm);
		
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

}
