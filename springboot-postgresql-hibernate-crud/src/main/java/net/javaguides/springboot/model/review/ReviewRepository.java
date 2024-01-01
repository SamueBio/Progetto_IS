package net.javaguides.springboot.model.review;

import net.javaguides.springboot.model.accomodation.Accommodation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review,String> {
    @Query(value = "INSERT INTO reviews (username,accommodation,text,stars,date) VALUES (:#{#review.username},:#{#review.accommodation},:#{#review.text},:#{#review.stars},:#{#review.date})", nativeQuery = true )
    void saveReview(@Param("review") Review review);

    @Query("SELECT r FROM Accommodation a JOIN Review r ON a.id = r.accommodation WHERE r.accommodation = :#{#accommodation.id}")
    List<Review> getReviewByAccommodation(@Param("accommodation") Accommodation accommodation);

}
