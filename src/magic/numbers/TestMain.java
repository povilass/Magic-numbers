package magic.numbers;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.*;

/**
 * Created by Povilas on 2015.10.05.
 */
public class TestMain {

    public static void main(String[] args) throws ScriptException {
        List<Sign> signs = new LinkedList<>();
        signs.add(new Sign("+", new LinkedList<Sign>()));
        signs.add(new Sign("-", new LinkedList<Sign>()));
        signs.add(new Sign("", new LinkedList<Sign>()));

        List<List<String>> result = new LinkedList<>();
        List<Integer> numbers = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        addBranches(new Sign(), numbers.size() - 1, signs, result);

        printArray(result, numbers);
    }

    public static String merge(List<Integer> a, List<String> b) {
        int c1 = 0, c2 = 0;
        String result = "";
        while(c1 < a.size() || c2 < b.size()) {
            if(c1 < a.size())
                result += a.get(c1++).toString();
            if(c2 < b.size())
                result += b.get(c2++).toString();
        }
        return result;
    }


    private static void addBranches(Sign result, int deep, List<Sign> signs, List<List<String>> results) {

        result.setSigns(generate(signs));

        for (Sign sign : result.getSigns()) {
            if (result != null) {
                sign.getPreviousValues().addAll(result.getPreviousValues());
            }
            if (result.getValue() != null) {
                sign.getPreviousValues().add(result.getValue());
            }
            if (sign.getPreviousValues().size() < deep) {
                addBranches(sign, deep, signs, results);
            } else {
                results.add(sign.getPreviousValues());
                break;
            }
        }

    }

    private static void printArray(List<List<String>> values, List<Integer> numbers) throws ScriptException {
        for(List<String> item : values) {
            String evaluate = merge(numbers, item);
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");
            Object eval = engine.eval(evaluate);
            if(eval.equals(100)) {
                System.out.println(evaluate + "=" + eval);
            }
        }

    }

    private static List<Sign> generate(List<Sign> signs) {
        List<Sign> newSigns = new LinkedList<>();
        for(Sign sign : signs) {
            newSigns.add(new Sign(sign.getValue(), sign.getSigns()));
        }
        return newSigns;
    }
}
