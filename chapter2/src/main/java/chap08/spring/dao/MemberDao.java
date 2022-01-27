package chap08.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import chap08.spring.member.Member;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Component
public class MemberDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MemberDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public class MemberRowMapper implements RowMapper<Member> {
        @Override
        public Member mapRow(ResultSet rs, int rowNow) throws SQLException {
            Member member = new Member(
                    rs.getString("EMAIL"),
                    rs.getString("PASSWORD"),
                    rs.getString("NAME"),
                    rs.getTimestamp("REGDATE").toLocalDateTime());
            member.setId(rs.getLong("ID"));
            return member;
        }
    }

    public Member selectByEmail(String email) {
        List<Member> results = jdbcTemplate.query(
                "select * from Member where EMAIL = ?",
                new RowMapper<Member>() {
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member(
                                rs.getString("EMAIL"),
                                rs.getString("PASSWORD"),
                                rs.getString("NAME"),
                                rs.getTimestamp("REGDATE").toLocalDateTime());
                        member.setId(rs.getLong("ID"));
                        return member;
                    }
                },
                email);

        return results.isEmpty() ? null : results.get(0);
    }

    public void insert(Member member) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement pstmt = connection.prepareStatement(
                    "insert into MEMBER (EMAIL, PASSWORD, NAME, REGDATE) values (?,?,?,?)",
                    new String[]{"id"});
            pstmt.setString(1, member.getEmail());
            pstmt.setString(2, member.getPassword());
            pstmt.setString(3, member.getName());
            pstmt.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));
            return pstmt;
        }, keyHolder); // update() 메서드에 두 번째 파라미터로 keyHolder 를 전달
        Number keyValue = keyHolder.getKey();
        member.setId(keyValue.longValue());
    }

    public void update(Member member) {

        jdbcTemplate.update(con -> {
            PreparedStatement pstmt = con.prepareStatement("update Member set PASSWORD = ? where EMAIL = ?");
            pstmt.setString(1, member.getPassword());
            pstmt.setString(2, member.getEmail());
            return pstmt;
        });

    }

    public void delete(Member member) {
        jdbcTemplate.update(
                "delete from MEMBER where EMAIL = ?",
                member.getEmail()
        );
        //jdbcTemplate.update("delete from MEMBER where EMAIL = ?",new Object[]{ member.getEmail()});
    }

    public List<Member> selectAll() {
        return jdbcTemplate.query(
                "select * from Member order by id",
                new MemberRowMapper());
    }

    public int count() {
        return jdbcTemplate.queryForObject(
                "select count(*) from MEMBER", Integer.class
        );
    }
}

/*
docker run -p 5432:5432 --name postgres -e POSTGRES_PASSWORD=123 -d postgres

create table MEMBER(
    id serial primary key,
    email varchar(255) unique,
    password varchar(100),
    name varchar(100),
    regdate date
);

insert into MEMBER(EMAIL,PASSWORD,NAME,REGDATE) values ('gmldud9605@naver.com','9605','임희영',now());
 */