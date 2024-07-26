package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.DriveConstants;

public class Driving extends Command {
  private final DriveTrain driveTrain;
  private final CommandXboxController controller;
  private boolean isTank;
  private double leftStick;
  private double rightStick;

  public Driving(DriveTrain driveTrain) {
    this.driveTrain = driveTrain;
    this.isTank = DriveConstants.isTankDefault;
    controller = RobotContainer.controller;

    addRequirements(driveTrain);
  }

  @Override
  public void execute() {

    leftStick = controller.getLeftY();
    rightStick = isTank ? controller.getRightY() : controller.getRightX();

    if (isTank) 
    {
      driveTrain.tankDrive(rightStick, leftStick);
    } 
    
    else 
    {
      driveTrain.arcadeDrive(rightStick, leftStick);
    }
  }

  public void toggleDriveMode() {
    isTank = !isTank;
  }

  public Command toggleDriveMode = Commands.runOnce (() -> toggleDriveMode());


    
}
