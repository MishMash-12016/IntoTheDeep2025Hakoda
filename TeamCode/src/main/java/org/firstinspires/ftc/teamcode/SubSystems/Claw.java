package org.firstinspires.ftc.teamcode.SubSystems;

import com.arcrobotics.ftclib.command.SubsystemBase;

import org.firstinspires.ftc.teamcode.Libraries.CuttlefishFTCBridge.src.devices.CuttleServo;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.Utils.Configuration;

public class Claw extends SubsystemBase {

    public enum State {
        CLOSE(1), OPEN(0.3);
        public double position;

        State(double position){
            this.position = position;
        }
    }

    CuttleServo servo;

    public Claw(){
        servo = new CuttleServo(MMRobot.getInstance().mmSystems.controlHub, Configuration.CLAW);
    }

    public void setPosition(double position){
        servo.setPosition(position);
    }

}
