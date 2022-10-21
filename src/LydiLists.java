import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LydiLists {
    static List<Object> toLists(Object[] arr) {
        List<Object> listArr = Arrays.asList(arr);
        for (int i = 0; i < listArr.size(); i++) {
            Object obj = listArr.get(i);
            if (obj instanceof Object[]) listArr.set(i, toLists((Object[]) obj));
        }
        return listArr;
    }

    static List<Integer> addListVectors(List<Integer> a, List<Integer> b) throws Exception {
        if (a.size() != b.size()) throw new Exception("Lists must be the same size to do element-wise addition.");
        List<Integer> ans = (ArrayList<Integer>) List.copyOf(a);
        for (int i = 0; i < a.size(); i++) {
            ans.set(i, ans.get(i) + b.get(i));
        }
        return ans;
    }

    static Object atCoordInList(Stack<Integer> coord, List<Object> list) {
        Object obj = list.get(coord.pop());
        if (obj instanceof List) return atCoordInList(coord, (List<Object>) obj);
        else return obj;
    }

    // find 'toFind' in 'dim' dimensional arraylist 'map'
    // do not accept a T where T.instanceOf(List)
    static List<Integer> findIn(List<Object> toSearch, List<Object> objectsToFind) throws Exception {
        return findIn(toSearch, objectsToFind, new ArrayList<Integer>());
    }
    static List<Integer> findIn(List<Object> toSearch, Object toFind) throws Exception {
        return findIn(toSearch, List.of(toFind), new ArrayList<Integer>());
    }
    private static List<Integer> findIn(List<Object> toSearch, List<Object> objectsToFind, List<Integer> index) throws Exception {
        for (int i = 0; i < toSearch.size(); i++) {
            Object obj = toSearch.get(i);
            if (objectsToFind.contains(obj)) { index.add(i); return index; }
            else if (obj instanceof List) {
                index.add(i);
                try {
                    return findIn((List<Object>) obj, objectsToFind, index); // thanks, java
                } catch (Exception e) {
                    index.remove(0);
                }
            }
        }
        throw new Exception("No element in " + objectsToFind + " was found.");
    }


    static List<List<Integer>> findAllIn(List<Object> toSearch, List<Object> objectsToFind) {
        return findAllIn(toSearch, objectsToFind, new ArrayList<Integer>());
    }
    static List<List<Integer>> findAllIn(List<Object> toSearch, Object toFind) {
        return findAllIn(toSearch, List.of(toFind), new ArrayList<Integer>());
    }
    private static List<List<Integer>> findAllIn(List<Object> toSearch, List<Object> objectsToFind, List<Integer> index) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        for (int i = 0; i < toSearch.size(); i++) {
            Object obj = toSearch.get(i);
            if (objectsToFind.contains(obj)) { index.add(i); results.add(index); }
            else if (obj instanceof List) {
                index.add(i);
                results.addAll(findAllIn((List<Object>) obj, objectsToFind, index)); // thanks, java
            }
        }
        return results;
    };
}