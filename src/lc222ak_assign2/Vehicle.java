package lc222ak_assign2;

import java.util.ArrayList;

class Vehicle {
    ArrayList<Passenger> passengers = new ArrayList<>();
    int space;
    int fee;

    void addPassengers(int number) {
        if (number <= space) {
            for (int i = 0; i < number; i++) {
                passengers.add(new Passenger());
            }
        }
    }
}