package org.firstinspires.ftc.teamcode.Utils;


/**
 * this file should represent ur configurations & ports.<p>
 * there are some examples here, ur welcome to change it however u want.</p>
 * please remember that cuttlefish is an experimental library,
 * if u dont get along with it, please go back to normal strings configuration.
 * <p>
 * notice that there are some things that i still haven't figured out how to use on cuttle fish,
 * for example: i still couldn't figure out how to use CR Servos.
 * in this case, i've used the normal string configuration to control it.
 * if u have more things that are missing, u can still combine the 2 methods.
 * im still not sure whether it just doesn't exist, or i don't know how to use it, so feel free to look around their docs and src.
 */
public class Configuration {

    public static final String IMU = "imu";

    /**CONTROL HUB*/
    //DriveTrain
    public static final int DRIVE_TRAIN_FRONT_LEFT = 0;
    public static final int DRIVE_TRAIN_BACK_LEFT = 1;
    public static final int DRIVE_TRAIN_FRONT_RIGHT = 2;
    public static final int DRIVE_TRAIN_BACK_RIGHT = 3;

    public static final String AUTO_DRIVE_TRAIN_FRONT_LEFT = "leftFront";
    public static final String AUTO_DRIVE_TRAIN_BACK_LEFT = "leftBack";
    public static final String AUTO_DRIVE_TRAIN_FRONT_RIGHT = "rightBack";
    public static final String AUTO_DRIVE_TRAIN_BACK_RIGHT = "rightFront";


    public static final String PERPENDICULAR = AUTO_DRIVE_TRAIN_BACK_RIGHT;
    public static final String PARALLEL = AUTO_DRIVE_TRAIN_BACK_RIGHT; //TODO: choose the right motor, preferable port 0,3

    public static final int ANGLE_INTAKE_CLAW = 0;
    public static final int INTAKE_CLAW = 3;

    public static final int SCORING_CLAW = 2;
    public static final int ANGLE_SCORING_CLAW = 2;

    public static final int LINEAR_INTAKE_RIGHT = 2;
    public static final int LINEAR_INTAKE_LEFT = 2;

    /**EXPANSION_HUB*/
    public static final int ELEVATOR_RIGHT = 8;
    public static final int ELEVATOR_LEFT = 8;


    /**From here irrelevant(example)*/


    public static final int ELEVATOR_ENCODER = ELEVATOR_LEFT;
    public static final int SHOOTER1 = 0;
    public static final int SHOOTER2 = 1;
    public static final int SHOOTER_INTAKE = 2;
    public static final int SHOOTER_TURRET = 3;
    public static final int SHOOTER_SERVO = 0;


}
