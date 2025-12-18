package com.example.aivle_4th_MiniProject_team19.Repository;

import com.example.aivle_4th_MiniProject_team19.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByUsername(String username);
    boolean existsByUsername(String username);
}