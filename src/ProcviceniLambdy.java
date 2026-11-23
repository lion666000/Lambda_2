import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ProcviceniLambdy {
    public static void main(String[] args) {
        List<String> jmena = List.of("Kuba", "Dan", "Lukáš", "", "Kuba", "Míša");
        List<Integer> body = List.of(2, 3, 4, 6, 5, 7, 3);
//        delkyJmen(jmena);
//        delkyJmen(List.of());
//        dvaSeznamy();
//        ulozHodnotu();
        pocetVRozsahu(body);
    }

    static void delkyJmen(List<String> jmena) {
        String prefix = "K";
        // TODO Vyber jména, která začínají na prefix, a vypiš jejich délky.

        Predicate<String> startsK = s -> s.startsWith(prefix);
        Function<String, Integer> lengthK = String::length;
        Consumer<Integer> print = s -> System.out.println(s);

        for (String s : jmena) {
            if(startsK.test(s)) {
                print.accept(lengthK.apply(s));
            }
        }
    }

    static void dvaSeznamy() {
        // TODO Vytvoř přes Supplier dvě samostatné soupisky a vypiš je.

        Supplier<List<String>> supplier = ArrayList::new;

        List<String> list = supplier.get();
        list.add("Vašek");
        List<String> list2 = supplier.get();
        list2.add("Ondra");

        System.out.println(list);
        System.out.println(list2);
    }

    static void ulozHodnotu() {
        // Předloha k opravě.
        // int limit = 2;
        // limit++;
        // Runnable vypis = () -> System.out.println(limit);
        // limit++;
        // vypis.run();

        int limit = 2;
        limit++;
        int tempLimit = limit;
        Runnable vypis = () -> System.out.println(tempLimit);
        limit++;
        vypis.run();
    }

    static void pocetVRozsahu(List<Integer> body) {
        int minimum = 3;
        int maximum = 6;
        // TODO Slož podmínky a vypiš počet hodnot v intervalu.

        Predicate<Integer> min = i -> i >= minimum;
        Predicate<Integer> max = i -> i < maximum;

        int correct = 0;
        for  (int i : body) {
            if (min.and(max).test(i)) {
                correct++;
            }
        }
        System.out.println(correct + "\n");
/*
        for  (int i : body) {
            if (min.and(max).test(i)) {
                System.out.println(i);
            }
        }

 */
    }
}