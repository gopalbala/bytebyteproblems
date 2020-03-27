package pramp;

/**
 * Created by gbalasubramanian on 02/08/18.
 */
public class CarApp {
    public static void main(String[] args) {
        CarNode node = new CarNode(0);

        node.addChild(new CarNode(5));
        node.addChild(new CarNode(3));
        node.addChild(new CarNode(6));


        node.getChidren().get(0).addChild(new CarNode(4));

        node.getChidren().get(1).addChild(new CarNode(2));
        node.getChidren().get(1).addChild(new CarNode(0));

        node.getChidren().get(2).addChild(new CarNode(1));
        node.getChidren().get(2).addChild(new CarNode(5));

        node.getChidren().get(1).getChidren().get(0).addChild(new CarNode(1));
        node.getChidren().get(1).getChidren().get(0).getChidren().get(0).addChild(new CarNode(1));

        node.getChidren().get(1).getChidren().get(1).addChild(new CarNode(10));

        //node.getChidren().search(0).addChild(new CarNode(4));

        node.min(node,0);

        System.out.println(CarNode.min);

    }
}
