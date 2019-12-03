package OOD.ElevatorDesign;

public class UserRequest {
    private int userCurrentFloor;
    private int userTargetFloor;

    public UserRequest(int userCurrentFloor, int userTargetFloor){
        this.userCurrentFloor = userCurrentFloor;
        this.userTargetFloor = userTargetFloor;
    }


    public int getUserCurrentFloor() {
        return userCurrentFloor;
    }

    public int getUserTargetFloor() {
        return userTargetFloor;
    }

    public void setUserCurrentFloor(int currentFloor) {
        this.userCurrentFloor = currentFloor;
    }
}
