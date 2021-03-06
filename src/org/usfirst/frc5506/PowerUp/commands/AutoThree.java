// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5506.PowerUp.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc5506.PowerUp.*;

/**
 * In a command group, you can run many sequenced commands. To do so, use addSequential(Command command) methods or
 * addParallel(Command command). An addParallel will run at the same time as the command beneath it.
 **/
public class AutoThree extends CommandGroup {
	
	private char endPosition;
	
	public AutoThree() {
		this.endPosition = Robot.endPosition;
		
		addSequential(new Wait(Robot.waitTime));
		
		String gameData = Robot.gameData;
		if(gameData!=null&&endPosition=='b') {//if gameData exists, do auto			
			if(Robot.gameData.charAt(0)=='R') {
				addSequential(new DriveLinear(132, '0'));//0 is based on encoders

				addSequential(new Turn(-90, false));
				addSequential(new DriveLinear(300, '1'));//timed drive forward so if we hit switch early its okay
				addSequential(new MoveHand(false));
			} else {
				addSequential(new DriveLinear(6, '0'));
				addSequential(new Turn(-56.8, false));
				addSequential(new DriveLinear(245, '0'));
				addSequential(new Turn(56.8, false));
				addSequential(new DriveLinear(300, '1'));
				addSequential(new MoveHand(false));
				
			}
		}/* else if(endPosition=='c'&&gameData!=null) {
			if(gameData.charAt(1)=='R') {
				addSequential(new DriveLinear(6, '0'));
				addSequential(new )
			}
		}*/
			
			/*switch(endPosition) {
			case 'a'://L == R for a
				addSequential(new DriveLinear(4));
				addSequential(new Turn(45));
				addSequential(new DriveLinear(47.376154));
				addSequential(new Turn(-45));
				addSequential(new DriveLinear(84.75));
				break;
				
			case 'b':
				//addSequential(new AutoThree('a', "R"));
				addSequential(new DriveLinear(4));
				addSequential(new Turn(45));
				addSequential(new DriveLinear(47.376154));
				addSequential(new Turn(-45));
				addSequential(new DriveLinear(84.75));
				//end AutoThree(a)
				
				if(gameData.charAt(0)=='R') {
					addSequential(new DriveLinear(85));
					addSequential(new Turn(-90));
					addParallel(new Curl(30));
					addSequential(new DriveLinear(45));
					//At same time as above command is running, lower arm
					addSequential(new MoveHand(true));
				} else {
					addSequential(new DriveLinear(153.75));
					addSequential(new Turn(-90));
					addSequential(new DriveLinear(284));
					addSequential(new Turn(-90));
					addSequential(new DriveLinear(68.75));
					addSequential(new Turn(-90));
					addParallel(new Curl(30));
					addSequential(new DriveLinear(45));
					//Same time as above command, run the command below
					addSequential(new MoveHand(true));
					break;
				}
			}*/
		
	}
}
