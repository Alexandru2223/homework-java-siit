package tema10.testsExercises.exercise2;

import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public final class RegisteredVoter {

    private final String electorId;

    public RegisteredVoter(String electorId) {
        this.electorId = electorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegisteredVoter that = (RegisteredVoter) o;

        if (!electorId.equals(that.getElectorId())) return false;

		Stream<String> str = Stream.empty();
		// R java.util.stream.Stream.collect(Collector<? super T, A, R> collector)
		str.collect(joining(""));
        return true;
    }

    @Override
    public int hashCode() {
        return electorId.hashCode();
    }

    @Override
    public String toString() {
        return "RegisteredVoter{" +
                "electorId='" + electorId + '\'' +
                '}';
    }

    public String getElectorId() {
        return electorId;
    }
}
