package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class Driving extends Command {
  private final DriveTrain driveTrain;
  private final CommandXboxController driverController;
  private boolean isTank = true;
  private double leftStick;
  private double rightStick;

  public Driving(DriveTrain driveTrain) {
    this.driveTrain = driveTrain;
    driverController = RobotContainer.driverController;

    addRequirements(driveTrain);
  }

  @Override
  public void execute() {

    leftStick = driverController.getLeftY();
    rightStick = isTank ? driverController.getRightY() : driverController.getRightX();

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
