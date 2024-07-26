package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.ShooterConstants;

public class Shooting extends Command {
    private final Shooter shooter;
    private final CommandXboxController controller;
    private boolean isToggle;
    private final double speed;
    private boolean isRbPressed;
    private boolean isToggleShouldBeRunning;

    public Shooting(Shooter shooter) {
        this.shooter = shooter;
        this.isToggle = ShooterConstants.isToggleDefault;
        controller = RobotContainer.controller;
        this.speed = ShooterConstants.speed;

        addRequirements(shooter);
    }

    


    @Override
    public void execute() {
        if (isRbPressed) {
            if (isToggle) {
                if (isToggleShouldBeRunning) {
                    shooter.shoot(speed);
                } else {
                    shooter.stop();
                }
            } else {
                shooter.shoot(speed);
            }
        }

    }

    public void toggleShootingMode() {
        isToggle = !isToggle;
        isToggleShouldBeRunning = false;

    }
    

    public void toggleRbButton() {
        isRbPressed = !isRbPressed;
    }

    public Command toggleShootingMode = Commands.runOnce(() -> toggleShootingMode());

    public Command toggleRbButton = Commands.runOnce(() -> toggleRbButton());
}
