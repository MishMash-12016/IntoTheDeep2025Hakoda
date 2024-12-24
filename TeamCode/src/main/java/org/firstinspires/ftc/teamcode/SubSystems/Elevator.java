package org.firstinspires.ftc.teamcode.SubSystems;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.roboctopi.cuttlefish.utils.Direction;

import org.firstinspires.ftc.teamcode.Libraries.CuttlefishFTCBridge.src.devices.CuttleEncoder;
import org.firstinspires.ftc.teamcode.Libraries.CuttlefishFTCBridge.src.devices.CuttleMotor;
import org.firstinspires.ftc.teamcode.Libraries.MMLib.PID.MMPIDSubsystem;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.Utils.Configuration;

@Config
public class Elevator extends MMPIDSubsystem {

    MMRobot robot = MMRobot.getInstance();

    public CuttleMotor motorRight;
    public CuttleMotor motorLeft;
    public CuttleMotor motorMidd;
    public CuttleEncoder motorLeftEncoder;

    final double TICKS_PER_REV = 384.5;
    final double GIR_RATIO = 1;
    final double LEVELS = 4;
    final double SPROCKET_PERIMETER = 6.56592;

    public static double kP = 0.11;
    public static double kI = 0.01;
    public static double kD = 0;
    public static double TOLERANCE = 2;

    double ticksOfset = 0;



    public Elevator() {
        super(kP,kI,kD,TOLERANCE);
        this.motorRight = new CuttleMotor(robot.mmSystems.expansionHub, Configuration.ELEVATOR_RIGHT);
        this.motorLeft = new CuttleMotor(robot.mmSystems.expansionHub, Configuration.ELEVATOR_LEFT);
        this.motorMidd = new CuttleMotor(robot.mmSystems.expansionHub, Configuration.ELEVATOR_MIDD);
//        this.motorLeft.setZeroPowerBehaviour(DcMotor.ZeroPowerBehavior.BRAKE);
//        this.motorRight.setZeroPowerBehaviour(DcMotor.ZeroPowerBehavior.BRAKE);
        this.motorLeftEncoder = new CuttleEncoder(robot.mmSystems.expansionHub,Configuration.ELEVATOR_ENCODER,TICKS_PER_REV);
        resetTicks();
    }

    public double getHeight(){
        return ((getTicks() / TICKS_PER_REV) * SPROCKET_PERIMETER * LEVELS / GIR_RATIO) ;
    }

    @Override
    public double getCurrentValue() {
        return getHeight();
    }

    public double getTicks() {
        return motorLeftEncoder.getCounts() + ticksOfset;
    }
    public void setTicks(double newTicks) {
        ticksOfset = newTicks - motorLeftEncoder.getCounts();
    }
    public void resetTicks() {
        setTicks(0);
    }



    @Override
    public void setPower(Double power) {
        motorLeft.setPower(power);
        motorRight.setPower(power);
        motorMidd.setPower(power);
    }

    @Override
    public void periodic() {
        updateToDashboard();
    }

    public void updateToDashboard(){
//        FtcDashboard.getInstance().getTelemetry().addData("motorLeftPower", motorLeft.getPower());
//        FtcDashboard.getInstance().getTelemetry().addData("motorRightPower",motorRight.getPower());
        FtcDashboard.getInstance().getTelemetry().addData("height",getHeight());
        FtcDashboard.getInstance().getTelemetry().addData("target", getPidController().getSetPoint());
        FtcDashboard.getInstance().getTelemetry().update();

    }

    @Override
    public double getFeedForwardPower() {
        return 0;
    }

    @Override
    public void stop() {
        setPower(0.1);
    }
}