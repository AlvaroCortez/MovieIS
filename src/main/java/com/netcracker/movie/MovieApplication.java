package com.netcracker.movie;

import com.netcracker.movie.model.Movie;
import com.netcracker.movie.model.Role;
import com.netcracker.movie.model.User;
import com.netcracker.movie.resopitory.MovieRepository;
import com.netcracker.movie.service.RoleService;
import com.netcracker.movie.service.UserService;
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
	CommandLineRunner init(MovieRepository movieRepository, UserService userRepository, RoleService roleRepository){
		return (evt) -> {
			Arrays.asList("Blade Runner", "Kingsman").forEach(name -> movieRepository.save(new Movie(name)));
//			prepareUsers(userRepository, roleRepository);
		};
	}

	private void prepareUsers(UserService userRepository, RoleService roleRepository){
		User user1 = new User();
		user1.setUsername("user");
		user1.setPassword("user");
		userRepository.saveOrUpdate(user1);

		User user2 = new User();
		user2.setUsername("admin");
		user2.setPassword("admin");
		userRepository.saveOrUpdate(user2);

		Role role = new Role();
		role.setRole("USER");
		roleRepository.saveOrUpdate(role);
		Role adminRole = new Role();
		adminRole.setRole("ADMIN");
		roleRepository.saveOrUpdate(adminRole);

		assignUsersToUserRole(userRepository, roleRepository);
		assignUsersToAdminRole(userRepository, roleRepository);
	}

	private void assignUsersToUserRole(UserService userRepository, RoleService roleRepository) {
		List<Role> roles = (List<Role>) roleRepository.listAll();
		List<User> users = (List<User>) userRepository.listAll();

		roles.forEach(role -> {
			if (role.getRole().equalsIgnoreCase("USER")) {
				users.forEach(user -> {
					if (user.getUsername().equals("user")) {
						user.addRole(role);
						userRepository.saveOrUpdate(user);
					}
				});
			}
		});
	}
	private void assignUsersToAdminRole(UserService userRepository, RoleService roleRepository) {
		List<Role> roles = (List<Role>) roleRepository.listAll();
		List<User> users = (List<User>) userRepository.listAll();

		roles.forEach(role -> {
			if (role.getRole().equalsIgnoreCase("ADMIN")) {
				users.forEach(user -> {
					if (user.getUsername().equals("admin")) {
						user.addRole(role);
						userRepository.saveOrUpdate(user);
					}
				});
			}
		});
	}
}
