package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.accomodation.Accommodation;
import net.javaguides.springboot.model.review.Review;
import net.javaguides.springboot.model.review.ReviewDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewController {
    @Autowired
    private ReviewDao reviewDao;

    @PostMapping("/Reviews/save")
    public void save(@RequestBody Review review){reviewDao.saveReview(review);}

    @PostMapping("/Reviews/get-reviews-by-accommodation")
    public List<Review> getReviewsByAccommodation(@RequestBody Accommodation accommodation){return reviewDao.getReviewByAccommodation(accommodation);}
}
