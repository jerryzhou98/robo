// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TurretSubsystem;

public class TurretTurnLeft extends CommandBase {
  PS4Controller m_controller;
  TurretSubsystem m_turret;

  public TurretTurnLeft(TurretSubsystem temp) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    m_turret = temp;
    addRequirements(m_turret);
  }

  private void addRequirements(TurretSubsystem m_turret2) {
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {}

  // Called repeatedly when this Command is scheduled to run
  public void execute() {
    boolean turn = m_controller.getL2ButtonPressed();
    if(turn){
      m_turret.spinLeft();
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  public boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  protected void end() {}

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  protected void interrupted() {}
}
