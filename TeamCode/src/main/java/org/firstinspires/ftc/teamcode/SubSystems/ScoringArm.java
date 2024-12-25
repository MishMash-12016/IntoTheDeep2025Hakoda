package org.firstinspires.ftc.teamcode.SubSystems;

import com.arcrobotics.ftclib.command.SubsystemBase;

import org.firstinspires.ftc.teamcode.Libraries.CuttlefishFTCBridge.src.devices.CuttleServo;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.Utils.Configuration;

public class ScoringArm extends SubsystemBase {
    public enum State {
        IN(0.7), SCORING(0), MIDD(0.5);
        public double position;

        State(double position) {
            this.position = position;
        }
    }

    CuttleServo rightServo;
    CuttleServo leftServo;

    public ScoringArm() {
        rightServo = new CuttleServo(MMRobot.getInstance().mmSystems.expansionHub, Configuration.SCORING_ARM_RIGHT);
        leftServo = new CuttleServo(MMRobot.getInstance().mmSystems.expansionHub, Configuration.SCORING_ARM_LEFT);
    }

    public void setState(double position) {
        rightServo.setPosition(position);
        leftServo.setPosition(1-position);
    }

    public double getPosition() {
        return rightServo.getPosition();
    }

}
