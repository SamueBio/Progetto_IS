package net.javaguides.springboot.model.review;

import net.javaguides.springboot.model.accomodation.Accommodation;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review,String> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reviews (username,accommodation,text,stars) VALUES (:#{#review.username},:#{#review.accommodation},:#{#review.text},:#{#review.stars})", nativeQuery = true )
    void saveReview(@Param("review") Review review);

    @Query("SELECT new net.javaguides.springboot.model.review.Review(r.username,r.accommodation,r.text,r.stars,r.date) FROM Review r WHERE r.accommodation = :#{#accommodation.id}")
    List<Review> getReviewByAccommodation(@Param("accommodation") Accommodation accommodation);

}
