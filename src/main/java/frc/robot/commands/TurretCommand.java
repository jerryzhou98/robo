// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TurretSubsystem;

public class TurretCommand extends CommandBase {
  private final TurretSubsystem m_turret;
  public static PS4Controller m1_controller;

  public TurretCommand(TurretSubsystem t) {
    m_turret = t;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    addRequirements(m_turret);
  }

  private void addRequirements(TurretSubsystem m_turret2) {
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {}

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    // define the controller inputs
    boolean l1_pressed = m1_controller.getL1Button();
    if (l1_pressed){
      m_turret.spinLeft();
    }
    boolean l2_pressed = m1_controller.getL2Button();
    if (l2_pressed){
      m_turret.spinRight();
    }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  //@Override
  public void end() {}

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  //@Override
  public void interrupted() {}
}
