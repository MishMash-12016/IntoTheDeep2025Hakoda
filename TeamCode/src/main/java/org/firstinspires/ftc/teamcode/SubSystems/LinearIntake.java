package org.firstinspires.ftc.teamcode.SubSystems;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SubsystemBase;

import org.firstinspires.ftc.teamcode.Libraries.CuttlefishFTCBridge.src.devices.CuttleServo;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.Utils.Configuration;

public class LinearIntake extends SubsystemBase {

    CuttleServo rightServo;
    CuttleServo leftServo;
    public static double closedpose = 0;

    public LinearIntake() {
        rightServo = new CuttleServo(MMRobot.getInstance().mmSystems.controlHub, Configuration.LINEAR_INTAKE_RIGHT);
        leftServo = new CuttleServo(MMRobot.getInstance().mmSystems.controlHub, Configuration.LINEAR_INTAKE_LEFT);
    }

    public void setPosition(double position) {
        rightServo.setPosition(position / 2);
        leftServo.setPosition(1 - position / 2);
    }

    public Command settestPosition() {
        return new InstantCommand(() -> {
            rightServo.setPosition(0.7);
            leftServo.setPosition(1 - 0.7);
        },
                this);
    }

    public String getPosition() {
        return String.valueOf(rightServo.getPosition()) + " " + String.valueOf(leftServo.getPosition());
    }

}
