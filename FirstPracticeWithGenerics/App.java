package org.itstep;

public class App {
    public static void main(String[] args) {
        
        List<Tea> tea = new List<>();
        tea.add(new Tea("Цейлонский черный", 150));
        tea.add(new Tea("Грузинский черный", 40));
        tea.add(new Tea("Китайский зеленый", 250));
        tea.add(new Tea("Кенийский черный", 50));

        System.out.println(tea.min()); 
        System.out.println(tea.max()); 
    }
}


