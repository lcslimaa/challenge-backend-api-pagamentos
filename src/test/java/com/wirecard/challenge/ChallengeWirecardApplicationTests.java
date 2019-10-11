package com.wirecard.challenge;

import com.wirecard.challenge.controller.PaymentController;
import com.wirecard.challenge.model.*;
import com.wirecard.challenge.model.type.PaymentMethod;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.not;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ChallengeWirecardApplicationTests {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void contextLoads() {
    }

    @Test
    public void getCard(){
        Card card = new Card();
        card.setCardHolderName("Lucas");
        card.setCardNumber("6062829659167013");
        card.setCardCVV(260);
    }

    @Test
    public void getBuyer(){
        Buyer buyer = new Buyer();
        buyer.setName("Lucas");
        buyer.setEmail("teste@teste.com");
        buyer.setCpf("254.331.820-88");
    }

    @Test
    public void getClient(){
        Client client = new Client();
        client.setId(1);
    }

    @Test
    public void getPayment(){
        Payment payment = new Payment();
        payment.setAmount(200);
        payment.setPaymentMethod(PaymentMethod.CREDIT_CARD);
    }

    @Test
    public void getBillet(){
        Billet billet = new Billet();
        billet.setBilletNumber(billet.getBilletNumber());
    }

    @Test
    public void getTransaction(){
        Transaction transaction = new Transaction();
        transaction.setPayment(transaction.getPayment());
        transaction.setSuccessful(true);
    }

    @Test
    public void createPayment(){
        PaymentController paymentController = new PaymentController();
        assertThat(paymentController).isNotNull();
    }


}
