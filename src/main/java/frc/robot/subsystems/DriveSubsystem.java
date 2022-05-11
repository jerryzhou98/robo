// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;

public class DriveSubsystem extends CommandBase {

  public WPI_TalonSRX leftMaster = new WPI_TalonSRX(Constants.leftMasterPort);
  public WPI_TalonSRX leftSlave = new WPI_TalonSRX(Constants.leftSlavePort);
  public WPI_TalonSRX rightMaster = new WPI_TalonSRX(Constants.rightMasterPort);
  public WPI_TalonSRX rightSlave = new WPI_TalonSRX(Constants.rightSlavePort);

  public DifferentialDrive drive = new DifferentialDrive(leftMaster, rightMaster);

  public DriveSubsystem() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);q
    leftSlave.follow(leftMaster);
    rightSlave.follow(rightMaster);
  }

  public void manualDrive(double move, double turn){
    drive.arcadeDrive(move, turn);
  }
  // Called just before this Command runs the first time
  @Override
  public void initialize() {}

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {}

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  protected void end() {}

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  protected void interrupted() {}
}
