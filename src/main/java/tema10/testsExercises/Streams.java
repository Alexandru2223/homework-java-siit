package tema10.testsExercises;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

	public static class NotImplementedException extends RuntimeException {
		public NotImplementedException() {
			super("This method hasn't been implemented yet!");
		}
	}

	public static List<Integer> returnSquareRoot(List<Integer> numbers) {
		return numbers.stream()
				.map(x -> (int) Math.sqrt(x))
				.collect(Collectors.toList());
	}

	public static List<Integer> getAgeFromUsers(List<User> user) {
		return user.stream()
				.map(user1 -> user1.getAge())
				.collect(Collectors.toList());
	}

	public static List<Integer> getDistinctAges(List<User> users) {
		return users.stream()
					.map(user -> user.getAge())
				.distinct()
				.collect(Collectors.toList());

	}

	public static List<User> getLimitedUserList(List<User> users, int limit) {
		return users.stream()
				.limit(limit)
				.collect(Collectors.toList());
	}

	public static Integer countUsersOlderThen25(List<User> users) {
		return (int) users.stream()
				.filter(user -> user.getAge() > 25)
				.count();
	}

	public static List<String> mapToUpperCase(List<String> strings) {
		return strings.stream()
			   .map(s -> s.toUpperCase())
			   .collect(Collectors.toList());
	}

	public static Integer sum(List<Integer> integers) {
		return integers.stream()
				.reduce(0, Integer::sum);
	}

	public static List<Integer> skip(List<Integer> integers, Integer toSkip) {
		return integers.stream()
				.skip(toSkip)
				.collect(Collectors.toList());
	}

	public static List<String> getFirstNames(List<String> names) {
		return names.stream()
				.map(name -> name.substring(0,name.lastIndexOf(" ")))
				.collect(Collectors.toList());
	}

	public static List<String> getDistinctLetters(List<String> names) {
		throw new NotImplementedException();
	}

	public static String separateNamesByComma(List<User> users) {
		return users.stream()
				.map(User::getName)
				.collect(Collectors.joining(", "));
	}

	public static double getAverageAge(List<User> users) {

		return users.stream()
					.mapToDouble(user -> user.getAge())
				.average()
				.getAsDouble();
	}

	public static Integer getMaxAge(List<User> users) {
		return users.stream()
					.map(User::getAge)
					.sorted(Comparator.reverseOrder())
					.findFirst()
					.get();
	}

	public static Integer getMinAge(List<User> users) {

		return users.stream()
				.map(user -> user.getAge())
				.sorted()
				.findFirst()
				.get();

	}

	public static Map<Boolean, List<User>> partionUsersByGender(List<User> users) {

		return users.stream()
			 .collect(Collectors.groupingBy(User::isMale));
	}

	public static Map<Integer, List<User>> groupByAge(List<User> users) {
		return users.stream()
					.collect(Collectors.groupingBy(User::getAge));
	}

	public static Map<Boolean, Map<Integer, List<User>>> groupByGenderAndAge(List<User> users) {
		return users.stream()
					.collect(Collectors.groupingBy(User::isMale, Collectors.groupingBy(User::getAge)));
	}

	public static Map<Boolean, Long> countGender(List<User> users) {
		return users.stream()
					.collect(Collectors.groupingBy(User::isMale, Collectors.counting()));
	}

	public static boolean anyMatch(List<User> users, int age) {
		return users.stream()
				.anyMatch(user -> user.getAge() == age);
	}

	public static boolean noneMatch(List<User> users, int age) {
		return users.stream()
					.noneMatch(user -> user.getAge() == age);
	}

	public static Optional<User> findAny(List<User> users, String name) {
		return users.stream()
				.filter(user -> user.getName().equals(name))
				.findAny();
	}

	public static List<User> sortByAge(List<User> users) {
		return users.stream()
				.sorted(Comparator.comparingInt(User::getAge))
				.collect(Collectors.toList());
	}

	public static Stream<Integer> getBoxedStream(IntStream stream) {
		throw new NotImplementedException();
	}

	public static List<Integer> generateFirst10PrimeNumbers() {
		return IntStream.rangeClosed(2, 29)
				 .filter(i -> IntStream.rangeClosed(2, (int)Math.sqrt(i))
									   .allMatch(j -> i%j != 0))
				 .boxed()
				.collect(Collectors.toList());
	}

	public static boolean isPrime(int number) {
		return IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
	}

	public static List<Integer> generate10RandomNumbers() {
		Random random = new Random();
		return random.ints(10).boxed().collect(Collectors.toList());
	}

	public static User findOldest(List<User> users) {
		return users.stream()
					.sorted(Comparator.comparingInt(User::getAge).reversed())
				.findFirst()
				.get();
	}

	public static int sumAge(List<User> users) {
		return users.stream()
					   .mapToInt(user -> user.getAge())
					   .reduce(0, Integer::sum);
	}

}
