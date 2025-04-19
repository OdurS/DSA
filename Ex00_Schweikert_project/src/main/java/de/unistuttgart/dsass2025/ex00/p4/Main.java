package de.unistuttgart.dsass2025.ex00.p4;
import java.util.Iterator;
public class Main {
    public static void main(String[] args) {
        SimpleList list = new SimpleList();

        list.append("NULL");
        list.append("1");

        Iterator<String> iter = list.iterator();
        //Ausgabe von iter
        while (iter.hasNext()) {
            Object obj = iter.next();
            System.out.println(obj);
        }

        list.append("2");
        list.append("3");
        list.append("4");
        list.append("5");
        list.append("6");
        list.append("7");
        list.append("8");
        list.append("9");

        System.out.println("------Skipping--------");
        Iterator<String> iterator = list.skippingIterator(3);
        //Ausgabe von iterator
        boolean wahrheit = true;
        while (wahrheit)  {
            if (!iterator.hasNext()){
                wahrheit = false;

            }
            Object obj = iterator.next();
            System.out.println(obj);
        };

    }
}

