package org.firstinspires.ftc.teamcode.SubSystems;

import com.arcrobotics.ftclib.command.Command;

import org.firstinspires.ftc.teamcode.Libraries.CuttlefishFTCBridge.src.devices.CuttleMotor;
import org.firstinspires.ftc.teamcode.Libraries.MMLib.PID.MMPIDSubsystem;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.Utils.Configuration;

public class Arm extends MMPIDSubsystem {

    CuttleMotor motor1;
    CuttleMotor motor2;
    CuttleMotor motor3;

    final double Ki = 1;
    final double Kp = 0;
    final double Kd = 0;
    final double TOLERANCE = 2;

    MMRobot mmRobot = MMRobot.getInstance();

    public Arm(){
        super(0,0,0,0);

        motor1 = new CuttleMotor(mmRobot.mmSystems.controlHub, Configuration.ARM_MOTOR1);
        motor2 = new CuttleMotor(mmRobot.mmSystems.controlHub, Configuration.ARM_MOTOR2);
        motor3 = new CuttleMotor(mmRobot.mmSystems.controlHub, Configuration.ARM_MOTOR3);

        // TODO reverse
    }


    @Override
    public void setDefaultCommand(Command defaultCommand) {
        super.setDefaultCommand(defaultCommand);
    }

    @Override
    public double getCurrentValue() {
        return motor1.getCurrent();
    }

    @Override
    public void setPower(Double power) {
        motor1.setPower(power);
        motor2.setPower(power);
        motor3.setPower(power);
    }
}
