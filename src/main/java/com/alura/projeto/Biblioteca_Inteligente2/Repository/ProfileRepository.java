package com.alura.projeto.Biblioteca_Inteligente2.Repository;

import com.alura.projeto.Biblioteca_Inteligente2.Entitys.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
