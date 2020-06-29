package tema10.testsExercises.exercise4;

public interface Translator {

    String translate(String input);

    enum Languages implements Translator {
        REVERSISH {
            @Override
            public String translate(String input) {
                return new StringBuilder(input).reverse().toString();
            }
        }

    }

}

