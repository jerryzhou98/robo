// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.HoodDown;
import frc.robot.commands.HoodUp;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.ShooterCommand;
import frc.robot.commands.TurretTurnLeft;
import frc.robot.commands.TurretTurnRight;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.HoodSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.TurretSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Button;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  final PS4Controller m_controller = new PS4Controller(1);
  final XboxController m_xbox = new XboxController(1);
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  public Joystick stick = new Joystick(Constants.joystickPort);

  public static DriveSubsystem driveSubsytem = new DriveSubsystem();
  public final DriveCommand driveCommand = new DriveCommand(m_controller,driveSubsytem);

  public static ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  public final ShooterCommand shooterCommand = new ShooterCommand(shooterSubsystem);

  public static IntakeSubsystem m_intake = new IntakeSubsystem();
  public final IntakeCommand intakeCommand = new IntakeCommand(m_intake);

  public static TurretSubsystem m_turret = new TurretSubsystem();
  public final TurretTurnLeft turretleft = new TurretTurnLeft(m_turret);
  public final TurretTurnRight turretright = new TurretTurnRight(m_turret);

  public static HoodSubsystem m_hood = new HoodSubsystem();
  public final HoodDown hoodown = new HoodDown(m_hood);
  public final HoodUp hoodup = new HoodUp(m_hood);



  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new Button(m_controller::getL2Button)
      .whileHeld(turretleft);
    new Button(m_controller::getR2Button)
      .whenHeld(turretright);
    new Button(m_xbox::getAButton)
      .whenPressed(intakeCommand);
    new Button(m_controller::getL1Button)
      .whenHeld(hoodup);
    new Button(m_controller::getR1Button)
      .whenHeld(hoodown);
    new Button(m_controller::getSquareButton)
      .whenPressed(shooterCommand);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
