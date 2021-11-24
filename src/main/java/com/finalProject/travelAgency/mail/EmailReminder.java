package com.finalProject.travelAgency.mail;
import com.finalProject.travelAgency.model.Order;
import com.finalProject.travelAgency.service.MailService;
import com.finalProject.travelAgency.service.OrderService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmailReminder {

    private  final OrderService orderService;
    private final MailService mailService;

    public EmailReminder(OrderService orderService, MailService mailService) {
        this.orderService = orderService;
        this.mailService = mailService;
    }

   // @Scheduled(cron = "0 30 7 * * *")
    @Scheduled(fixedRate = 5000L)
    public void ordersToRemind(){
        List<Order> orderedToursDepartureInSevenDays;
        List<Order> allOrderedTours = orderService.getAllOrders();

        orderedToursDepartureInSevenDays = allOrderedTours.stream()
                .filter(order -> (ChronoUnit.DAYS.between(LocalDate.now(),order.getTour().getArrivalDate()))==7)
                .collect(Collectors.toList());

        orderedToursDepartureInSevenDays
                .forEach(mailService::sendEmail);
    }
}
