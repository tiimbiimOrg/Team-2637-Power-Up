package autonomous;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import robot.CatzConstants;
import robot.CatzRobotMap;

public class CatzAutonomousAlternatePaths
{
	static String gameData = DriverStation.getInstance().getGameSpecificMessage();
	
	public static void left_SwitchSingle() 
	{
		CatzPIDDrive.PIDDriveNoTrig(0.0, 150, 1.6);
		
		CatzPIDTurn.PIDturn(90, 1);
		
		CatzPIDDrive.PIDDriveNoTrig(0.0, 20, 1);
		
		CatzRobotMap.grabber.placeCube(-1.0);
		
		CatzRobotMap.grabber.retractBicep();
		
	}

	public static void right_SwitchSingle()
	{
		CatzPIDDrive.PIDDriveNoTrig(0.0, 150, 1.6);

		CatzPIDTurn.PIDturn(-90, 1);
			

		CatzPIDDrive.PIDDriveNoTrig(0.0, 20, 1);
		

		CatzRobotMap.grabber.placeCube(-1.0);
		
		CatzRobotMap.grabber.retractBicep();
	}

	public static void right_ScaleSingle()
	{
			CatzPIDDrive.PIDDriveNoTrig(0.0, 230, 6);
		
			CatzPIDTurn.PIDturn(-90, 1);
			

			CatzRobotMap.lift.liftToHeight(CatzConstants.LIFT_SCALE_HEIGHT);
			
			while (CatzRobotMap.lift.liftThreadRunning == true)
			{
				//Wait for thread to complete
				Timer.delay(0.005);
			}
			
			CatzRobotMap.grabber.placeCube(-0.8);
			
			CatzRobotMap.grabber.retractBicep();
			
			CatzRobotMap.lift.dropToGroundHeight();
	
	}

	public static void left_ScaleSingle()
	{
			CatzPIDDrive.PIDDriveNoTrig(0.0, 250, 6);
		
			CatzRobotMap.lift.liftToHeight(CatzConstants.LIFT_SCALE_HEIGHT);
			
			CatzPIDTurn.PIDturn(90, 1);
			
			CatzPIDDrive.PIDDriveNoTrig(5.5, 16, 1 );
			
			while (CatzRobotMap.lift.liftThreadRunning == true)
			{
				//Wait for thread to complete
				Timer.delay(0.005);
			}
			
			CatzRobotMap.grabber.placeCube(-0.8);
			
			CatzRobotMap.grabber.retractBicep();
			
			CatzRobotMap.lift.dropToGroundHeight();
	}

	public static void defaultPathLeft()
	{
		CatzPIDDrive.PIDDriveNoTrig(0.0, 210, 5.0);
		
		CatzPIDTurn.PIDturn(90, 1);
	}
lancaster
	public static void defaultPathRight()
	{
		CatzPIDDrive.PIDDriveNoTrig(0.0, 210, 5.0);
		
		CatzPIDTurn.PIDturn(-90, 1);
	}
	
lancaster
	public static void alternatePathChooser(String side)
	{
		if(side.equalsIgnoreCase("right"))
		{
			if(gameData.charAt(1) == 'R')
			{
				right_ScaleSingle();
			}
			else if(gameData.charAt(0)== 'R')
			{
				right_SwitchSingle();
			}
			else
			{
				defaultPathRight();
			}
		}
		else
		{
			if(gameData.charAt(1) == 'L')
			{
				left_ScaleSingle();
			}
			else if(gameData.charAt(0) == 'L')
			{
				left_SwitchSingle();
			}
			else
			{
				defaultPathLeft();
			}
		}
	}
}
