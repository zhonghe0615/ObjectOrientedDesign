package OOD.ElevatorDesign;

public class ElevatorImpl implements Elevator{
    private int currentFloor;
    private int [] range;
    private boolean isStart;

    public ElevatorImpl(int [] range){
        this.currentFloor = 1;
        this.range = range;
        this.isStart = false;
    }

    @Override
    public void start() {
        this.isStart = true;
    }

    @Override
    public void stop() {
        this.isStart = false;
    }

    @Override
    public void moveTo(int floorNum, UserRequest userRequest) {
        while(currentFloor < floorNum) {
            moveUp();
        }

        while(currentFloor > floorNum) {
            moveDown();
        }
        stop();
        userRequest.setUserCurrentFloor(this.currentFloor);
    }

    @Override
    public void moveUp() {
        this.currentFloor ++;
    }

    @Override
    public void moveDown() {
        this.currentFloor--;
    }

    @Override
    public int getCurrentFloor() {
        return this.currentFloor;
    }

    @Override
    public boolean isStart() {
        return this.isStart;
    }

    @Override
    public int[] getRange() {
        return this.range;
    }
}
