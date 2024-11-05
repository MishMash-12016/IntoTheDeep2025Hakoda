package org.firstinspires.ftc.teamcode.SubSystems;

import org.firstinspires.ftc.teamcode.Libraries.CuttlefishFTCBridge.src.devices.CuttleMotor;
import org.firstinspires.ftc.teamcode.Libraries.MMLib.PID.MMPIDSubsystem;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.Utils.Configuration;

public class ArmAngle extends MMPIDSubsystem {

    CuttleMotor angleMotor;

    final double Ki = 1;
    final double Kp = 0;
    final double Kd = 0;
    final double TOLERANCE = 2;

    MMRobot mmRobot = MMRobot.getInstance();

    public ArmAngle() {
        super(0,0,0,0);
        angleMotor = new CuttleMotor(mmRobot.mmSystems.controlHub, Configuration.ARM_ANGLE_MOTOR);

    }

    @Override
    public double getCurrentValue() {
        return angleMotor.getCurrent();
    }

    @Override
    public void setPower(Double power) {
        angleMotor.setPower(power);
    }
}
