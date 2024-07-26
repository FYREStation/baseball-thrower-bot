// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int controllerPort = 0;
  }
  public static class DriveConstants {
    public static final int leftMotorPort1 = 1;
    public static final int rightMotorPort1 = 2;
    public static final int leftMotorPort2 = 3;
    public static final int rightMotorPort2 = 4;
    public static final int leftMotorPort3 = 5;
    public static final int rightMotorPort3 = 6;
    public static final boolean isTankDefault = true;

    public static final double deadband = 0.25;

  }

  public static class ShooterConstants {
    public static final int shooterMotorPort1 = 7;
    public static final int shooterMotorPort2 = 8;
    public static final boolean isToggleDefault = false;
    public static final int speed = 1;
  }
}