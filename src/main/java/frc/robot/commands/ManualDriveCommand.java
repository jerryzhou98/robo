// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.lang.module.ModuleDescriptor.Requires;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.*;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

public class ManualDriveCommand extends CommandBase {

  private final PS4Controller m_controller;
  private final DriveSubsystem m_driveSubsystem;

  public ManualDriveCommand(DriveSubsystem driveSubsystem, PS4Controller controller) {
    m_driveSubsystem = driveSubsystem;
    m_controller = controller;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    addRequirements(m_driveSubsystem, m_controller);
  }
  //note: please copy whatever the actual code is supposed to be from github
  private void addRequirements(DriveSubsystem m_driveSubsystem2, PS4Controller m_controller2) {
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {}

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    double move = -1 * m_controller.getLeftY();
    double turn = m_controller.getRightX();

    RobotContainer.driveSubsystem.manualDrive(move, turn);
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
