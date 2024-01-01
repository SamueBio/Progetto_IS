package net.javaguides.springboot.model.review;

import net.javaguides.springboot.model.accomodation.Accommodation;
import net.javaguides.springboot.model.favourites.Favourite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewDao {
    @Autowired
    private ReviewRepository reviewRepository;

    public void saveReview(Review review){reviewRepository.saveReview(review);}

    public List<Review> getReviewByAccommodation(Accommodation accommodation){return reviewRepository.getReviewByAccommodation(accommodation);}
}
