package array;

/**
 * Created by gbalasubramanian on 25/09/18.
 */
public class PetrolPumpProblem {
    public static void main(String[] args) {
        PetrolPump[] arr =
                {new PetrolPump(4, 6),
                        new PetrolPump(6, 5),
                        new PetrolPump(7, 3),
                        new PetrolPump(4,5)};

//                {new PetrolPump(6, 4),
//                new PetrolPump(3, 6),
//                new PetrolPump(7, 3)};

        int start = printTour(arr, arr.length);

        System.out.println(start == -1 ? "No Solution" : "Start = " + start);
    }

    static class PetrolPump {
        int petrol;
        int distance;

        // constructor
        public PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    static int printTour(PetrolPump[] petrolPumps, int n) {
        int start = 0, end = 1;
        int curr_pet = petrolPumps[start].petrol - petrolPumps[start].distance;
        while (start != end || curr_pet < 0) {
            while (start != end && curr_pet < 0) {
                curr_pet -= petrolPumps[start].petrol - petrolPumps[start].distance;
                start = (start + 1) % n;
                if (start == 0) {
                    return -1;
                }
            }
            curr_pet+= petrolPumps[end].petrol - petrolPumps[end].distance;
            end = (end +1) %n;
        }
       return start;
    }
}
