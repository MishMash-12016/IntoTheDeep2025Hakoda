package org.firstinspires.ftc.teamcode.SubSystems;

import com.arcrobotics.ftclib.command.SubsystemBase;

import org.firstinspires.ftc.teamcode.Libraries.CuttlefishFTCBridge.src.devices.CuttleServo;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.Utils.Configuration;

public class ScoringClaw extends SubsystemBase {

    public enum State {
        CLOSE(1), OPEN(0.3);
        public double position;

        State(double position){
            this.position = position;
        }
    }

    CuttleServo clawServo;
    CuttleServo clawAngel;

    public ScoringClaw(){
        clawServo = new CuttleServo(MMRobot.getInstance().mmSystems.controlHub, Configuration.SCORING_CLAW);
        clawAngel = new CuttleServo(MMRobot.getInstance().mmSystems.controlHub, Configuration.ANGLE_SCORING_CLAW);
    }

    public void setState(double position){

        clawServo.setPosition(position);
    }

    public void setAngle(double angle){

        clawAngel.setPosition(angle);
    }

    public double getClawPosition() {
        return clawServo.getPosition();
    }
    public double getAnglePosition() {
        return clawAngel.getPosition();
    }
}
