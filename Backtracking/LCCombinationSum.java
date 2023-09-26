class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        comboMaker(target, 0, candidates, new LinkedList<>(), result);
        return result;
    }

    public void comboMaker(int target, int start, int[] candidates, LinkedList<Integer> combo, List<List<Integer>> result) {
        // System.out.printf("target:%d, start:%d, combo:%s, result:%s\n", target, start, listToString(combo), list2DToString(result));
        if(target == 0) {
            result.add(new ArrayList<Integer>(combo));
            return;
        } 
        if(target < 0) {
            return;
        }

        for(int i = start; i < candidates.length; i++) {
            combo.add(candidates[i]);
            comboMaker(target - candidates[i], i, candidates, combo, result);
            combo.removeLast();
        }
    }

    public String listToString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if(i < list.size()-1)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public String list2DToString(List<List<Integer>> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < list.size(); i++) {
            sb.append(listToString(list.get(i)));
            if(i < list.size()-1)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}