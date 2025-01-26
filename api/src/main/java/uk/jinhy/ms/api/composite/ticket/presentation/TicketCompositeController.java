package uk.jinhy.ms.api.composite.ticket.presentation;

import org.springframework.web.bind.annotation.*;
import uk.jinhy.ms.api.composite.ticket.presentation.dto.CreateReviewRequestDto;
import uk.jinhy.ms.api.composite.ticket.presentation.dto.TicketResponseDto;

@RequestMapping(
        value = "/api/ticket",
        produces = "application/json")
public interface TicketCompositeController {
    @GetMapping("/{uuid}")
    TicketResponseDto getTicketByUuid(@PathVariable("uuid") String uuid);

    @PostMapping("/review")
    void createReview(CreateReviewRequestDto dto);

    @DeleteMapping("/review/{reviewUuid}")
    void deleteReview(@PathVariable("reviewUuid") String reviewUuid);
}
