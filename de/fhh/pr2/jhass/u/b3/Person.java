package de.fhh.pr2.jhass.u.b3;

import java.io.Serializable;

public class Person implements Serializable {
	private String name;
	private Person bestFriend;

	public Person(String name) {
		this.name = name;
	}

	public void setBestFriend(Person friend) {
		this.bestFriend = friend;
	}

	public Person getBestFriend() {
		return bestFriend;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name + " (" + bestFriend.name + ")";
	}
}
