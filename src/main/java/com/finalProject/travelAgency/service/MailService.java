package com.finalProject.travelAgency.service;


import com.finalProject.travelAgency.mail.EmailConfiguration;
import com.finalProject.travelAgency.model.Order;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private final EmailConfiguration emailConfiguration;
    private final TourService tourService;
    private final OrderService orderService;

    public MailService(EmailConfiguration emailConfiguration, TourService tourService, OrderService orderService) {
        this.emailConfiguration = emailConfiguration;
        this.tourService = tourService;
        this.orderService = orderService;
    }

    public void sendEmail(Order order){

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.emailConfiguration.getHost());
        mailSender.setPort(this.emailConfiguration.getPort());
        mailSender.setUsername(this.emailConfiguration.getUsername());
        mailSender.setPassword(this.emailConfiguration.getPassword());

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("travel@gmail.com");
        mailMessage.setTo(order.getUser().getEmail());
        mailMessage.setSubject("Zakup wycieczki w serwisie Travel");
        mailMessage.setText("Dziękujemy za zakup wycieczki do: "+tourService.getTour(order.getTour().getId()).getTo()
                +" w terminie "+tourService.getTour(order.getId()).getArrivalDate()+" - "+tourService.getTour(order.getId()).getDepartureDate()+". Koszt zakupionej wycieczki to: "+ order.getTotalPrice());
        mailSender.send(mailMessage);
    }

    public void sendAsk(String message, String email, String subject){

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.emailConfiguration.getHost());
        mailSender.setPort(this.emailConfiguration.getPort());
        mailSender.setUsername(this.emailConfiguration.getUsername());
        mailSender.setPassword(this.emailConfiguration.getPassword());

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(email);
        mailMessage.setTo("travel@gmail.com");
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailSender.send(mailMessage);
    }
}
