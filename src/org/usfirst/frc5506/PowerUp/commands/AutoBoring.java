package org.usfirst.frc5506.PowerUp.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoBoring extends CommandGroup {
	public AutoBoring()
	{
		//just drive forward bang bang
		addSequential(new DriveLinear(1000, '2'));//5 seconds
	}
}