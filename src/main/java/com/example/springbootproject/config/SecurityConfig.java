//
//@EnableWebSecurity
//@RequiredArgsConstructor
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private final UserDetailImpl userDetails;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/api/user/registration").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .csrf().disable().httpBasic();
//    }
//
//        @Bean
//        public BCryptPasswordEncoder encoder(){
//            return new BCryptPasswordEncoder();
//        }
//
//        @Bean
//        public DaoAuthenticationProvider authenticationProvider(){
//
//            DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//
//            daoAuthenticationProvider.setPasswordEncoder(encoder());
//            daoAuthenticationProvider.setUserDetailsService(userDetails);
//
//            return daoAuthenticationProvider;
//        }
//    }
//
//
//
//
//
//
