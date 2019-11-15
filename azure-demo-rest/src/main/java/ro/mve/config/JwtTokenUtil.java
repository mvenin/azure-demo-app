package ro.mve.config;

//import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import ro.mve.model.Constants;

import java.io.Serializable;
import java.util.Arrays;

@Component
public class JwtTokenUtil implements Serializable {
	    public String generateToken(String subject) {
	      return "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbGV4MTIzIiwic2NvcGVzIjpbeyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn1dLCJpc3MiOiJodHRwOi8vZGV2Z2xhbi5jb20iLCJpYXQiOjE1NzI5NDY0MzUsImV4cCI6MTU3Mjk2NDQzNX0.Pri5ThIH0kSpfcdO42S0yRkPQeycy55nNjXsXGbZRNQ ";
	    }
}
//
//import ro.mve.model.User;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//import ro.mve.model.Constants;
//
//import java.io.Serializable;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.function.Function;
//
//@Component
//public class JwtTokenUtil implements Serializable {
//
//    public String getUsernameFromToken(String token) {
//        return getClaimFromToken(token, Claims::getSubject);
//    }
//
//    public Date getExpirationDateFromToken(String token) {
//        return getClaimFromToken(token, Claims::getExpiration);
//    }
//
//    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
//        final Claims claims = getAllClaimsFromToken(token);
//        return claimsResolver.apply(claims);
//    }
//
//    private Claims getAllClaimsFromToken(String token) {
//        return Jwts.parser()
//                .setSigningKey(Constants.SIGNING_KEY)
//                .parseClaimsJws(token)
//                .getBody();
//    }
//
//    private Boolean isTokenExpired(String token) {
//        final Date expiration = getExpirationDateFromToken(token);
//        return expiration.before(new Date());
//    }
//
//    public String generateToken(User user) {
//        return doGenerateToken(user.getUsername());
//    }
//
//    private String doGenerateToken(String subject) {
//
//        Claims claims = Jwts.claims().setSubject(subject);
//        claims.put("scopes", Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
//
//        return Jwts.builder()
//                .setClaims(claims)
//                .setIssuer("http://veninsoft.com")
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + Constants.ACCESS_TOKEN_VALIDITY_SECONDS*1000))
//                .signWith(SignatureAlgorithm.HS256, Constants.SIGNING_KEY)
//                .compact();
//    }
//
//    public Boolean validateToken(String token, UserDetails userDetails) {
//        final String username = getUsernameFromToken(token);
//        return (
//              username.equals(userDetails.getUsername())
//                    && !isTokenExpired(token));
//    }
//
//}
