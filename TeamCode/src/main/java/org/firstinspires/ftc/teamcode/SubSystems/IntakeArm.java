package org.firstinspires.ftc.teamcode.SubSystems;

import com.arcrobotics.ftclib.command.SubsystemBase;

import org.firstinspires.ftc.teamcode.Libraries.CuttlefishFTCBridge.src.devices.CuttleServo;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.Utils.Configuration;

public class IntakeArm extends SubsystemBase {

    CuttleServo rightServo;
    CuttleServo leftServo;

    public enum State {
        IN(0.8), COLLECT(0.3), MID(0.55);

        private final double position;

        State(double position) {
            this.position = position;
        }

        public double getPosition() {
            return position;
        }
    }

    public IntakeArm() {
        rightServo = new CuttleServo(MMRobot.getInstance().mmSystems.controlHub, Configuration.INTAKE_ARM_RIGHT);
        leftServo = new CuttleServo(MMRobot.getInstance().mmSystems.controlHub, Configuration.INTAKE_ARM_LEFT);
    }

    public void setState(double position) {
        rightServo.setPosition(1-position);
        leftServo.setPosition(position);
    }

    public double getPosition() {
        return leftServo.getPosition();
    }

}
