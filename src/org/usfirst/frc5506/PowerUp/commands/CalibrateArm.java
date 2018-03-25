package org.usfirst.frc5506.PowerUp.commands;

import org.usfirst.frc5506.PowerUp.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class CalibrateArm extends CommandGroup {
	private static final double DEG_TO_ZERO = 11.0;//arm resting on base is at 11deg below x axis

	public CalibrateArm() {
		while(!(Robot.elbow.getForeLS().get()))//go down until we hit the bottom limit switch
			addSequential(new Curl(-1, false));
		
		addSequential(new Curl(DEG_TO_ZERO, false));//move up till arm is parallel to floor
		Robot.elbow.getArmPos().reset();//set to 0, because now its 0 degrees at parallel
		
		while(Robot.elbow.getArmPos().getDistance()<50)//move arm up until we hit 50 degrees
			addSequential(new Curl(1, false));
	}
}
