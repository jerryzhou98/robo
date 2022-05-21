// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

//use spark max instead of encoder for neo encoder
//use talonfx for falcons

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
//encoder
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/** Add your docs here. */
public class TurretSubsystem extends CommandBase {
  public static TalonSRX encoder;
  public static WPI_TalonSRX motor1;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public TurretSubsystem(){
    encoder = new TalonSRX(2);
    motor1 = new WPI_TalonSRX(1);
  }

  public double getAngle(){
    //this returns internal encoder ticks, have to convert to degree or radians
    double temp_angle = encoder.getSelectedSensorPosition();
    double angle = (double)360/2048 * temp_angle;
    return angle;
  }

  public void spinRight(){

    double angle = getAngle();

    if(-135 <= angle && angle <= 135){
      motor1.set(ControlMode.Position, getAngle()+1);
    }
    else if(angle >= 135){
      motor1.set(0);
    }
  } 

  public void spinLeft(){
    double angle = getAngle();
    if(-135 <= angle && angle <= 135){
      motor1.set(ControlMode.Position, getAngle()-1);
    }
    else{
      motor1.set(0);
    }
  }
  
  public void stopSpin(){
    motor1.set(0);
  }

  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
