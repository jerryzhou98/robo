// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends CommandBase {

  PS4Controller m_controller;
  DriveSubsystem m_driveSubstystem;

  public DriveCommand(PS4Controller controller, DriveSubsystem drivetrainSubsystem) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    m_driveSubstystem = drivetrainSubsystem;
    addRequirements(m_driveSubstystem);
  }

  /*private void addRequirements(DriveSubsystem m_driveSubstystem2) {
  }*/

  // Called just before this Command runs the first time
  @Override
  public void initialize() {}

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    double move = -1 * m_controller.getLeftY();
    double turn = m_controller.getRightX();

    m_driveSubstystem.manualDrive(move, turn);
  }

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
