package OOD.ElevatorDesign;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ElevatorTest {
    @Test
    public void testUsersTakeElevator(){
        List<Elevator> elevators = new ArrayList<>();

        elevators.add(new ElevatorImpl(new int [] {1, 10}));
        elevators.add(new ElevatorImpl(new int [] {11,20}));

        Scheduler scheduler = new Scheduler(elevators);

        Deque<UserRequest> requestsQueue = new ArrayDeque<>();
        UserRequest userRequest1 = new UserRequest(1, 7);
        requestsQueue.add(userRequest1);
        scheduler.handleReuest(userRequest1);
        assertEquals(userRequest1.getUserCurrentFloor(), userRequest1.getUserTargetFloor());


        UserRequest userRequest2 = new UserRequest(10, 2);
        requestsQueue.add(userRequest2);
        scheduler.handleReuest(userRequest2);
        assertEquals(userRequest2.getUserCurrentFloor(), userRequest2.getUserTargetFloor());


        UserRequest userRequest3 = new UserRequest(11, 15);
        requestsQueue.add(userRequest3);
        scheduler.handleReuest(userRequest3);
        assertEquals(userRequest3.getUserCurrentFloor(), userRequest3.getUserTargetFloor());


        UserRequest userRequest4 = new UserRequest(20, 13);
        requestsQueue.add(userRequest4);
        scheduler.handleReuest(userRequest4);
        assertEquals(userRequest4.getUserCurrentFloor(), userRequest4.getUserTargetFloor());


        UserRequest userRequest5 = new UserRequest(9, 11);
        requestsQueue.add(userRequest5);
        boolean thrown = false;
        try {
            scheduler.handleReuest(userRequest5);
        } catch (NoSuchElementException ex) {
            thrown = true;
            assertTrue(thrown);
        }
    }
}
