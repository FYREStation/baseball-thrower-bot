package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class Shooter extends SubsystemBase {

    private final Victor shooterMotor1;
    private final Victor shooterMotor2;

    public Shooter() {
        shooterMotor1 = new Victor(ShooterConstants.shooterMotorPort1);
        shooterMotor2 = new Victor(ShooterConstants.shooterMotorPort2);

        setupMotors();
    }

    private void setupMotors() {
        shooterMotor1.addFollower(shooterMotor2);

        shooterMotor1.setInverted(true); // caden- Does this need to be here?
    }

    public void shoot(double speed) {
        shooterMotor1.set(speed);
    }

    public void stop() {
        shooterMotor1.stopMotor();
    }

    
}
