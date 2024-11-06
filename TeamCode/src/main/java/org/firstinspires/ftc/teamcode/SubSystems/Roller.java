package org.firstinspires.ftc.teamcode.SubSystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.CRServo;

import org.firstinspires.ftc.teamcode.Libraries.CuttlefishFTCBridge.src.devices.CuttleServo;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.Utils.Configuration;

public class Roller extends SubsystemBase {

    CuttleServo angleRoller;
    CRServo roller;

    public Roller(){
        angleRoller = new CuttleServo(MMRobot.getInstance().mmSystems.controlHub, Configuration.ANGLE_ROLLER);
        roller = MMRobot.getInstance().mmSystems.hardwareMap.crservo.get(Configuration.ROLLER);
    }

    public void setSpeed(double speed){
        roller.setPower(speed);
    }

    public void setAngleRoller(double position){
        angleRoller.setPosition(position);
    }

}