package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;
    private String city;
    private String street;
    private String zipcode;

    // Member에서 Order 조회할 일이 있을까? (관심사를 적절하게 끊지 못한 것 -> 필요하면 따로 조회)
    // 최대한 단방향 연관관계를 써라 (실무에서 JPQL 작성 및 조회를 편하게 하기 위해서 양방향 맵핑을 하게됨)
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}
