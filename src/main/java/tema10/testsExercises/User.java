package tema10.testsExercises;

import java.util.ArrayList;
import java.util.List;

public class User {

	private String name;
	private int age;
	private boolean male;

	public User(Integer age) {
		this.age = age;
	}

	public User(String name) {
		this.name = name;
	}

	public User(String name, boolean male) {
		this.name = name;
		this.male = male;
	}

	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public User(String name, int age, boolean male) {
		this.name = name;
		this.age = age;
		this.male = male;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public boolean isMale() {
		return male;
	}

	public static List<User> getUsersWithAge(int... ages) {
		List<User> users = new ArrayList<>();
		for (Integer age : ages) {
			users.add(new User(age));
		}
		return users;
	}

}
