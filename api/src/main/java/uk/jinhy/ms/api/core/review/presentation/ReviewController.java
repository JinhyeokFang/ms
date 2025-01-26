package uk.jinhy.ms.api.core.review.presentation;

import org.springframework.web.bind.annotation.*;
import uk.jinhy.ms.api.core.review.domain.Review;
import uk.jinhy.ms.api.core.review.presentation.dto.CreateReviewRequestDto;

import java.util.List;

@RequestMapping(
        value = "/review",
        produces = "application/json")
public interface ReviewController {
    @GetMapping("")
    List<Review> getReview(@RequestParam("ticketId") int ticketId);

    @GetMapping("/{uuid}")
    Review getReviewByUuid(@PathVariable("uuid") String uuid);

    @PostMapping("")
    void createReview(CreateReviewRequestDto review);

    @DeleteMapping("/{id}")
    void deleteReviewById(@PathVariable("id") int id);
}
