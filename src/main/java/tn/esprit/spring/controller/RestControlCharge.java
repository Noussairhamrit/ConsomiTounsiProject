package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

import tn.esprit.spring.entity.*;

import tn.esprit.spring.service.StripeService;

@RestController
public class RestControlCharge {

	@Autowired
	private StripeService stripeService;

	@PostMapping("/customer1/{idUser}")
	@ResponseBody
	public String createCustomer(@PathVariable("idUser") int idUser) {
		return stripeService.createStripeCustomer(idUser);
	}

	// http://localhost:8081/SpringMVC/servlet/customer/retour_ta3_methode_create_customer/4242424242424242/11/2026/123
	@PostMapping("/customer/{customerId}/{carta}/{expMonth}/{expYear}/{cvc}")
	@ResponseBody
	// @PreAuthorize("hasRole('USER')")
	public String createCustomer(@PathVariable("customerId") String customerId, @PathVariable("carta") String carta,
			@PathVariable("expMonth") String expMonth, @PathVariable("expYear") String expYear,
			@PathVariable("cvc") String cvc) throws StripeException {
		return stripeService.createCustumorStripe(customerId, carta, expMonth, expYear, cvc);
	}

	// http://localhost:8081/SpringMVC/servlet/paymentintent
	/*
	 * { "description":"test la methode payment", "amount":"10000",
	 * "currency":"EUR" }
	 */
	@PostMapping("/paymentintent")
	// @PreAuthorize("hasRole('USER')")
	public String payment(@RequestBody ChargeRequest chargeRequest) throws StripeException {
		return stripeService.paymentIntent(chargeRequest); 
		
	}

	// http://localhost:8081/SpringMVC/servlet/confirm/{id}
	@PostMapping("/confirm/{id}")
	// @PreAuthorize("hasRole('USER')")
	public ResponseEntity<String> confirm(@PathVariable("id") String id) throws StripeException {
		PaymentIntent paymentIntent = stripeService.confirm(id);
		String paymentStr = paymentIntent.toJson();
		return new ResponseEntity<String>(paymentStr, HttpStatus.OK);
	}
	//////              1/4242424242424242/11/2026/123
	@PostMapping("/pay/{idc}/{id}/{carta}/{expMonth}/{expYear}/{cvc}")
	public void Pay(@PathVariable("idc") int idc,@PathVariable("id") long id, @PathVariable("carta") String carta,
			@PathVariable("expMonth") int expMonth, @PathVariable("expYear") int expYear,
			@PathVariable("cvc") String cvc) throws AuthenticationException, InvalidRequestException, CardException, StripeException{
		stripeService.Pay(idc,id,carta,expMonth,expYear,cvc);
	}
}
