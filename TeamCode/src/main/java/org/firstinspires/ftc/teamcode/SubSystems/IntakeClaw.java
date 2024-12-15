package org.firstinspires.ftc.teamcode.SubSystems;

import com.arcrobotics.ftclib.command.SubsystemBase;

import org.firstinspires.ftc.teamcode.Libraries.CuttlefishFTCBridge.src.devices.CuttleServo;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.Utils.Configuration;

public class IntakeClaw extends SubsystemBase {

    public enum State {
        CLOSE(0), OPEN(0.3);
        public double position;

        State(double position){
            this.position = position;
        }
    }

    public CuttleServo angleClaw;
    public CuttleServo claw;

    public IntakeClaw(){
        angleClaw = new CuttleServo(MMRobot.getInstance().mmSystems.controlHub, Configuration.ANGLE_INTAKE_CLAW);
        claw = new CuttleServo(MMRobot.getInstance().mmSystems.controlHub,Configuration.INTAKE_CLAW);
    }

    public void setState(double position){
        angleClaw.setPosition(position);
    }

    public void setAngle(double position){
        angleClaw.setPosition(position);
    }

    public double getClawPosition() {
        return claw.getPosition();
    }

    public double getAnglePosition() {
        return angleClaw.getPosition();
    }

}
