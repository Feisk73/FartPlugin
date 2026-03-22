package org.feisk73.fartPlugin.utils;

import cn.nukkit.level.Position;
import cn.nukkit.level.Level;

import java.util.ArrayList;
import java.util.List;

public class TrajectoryUtil {
    private final double pitch;
    private final double yaw;
    private final Position startPos;
    private final double speed;
    private final double gravity;
    private final int steps;
    private final double timeStep;

    public TrajectoryUtil(double yaw, Position startPos, double speed, double gravity, int steps) {
        this(yaw, startPos, speed, gravity, steps, 0.1);
    }

    public TrajectoryUtil(double yaw, Position startPos, double speed, double gravity, int steps, double timeStep) {
        if (startPos == null || startPos.getLevel() == null) {
            throw new IllegalArgumentException("Start position and level cannot be null");
        }
        this.pitch = 22.5;
        this.yaw = yaw+90;
        this.startPos = startPos.add(0, 0.5, 0);
        this.speed = speed;
        this.gravity = gravity;
        this.steps = steps;
        this.timeStep = timeStep;
    }

    public List<Position> calculate() {
        List<Position> trajectory = new ArrayList<>(steps);

        double pitchRad = Math.toRadians(pitch);
        double yawRad = Math.toRadians(yaw);

        double vx = Math.cos(pitchRad) * Math.cos(yawRad) * speed;
        double vy = Math.sin(pitchRad) * speed;
        double vz = Math.cos(pitchRad) * Math.sin(yawRad) * speed;

        Level level = startPos.getLevel();
        double startX = startPos.getX();
        double startY = startPos.getY();
        double startZ = startPos.getZ();

        for (int i = 0; i < steps; i++) {
            double t = i * timeStep;
            double x = startX + vx * t;
            double z = startZ + vz * t;
            double y = startY + vy * t - 0.5 * gravity * t * t;

            trajectory.add(new Position(x, y, z, level));
        }
        return trajectory;
    }
}