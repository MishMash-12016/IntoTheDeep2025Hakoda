package org.firstinspires.ftc.teamcode.SubSystems;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.Libraries.CuttlefishFTCBridge.src.devices.CuttleEncoder;
import org.firstinspires.ftc.teamcode.Libraries.CuttlefishFTCBridge.src.devices.CuttleMotor;
import org.firstinspires.ftc.teamcode.Libraries.MMLib.PID.MMPIDCommand;
import org.firstinspires.ftc.teamcode.Libraries.MMLib.PID.MMPIDSubsystem;
import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.Utils.Configuration;

@Config
public class Elevator extends MMPIDSubsystem {

    MMRobot robot = MMRobot.getInstance();
    public  CuttleMotor motor1;
    public  CuttleMotor motor2;
    public CuttleMotor motor3;
    public CuttleEncoder motorLeftEncoder;

    final double TICKS_PER_REV = 384.5;
    final double GEAR_RATIO = 1;
    final double LEVELS = 4;
    final double SPROCKET_PERIMETER = 6.56592;

    public static double kP = 0.11;
    public static double kI = 0.01;
    public static double kD = 0;
    public static double TOLERANCE = 2;

    double ticksOfset = 0;
    public static double targetPose=0;
    public static final double elevatorDown=0;
    public static final double specimenIntake=0;
    public static final double specimenHIGH=0;
    public static final double HIGH_Basket= 45;
    public static final double Low_Basket= 10;




    public Elevator() {
        super(kP,kI,kD,TOLERANCE);
        motor1=  new CuttleMotor(robot.mmSystems.expansionHub, Configuration.ELEVATOR_1);
        motor2=  new CuttleMotor(robot.mmSystems.expansionHub, Configuration.ELEVATOR_2);
        motor3= new CuttleMotor(robot.mmSystems.expansionHub, Configuration.ELEVATOR_3);
//        this.motorLeft.setZeroPowerBehaviour(DcMotor.ZeroPowerBehavior.BRAKE);
//        this.motorRight.setZeroPowerBehaviour(DcMotor.ZeroPowerBehavior.BRAKE);
        this.motorLeftEncoder = new CuttleEncoder(robot.mmSystems.expansionHub,Configuration.ELEVATOR_ENCODER,TICKS_PER_REV);
        resetTicks();
    }
    public Command moveToPose(double setPoint){
        return new MMPIDCommand(this,setPoint).alongWith(
                new InstantCommand(()-> targetPose=setPoint));

    }

    public double getHeight(){
        return -1*((getTicks() / TICKS_PER_REV) * SPROCKET_PERIMETER * LEVELS / GEAR_RATIO) ;
    }

    @Override
    public double getCurrentValue() {
        return getHeight();
    }

    public double getTicks() {
        return -1* motorLeftEncoder.getCounts() + ticksOfset;
    }
    public void setTicks(double newTicks) {

        ticksOfset = newTicks - motorLeftEncoder.getCounts();
    }
    public void resetTicks() {
        setTicks(0);
    }



    @Override
    public void setPower(Double power) {
        motor1.setPower(power);
        motor2.setPower(power);
        motor3.setPower(power);
    }

    @Override
    public void periodic() {
        updateToDashboard();
    }

    public void updateToDashboard(){
//        FtcDashboard.getInstance().getTelemetry().addData("motorLeftPower", motor1.getPower());
//        FtcDashboard.getInstance().getTelemetry().addData("motorRightPower",motor2.getPower());
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