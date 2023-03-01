package org.itstep;

public class App {
    public static void main(String[] args) {
        // FIXME: обобщенный тип должен быть классом, в котором будет реализован интерфейс Comparable<T>
        List<Tea> tea = new List<>();
        tea.add(new Tea("Цейлонский черный", 150));
        tea.add(new Tea("Грузинский черный", 40));
        tea.add(new Tea("Китайский зеленый", 250));
        tea.add(new Tea("Кенийский черный", 50));

        System.out.println(tea.min()); // должен вывести: Чай: Грузинский черный Цена: 40.0
        System.out.println(tea.max()); // должен вывести: Чай: Китайский зеленый Цена: 250.0
    }
}


