package com.example.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;


//@EnableAuthorizationServer
@Configuration
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
    private String clientid = "myrestoauth147852369az=";
    private String clientSecret = "fDDccoJw4cW2BatOR8An1wA";

    private String privateKey = "MIIEpAIBAAKCAQEAvyEAtz5co3UEDjC3sBKZTNcPoC7y9Y0qYBNOvGhChoBK+hcS\n" +
            "RwVQnlk1812PcLNUaxQwNOkHWf89qVlCXG8H7ro2qs8YO3QQrsSDZpFoTgblnluM\n" +
            "gwvDD3sHMNvuW50X8ZvMyKbyVB3BTFXC0AeEmSpMqrUY/OFDAc2RTXWYfm8DUfk+\n" +
            "Kldx1DOQjYC258Zxl0hEnII5yHiyfmFaudZEF4T6tKMYDg1X7/2wL7+HnBFZzhqe\n" +
            "JQ6OWN0vesvR06S/L7c7QCndIfOo69OuuXpMjrz7qe8mNavYwDH1RM3VMT6qgmpQ\n" +
            "mq+yFwQBX2E+CzE5O5pRNvyIc4Tca+F0OSMW3wIDAQABAoIBADLpJpipCuIbfF4P\n" +
            "Sg6jlaQrMSVY/Cy+UohO/E0hdH8BU3d0h9DVMJlNaBqQVHIPwq/XK9QcMnIdlB41\n" +
            "AYE/rhxAC+nJykmj7AGxpNLAbslB+w4IktAhZO8NtWelXcOXf9ZCyvSzy57uYhvk\n" +
            "SEVDi2WFJ/Dc1nAdzMyBJnA8n8clcyOL/SkFawnUKJ4Fdu8sgeOx7eiy8DE+wYRP\n" +
            "JHrWf+4pT3xnewQW6Lxt4sVdTgnxtM87grx9uhZyJZZugWuqN4V9LOf5FPoe859Y\n" +
            "pJ3ztAH+3MuVdIGlnEh0hrfYYGKh1hGc5g1RSfiXBf80dNqHDM1ZmlHKp4Lvs8rj\n" +
            "XVDoYYECgYEA3q2OG7dvMejNsmh4hCFqYGgLiygqfKhVLZ6eaXlwmPvi/87knD/G\n" +
            "bDWBf9l2DVxKiivEV8UIubt7SC1qAYeUyL0yn0BDOxw+i4JcEDsk89Ptp0gR1535\n" +
            "8leL0XLY9rjN7JSxb7w2V/W9fhAS20NfJGueIcmDExJ8b1rqEJ/a50ECgYEA27ra\n" +
            "fLlY9gGcpe6+EcUmkdlKZcxgaDq9uIlZFOqJQ0XZPdDzPZ6WvikbE63CoW3miMLQ\n" +
            "fXwRwk+RkCCcFAuLHQFAx5/oFd6kW2UX450cFPgQ2qjWZg3vFPBI4pnoMgd9iKkB\n" +
            "G0KkmABxBFreswpIMymM8cWYLSlvrvmadNrhlh8CgYB9sjZfiuInqCREqxgsbbhg\n" +
            "hxrNCHVDPLooMDt3imd20+jFQYJmeNGGz4U0KAqtbAVfjWkdqklMnnnuukP2bRQd\n" +
            "ZD8pCdtpiH39vi49s0Uepeim3tXDgpdOpwBz0IKMcrE69IxcaD+80yiN+oDKaHNS\n" +
            "WbU/mUJ2B59aNFWf4LxugQKBgQCpF9h/1xsQ5hio0VtPzYpq/u7z/B3M2DecRYZa\n" +
            "REsxjBUsLxqhNuQGnxeJQ1TeafbZFCLiDpKUGCuK4K17944s2gQCG5q9CcMt2lRS\n" +
            "A1vS/zvpKbkkfGCamndcethnd8AxZO3HDrgfiWdv1IZA/g6l4LnobQk46ARcgRVO\n" +
            "DAtCPQKBgQDKww0BJROkvfA0opU//31ts8LjV4VQGIQDA/42CgvzJROoLzBVEeOB\n" +
            "tcasgeRxRHajH+jAHSt1mg026/RRi7AEKe8hWb7waC9uaNiM3CuvwIKcw/7fGPvg\n" +
            "E39dKUnQJW4jt8lAf0bRHYZvCY5n7TOMdk0/zZoPHbQrcf0EEePwnQ==";
    private String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvyEAtz5co3UEDjC3sBKZ\n" +
            "TNcPoC7y9Y0qYBNOvGhChoBK+hcSRwVQnlk1812PcLNUaxQwNOkHWf89qVlCXG8H\n" +
            "7ro2qs8YO3QQrsSDZpFoTgblnluMgwvDD3sHMNvuW50X8ZvMyKbyVB3BTFXC0AeE\n" +
            "mSpMqrUY/OFDAc2RTXWYfm8DUfk+Kldx1DOQjYC258Zxl0hEnII5yHiyfmFaudZE\n" +
            "F4T6tKMYDg1X7/2wL7+HnBFZzhqeJQ6OWN0vesvR06S/L7c7QCndIfOo69OuuXpM\n" +
            "jrz7qe8mNavYwDH1RM3VMT6qgmpQmq+yFwQBX2E+CzE5O5pRNvyIc4Tca+F0OSMW\n" +
            "3wIDAQAB";

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;



    @Bean
    public JwtAccessTokenConverter tokenEnhancer() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("123");
       // converter.setVerifierKey(publicKey);
        return converter;
    }
    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(tokenEnhancer());
    }
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore())
                .accessTokenConverter(tokenEnhancer());
    }
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient(clientid).secret(clientSecret).scopes("read", "write")
                .authorizedGrantTypes("password", "refresh_token").accessTokenValiditySeconds(20000)
                .refreshTokenValiditySeconds(20000);

    }
}