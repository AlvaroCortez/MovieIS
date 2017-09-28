package com.netcracker.movie;

import com.netcracker.movie.model.Movie;
import com.netcracker.movie.model.Role;
import com.netcracker.movie.model.User;
import com.netcracker.movie.resopitory.MovieRepository;
import com.netcracker.movie.resopitory.RoleRepository;
import com.netcracker.movie.resopitory.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication(scanBasePackages = {"com.netcracker.movie"})
public class MovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
	}

	@Bean
	CommandLineRunner init(MovieRepository movieRepository, UserRepository userRepository, RoleRepository roleRepository){
		return (evt) -> {
			Arrays.asList("Blade Runner", "Kingsman").forEach(name -> movieRepository.save(new Movie(name)));
			User user1 = new User();
			user1.setUsername("user");
			user1.setPassword("user");
			userRepository.save(user1);

			User user2 = new User();
			user2.setUsername("admin");
			user2.setPassword("admin");
			userRepository.save(user2);

			Role role = new Role();
			role.setRole("USER");
			roleRepository.save(role);
			Role adminRole = new Role();
			adminRole.setRole("ADMIN");
			roleRepository.save(adminRole);

			assignUsersToUserRole(userRepository, roleRepository);
			assignUsersToAdminRole(userRepository, roleRepository);
		};
	}

	private void assignUsersToUserRole(UserRepository userRepository, RoleRepository roleRepository) {
		List<Role> roles = (List<Role>) roleRepository.findAll();
		List<User> users = (List<User>) userRepository.findAll();

		roles.forEach(role -> {
			if (role.getRole().equalsIgnoreCase("USER")) {
				users.forEach(user -> {
					if (user.getUsername().equals("user")) {
						user.addRole(role);
						userRepository.save(user);
					}
				});
			}
		});
	}
	private void assignUsersToAdminRole(UserRepository userRepository, RoleRepository roleRepository) {
		List<Role> roles = (List<Role>) roleRepository.findAll();
		List<User> users = (List<User>) userRepository.findAll();

		roles.forEach(role -> {
			if (role.getRole().equalsIgnoreCase("ADMIN")) {
				users.forEach(user -> {
					if (user.getUsername().equals("admin")) {
						user.addRole(role);
						userRepository.save(user);
					}
				});
			}
		});
	}
}
