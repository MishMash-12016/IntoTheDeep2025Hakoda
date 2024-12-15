package org.firstinspires.ftc.teamcode.SubSystems;

import com.arcrobotics.ftclib.command.SubsystemBase;

import org.firstinspires.ftc.teamcode.Libraries.CuttlefishFTCBridge.src.devices.CuttleServo;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.Utils.Configuration;

public class IntakeArm extends SubsystemBase {
    public enum State {
        IN(0), COLLECT(1);
        public double position;

        State(double position) {
            this.position = position;
        }
    }

    CuttleServo rightServo;
    CuttleServo leftServo;

    public IntakeArm() {
        rightServo = new CuttleServo(MMRobot.getInstance().mmSystems.controlHub, Configuration.INTAKE_CLAW);
        leftServo = new CuttleServo(MMRobot.getInstance().mmSystems.controlHub, Configuration.ANGLE_INTAKE_CLAW);
    }

    public void setState(double position) {
        rightServo.setPosition(position);
        leftServo.setPosition(1-position);
    }

    public double getPosition() {
        return rightServo.getPosition();
    }

}
