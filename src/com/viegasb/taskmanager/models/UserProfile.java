package com.viegasb.taskmanager.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.viegasb.taskmanager.config.ConvertConfig;
import com.viegasb.taskmanager.config.DateConfig;

public class UserProfile {
	private Integer id;
	private String firstName;
	private String lastName;
	private LocalDate birthOfDate;

	private Set<Task> tasks;
	private Account account;

	public UserProfile(String firstName, String lastName, String birthOfDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthOfDate = DateConfig.dateFormatter(birthOfDate);
		this.tasks = new HashSet<>();
	}

	public String getFirstName() { return firstName; }

	public void setFirstName(String firstName) { this.firstName = firstName; }

	public String getLastName() { return lastName; }

	public void setLastName(String lastName) { this.lastName = lastName; }

	public LocalDate getBirthOfDate() { return birthOfDate; }

	public void setBirthOfDate(LocalDate birthOfDate) { this.birthOfDate = birthOfDate; }

	public Set<Task> getTasks() { return tasks; }

	public Account getAccount() { return account; }

	public void setAccount(Account account) { this.account = account; }

	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }

	@Override
	public int hashCode() { return Objects.hash(birthOfDate, firstName, lastName); }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		UserProfile other = (UserProfile) obj;
		return Objects.equals(birthOfDate, other.birthOfDate)
				&& Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName);
	}

	@Override
	public String toString() {
		return new StringBuilder()
				.append("User-Profile ")
				.append("[")
				.append(String.format("Id: %s, ", getId()))
				.append(String.format("First-Name: %s, ", firstName))
				.append(String.format("Last-Name: %s, ", lastName))
				.append(String.format("Birth-Of-Date: %s", birthOfDate))
				.append("]\n")
				.append(ConvertConfig.convertToCollections(tasks))
				.toString();
	}

}