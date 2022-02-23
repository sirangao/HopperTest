// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HopperSubsystem;

public class HopperCommand extends CommandBase {
  /** Creates a new HopperCommand. */

  HopperSubsystem hopper;

  public HopperCommand() {
    // Use addRequirements() here to declare subsystem dependencies.

    hopper = new HopperSubsystem();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if( !(hopper.getBreakbeam1()) ){
      hopper.setMotorSpeed(0.2);
    }

    if( !(hopper.previousState2) && hopper.getBreakbeam2() ){
      hopper.stopMotor();
    }

    hopper.previousState2 = hopper.getBreakbeam2();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
