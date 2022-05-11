// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** Add your docs here. */
public class Turret extends CommandBase {
  public static Encoder encoder;
  public static WPI_TalonSRX motor1;
  public static PS4Controller m_controller;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public Turret(){
    encoder = new Encoder(0, 1);
    motor1 = new WPI_TalonSRX(1);
  }

  public void spin(){
    int angle = encoder.getRaw() * /*gear ratio*/ 360 /* / ticks per rotation*/ - 180;
    boolean good = check(angle);
    if(good){
      /* implement the joysticks*/
      if(m_controller.getL2ButtonPressed()){
        motor1.set(-0.7);
      }
      else{
        motor1.set(0.7);
      }
    }
    else{
      //read the joystick spin
      if(angle <= -135 && m_controller.getR2ButtonPressed()){
        motor1.set(0.7);
      }
      else if(angle >= 135 && m_controller.getL2ButtonPressed()){
        motor1.set(-0.7);
      }
      else{
        motor1.set(0);
      }
    }
  }

  public boolean check(int a){
    if(-135<= a && a <= 135){
      return true;
    }
    else{
      return false;

    }
  }

  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
