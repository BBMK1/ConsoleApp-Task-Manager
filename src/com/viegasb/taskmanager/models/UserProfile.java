package com.viegasb.taskmanager.models;

import java.time.LocalDate;
import java.util.Objects;

import com.viegasb.taskmanager.config.DateConfig;

public class UserProfile {
	private String firstName;
	private String lastName;
	private LocalDate birthOfDay;

	private Task task;

	public UserProfile(String firstName, String lastName, String birthOfDay) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthOfDay = DateConfig.dateFormatter(birthOfDay);
	}

	public String getFirstName() { return firstName; }

	public void setFirstName(String firstName) { this.firstName = firstName; }

	public String getLastName() { return lastName; }

	public void setLastName(String lastName) { this.lastName = lastName; }

	public LocalDate getBirthOfDay() { return birthOfDay; }

	public void setBirthOfDay(LocalDate birthOfDay) { this.birthOfDay = birthOfDay; }

	public Task getTask() { return task; }

	public void setTask(Task task) { this.task = task; }

	@Override
	public int hashCode() { return Objects.hash(birthOfDay, firstName, lastName); }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		UserProfile other = (UserProfile) obj;
		return Objects.equals(birthOfDay, other.birthOfDay)
				&& Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName);
	}

	@Override
	public String toString() {
		return new StringBuilder()
				.append("User-Profile ")
				.append("[")
				.append(String.format("First-Name: %s, ", firstName))
				.append(String.format("Last-Name: %s, ", lastName))
				.append(String.format("Birth-Of-Day: %s, ", birthOfDay))
				.append(task)
				.append("]")
				.toString();
	}

}