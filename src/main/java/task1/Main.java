package task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int valuesAmount = 0;
        int maxValue = 0;
        int minValue = 0;

        List list;
        Set set;

        try {
            System.out.print("Input amount of values: ");
            valuesAmount = Integer.parseInt(reader.readLine());

            System.out.print("Input minimum value: ");
            minValue = Integer.parseInt(reader.readLine());

            System.out.print("Input maximum value: ");
            maxValue = Integer.parseInt(reader.readLine());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        NumberCreator numberCreator = new NumberCreator(valuesAmount, minValue, maxValue);

        set = numberCreator.getSet();
        list = numberCreator.getList();
        System.out.println("Random set: " + Arrays.toString(set.toArray()));
        System.out.println("Random list: " + Arrays.toString(list.toArray()));

    }
}
