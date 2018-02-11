package mariuszjaczewski.multiliga.security;

import org.springframework.context.annotation.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//@Configuration
//@EnableWebMvcSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityConfig {//extends WebSecurityConfigurerAdapter {

//    @Override
//    protected void configure(HttpSecurity http) {
//        http.
//                csrf().
//                disable().
//                requiresChannel().
//                and().
//                authorizeRequests().
//                antMatchers("/resources/**").permitAll().
//                antMatchers("/admin").hasAuthority(Role.ADMIN.toString()). //move this line after the next one and see what happens when you log in via test:test
//                anyRequest().authenticated().
//                and().
//                formLogin().
//                permitAll().
//                defaultSuccessUrl("/index").
//                and().
//                logout().
//                deleteCookies("remember-me").
//                invalidateHttpSession(true).
//                logoutSuccessUrl("/bye").
//                logoutUrl("/logout").
//                permitAll().
//                and().
//                rememberMe().
//                key("veryTajnyKeyKtóryNieDajemyNikomu")
//    }
}