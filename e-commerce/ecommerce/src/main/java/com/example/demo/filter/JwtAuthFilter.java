package com.example.demo.filter;

import org.springframework.stereotype.Component;

@Component
public class JwtAuthFilter {

//	@Autowired
//	private JwtService jwtService;
//
//	@Autowired
//	private UserInfoDetailsService detailsService;
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//		String token = null;
//		String email = null;
//		String header = request.getHeader("Authorization");
//		if (null != header && header.startsWith("Bearer ")) {
//			token = header.substring(7);
//			email = jwtService.getUserFromToken(token);
//
//		}
//		if (null != email && SecurityContextHolder.getContext().getAuthentication() == null) {
//			UserDetails userDetails = detailsService.loadUserByUsername(email);
//			if (jwtService.validateToken(token, userDetails)) {
//				UsernamePasswordAuthenticationToken userToken = new UsernamePasswordAuthenticationToken(userDetails,
//						userDetails, userDetails.getAuthorities());
//				userToken.setDetails(new WebAuthenticationDetails(request));
//				SecurityContextHolder.getContext().setAuthentication(userToken);
//			}
//		}
//		filterChain.doFilter(request, response);
//
//	}

}
