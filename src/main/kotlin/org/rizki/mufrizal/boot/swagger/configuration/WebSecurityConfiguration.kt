package org.rizki.mufrizal.boot.swagger.configuration

import org.rizki.mufrizal.boot.swagger.helpers.AccessDeniedHandlerHelper
import org.rizki.mufrizal.boot.swagger.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.access.channel.ChannelProcessingFilter

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 17 December 2017
 * @Time 3:33 PM
 * @Project Boot-Swagger
 * @Package org.rizki.mufrizal.boot.swagger.configuration
 * @File WebSecurityConfiguration
 *
 */

@Configuration
@EnableWebSecurity(debug = true)
class WebSecurityConfiguration : WebSecurityConfigurerAdapter() {

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var accessDeniedHandlerHelper: AccessDeniedHandlerHelper

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    override fun userDetailsService() = UserDetailsService { username ->
        userRepository.findByUsername(username)
                .map { user ->
                    buildUserForAuthentication(user, buildUserAuthority(userRoles = user.roles as Set<*>))
                }
                .orElseThrow {
                    UsernameNotFoundException("username not found $username")
                }
    }

    private fun buildUserForAuthentication(user: org.rizki.mufrizal.boot.swagger.domain.User, grantedAuthorities: List<GrantedAuthority>): User {
        return User(user.username, user.password, user.isActive as Boolean, true, true, true, grantedAuthorities)
    }

    private fun buildUserAuthority(userRoles: Set<*>): List<GrantedAuthority> {
        val grantedAuthorities = HashSet<GrantedAuthority>()
        userRoles.forEach { grantedAuthorities.add(SimpleGrantedAuthority(it as String?)) }
        return ArrayList(grantedAuthorities)
    }

    override fun configure(authenticationManagerBuilder: AuthenticationManagerBuilder?) {
        authenticationManagerBuilder
                ?.userDetailsService(this.userDetailsService())
                ?.passwordEncoder(passwordEncoder())
    }

    override fun configure(httpSecurity: HttpSecurity?) {
        httpSecurity
                ?.authorizeRequests()
                ?.antMatchers("/v2/api-docs", "/swagger-resources", "/swagger-resources/configuration/ui", "/swagger-resources/configuration/security", "/swagger-ui.html", "/webjars/**")?.permitAll()
                ?.anyRequest()?.authenticated()
                ?.and()
                ?.httpBasic()
                ?.and()
                ?.addFilterBefore(CorsConfiguration(), ChannelProcessingFilter::class.java)
                ?.csrf()
                ?.disable()
                ?.exceptionHandling()
                ?.accessDeniedHandler(accessDeniedHandlerHelper)
                ?.authenticationEntryPoint(accessDeniedHandlerHelper)
    }

}