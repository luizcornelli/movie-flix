package com.movieflix.config;

import com.movieflix.domain.adapters.services.GenreServiceImpl;
import com.movieflix.domain.adapters.services.MovieServiceImpl;
import com.movieflix.domain.adapters.services.ReviewServiceImpl;
import com.movieflix.domain.adapters.services.UserServiceImpl;
import com.movieflix.domain.ports.repositories.GenreRepositoryPort;
import com.movieflix.domain.ports.repositories.MovieRepositoryPort;
import com.movieflix.domain.ports.repositories.ReviewRepositoryPort;
import com.movieflix.domain.ports.repositories.UserRepositoryPort;
import com.movieflix.domain.ports.services.GenreServicePort;
import com.movieflix.domain.ports.services.MovieServicePort;
import com.movieflix.domain.ports.services.ReviewServicePort;
import com.movieflix.domain.ports.services.UserServicePort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class AppConfig {

	@Value("${jwt.secret}")
	private String jwtSecret;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		tokenConverter.setSigningKey(jwtSecret);
		return tokenConverter;
	}

	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

	@Bean
	GenreServicePort genreService(GenreRepositoryPort genreRepositoryPort) {
		return new GenreServiceImpl(genreRepositoryPort);
	}

	@Bean
	ReviewServicePort reviewService(ReviewRepositoryPort reviewRepositoryPort,
									MovieRepositoryPort movieRepositoryPort,
									UserRepositoryPort userRepositoryPort) {
		return new ReviewServiceImpl(reviewRepositoryPort, movieRepositoryPort, userRepositoryPort);
	}

	@Bean
	MovieServicePort movieService(MovieRepositoryPort movieRepositoryPort) {
		return new MovieServiceImpl(movieRepositoryPort);
	}

	@Bean
	UserServicePort userService(UserRepositoryPort userRepositoryPort) {
		return new UserServiceImpl(userRepositoryPort);
	}
}
