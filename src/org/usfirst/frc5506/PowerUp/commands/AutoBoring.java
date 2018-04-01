package org.usfirst.frc5506.PowerUp.commands;

import org.usfirst.frc5506.PowerUp.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoBoring extends CommandGroup {
	public AutoBoring()
	{
		//wait
		addSequential(new Wait(Robot.waitTime));
		
		//just drive forward bang bang
		addSequential(new DriveLinear(132, '0'));//0 is based on encoders
		
		//addSequential(new Curl(100, false));
	}
}