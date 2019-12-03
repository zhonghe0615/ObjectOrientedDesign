package OOD.ElevatorDesign;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Scheduler {
    private List<Elevator> elevatorList;

    public Scheduler(List<Elevator> elevators){
        this.elevatorList = elevators;
    }

    public Elevator dispatchElevator(UserRequest userRequest){
        return getBestEligibleElevator(userRequest);
    }

    private Elevator getBestEligibleElevator(UserRequest userRequest) {
        List<Elevator> eligibleElevators = getEligibleElevators(userRequest);

        if(eligibleElevators.isEmpty()) {
            throw new NoSuchElementException();
        }
        Elevator closestEle = eligibleElevators.get(0);
        int distance = Math.abs(closestEle.getCurrentFloor() - userRequest.getUserCurrentFloor())
                + Math.abs(closestEle.getCurrentFloor() - userRequest.getUserTargetFloor());

        for(int i = 1; i < eligibleElevators.size(); i ++) {
            Elevator elevator = eligibleElevators.get(i);
            int currentDistance = Math.abs(elevator.getCurrentFloor() - userRequest.getUserCurrentFloor())
                    + Math.abs(elevator.getCurrentFloor() - userRequest.getUserTargetFloor());

            if(currentDistance < distance) {
                distance = currentDistance;
                closestEle = elevator;
            }
        }
        return closestEle;
    }

    private List<Elevator> getEligibleElevators(UserRequest userRequest) {
        List<Elevator> list = new ArrayList<>();
        for(Elevator ele : this.elevatorList) {
            int [] range = ele.getRange();
            if(userRequest.getUserTargetFloor() >= range[0]
                    && userRequest.getUserTargetFloor() <= range[1]
                    && userRequest.getUserCurrentFloor() <= range[1]
                    && userRequest.getUserCurrentFloor() >= range[0]) {
                list.add(ele);
            }
        }
        return list;
    }

    public void handleReuest(UserRequest userRequest){
        Elevator elevator = getBestEligibleElevator(userRequest);
        elevator.moveTo(userRequest.getUserCurrentFloor(), userRequest);
        elevator.moveTo(userRequest.getUserTargetFloor(), userRequest);
    }
}
