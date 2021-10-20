package com.jx2lee.mockito.study;

import com.jx2lee.mockito.domain.Study;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRepository extends JpaRepository<Study , Long> {

}
