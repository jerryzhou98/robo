// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;

/** Add your docs here. */
public class Turret extends CommandBase {
  public static Encoder encoder;
  public static WPI_TalonSRX motor1;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public Turret(){
    encoder = new Encoder(Constants.encoderPortChannelA, Constants.encoderPortChannelB);
    motor1 = new WPI_TalonSRX(1);
  }

  public void spinRight(){
    int angle = encoder.getRaw() * /*gear ratio*/ 360 /* / ticks per rotation*/ - 180;
    if(-135 <= angle && angle <= 135){
      motor1.set(0.7);
    }
    else if(angle >= 135){
      motor1.set(0);
    }
  } 

  public void spinLeft(){
    int angle = encoder.getRaw() * /*gear ratio*/ 360 /* / ticks per rotation*/ - 180;
    if(-135 <= angle && angle <= 135){
      motor1.set(-0.7);
    }
    else{
      motor1.set(0);
    }
  }
  

  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
