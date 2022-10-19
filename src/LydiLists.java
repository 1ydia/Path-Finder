import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LydiLists {
    static List<Object> toLists(Object[] arr) {
        List<Object> listArr = Arrays.asList(arr);
        for (int i = 0; i < listArr.size(); i++) {
            Object obj = listArr.get(i);
            if (obj instanceof Object[]) listArr.set(i, toLists((Object[]) obj));
            // thanks, java
        }
        return listArr;
    }

    static <T> List<Object> toListMatrix(Object[] arr, int dim) {
        int size = arr.length;
        List<T> listArr = new ArrayList<T>();
        if (dim > 1) {
            listArr = (List<T>) Arrays.asList(arr);
            for (int i = 0; i < size; i++) {
                List<Object> next = toListMatrix<List<T>>((Object[][]) arr, dim-1)
            }
        }
    }

    private static <T> List<Object> toListMatrixPrivate(Object[] arr, int dim) {
        int size = arr.length;
        List<T> listArr = new ArrayList<T>();
        if (dim > 1) {
            listArr = (List<T>) Arrays.asList(arr)
            listArr = ((List<T>) listArr);
            for (int i = 0; i < size; i++) {
                List<Object> next = toListMatrix((Object[]) arr[i], dim-1);
            }
        }
        return listArr;
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