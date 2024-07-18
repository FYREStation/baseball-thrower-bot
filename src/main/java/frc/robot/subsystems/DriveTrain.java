package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;





public class DriveTrain extends SubsystemBase {

    private final Victor leftMotor1;
    private final Victor rightMotor1;
    private final Victor leftMotor2;
    private final Victor rightMotor2;
    private final Victor leftMotor3;
    private final Victor rightMotor3;
    private final DifferentialDrive diffDrive;
    //private Boolean stopped = false;


    public DriveTrain() {
        leftMotor1 = new Victor(DriveConstants.leftMotorPort1);
        rightMotor1 = new Victor(DriveConstants.rightMotorPort1);
        leftMotor2 = new Victor(DriveConstants.leftMotorPort2);
        rightMotor2 = new Victor(DriveConstants.rightMotorPort2);
        leftMotor3 = new Victor(DriveConstants.leftMotorPort3);
        rightMotor3 = new Victor(DriveConstants.rightMotorPort3);

        diffDrive = new DifferentialDrive(leftMotor1, rightMotor1);

        setupMotors();
    }

    private void setupMotors() {
        leftMotor1.addFollower(leftMotor2);
        leftMotor1.addFollower(leftMotor3);
        rightMotor1.addFollower(rightMotor2);
        rightMotor1.addFollower(rightMotor3);

        leftMotor1.setInverted(true);

        diffDrive.setDeadband(DriveConstants.deadband);
    
    }




    public void tankDrive(double rightSpeed, double leftSpeed) {
        //if (stopped) {
            diffDrive.tankDrive(leftSpeed, rightSpeed);
        //}
    }

    public void arcadeDrive(double speed, double rotation) {
        diffDrive.arcadeDrive(speed, rotation);
    }

    // public void stop() {
    //     tankDrive(0, 0);
    //     stopped = true;
        
    // }



    
}
