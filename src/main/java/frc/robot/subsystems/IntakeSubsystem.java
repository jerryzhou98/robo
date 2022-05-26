// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** Add your docs here. */
public class IntakeSubsystem extends CommandBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //try to code for a pnuematic intake
  public static WPI_TalonSRX motor;

  public IntakeSubsystem(){
    motor = new WPI_TalonSRX(1); //add constants
  }

  public void start(){
    motor.set(0.5);
  }

  public void stop(){
    motor.set(0.0);
  }

  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
