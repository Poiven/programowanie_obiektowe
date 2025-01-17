import java.util.*;

class TestPunkt{
    public static <T> void printUnique(Collection<T> items){
        Set<T> uniqueElements = new HashSet<>(items);

        for(T item : uniqueElements){
            System.out.println(item);
        }
    }
    public static <T> int countOccurrences(Collection<T> items, T element){
        int count = 0;
        for(T item : items){
            if(item.equals(element)){
                count++;
            }
        }
        return count;
    }
    public static <T> ArrayList<T> mergeList(ArrayList<T> list1, ArrayList<T> list2){
        ArrayList<T> result = new ArrayList<>();
        result.addAll(list1);
        result.addAll(list2);
        return result;
    }
    public static <T> boolean isPalindrome(LinkedList<T> list){
        LinkedList<T> temp = new LinkedList<>();
        for(int i = list.size() - 1; i > 0; i--){
            temp.add(list.get(i));
        }
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) != temp.get(i)) {
                return false;
            }
        }

        return true;
    }

    // f1 - tree set
    public static <T> TreeSet<T> findElementsInRange(TreeSet<T> set, T lowerBound, T upperBound){
        return (TreeSet<T>) set.subSet(lowerBound,true, upperBound, true);
    }
    public static <K,V> HashMap<K,Integer> countValueOccurances(HashMap<K,V> map){
        HashMap<K,Integer> result = new HashMap<>();
        for(K key : map.keySet()){
            if(!result.containsKey(key)){
                result.put(key, 1);
            }
            else{
                result.put(key, result.get(key) + 1);
            }
        }
        return result;
    }
    public static <T> HashSet<T> findUniqueElement(List<T> lista){
        HashSet<T> result = new HashSet<>();
        for(T item : lista){
            if(!result.contains(item)){
                result.add(item);
            }
        }
        return result;
    }
}





public class Zestaw12 {

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(19);
        set.add(23);
         var noweDrzewo = TestPunkt.findElementsInRange(set, 2,5);
         for(var item: noweDrzewo){
             System.out.println(item);
         }
    }
}
