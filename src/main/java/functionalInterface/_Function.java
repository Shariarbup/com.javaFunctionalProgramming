package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        int increment = increment(0);
        System.out.println(increment);

        int incrementByOneAndMultiplyBY10 = incrementAndMultiplyBy10(1, 10);
        System.out.println(incrementByOneAndMultiplyBY10);

        Integer increment2 = incrementByOneByFunction.apply(1);
        System.out.println(increment2);

        Integer multiplyBy10Result = multiplyBy10BYFunction.apply(increment2);
        System.out.println(multiplyBy10Result);

        Integer incrementByOneAndMultiplyBy10ByFunction = incrementByOneByFunction.andThen(multiplyBy10BYFunction).apply(2);
        System.out.println(incrementByOneAndMultiplyBy10ByFunction);

        Integer incrementByOneThenIncrementByTwoThenMultiplyBy10ByFunction = incrementByOneByFunction.andThen(incrementByTwoByFunction.andThen(multiplyBy10BYFunction)).apply(2);
        System.out.println(incrementByOneThenIncrementByTwoThenMultiplyBy10ByFunction);

        Integer incrementByOneMultiplyTogetherByFunction = incrementByOneMultiplyBy10BYFunction.apply(1, 10);
        System.out.println(incrementByOneMultiplyTogetherByFunction);
    }

    //Declarative function
    static Function<Integer, Integer> incrementByOneByFunction = number -> number + 1;

    static Function<Integer, Integer> incrementByTwoByFunction = number -> number + 2;

    static Function<Integer, Integer> multiplyBy10BYFunction = number -> number * 10;

    static BiFunction<Integer, Integer, Integer> incrementByOneMultiplyBy10BYFunction = (number, toMultiplyNumber) -> (number + 1) * toMultiplyNumber;

    // imperative function
    static int increment(int number) {
        return number + 1;
    }

    static int incrementAndMultiplyBy10(int number, int numberToMultiply) {
        return (number + 1) * numberToMultiply;
    }
}
