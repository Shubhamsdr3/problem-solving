package easy.data;

import java.util.ArrayList;
import java.util.List;

public class NAryTreeNode {

    public int val;
    public List<NAryTreeNode> children = new ArrayList<>();

    public NAryTreeNode(int _val) {
        val = _val;
    }

    public NAryTreeNode(int _val, List<NAryTreeNode> _children) {
        val = _val;
        children = _children;
    }
}
