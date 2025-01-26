package uk.jinhy.ms.api.core.review.presentation;

import org.springframework.web.bind.annotation.*;
import uk.jinhy.ms.api.core.review.domain.Review;

import java.util.List;

@RequestMapping(
        value = "/",
        produces = "application/json")
public interface ReviewController {
    @GetMapping("")
    List<Review> getReview(@RequestParam("ticketId") int ticketId);

    @GetMapping("/{uuid}")
    Review getReviewByUuid(@PathVariable("uuid") String uuid);
}
