package org.firstinspires.ftc.teamcode.SubSystems;

import com.arcrobotics.ftclib.command.SubsystemBase;

import org.firstinspires.ftc.teamcode.Libraries.CuttlefishFTCBridge.src.devices.CuttleServo;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.Utils.Configuration;

public class LinearIntake extends SubsystemBase {

    CuttleServo rightServo;
    CuttleServo leftServo;

    public LinearIntake(){
        rightServo = new CuttleServo(MMRobot.getInstance().mmSystems.controlHub, Configuration.LINEAR_INTAKE_RIGHT);
        leftServo = new CuttleServo(MMRobot.getInstance().mmSystems.controlHub, Configuration.LINEAR_INTAKE_LEFT);
    }

    public void setPosition(double position){
        rightServo.setPosition(position /2);
        leftServo.setPosition(1-position/2);
    }

    public double getPosition() {
        return rightServo.getPosition();
    }

}
