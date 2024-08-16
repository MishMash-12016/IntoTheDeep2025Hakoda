package org.firstinspires.ftc.teamcode.Libraries.MMLib.Examples.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.CRServo;

import org.firstinspires.ftc.teamcode.Libraries.CuttlefishFTCBridge.src.devices.CuttleMotor;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.Utils.Configuration;

public class ShooterIntake extends SubsystemBase {

    MMRobot mmRobot = MMRobot.getInstance();

    CuttleMotor motor;
    CRServo crServo;

    public ShooterIntake() {
        motor = mmRobot.mmSystems.controlHub.getMotor(Configuration.SHOOTER_INTAKE);
        crServo = mmRobot.mmSystems.hardwareMap.get(CRServo.class, Configuration.INTAKE_SERVO);
    }

    public void setMotorPower(double power) {
        motor.setPower(power);
    }

    public void setServoPower(double power) {
        crServo.setPower(power);
    }

}