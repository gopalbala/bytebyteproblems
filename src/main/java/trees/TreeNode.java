package trees;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by gbalasubramanian on 20/10/17.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode {
    TreeNode left;
    TreeNode right;
    int data;
    public TreeNode(int data){
        this.data = data;
    }
}
