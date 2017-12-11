package task1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class NumberCreator {
    private int valuesAmount;
    private int minValue;
    private int maxValue;
    private Set set;
    private List list;

    NumberCreator(int valuesAmount, int minValue, int maxValue) {
        this.valuesAmount = valuesAmount;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }


    private int getRandomValue() {
        return (int)(minValue + Math.random() * maxValue);
    }

    private void getRandomList() {
        list = new ArrayList();
        for (int i = 0; i < valuesAmount; i++) {
            list.add(getRandomValue());
        }
    }

    private void getRandomSet() {
        set = new HashSet();
        for (int i = 0; i < valuesAmount; i++) {
            set.add(getRandomValue());
        }
    }

    public Set getSet() {
        getRandomSet();
        return set;
    }

    public List getList() {
        getRandomList();
        return list;
    }

}
