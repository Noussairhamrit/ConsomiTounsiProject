package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;

import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.PaymentIntent;
import com.stripe.model.Token;

import tn.esprit.spring.entity.*;


import tn.esprit.spring.repository.ClientRepository;


@Service
public class StripeService {

	@Autowired
	ClientRepository userRepository;
	
	@Value("${stripe.keys.secret}")
	private String secretKey;

	@PostConstruct
	public void init() {
		Stripe.apiKey = secretKey;
	}
	
	
	public String createStripeCustomer(long idUser) {
		
		// stripe key
		Stripe.apiKey = "sk_test_UHZrLj1j6biRBfKOjmm8YFN400Q29LPaWs";

		Client user = userRepository.findById(idUser).get();
		Map<String, Object> params = new HashMap<>();
		params.put("description", "My First Test Customer (created for API docs)");
		params.put("email", user.getEmail());

		// affichage id du customer
		try {
			Customer customer = Customer.create(params);

			System.out.println("create customer id: {}");
			return customer.getId();
		} catch (StripeException e) {

			throw new RuntimeException(e);
		}
		// TODO Auto-generated method stub
//		return null;
	}

	
	public String createCustumorStripe(String customerId, String carta, String expMonth, String expYear, String cvc)
			throws StripeException {
		// TODO Auto-generated method stub
		//return null;
		// stripe key
		Stripe.apiKey = "sk_test_UHZrLj1j6biRBfKOjmm8YFN400Q29LPaWs";

		Customer customer = Customer.retrieve(customerId);

		Map<String, Object> cardParam = new HashMap<String, Object>();
		cardParam.put("number", carta);
		cardParam.put("exp_month", expMonth);
		cardParam.put("exp_year", expYear);
		cardParam.put("cvc", cvc);

		Map<String, Object> tokenParam = new HashMap<String, Object>();
		tokenParam.put("card", cardParam);

		Token token = Token.create(tokenParam);

		Map<String, Object> source = new HashMap<String, Object>();
		source.put("source", token.getId());

		customer.getSources().create(source);
		return token.getId();
	}

	
	public String paymentIntent(ChargeRequest chargerequest)throws StripeException{
		// TODO Auto-generated method stub
		//return null;
		// stripe key
		Stripe.apiKey = "sk_test_UHZrLj1j6biRBfKOjmm8YFN400Q29LPaWs";

		// `source` is obtained with Stripe.js; see
		// https://stripe.com/docs/payments/accept-a-payment-charges#web-create-token
		List<String> paymentMethodTypes = new ArrayList();
		paymentMethodTypes.add("card");
		
		
		Map<String, Object> params = new HashMap<>();
		params.put("amount",chargerequest.getAmount());
		params.put("currency", chargerequest.getCurrency());
		params.put("description", chargerequest.getDescription());
		params.put("payment_method_types", paymentMethodTypes);
		
		PaymentIntent p = PaymentIntent.create(params);
		p.getId();
		//Charge charge = Charge.create(params);
		return p.getId();
	}
	
	
	
	/*
	 * this methode is to confirm that your customer intends to pay with current
	 * or provided payment method. Upon confirmation, the PaymentIntent will
	 * attempt to initiate a payment
	 */
	public PaymentIntent confirm(String id) throws StripeException {
		Stripe.apiKey = "sk_test_UHZrLj1j6biRBfKOjmm8YFN400Q29LPaWs";
		PaymentIntent paymentIntent = PaymentIntent.retrieve(id);
		Map<String, Object> params = new HashMap<>();
		params.put("payment_method", "pm_card_visa");
		// params.put("customer", "cus_H1OvsnwEn1KX36");
		paymentIntent.confirm(params);
		return paymentIntent;
	}
	

	
}
