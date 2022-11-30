package jcw.javaTeamProjectServer.repository;

import jcw.javaTeamProjectServer.dto.ReviewListDto;
import jcw.javaTeamProjectServer.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "SELECT r.reviewKey, r.reviewBody, r.reviewStar, r.reviewDate, m.memberName " +
            "FROM Review r, Member m " +
            "WHERE r.memberKey = m.memberKey")
    List<ReviewListDto> findByItemKey(Long itemKey);

    @Query(value = "SELECT AVG(r.reviewStar) FROM Review r WHERE r.itemKey = :itemKey GROUP BY r.itemKey")
    double avgRating(@Param("itemKey") Long itemKey);
}
