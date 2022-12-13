import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

/*
    Урок 6. Хранение и обработка данных ч3: множество коллекций Set
    Реализовать множество (set) с помощью TreeMap. Создать метод add,
    добавляющий элемент в ваше множество. Объявить и инициализировать
    компаратор с обратной (от большего к меньшеиу) логикой сортировки чисел.
    Объявить и инициализировать TreeSet использующий ваш компаратор.
    Добавить несколько эллементов в сет и вывести в консоль.
*/
public class FinalTask {

    static class MyTreeMapSet {

        private final static Object DUMMY = new Object();

        private final TreeMap<Integer, Object> mTreeMap;

        public MyTreeMapSet() {
            mTreeMap = new TreeMap<>();
        }

        boolean add(int item) {
            if (mTreeMap.containsKey(item)) {
                return false;
            } else {
                mTreeMap.put(item, DUMMY);
                return true;
            }
        }

        boolean remove(int item) {
            if (mTreeMap.containsKey(item)) {
                mTreeMap.remove(item);
                return true;
            } else {
                return false;
            }
        }

        boolean contains(int item) {
            return mTreeMap.containsKey(item);
        }

        int size() {
            return mTreeMap.size();
        }

        void clear() {
            mTreeMap.clear();
        }
    }

    public static void main(String[] args) {

        // Реализовать множество (set) с помощью TreeMap.
        MyTreeMapSet mySet = new MyTreeMapSet();
        System.out.println("size of the set: " + mySet.size());

        // Создать метод add, добавляющий элемент в ваше множество.
        System.out.println("Element added: " + mySet.add(0));
        System.out.println("size of the set: " + mySet.size());

        /*
        Объявить и инициализировать компаратор с обратной (от большего к меньшеиу)
        логикой сортировки чисел.
        */
        Comparator<Integer> decreasingComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                /*
                Compares its two arguments for order.
                Returns a negative integer, zero, or a positive integer as
                the first argument is less than, equal to, or greater than the second.
                 */
                return (o1 - o2) * -1;
            }
        };

        // Объявить и инициализировать TreeSet использующий ваш компаратор.
        TreeSet<Integer> numbers = new TreeSet<Integer>(decreasingComparator);

        // Добавить несколько эллементов в сет и вывести в консоль.
        numbers.add(44);
        numbers.add(51);
        numbers.add(30);
        numbers.add(66);
        System.out.println("numbers TreeSet: ");
        System.out.println(Arrays.toString(numbers.toArray()));
    }
}