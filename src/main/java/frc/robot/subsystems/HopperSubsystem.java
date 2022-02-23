// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HopperSubsystem extends SubsystemBase {
  /** Creates a new HopperSubsystem. */

  private TalonSRX hopperMotor;
  private DigitalInput breakbeam1;
  private DigitalInput breakbeam2;

  public boolean previousState2;

  public HopperSubsystem() {
    hopperMotor = new TalonSRX(0);
    breakbeam1 = new DigitalInput(7);
    breakbeam2 = new DigitalInput(8);

    previousState2 = false;
  }

  public boolean getBreakbeam1(){
    return breakbeam1.get();
  }

  public boolean getBreakbeam2(){
    previousState2 = breakbeam2.get();
    return previousState2;
  }

  // public boolean breakBeam2State(){
  //   boolean previousState2 = getBreakbeam2();
  //   return previousState2;
  // }

  public void setMotorSpeed(double speed){
    hopperMotor.set(ControlMode.PercentOutput, speed);
  }

  public void stopMotor(){
    setMotorSpeed(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
