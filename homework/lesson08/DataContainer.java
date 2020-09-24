/*
 * Олег Макиевский (группа MK-JC1-50-20)
 * г. Минск, 2020
 *
 * Тема: "Работа с массивами, Работа с дженериками, Comparable, Comparator.
 *        DataContainer".
 *
 * 1. Создать класс DataContainer у которого есть один дженерик (обобщение).
 *    Например T.
 *
 * 2. Внутри DataContainer есть поле T[] data которое предназначено
 *    для хранения передаваемых объектов.
 *
 * 3. Данный класс будет служить для хранения неограниченного количества объектов
 *    передаваемых через метод int add(T item). Данный метод сохраняет переданный item
 *    внутри DataContainer'а и возвращает index данного элемента.
 *
 * 4. Метод int add(T item) добавляет данные в первую позицию (ячейку) в массиве
 *    после последней заполненной ячейки. Пример: data = [1, 2, 3, null, null, null].
 *    Вызвали add(777). Должно получиться data = [1, 2, 3, 777, null].
 *    Метод add вернёт число 3.
 * 5. В случае если массив будет переполнен нужно придумать механизм который будет
 *    расширять пространство для новых элементов. Тут вам поможет Arrays.copyOf.
 *    Пример: data = [1, 2, 3]. Вызвали add(777). Должно получиться data = [1, 2, 3, 777].
 *    Метод add вернёт число 3.
 *
 * 6. В данном классе должен быть метод T get(int index). Данный метод получает
 *    из DataContainer'а предварительно сохранённый объект в нём (переданный через add).
 *
 * 7. В данном классе должен быть метод T[] getItems(). Данный метод возвращает data.
 *
 * 8. Добавить метод boolean delete(int index) который будет удалять элемент массива по индексу.
 *    8.1. Метод возвращает true если у нас получилось удалить данные.
 *         Пример data = [1, 2, 3, 777]. Вызывают delete(3). Должно получиться data = [1, 2, 3].
 *         Метод delete вернёт true
 *    8.2. Метод возвращает false если нет такого индекса. Пример data = [1, 2, 3, 777].
 *         Вызывают delete(9). Должно получиться data = [1, 2, 3, 777]. Метод delete вернёт false
 *    8.3. Освободившуюся ячейку необходимо удалить полностью. Пустых элементов не должно быть.
 *         Пример data = [1, 2, 3, 777]. Вызывают delete(2). Должно получиться data = [1, 2, 777].
 *         Метод delete вернёт true.
 *
 * 9. Добавить метод boolean delete(E item) который будет удалять элемент массива по элементу.
 *    9.1. Метод возвращает true если у нас получилось удалить данные.
 *         Пример data = [1, 2, 3, 777]. Вызывают delete(777). Должно получиться data = [1, 2, 3].
 *         Метод delete вернёт true.
 *    9.2. Метод возвращает false если нет такого элемента.
 *         Пример data = [1, 2, 3, 777]. Вызывают delete(111).
 *         Должно получиться data = [1, 2, 3, 777]. Метод delete вернёт false
 *    9.3. Освободившуюся ячейку необходимо удалить полностью. Пустых элементов не должно быть.
 *         Пример data = [1, 2, 3, 777, 3]. Вызывают delete(3).
 *         Должно получиться data = [1, 2, 777, 3]. Метод delete вернёт true.
 *
 * 10. В данном классе должен быть НЕ СТАТИЧЕСКИЙ метод
 *     void sort(Comparator<.......> comparator). Данный метод должен отсортировать
 *     текущий контейнер используя реализацию сравнения из ПЕРЕДАННОГО объекта интерфейса Comparator.
 *
 * 11. Переопределить метод toString() в классе и выводить содержимое data без ячеек
 *     в которых хранится null.
 */
package lesson08;

import java.util.Arrays;
import java.util.Comparator;

public class DataContainer<T> {

    private T[] data;

    // Конструктор
    public DataContainer(T[] arr){
        data = arr;
        clearData();
    }

    // Mетод сохраняет переданный item и возвращает index данного элемента.
    public int add(T item){
        if(item != null){
            increaseSize();
            data[data.length - 1] = item;
            return data.length - 1;
        }
        return -1;
    }

    // Метод получает предварительно сохранённый объект в нём (переданный в add).
    public T get(int index){
        if (index < data.length && index >= 0) {
            return data[index];
        } else {
            System.out.println("\nИндекс " + index + " не найден!");
            System.out.println("Попробуйте значение от 0 до " + (data.length - 1));
            return null;
        }
    }

    // Mетод возвращает data.
    public T[] getItems(){
        return data;
    }

    // Метод который будет удалять элемент массива по индексу.
    // Метод возвращает true если у нас получилось удалить данные.
    boolean delete(int index){
        if (index < data.length && index >= 0){
            data[index] = null;
            clearData();
            return true;
        }
        return false;
    }

    // Метод который будет удалять элемент массива по элементу.
    // Метод возвращает true если у нас получилось удалить данные.
    boolean delete(T item){
        for (int i = 0; i < data.length; i++) {
            if(data[i].equals(item)){
                data[i] = null;
                clearData();
                return true;
            }
        }
        return false;
    }

    /* В данном классе должен быть НЕ СТАТИЧЕСКИЙ метод
     * void sort(Comparator<.......> comparator).
     * Данный метод должен отсортировать текущий контейнер используя реализацию сравнения
     * из ПЕРЕДАННОГО объекта интерфейса Comparator.
     * Сортировка используется пузырьковая.
     */
    void sort(Comparator<? super T> comparator){
        if(data.length > 1) {
            for (int i = 0; i < data.length; i++) {
                boolean isSwap = false;
                for (int j = data.length - 1; j > i; j--) {
                    if (comparator.compare(data[j - 1], data[j]) > 0) {
                        isSwap = swapIt(data, j - 1, j);
                    }
                }
                if (!isSwap) break; // Если не было перестановок
            }
        }
    }

    // Выводит содержимое data без ячеек в которых хранится null
    @Override
    public String toString(){
        String str = "{";
        for (T obj: data) {
            if(obj != null){
                str += "\t" + obj + ",\n";
            }
        }
        str += " }\n";
        return str;
    }

    // Статические методы:
    /* 11* В даном классе должен быть СТАТИЧЕСКИЙ метод
     *     void sort(DataContainer<.............> container)
     *     который будет принимать объект DataContainer с дженериком extends Comparable.
     *     Данный метод будет сортировать элементы в ПЕРЕДАННОМ объекте DataContainer
     *     используя реализацию сравнения вызываемый у хранимых объектов.
     */

    public static <V extends Comparable> void sort(DataContainer<V> container){
        if(container.data.length > 1) {
            for (int i = 0; i < container.data.length; i++) {
                boolean isSwap = false;
                for (int j = container.data.length - 1; j > i; j--) {
                    if (container.data[j - 1].compareTo(container.data[j]) > 0) {
                        isSwap = container.swapIt(container.data, j - 1, j);
                    }
                }
                if (!isSwap) break; // Если не было перестановок
            }
        }
    }

    /* 12** В данном классе должен быть СТАТИЧЕСКИЙ метод
     *      void sort(DataContainer<.............> container, Comparator<.......> comparator)
     *      который будет принимать объект DataContainer и реализацию интерфейса Comparator.
     *      Данный метод будет сортировать элементы в ПЕРЕДАННОМ объекте DataContainer
     *      используя реализацию сравнения из ПЕРЕДАННОГО объекта интерфейса Comparator.
     *
     */
    public static <V> void sort(DataContainer<V> container, Comparator<V> comparator){
        if(container.data.length > 1) {
            for (int i = 0; i < container.data.length; i++) {
                boolean isSwap = false;
                for (int j = container.data.length - 1; j > i; j--) {
                    if (comparator.compare(container.data[j - 1], container.data[j]) > 0) {
                        isSwap = container.swapIt(container.data, j - 1, j);
                    }
                }
                if (!isSwap) break; // Если не было перестановок
            }
        }
    }

    // Дополнительные обслуживающие методы:

    // Метод добавляет пустую ячейку массива
    private void increaseSize(){
        data = Arrays.copyOf(data, data.length + 1);
    }

    // Метод укорачивает массив, удаляя все null из массива
    private void clearData() {
        int firstIndexOfNull = shiftNull();

        if (firstIndexOfNull > 0) {
            data = Arrays.copyOf(data, firstIndexOfNull);
        }
    }

    /** Метод сдвигает все null вправо, а слева (без сортировки) будут не null объекты
     * @return индекс первого null-объекта. Если -1, значит в массиве нет null-объектов.
     */
    private int shiftNull() {
        int cursor;

        for (cursor = 0; cursor < data.length - 1; cursor++) {
            if(data[cursor] == null){
                for(int i = cursor + 1; i < data.length; i++){
                    if(data[i] != null){
                        data[cursor] = data[i];
                        data[i] = null;
                        break;
                    }
                }
            }
        }

        // Ищем индекс первого null в массиве, где все null справа
        cursor = -1;
        for (int i = 0; i < data.length; i++) {
            if(data[i] == null){
                cursor = i;
                break;
            }
        }
        return cursor;
    }

    /**
     * Метод получает массив @param arr и индексы @param i и @param j.
     * Меняет местами значения элементов массива arr[i] и arr[j]
     * @return true всегда, если был вызван.
     */
    public boolean swapIt (T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return true;
    }
}