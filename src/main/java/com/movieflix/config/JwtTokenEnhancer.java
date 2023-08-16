package com.movieflix.config;

import com.movieflix.infra.adapters.domain.UserEntity;
import com.movieflix.infra.adapters.repositories.SpringUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenEnhancer implements TokenEnhancer {

	@Autowired
	private SpringUserRepository userRepository;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

		UserEntity user = userRepository.findByEmail(authentication.getName());
		
		Map<String, Object> map = new HashMap<>();
		map.put("userName", user.getUsername());
		map.put("userId", user.getId());

		DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) accessToken;
		token.setAdditionalInformation(map);
		
		return accessToken;
	}
}
