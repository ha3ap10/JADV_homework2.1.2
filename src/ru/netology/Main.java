package ru.netology;

import java.util.*;
import java.util.function.Predicate;

public class Main {

    private static final int DEALS_COUNT = 20;
    private static final int AREA_RATIO = 1_000;
    private static final int PRICE_RATIO = 10_000_000;
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();


    public static void main(String[] args) {

        List<Deal> deals = generationOfDeals();

        System.out.println("Введите цену за квадратный метр:"); // 2_000
        double pricePerMeter = scanner.nextDouble();

        Predicate<Deal> checkFair = x -> x.getSaleValue() / (x.getLength() * x.getWidth()) >= pricePerMeter;
        Predicate<Deal> checkRaw = x -> x.getSaleValue() / (x.getLength() * x.getWidth()) < pricePerMeter;

        System.out.println("\"Честные\" сделки:");
        deals.stream().filter(checkFair).forEach(System.out::println);

        System.out.println("\"Нечестные\" сделки:");
        deals.stream().filter(checkRaw).forEach(System.out::println);
    }

    public static List<Deal> generationOfDeals() {
        List<Deal> dealList = new ArrayList<>();

        for (int i = 0; i < DEALS_COUNT; i++) {
            dealList.add(new Deal(random.nextDouble() * random.nextInt(AREA_RATIO) + 1,
                    random.nextDouble() * random.nextInt(AREA_RATIO) + 1,
                    random.nextDouble() * random.nextInt(PRICE_RATIO) + PRICE_RATIO));
        }

        return dealList;
    }
}
