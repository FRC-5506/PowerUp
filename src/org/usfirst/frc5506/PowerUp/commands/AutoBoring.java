package org.usfirst.frc5506.PowerUp.commands;

import org.usfirst.frc5506.PowerUp.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoBoring extends CommandGroup {
	public AutoBoring()
	{
		//wait
		System.out.println(Robot.waitTime);
		setTimeout(Robot.waitTime);
		new AutoStay();
		
		//just drive forward bang bang
		addSequential(new DriveLinear(400, '1'));//5 seconds
	}
}