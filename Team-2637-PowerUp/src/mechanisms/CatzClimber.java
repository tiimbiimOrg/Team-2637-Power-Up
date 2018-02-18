package mechanisms;

import org.usfirst.frc.team2637.robot.CatzRobotMap;
import constants.CatzConstants;

/*
 *  Author : Derek Duenas
 *  Last Revised : 2-4-2018 DD
 *  Added functionality to be able to climb
 *  Methods : climb
 *  Functionality : Climb
 */

public class CatzClimber 
{
	public void climbUp()
	{
		CatzRobotMap.climberMotor.set(CatzConstants.CLIMB_SPEED);
		//instance.climber2.set(CatzConstants.CLIMB_SPEED);
	}
	public void climbDown()
	{
		CatzRobotMap.climberMotor.set(-CatzConstants.CLIMB_SPEED);
		//instance.climber2.set(-CatzConstants.CLIMB_SPEED);
	}
	public void stopClimb()
	{
		CatzRobotMap.climberMotor.set(CatzConstants.ZERO);
		//instance.climber2.set(CatzConstants.ZERO);
	}
}
