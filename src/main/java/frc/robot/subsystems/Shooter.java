package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel;


public class Shooter extends SubsystemBase {

    private final CANSparkMax shooterMotor1;
    private final CANSparkMax shooterMotor2;
    private final Servo shooterServo;

    public Shooter() {
        shooterMotor1 = new CANSparkMax(
            ShooterConstants.shooterMotorPort1,
            CANSparkLowLevel.MotorType.kBrushless
        );

        shooterMotor2 = new CANSparkMax(
            ShooterConstants.shooterMotorPort2,
            CANSparkLowLevel.MotorType.kBrushless
        );

        shooterServo = new Servo(ShooterConstants.servoMotorPort);
        
        setupMotors();
    }

    private void setupMotors() {
        shooterMotor2.follow(shooterMotor1, true);
        shooterMotor1.setInverted(true);
    }

    public void shoot(double speed) {
        shooterMotor1.set(speed);
    }

    public void stop() {
        shooterMotor1.stopMotor();
    }

    public void pushBall() {
        shooterServo.set(0.15);
    }

    public void returnPusher() {
        shooterServo.set(0);
    }

    
}
