package OOD.ElevatorDesign;

public interface Elevator {
    void start();

    void stop();

    void moveTo(int floorNum, UserRequest userRequest);

    void moveUp();

    void moveDown();

    int getCurrentFloor();

    boolean isStart();

    int[] getRange();
}
