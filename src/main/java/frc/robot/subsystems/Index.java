// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Index extends SubsystemBase {
  private CANSparkMax index1, index2; 
  private VictorSP fire; 
  /** Creates a new Index. */
  public Index() {
    index1 = new CANSparkMax(Constants.leftIndex, MotorType.kBrushless); 
    index1.setClosedLoopRampRate(0);
    index1.setOpenLoopRampRate(0); 
    index1.setIdleMode(IdleMode.kBrake); 
    index1.setInverted(true);

    index2 = new CANSparkMax(Constants.rightIndex, MotorType.kBrushless); 
    index2.setClosedLoopRampRate(0);
    index2.setOpenLoopRampRate(0); 
    index2.setIdleMode(IdleMode.kBrake); 
    index2.setInverted(false);

    fire = new VictorSP(0); 

  }
  
  public void indexBall(double speed){
    index1.set(speed);
    index2.set(speed);
  }

  public void fire(double speed){
    fire.set(0.8);
    indexBall(speed);
  }

  public void stopIndex(){
    index1.set(0);
    index2.set(0);
    fire.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
