package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import spring.AuthService;
import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;


@Configuration
public class MemberConfigWithProfile {

    @Autowired
    private DataSource dataSource;

    @Bean
    public MemberDao memberDao() {
        return new MemberDao(dataSource);
    }

    @Configuration
    @Profile("dev")
    public static class InDsDevConfig {
        @Bean(destroyMethod = "close")
        public DataSource dataSource() {
            System.out.println("DevConfig");
            DataSource ds = new DataSource();
            ds.setDriverClassName("org.postgresql.Driver");
            ds.setUrl("jdbc:postgresql://localhost/spring5");
            ds.setUsername("spring5_localhost");
            ds.setPassword("spring5");
            ds.setInitialSize(2);
            ds.setMaxActive(10);
            ds.setMaxIdle(10);
            ds.setTestWhileIdle(true);
            ds.setMinEvictableIdleTimeMillis(1000 * 60 * 3);
            ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
            return ds;
        }

        @Bean
        public PlatformTransactionManager transactionManager() {
            DataSourceTransactionManager tm = new DataSourceTransactionManager();
            tm.setDataSource(dataSource());

            return tm;
        }

        @Bean
        public MemberDao memberDao() {
            return new MemberDao(dataSource());
        }

        @Bean
        public MemberRegisterService memberRegSvc() {
            return new MemberRegisterService();
        }

        @Bean
        public ChangePasswordService changePwdSvc() {
            return new ChangePasswordService();
        }

        @Bean
        public AuthService authService() {
            AuthService authService = new AuthService();
            authService.setMemberDao(memberDao());
            return authService;
        }
    }

    @Configuration
    @Profile("real")
    public static class InDsRealConfig {
        @Bean(destroyMethod = "close")
        public DataSource dataSource() {
            System.out.println("RealConfig");
            DataSource ds = new DataSource();
            ds.setDriverClassName("org.postgresql.Driver");
            ds.setUrl("jdbc:postgresql://localhost/spring5");
            ds.setUsername("spring5_localhost");
            ds.setPassword("spring5");
            ds.setInitialSize(2);
            ds.setMaxActive(10);
            ds.setMaxIdle(10);
            ds.setTestWhileIdle(true);
            ds.setMinEvictableIdleTimeMillis(1000 * 60 * 3);
            ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
            return ds;
        }

        @Bean
        public PlatformTransactionManager transactionManager() {
            DataSourceTransactionManager tm = new DataSourceTransactionManager();
            tm.setDataSource(dataSource());

            return tm;
        }

        @Bean
        public MemberDao memberDao() {
            return new MemberDao(dataSource());
        }

        @Bean
        public MemberRegisterService memberRegSvc() {
            return new MemberRegisterService();
        }

        @Bean
        public ChangePasswordService changePwdSvc() {
            return new ChangePasswordService();
        }

        @Bean
        public AuthService authService() {
            AuthService authService = new AuthService();
            authService.setMemberDao(memberDao());
            return authService;
        }
    }

}
