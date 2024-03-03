package treedp.treediameter;

import util.DPUtil;

import java.util.List;
import java.util.Objects;

public class TreeDiameterProblemDFS {

    private final List<List<Integer>> graph;

    private final List<Integer> dp;

    private final List<Integer> g;

    private Integer iteration = 0;

    @SuppressWarnings({"unchecked"})
    public TreeDiameterProblemDFS(List<List<Integer>> graph) {
        this.graph = graph;
        this.dp = (List<Integer>) DPUtil.init(Integer.class, 1, graph.size(), 0);
        this.g =  (List<Integer>) DPUtil.init(Integer.class,1, graph.size(), 0);

    }

    public Integer getDiameter() {
        //assuming 1 as root node
        getDiameter(1, -1);
        return dp.get(1);
    }

    private void getDiameter(Integer currentNode, Integer currentNodeParent) {

        System.out.println(this.iteration++);

        int firstMax = 0;
        int secondMax = 0;

        for (int i = 0; i < graph.get(currentNode).size(); i++) {
            if (!Objects.equals(graph.get(currentNode).get(i), currentNodeParent)) {
                getDiameter(this.graph.get(currentNode).get(i), currentNode);

                this.g.set(currentNode,
                        Math.max(this.g.get(currentNode), this.g.get(this.graph.get(currentNode).get(i)) + 1)
                );
                this.dp.set(currentNode,
                        Math.max(this.dp.get(currentNode), this.dp.get(this.graph.get(currentNode).get(i)))
                );

                if (this.g.get(this.graph.get(currentNode).get(i)) + 1 > firstMax) {
                    secondMax = firstMax;
                    firstMax = this.g.get(this.graph.get(currentNode).get(i)) + 1;
                } else if (this.g.get(this.graph.get(currentNode).get(i)) + 1 > secondMax) {
                    secondMax = this.g.get(this.graph.get(currentNode).get(i)) + 1;
                }
            }
        }

        this.dp.set(currentNode,
                Math.max(this.dp.get(currentNode), firstMax + secondMax)
        );
    }
}
