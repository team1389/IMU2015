package com.team1389;

import com.team1389.auton.DriveStraight;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public abstract class GenericDriver extends Component {
	public static final int STRICT_COMPUTER=0;
	public static final int FULL_USER=1;
	public static final int COMPUTER_ASSISTED=2;

	public abstract void setRampMode(int mode);
	public abstract void drive(double direction, double magnitude);
	
	
	private DriveStraight straight;
	
	public GenericDriver() {
		straight = new DriveStraight(Robot.state.imu, .4);
	}
	
	@Override
	public void autonConfig() {
		Robot.driveControl.setRampMode(GenericDriver.FULL_USER);
		SmartDashboard.putString("i am", "staring auton");
		straight.setSetpoint(Robot.state.imu.getYaw());
		straight.enable();
	}

	@Override
	public void autonTick() {
	}
	
	@Override
	public void onDisable() {
		SmartDashboard.putString("i am", "diabled");
		straight.disable();
	}

}