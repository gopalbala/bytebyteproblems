package pramp;

//import lombok.Getter;
//import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gbalasubramanian on 02/08/18.
 */

public class CarNode {

    static int min = Integer.MAX_VALUE;

    int val;
    List<CarNode> carNodes;

    public CarNode(int val) {
        this.val = val;
    }

    public void addChild(CarNode node) {
        if (this.carNodes == null)
            carNodes = new ArrayList<>();
        this.carNodes.add(node);
    }

    public List<CarNode> getChidren() {
        return this.carNodes;
    }

    public void min(CarNode node, int prev) {
        if (node == null)
            return;
        prev = prev + node.val;
        if (node.getChidren() == null || node.getChidren().size() == 0) {
            min = prev < min ? prev : min;
            return;
        }
        for (CarNode carNode : node.getChidren()) {
             min(carNode, prev);
        }
    }
}
